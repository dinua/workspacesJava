package com.medweb.ui.medic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import medweb.psconf.daos.CasaAsigurari;
import medweb.psconf.daos.MedicPrimar;
import medweb.psconf.daos.MedicPrimarInfo;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import com.medweb.ui.help.ImageID;

import com.medweb.ui.help.WidgetFactory;
import com.medweb.ui.table.ColumnDescriptor;
import com.medweb.ui.table.ColumnType;
import com.medweb.ui.table.TableMessages;

public class MedicInfoView extends ViewPart{
	
	public static final String ID = "com.medweb.ui.medic.medicInfoView";
	
	private Composite tableComposite;
	private TableViewer tableViewer;
	private Button saveButton;
	private Text numeMedicText;
	private Text prenumeMedicText;
	private ComboViewer casaAsigComboViewer;
	private MedicModel medicModel;
	
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1,true));
		Composite composite=new Composite(parent,SWT.FILL);
		composite.setLayout(new GridLayout(12,true));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		createToolbarButtons(composite);
		addBlankLabels(composite, 23);
		
		Group headComposite=new Group(composite, SWT.None);
		headComposite.setLayout(new GridLayout(8,true));
		GridData headDataGrid=new GridData(SWT.FILL, SWT.FILL, true, true,10,1);
		headComposite.setLayoutData(headDataGrid);
		headComposite.setText("Informatii");
		createHeadComposite(headComposite);
		
		tableComposite = WidgetFactory.createTableViewer(parent, SWT.V_SCROLL,
				tableColumnDescrisptors(),tableInputObject(),115);
		GridLayout gridLayout = new GridLayout();
		 tableComposite.setLayout(gridLayout);
		 GridData data=new GridData(SWT.FILL, SWT.FILL, true, true);
		tableComposite.setLayoutData(data);
		
		tableViewer=WidgetFactory.getTableViewer();
		createBindings();
		createListeners();
		
	}
	private void createToolbarButtons(Composite parent){
		 
		   saveButton = WidgetFactory.createButton(parent, "saveButton",MedicMessages.EDIT_SAVE.getMessage(), false,ImageID.IMAGE_SAVE);
		   GridData data =new GridData(SWT.FILL,SWT.BOTTOM,false,false,1,1);
		   data.widthHint=80;
		   saveButton.setLayoutData(data);
		   
		}
	
	private void createHeadComposite(Group composite){
		//grid 8 cell 
		Label numeMedicLabel=WidgetFactory.createLabel(composite, "numeMedicLabel","Nume:");
		 numeMedicLabel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));
		 
		 numeMedicText = WidgetFactory.createText(composite, "numeMedicText", 100, false);
		 numeMedicText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		 addBlankLabels(composite, 5);
		
		Label prenumeMedicLabel=WidgetFactory.createLabel(composite, "prenumeMedicLabel","Prenume:");
		prenumeMedicLabel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));
		
		prenumeMedicText = WidgetFactory.createText(composite, "prenumeMedicText", 100, false);
		prenumeMedicText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		
		addBlankLabels(composite, 5);
		
		 Label casaAsigLabel=WidgetFactory.createLabel(composite, "casaAsigLabel","Casa asigurari:");
		 casaAsigLabel.setLayoutData(new GridData(SWT.LEFT,SWT.FILL,true,false,2,1));
         
		 casaAsigComboViewer = WidgetFactory.createComboViewer(composite, "casaAsigComboViewer", false);
		 
		
	}
	 private List<ColumnDescriptor> tableColumnDescrisptors(){
		   List<ColumnDescriptor> columnDescriptors=new ArrayList<ColumnDescriptor>();
		   
		   ColumnDescriptor columnDescriptor=new ColumnDescriptor(TableMessages.EDIT_INFO.getMessage(),150,ColumnType.COLUMN_LABLE, TableMessages.EDIT_INFO.getMessage(),false);
		   columnDescriptors.add(columnDescriptor);
		   
		   columnDescriptor=new ColumnDescriptor(TableMessages.EDIT_VALUE.getMessage(),150,ColumnType.COLUMN_LABLE, TableMessages.EDIT_VALUE.getMessage(),true);
		   columnDescriptors.add(columnDescriptor);
		   
		   return columnDescriptors;
	   }
	 private List<Object> tableInputObject(){
			List<Object> list=new ArrayList<Object>();
			
			MedicPrimarInfo info=this.medicModel.getMedicPrimarInfo();
			
			list.add(createMedicRowInformation(MedicMessages.EDIT_INFO_CNP.getMessage(), info.getCNP()));
            list.add(createMedicRowInformation(MedicMessages.EDIT_INITIALA.getMessage(), info.getInitiala()));
            list.add(createMedicRowInformation(MedicMessages.EDIT_INFO_ADRESA.getMessage(), info.getAdresa()));
            list.add(createMedicRowInformation(MedicMessages.EDIT_INFO_TELEFON.getMessage(), info.getTelefon()));
            list.add(createMedicRowInformation(MedicMessages.EDIT_COD_PARAFA.getMessage(), info.getCodParafa()));
            list.add(createMedicRowInformation(MedicMessages.EDIT_NR_LICENTA.getMessage(), info.getNrLicenta()));
            list.add(createMedicRowInformation(MedicMessages.EDIT_NR_CONTRACT_CNAS.getMessage(), info.getNrContractCNAS()));
			
			return list;
		}
	 private MedicRowInformation createMedicRowInformation(String rowName,String value){
		 MedicRowInformation medicRowInformation =new MedicRowInformation();
		 medicRowInformation.setRowName(rowName);
		 if(value==null)
			 value="";
		 medicRowInformation.setValue(value);
		 return medicRowInformation;
	 }
	 private void createBindings(){
		 
		 MedicPrimar medic=medicModel.getMedicPrimar();
		 
		 numeMedicText.setText(medic.getNume());
		 prenumeMedicText.setText(medic.getPrenume());
		 
		 int index=0;
	     Iterator<CasaAsigurari> itCasa= this.medicModel.getAllCasaAsigurari().iterator();
	     String numeCasaAsig=medic.getCasaAsigurari().getNume();
	     while(itCasa.hasNext()){
	    	 CasaAsigurari casaAsig=itCasa.next();
	    	 casaAsigComboViewer.add(casaAsig.getNume());
	    	 if(numeCasaAsig.equals(casaAsig.getNume()))
	    		 casaAsigComboViewer.getCombo().select(index);
	    	 index++;
	     }
		
	 }
	 private void createListeners(){
		
		 SaveAction saveAction=new SaveAction();
		 saveAction.setSaveInfo(saveButton);
		 saveAction.setNumeMedicText(prenumeMedicText);
		 saveAction.setPrenumeMedicText(prenumeMedicText);
		 saveAction.setTableViewer(tableViewer);
		 saveAction.setCasaAsigComboViewer(casaAsigComboViewer);
		 saveAction.setMedicModel(medicModel);
		 
		 this.saveButton.addListener(SWT.Selection, saveAction);
		
	   }
	private void addBlankLabels(Composite parent,int number){
		for(int i=0;i<number;i++){
			Label label=WidgetFactory.createLabel(parent, "");
			label.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		   //label.setText("#");
		}
	}
	@Override
	public void setFocus() {
		
		
	}
	/**
	 * @return the medicModel
	 */
	public MedicModel getMedicModel() {
		return medicModel;
	}
	/**
	 * @param medicModel the medicModel to set
	 */
	public void setMedicModel(MedicModel medicModel) {
		this.medicModel = medicModel;
	}

}
