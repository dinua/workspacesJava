package com.medweb.ui.pacient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.Consult;
import medweb.psconf.daos.MedicPrimar;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

import com.medweb.ui.help.ImageID;
import com.medweb.ui.help.WidgetFactory;
import com.medweb.ui.retete.RetetaModel;
import com.medweb.ui.table.ColumnDescriptor;
import com.medweb.ui.table.ColumnType;

public class VisitHistoryView extends ViewPart{

	public static final String ID = "com.medweb.ui.pacient.visitHistoryView";
	private Composite tableComposite;
	private TableViewer tableViewer;
	private Button reteteElibButton;
	private Button adeverinteElibButton;
	
	private PacientModel patientModel;
	private RetetaModel retetaModel;
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1,true));
		Composite composite=new Composite(parent,SWT.FILL);
		composite.setLayout(new GridLayout(12,true));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		createToolbarButtons(composite);
		addBlankLabels(composite, 20);
		
		tableComposite = WidgetFactory.createTableViewer(parent, SWT.V_SCROLL,tableColumnDescrisptors(),tableInputObject());
		GridLayout gridLayout = new GridLayout();
		 tableComposite.setLayout(gridLayout);
		 GridData data=new GridData(SWT.FILL, SWT.FILL, true, true);
		tableComposite.setLayoutData(data);
		
		tableViewer=WidgetFactory.getTableViewer();
		createListeners();
		
	}

	
	private void createToolbarButtons(Composite parent){
		 
		   reteteElibButton = WidgetFactory.createButton(parent, "reteteElibButton"," Reteta Eliberata", false,ImageID.IMAGE_EDITOR);
		   GridData data =new GridData(SWT.FILL,SWT.BOTTOM,false,false,2,1);
		   data.widthHint=160;
		   reteteElibButton.setLayoutData(data);
		   
		   adeverinteElibButton = WidgetFactory.createButton(parent, "adeverinteElibButton","Adeverinta Eliberata", false,ImageID.IMAGE_EDITOR_GRAY);
		   adeverinteElibButton.setLayoutData(data);
		 
		   
		  
		 
		}
	 private List<ColumnDescriptor> tableColumnDescrisptors(){
		   List<ColumnDescriptor> columnDescriptors=new ArrayList<ColumnDescriptor>();
		   
		   ColumnDescriptor columnDescriptor=new ColumnDescriptor(PacientMessages.EDIT_COLUMN_DATE.getMessage(),100,ColumnType.COLUMN_LABLE, PacientMessages.EDIT_COLUMN_DATE.getMessage(),false);
		   columnDescriptors.add(columnDescriptor);
		   
		   columnDescriptor=new ColumnDescriptor(PacientMessages.EDIT_COLUMN_NUME.getMessage(),150,ColumnType.COLUMN_LABLE, PacientMessages.EDIT_COLUMN_NUME.getMessage(),false);
		   columnDescriptors.add(columnDescriptor);
		   
		   columnDescriptor=new ColumnDescriptor(PacientMessages.EDIT_COLUMN_PRENUME.getMessage(),150,ColumnType.COLUMN_LABLE, PacientMessages.EDIT_COLUMN_PRENUME.getMessage(),false);
		   columnDescriptors.add(columnDescriptor);
		   
		   columnDescriptor=new ColumnDescriptor(PacientMessages.EDIT_COLUMN_OBS.getMessage(),500,ColumnType.COLUMN_LABLE, PacientMessages.EDIT_COLUMN_OBS.getMessage(),false);
		   columnDescriptors.add(columnDescriptor);
		   
		   return columnDescriptors;
	   }
	   
	 private List<Object> tableInputObject(){
			List<Object> list=new ArrayList<Object>();
			
			MedicPrimar medicPrimar=this.patientModel.getMedicModel().getMedicPrimar();
			
			
			Iterator<Consult> it = null;
			try {
				it = patientModel.getBusinessService().getAllConsultatiiForMedic(medicPrimar).iterator();
			} catch (BusinessSQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (it.hasNext()) {
				Consult consult=it.next();
				list.add(consult);
			}
			return list;
		}
	  
	   private void createListeners(){
		   
		   VisitHistoryAction action=new VisitHistoryAction();
		   action.setTableViewer(tableViewer);
		   action.setAdeverinteElibButton(adeverinteElibButton);
		   action.setReteteElibButton(reteteElibButton);
		   action.setRetetaModel(retetaModel);
		   action.setPacinetModel(patientModel);
		   
		   adeverinteElibButton.addListener(SWT.Selection, action);
		   reteteElibButton.addListener(SWT.Selection, action);
		  
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
		// TODO Auto-generated method stub
		
	}
	/**
	 * @return the patientModel
	 */
	public PacientModel getPatientModel() {
		return patientModel;
	}

	/**
	 * @param patientModel the patientModel to set
	 */
	public void setPatientModel(PacientModel patientModel) {
		this.patientModel = patientModel;
	}


	/**
	 * @return the retetaModel
	 */
	public RetetaModel getRetetaModel() {
		return retetaModel;
	}


	/**
	 * @param retetaModel the retetaModel to set
	 */
	public void setRetetaModel(RetetaModel retetaModel) {
		this.retetaModel = retetaModel;
	}


}
