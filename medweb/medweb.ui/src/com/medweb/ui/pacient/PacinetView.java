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



/**
 * This view shows a &quot;mail message&quot;. This class is contributed through
 * the plugin.xml.
 */
public class PacinetView extends ViewPart {

	public static final String ID = "com.medweb.ui.pacient.pacinetView";
	private Composite tableComposite;
	private TableViewer tableViewer;
	//private Button newVisit;
	private Button delete;
	private Button info;
	private PacientModel patientModel;
	
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

	public void setFocus() {
	}
	
	private void createToolbarButtons(Composite parent){
	 
	  // newVisit = WidgetFactory.createButton(parent, "newVisit",PacientMessages.EDIT_BUTTON_NEW_VISIT.getMessage(), false,ImageID.IMAGE_NEW);
	   GridData data =new GridData(SWT.FILL,SWT.BOTTOM,false,false,1,1);
	   data.widthHint=80;
	  // newVisit.setLayoutData(data);
	     
	   delete = WidgetFactory.createButton(parent, "delete",PacientMessages.EDIT_BUTTON_DELETE.getMessage(), false,ImageID.IMAGE_DELETE);
	   delete.setLayoutData(data);
	   
	   info = WidgetFactory.createButton(parent, "info",PacientMessages.EDIT_BUTTON_INFO.getMessage(), false,ImageID.IMAGE_PASTE_EDIT);
	   info.setLayoutData(data);
	   
	   addBlankLabels(parent, 21);
	 
	}
	private void addBlankLabels(Composite parent,int number){
		for(int i=0;i<number;i++){
			Label label=WidgetFactory.createLabel(parent, "");
			label.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		    //label.setText("#");
		}
	}
	
	private List<Object> tableInputObject(){
		List<Object> list=new ArrayList<Object>();
		int idMedic=this.patientModel.getMedicModel().getIdMedicRezident();
		List<Pacient> listActiv = null;
		try {
			listActiv = patientModel.getBusinessService().getAllActivPatientsForMedic(idMedic);
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
	   
	   PacientAction pacinetAction=new PacientAction();
	  // pacinetAction.setNewVisit(newVisit);
	   pacinetAction.setDelete(delete);
	   pacinetAction.setInfo(info);
	   pacinetAction.setTableViewer(tableViewer);
	   
	   //newVisit.addListener(SWT.Selection, pacinetAction);
	   delete.addListener(SWT.Selection, pacinetAction);
	   info.addListener(SWT.Selection, pacinetAction);
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
