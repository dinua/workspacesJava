package com.medweb.ui.administrare;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.MedicPrimar;
import medweb.psconf.daos.User;

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

public class UtilizatoriInactiviView extends ViewPart{
	
	public static final String ID = "com.medweb.ui.administrare.utilizatoriInactiviView";
	private Composite tableComposite;
	private TableViewer tableViewer;
	private Button reactivateButton;
	private UtilizatorModel utilizatorModel;
	
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
		
		List<User> listUsers=null;
		MedicPrimar medicPrimar=null;
		try {
			 listUsers=this.utilizatorModel.getBusinessService().getAllInactivUsers();
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<User> itU=listUsers.iterator();
		while(itU.hasNext()){
			User u=itU.next();
			try {
				medicPrimar=this.utilizatorModel.getBusinessService().getMedicPrimarByID(u.getIdUser());
			} catch (BusinessSQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UtilizatorRow row=new UtilizatorRow();
			row.setIdUser(u.getIdUser());
			row.setUsername(u.getUsername());
			row.setNume(medicPrimar.getNume());
			row.setPrenume(medicPrimar.getPrenume());
			row.setTip(u.getUserType().getName());
			list.add(row);
		}
		return list;
	}
	
   
   private List<ColumnDescriptor> tableColumnDescrisptors(){
 List<ColumnDescriptor> columnDescriptors=new ArrayList<ColumnDescriptor>();
	   
	   ColumnDescriptor columnDescriptor=new ColumnDescriptor(UtilizatorMessages.COLUMN_USERNAME.getMessage(),150,ColumnType.COLUMN_LABLE, UtilizatorMessages.COLUMN_USERNAME.getMessage(),false);
	   columnDescriptors.add(columnDescriptor);
	   
	   columnDescriptor=new ColumnDescriptor(UtilizatorMessages.COLUMN_NUME.getMessage(),150,ColumnType.COLUMN_LABLE, UtilizatorMessages.COLUMN_NUME.getMessage(),false);
	   columnDescriptors.add(columnDescriptor);
	   
	   columnDescriptor=new ColumnDescriptor(UtilizatorMessages.COLUMN_PRENUME.getMessage(),150,ColumnType.COLUMN_LABLE, UtilizatorMessages.COLUMN_PRENUME.getMessage(),false);
	   columnDescriptors.add(columnDescriptor);
	   
	   columnDescriptor=new ColumnDescriptor(UtilizatorMessages.COLUMN_TIP.getMessage(),100,ColumnType.COLUMN_LABLE, UtilizatorMessages.COLUMN_TIP.getMessage(),false);
	   columnDescriptors.add(columnDescriptor);
	   
	   return columnDescriptors;
   }
   
   
  
   private void createListeners(){
	     UtilizatorReactivateAction action=new UtilizatorReactivateAction();
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
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the utilizatorModel
	 */
	public UtilizatorModel getUtilizatorModel() {
		return utilizatorModel;
	}

	/**
	 * @param utilizatorModel the utilizatorModel to set
	 */
	public void setUtilizatorModel(UtilizatorModel utilizatorModel) {
		this.utilizatorModel = utilizatorModel;
	}

}
