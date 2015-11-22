package com.medweb.ui.pacient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.Pacient;

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
import com.medweb.ui.table.ColumnDescriptor;
import com.medweb.ui.table.ColumnType;

public class PacinetInactivView extends ViewPart{
	public static final String ID = "com.medweb.ui.pacient.pacinetInactivView";
	private Composite tableComposite;
	private TableViewer tableViewer;
	//private Button newVisit;
	private Button reactivateButton;
	//private Button info;
	private PacientModel patientModel;
	
	
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1,true));
		Composite composite=new Composite(parent,SWT.FILL);
		composite.setLayout(new GridLayout(12,true));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		createToolbarButtons(composite);
		
		
		tableComposite = WidgetFactory.createTableViewer(parent, SWT.V_SCROLL,tableColumnDescrisptors(),tableInputObject());
		GridLayout gridLayout = new GridLayout();
		 tableComposite.setLayout(gridLayout);
		 GridData data=new GridData(SWT.FILL, SWT.FILL, true, true);
		tableComposite.setLayoutData(data);
		
		tableViewer=WidgetFactory.getTableViewer();
		createListeners();
		
	}
	private void createToolbarButtons(Composite parent){
		 
		addBlankLabels(parent, 1);
		   GridData data =new GridData(SWT.FILL,SWT.BOTTOM,false,false,2,1);
		   data.widthHint=80;
		   
		   reactivateButton = WidgetFactory.createButton(parent, "reactivateButton","Reactiveaza", false,ImageID.IMAGE_DELETE);
		   reactivateButton.setLayoutData(data);
		 
		   addBlankLabels(parent, 21);
		 
		}
	private List<Object> tableInputObject(){
		List<Object> list=new ArrayList<Object>();
		int idMedic=this.getPatientModel().getMedicModel().getIdMedicRezident();
		List<Pacient> listActiv = null;
		try {
			listActiv = getPatientModel().getBusinessService().getAllInactivPatientsForMedic(idMedic);
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Pacient> it=listActiv.iterator();
		while (it.hasNext()) {
			Pacient pacient=it.next();
			list.add(pacient);
		}
		return list;
	}
	
   
   private List<ColumnDescriptor> tableColumnDescrisptors(){
	   List<ColumnDescriptor> columnDescriptors=new ArrayList<ColumnDescriptor>();
	   
	   ColumnDescriptor columnDescriptor=new ColumnDescriptor("Nume",150,ColumnType.COLUMN_LABLE, "Nume",false);
	   columnDescriptors.add(columnDescriptor);
	   
	   columnDescriptor=new ColumnDescriptor("Prenume",150,ColumnType.COLUMN_LABLE, "Prenume",false);
	   columnDescriptors.add(columnDescriptor);
	   
	   columnDescriptor=new ColumnDescriptor("Asigurat",30,ColumnType.COLUMN_LABLE, "Asigurat",false);
	   columnDescriptors.add(columnDescriptor);
	   
	   return columnDescriptors;
   }
   
   
  
   private void createListeners(){
	   
	   PacientReactivateAction action=new PacientReactivateAction();
	   action.setTableViewer(tableViewer);
	 
	   reactivateButton.addListener(SWT.Selection, action);
	 
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

}
