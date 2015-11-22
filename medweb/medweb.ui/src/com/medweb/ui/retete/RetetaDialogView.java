package com.medweb.ui.retete;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.CabinetMedical;
import medweb.psconf.daos.Fisa;
import medweb.psconf.daos.Medicament;
import medweb.psconf.daos.Reteta;
import medweb.psconf.daos.RetetaLinie;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.medweb.ui.help.Constants;
import com.medweb.ui.help.ImageID;
import com.medweb.ui.help.WidgetFactory;
import com.medweb.ui.medicamente.SublistaEnum;
import com.medweb.ui.pacient.PacientMessages;
import com.medweb.ui.table.ColumnDescriptor;
import com.medweb.ui.table.ColumnType;

@SuppressWarnings("serial")
public class RetetaDialogView extends Dialog{

	private Composite tableComposite;
	private TableViewer tableViewer;
	private Text medicamentText;
	private Button searchButton;
	private Button resertButton;
	private ListViewer list;
	private List<String> listMedicamente;
	private Label unitateLabel;
	private Label codFiscalLabel;
	private Label dataLabel;
	private RetetaModel retetaModel;
	private Button saveButton;
	private Label observatiiInfoLabel;
	private Text observatiiText;
	private Reteta reteta;
	private String textObs; 
	
	public RetetaDialogView(final Shell parentShell) {
	    super(parentShell);
		  
	}
	public RetetaDialogView(final Shell parentShell,final RetetaModel model) {
	    super(parentShell);
	    this.retetaModel=model;
		  
	}
	
	public RetetaDialogView(final Shell parentShell,final RetetaModel model,Reteta reteta,String textObservati) {
	    super(parentShell);
	    this.retetaModel=model;
		this.reteta=reteta;  
		this.textObs=textObservati;
	}
	
