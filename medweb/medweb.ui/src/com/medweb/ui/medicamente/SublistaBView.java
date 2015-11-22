
package com.medweb.ui.medicamente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.Medicament;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

import com.medweb.ui.help.ImageID;
import com.medweb.ui.help.WidgetFactory;
import com.medweb.ui.table.ColumnDescriptor;
import com.medweb.ui.table.ColumnType;

public class SublistaBView extends ViewPart{
	public static final String ID = "com.medweb.ui.medicamente.sublistaBView";
	
	private Composite tableComposite;
	private TableViewer tableViewer;
	private Button infoButton;
	private MedicamneteModel medicamentModel;
	
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1,true));
		Composite composite=new Composite(parent,SWT.FILL);
		composite.setLayout(new GridLayout(12,true));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));


		Group headComposite=new Group(composite, SWT.None);
		headComposite.setLayout(new GridLayout(8,true));
		GridData headDataGrid=new GridData(SWT.FILL, SWT.FILL, true, true,12,1);
		headComposite.setLayoutData(headDataGrid);
		headComposite.setText(MedicamenteMessages.EDIT_TABLE_NAME.getMessage());
		createHeadComposite(headComposite);
		
		createToolbarCompiste(parent);
		
		tableComposite = WidgetFactory.createTableViewer(parent, SWT.V_SCROLL,
				tableColumnDescrisptors(),tableInputObject(),115,true);
		GridLayout gridLayout = new GridLayout();
		 tableComposite.setLayout(gridLayout);
		 GridData data=new GridData(SWT.FILL, SWT.FILL, true, true);
		tableComposite.setLayoutData(data);
		
		tableViewer=WidgetFactory.getTableViewer();
		
		createBindings();
		createListeners();
	}
	private void createToolbarCompiste(Composite composite){
		Composite toolbar=new Composite(composite, SWT.None);
		toolbar.setLayout(new GridLayout(12,true));
		toolbar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		addBlankLabels(toolbar, 1);
	    infoButton=WidgetFactory.createButton(toolbar, "infoButton",  MedicamenteMessages.EDIT_BUTTON_INFO.getMessage(), false,ImageID.IMAGE_PASTE_EDIT);
		infoButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	}
	private void createHeadComposite(Group composite){
		//grid 8 cell 
		addBlankLabels(composite, 1);
		Label info1=WidgetFactory.createLabel(composite, "info1",MedicamenteMessages.EDIT_SUBLISTA_INFO_B1.getMessage());
		info1.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,6,1));
		addBlankLabels(composite, 1);
		
		Label info2=WidgetFactory.createLabel(composite, "info2",MedicamenteMessages.EDIT_SUBLISTA_INFO_B2.getMessage());
		info2.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,8,1));
		
		Label info3=WidgetFactory.createLabel(composite, "info3",MedicamenteMessages.EDIT_SUBLISTA_INFO_B3.getMessage());
		info3.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,8,1));
		
	}
	 private List<ColumnDescriptor> tableColumnDescrisptors(){
		   List<ColumnDescriptor> columnDescriptors=new ArrayList<ColumnDescriptor>();
		   
		
		 	
		   ColumnDescriptor columnDescriptor=new ColumnDescriptor(MedicamenteMessages.EDIT_COLUMN1_NAME.getMessage(),150,ColumnType.COLUMN_LABLE, MedicamenteMessages.EDIT_COLUMN1_NAME.getMessage(),false);
		   columnDescriptors.add(columnDescriptor);
		   
		   columnDescriptor=new ColumnDescriptor(MedicamenteMessages.EDIT_COLUMN2_NAME.getMessage(),270,ColumnType.COLUMN_LABLE, MedicamenteMessages.EDIT_COLUMN2_NAME.getMessage(),false);
		   columnDescriptors.add(columnDescriptor);
		   
		   columnDescriptor=new ColumnDescriptor(MedicamenteMessages.EDIT_COLUMN3_NAME.getMessage(),270,ColumnType.COLUMN_LABLE, MedicamenteMessages.EDIT_COLUMN3_NAME.getMessage(),false);
		   columnDescriptors.add(columnDescriptor);
		   
		   columnDescriptor=new ColumnDescriptor(MedicamenteMessages.EDIT_COLUMN4_NAME.getMessage(),230,ColumnType.COLUMN_LABLE,MedicamenteMessages.EDIT_COLUMN4_NAME.getMessage(),false);
		   columnDescriptors.add(columnDescriptor);
		   
		   columnDescriptor=new ColumnDescriptor(MedicamenteMessages.EDIT_COLUMN5_NAME.getMessage(),150,ColumnType.COLUMN_LABLE,MedicamenteMessages.EDIT_COLUMN5_NAME.getMessage(),false);
		   columnDescriptors.add(columnDescriptor);
		   
		   columnDescriptor=new ColumnDescriptor(MedicamenteMessages.EDIT_COLUMN6_NAME.getMessage(),300,ColumnType.COLUMN_LABLE, MedicamenteMessages.EDIT_COLUMN6_NAME.getMessage(),false);
		   columnDescriptors.add(columnDescriptor);
		   
		  
		   return columnDescriptors;
	   }
	 private List<Object> tableInputObject(){
		 List<Object> list=new ArrayList<Object>();
			
			List<Medicament> listMedicament = null;
			try {
				listMedicament = this.medicamentModel.getBusinessService()
						.getSublistaMedicamente(SublistaEnum.SUBLISTA_B.getOrdinalValue());
			} catch (BusinessSQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Iterator<Medicament> it=listMedicament.iterator();
			while(it.hasNext()){
				Medicament m=it.next();
				list.add(m);
			}
			
			return list;
		}
	 private void createBindings(){
		 
		
	 }
	 private void addBlankLabels(Composite parent,int number){
			for(int i=0;i<number;i++){
				Label label=WidgetFactory.createLabel(parent, "");
				label.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
			    //label.setText("#");
			}
		}
	 
	 private void createListeners(){
		 infoButton.addListener(SWT.Selection, new MedicamenteInfoAction(medicamentModel,tableViewer));
	 }
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @return the medicamentModel
	 */
	public MedicamneteModel getMedicamentModel() {
		return medicamentModel;
	}
	/**
	 * @param medicamentModel the medicamentModel to set
	 */
	public void setMedicamentModel(MedicamneteModel medicamentModel) {
		this.medicamentModel = medicamentModel;
	}

}