	@Override
	protected Control createDialogArea(final Composite parent) {
	    final Composite container = (Composite) super.createDialogArea(parent);
	    container.setLayout(new GridLayout(4, true));
	    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	  
	    parent.setLayout(new GridLayout(1,true));
		Composite composite=new Composite(parent,SWT.FILL);
		composite.setLayout(new GridLayout(12,true));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		
		Group headFilterGroup=new Group(composite, SWT.None);
		headFilterGroup.setLayout(new GridLayout(3,true));
		GridData filterDataGrid=new GridData(SWT.FILL, SWT.FILL, true, true,5,1);
		headFilterGroup.setLayoutData(filterDataGrid);
		headFilterGroup.setText("Info");
		createFilerHeadComposite(headFilterGroup);
		
		
		Group headComposite=new Group(composite, SWT.H_SCROLL);
		headComposite.setLayout(new GridLayout());
		GridData headDataGrid=new GridData(SWT.FILL, SWT.FILL, true, true,6,1);
		headComposite.setLayoutData(headDataGrid);
		headComposite.setText("Lista medicamente");
		createHeadComposite(headComposite);
		
		saveButton=WidgetFactory.createButton(parent, "saveButton", "Save", false, ImageID.IMAGE_SAVE);
		   GridData dataBut =new GridData(SWT.LEFT,SWT.FILL,false,false);
		   dataBut.widthHint=80;
		saveButton.setLayoutData(dataBut);
		   
		tableComposite = WidgetFactory.createTableViewer(parent, SWT.V_SCROLL,
				tableColumnDescrisptors(),tableInputObject(),145,true,true);
		GridLayout gridLayout = new GridLayout();
		 tableComposite.setLayout(gridLayout);
		 GridData data=new GridData(SWT.FILL, SWT.FILL, true, true);
		tableComposite.setLayoutData(data);
		
		tableViewer=WidgetFactory.getTableViewer();
		createBindings();
		createListeners();
	    
	   	    
	    return container;
	}
	private void createHeadComposite(Group composite){
		//grid 8 cell 
		 
	     list = WidgetFactory.createListViewer(composite, "", false, false);
	     GridData listData=new GridData(SWT.FILL,SWT.FILL,true,false);
	     listData.heightHint=200;
	     list.getControl().setLayoutData(listData);
	    
	    
		
	}
	private void  createFilerHeadComposite(Group composite){
		Label medicamentLabel=WidgetFactory.createLabel(composite, "medicamentLabel","Medicament");
		medicamentLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,1,1) );
		
		this.medicamentText=WidgetFactory.createText(composite, "", 100, false);
		this.medicamentText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1) );
		
		this.resertButton=WidgetFactory.createButton(composite, "resertButton", RetetaMessages.EDIT_RESERT.getMessage(), false,ImageID.IMAGE_RESET);
		this.resertButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,1,1) );
		
		addBlankLabels(composite, 1);
		this.searchButton=WidgetFactory.createButton(composite, "searchButton", RetetaMessages.EDIT_SEARCH.getMessage(), false,ImageID.IMAGE_IMPORT);
		this.searchButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,1,1) );
		
		//addBlankLabels(composite, 3);
		
		Label unitateInfoLabel=WidgetFactory.createLabel(composite, "unitateInfoLabel","Unitate Sanitara:");
		unitateInfoLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1) );
		
		unitateLabel = WidgetFactory.createLabel(composite, "unitateLabel","X");
		unitateLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,1,1) );
		
		//addBlankLabels(composite, 1);
		
		Label fiscalInfoLabel=WidgetFactory.createLabel(composite, "fiscalInfoLabel","Cod Fiscal:");
		fiscalInfoLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1) );
		
		codFiscalLabel = WidgetFactory.createLabel(composite, "codFiscalLabel","");
		codFiscalLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,1,1) );
		
		//addBlankLabels(composite, 1);
		
		Label dataInfoLabel=WidgetFactory.createLabel(composite, "dataInfoLabel","Data:");
		dataInfoLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1) );
		
		dataLabel = WidgetFactory.createLabel(composite, "dataLabel","X");
		dataLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,1,1) );
		
		//addBlankLabels(composite, 1);
		
		observatiiInfoLabel = WidgetFactory.createLabel(composite, "observatiiInfoLabel","Observatii:");
		observatiiInfoLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,3,1) );
		
		observatiiText = WidgetFactory.createTextArea(composite, "", 500, false);
		GridData obsGrid=new GridData(SWT.FILL, SWT.FILL, true, false,3,1);
		obsGrid.widthHint=100;
		obsGrid.heightHint=50;
		observatiiText.setLayoutData(obsGrid);
		
	}
	 private List<ColumnDescriptor> tableColumnDescrisptors(){
		   List<ColumnDescriptor> columnDescriptors=new ArrayList<ColumnDescriptor>();
		   
		   ColumnDescriptor columnDescriptor=new ColumnDescriptor(RetetaMessages.EDIT_COLUMN1_NAME.getMessage(),150,ColumnType.COLUMN_LABLE, RetetaMessages.EDIT_COLUMN1_NAME.getMessage(),false);
		   columnDescriptors.add(columnDescriptor);
		   
		   columnDescriptor=new ColumnDescriptor(RetetaMessages.EDIT_COLUMN2_NAME.getMessage(),150,ColumnType.COLUMN_LABLE, RetetaMessages.EDIT_COLUMN2_NAME.getMessage(),false);
		   columnDescriptors.add(columnDescriptor);
		   
		   columnDescriptor=new ColumnDescriptor(RetetaMessages.EDIT_COLUMN3_NAME.getMessage(),150,ColumnType.COLUMN_LABLE,RetetaMessages.EDIT_COLUMN3_NAME.getMessage(),true);
		   columnDescriptors.add(columnDescriptor);
		   
		   columnDescriptor=new ColumnDescriptor(RetetaMessages.EDIT_COLUMN4_NAME.getMessage(),150,ColumnType.COLUMN_LABLE, RetetaMessages.EDIT_COLUMN4_NAME.getMessage(),true);
		   columnDescriptors.add(columnDescriptor);
		   
		   return columnDescriptors;
	   }
	 private List<Object> tableInputObject(){
			List<Object> list=new ArrayList<Object>();
		int nrList=0;
	    if(reteta!=null)
		{
			nrList=reteta.getListaMedicamente().size();
	    	Iterator<RetetaLinie> itLinie=reteta.getListaMedicamente().iterator();
			while(itLinie.hasNext()){
				RetetaLinie linie=itLinie.next();
				RowReteta row=new RowReteta();
				row.setCod(linie.getMedicament().getCodAtc());
				row.setNume(linie.getMedicament().getDenumireComerciala());
				row.setCantitate(linie.getCantitate());
				row.setAdministrare(linie.getModAdministrare());
				list.add(row);
				hideElements();
			}
		}
		for(int i=0;i<10-nrList;i++){	
			RowReteta row=new RowReteta();
			 row.setCod("");
			 row.setNume("");
			 row.setCantitate("");
			 row.setAdministrare("");	 
			 list.add(row);
		}
	 
			return list;
		}
	 
	 
	 private void hideElements(){
		 this.saveButton.setVisible(false);
		 this.resertButton.setVisible(false);
		 this.searchButton.setVisible(false);
		 this.observatiiText.setText(textObs);
	 }
	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(final Composite parent) {
	    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.get().OK_LABEL, true);
	}
	
	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
	    return new Point(900, 800);
	}
	 private void createBindings(){
		 listMedicamente=new ArrayList<String>();
		 List<Medicament> lmed = null;
		try {
			lmed = this.retetaModel.getBusinessService().getAllMedicamente();
		} catch (BusinessSQLException e) {
			IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(), 
					Constants.SQL_ERROR);
		}
		 Iterator<Medicament> itMed=lmed.iterator();
		 while(itMed.hasNext()){
			 Medicament medicamnet=itMed.next();
			 String numeSublista=SublistaEnum.fromInteger(medicamnet.getNrSublista()).toString();
			 String val=medicamnet.getCodAtc()+" "+medicamnet.getDenumireComerciala()+" "+numeSublista;
			 listMedicamente.add(val);
			 list.add(val);
		 } 
		    int idPacient=retetaModel.getPatientModel().getPacient().getIdPacient();
			int idMedic=retetaModel.getMedicModel().getMedicPrimar().getIdMedicPrimar();
			Fisa fisa = null;
			try {
				fisa = retetaModel.getBusinessService().getFisaPacinet(idPacient,idMedic);
			} catch (BusinessSQLException e) {
				IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(), 
						Constants.SQL_ERROR);
			}
			retetaModel.setFisa(fisa);
				 
		 CabinetMedical cabinet=this.retetaModel.getMedicModel().getMedicPrimar().getCabinetMedical();
		 unitateLabel.setText(cabinet.getNume());
		 codFiscalLabel.setText(cabinet.getCodFiscal());
		 
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	     Date date = new Date();
	     dataLabel.setText(dateFormat.format(date));
	 }
	 private void createListeners(){
		RetetaFilterAction action=new RetetaFilterAction();
		action.setNumeMedicamnet(medicamentText);
		action.setSerach(searchButton);
		action.setReset(resertButton);
		action.setList(list);
		action.setLista(listMedicamente);
		action.setTableViewer(tableViewer);
		action.setRetetaModel(retetaModel);
		action.setSaveButton(saveButton);
		action.setObservatiiText(observatiiText);
		action.setUnitateLabel(unitateLabel);
		action.setCodFiscalLabel(codFiscalLabel);
		
		 this.searchButton.addListener(SWT.Selection, action);
		 this.resertButton.addListener(SWT.Selection, action);
		 this.saveButton.addListener(SWT.Selection, action);
		if(reteta==null) 
		 this.list.addDoubleClickListener(action);
		
		
	   }
	 private void addBlankLabels(Composite parent,int number){
			for(int i=0;i<number;i++){
				Label label=WidgetFactory.createLabel(parent, "");
				label.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
			    //label.setText("#");
			}
		}
}
