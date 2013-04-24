package com.medweb.ui.administrare;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import medweb.psconf.daos.UserType;

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
import com.medweb.ui.medic.MedicMessages;
import com.medweb.ui.medic.MedicRowInformation;
import com.medweb.ui.pacient.PacientMessages;
import com.medweb.ui.table.ColumnDescriptor;
import com.medweb.ui.table.ColumnType;
import com.medweb.ui.table.TableMessages;

public class UtilizatorNouView extends ViewPart{
	public static final String ID = "com.medweb.ui.administrare.utilizatorNouView";
	private UtilizatorModel utilizatorModel;
	private Composite tableComposite;
	private Group medicHeadComposite; 
	private TableViewer tableViewer;
	private Button saveButton;
	private Text usernameText;
	private Text passwordText;
	private Text numeText;
	private Text prenumeText;
	private ComboViewer userTypeComboViewer;
	private Button userButton;
	
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1,true));
		Composite composite=new Composite(parent,SWT.FILL);
		composite.setLayout(new GridLayout(12,true));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			
		createToolbarButtons(composite);
		addBlankLabels(composite, 23);
		
		Group userHeadComposite=new Group(composite, SWT.None);
		userHeadComposite.setLayout(new GridLayout(8,true));
		GridData headDataGrid=new GridData(SWT.FILL, SWT.FILL, true, true,10,1);
		userHeadComposite.setLayoutData(headDataGrid);
		userHeadComposite.setText("User Info");
		createUserComposite(userHeadComposite);
		
	    medicHeadComposite=new Group(composite, SWT.None);
		medicHeadComposite.setLayout(new GridLayout(8,true));
		medicHeadComposite.setLayoutData(headDataGrid);
		medicHeadComposite.setText("Medic Info");
		createMedicComposite(medicHeadComposite);
		
		tableComposite = WidgetFactory.createTableViewer(parent, SWT.V_SCROLL,
				tableColumnDescrisptors(),tableInputObject(),95,true,true);
		GridLayout gridLayout = new GridLayout();
		 tableComposite.setLayout(gridLayout);
		 GridData data=new GridData(SWT.FILL, SWT.FILL, true, true);
		tableComposite.setLayoutData(data);
		
		tableViewer=WidgetFactory.getTableViewer();
		
		medicHeadComposite.setVisible(false);
		tableComposite.setVisible(false);
		
		createBindings();
		createListeners();
		
	}
	private void createUserComposite(Group group){
		//8 cell grid
		
		Label usernameLabel=WidgetFactory.createLabel(group, "usernameLabel","Username");
		usernameLabel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));
		 usernameText = WidgetFactory.createText(group, "usernameText", 100, false);
		 usernameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		
		 addBlankLabels(group, 5);
		 
		 Label passwordLabel=WidgetFactory.createLabel(group, "passwordLabel","Password");
		 passwordLabel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));
		 passwordText = WidgetFactory.createTextPassword(group, "passwordText", 100, false);
		 passwordText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		 
		 addBlankLabels(group, 5);
		 
		 Label typeLabel=WidgetFactory.createLabel(group, "typeLabel","Tip utilizator");
		 typeLabel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));
         
		 userTypeComboViewer = WidgetFactory.createComboViewer(group, "userTypeComboViewer", false);
		 addBlankLabels(group, 8);
		 
		 userButton = WidgetFactory.createButton(group, "userButton","Set", false,ImageID.IMAGE_EDITOR);
		   GridData data =new GridData(SWT.FILL,SWT.BOTTOM,false,false,1,1);
		   data.widthHint=80;
		   userButton.setLayoutData(data);
	}
	
	private void createMedicComposite(Group group){
		//8 cell grid
		
		Label nameLabel=WidgetFactory.createLabel(group, "nameLabel","Nume");
		nameLabel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));
		 numeText = WidgetFactory.createText(group, "numeText", 100, false);
		 numeText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		
		 addBlankLabels(group, 5);
		 
		 Label prenumeLabel=WidgetFactory.createLabel(group, "prenumeLabel","Prenume");
		 prenumeLabel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));
		 prenumeText = WidgetFactory.createText(group, "prenumeText", 100, false);
		 prenumeText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		 
		 addBlankLabels(group, 5);
	}
	private void createToolbarButtons(Composite parent){
		 
		   saveButton = WidgetFactory.createButton(parent, "saveButton",PacientMessages.EDIT_SAVE.getMessage(), false,ImageID.IMAGE_SAVE);
		   GridData data =new GridData(SWT.FILL,SWT.BOTTOM,false,false,1,1);
		   data.widthHint=80;
		   saveButton.setLayoutData(data);
		   
		}
	
	private void addBlankLabels(Composite parent,int number){
		for(int i=0;i<number;i++){
			Label label=WidgetFactory.createLabel(parent, "");
			label.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		   // label.setText("#");
		}
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
					
			list.add(createMedicRowInformation(MedicMessages.EDIT_INFO_CNP.getMessage(), ""));
         list.add(createMedicRowInformation(MedicMessages.EDIT_INITIALA.getMessage(), ""));
         list.add(createMedicRowInformation(MedicMessages.EDIT_INFO_ADRESA.getMessage(), ""));
         list.add(createMedicRowInformation(MedicMessages.EDIT_INFO_TELEFON.getMessage(), ""));
         list.add(createMedicRowInformation(MedicMessages.EDIT_COD_PARAFA.getMessage(), ""));
         list.add(createMedicRowInformation(MedicMessages.EDIT_NR_LICENTA.getMessage(), ""));
         list.add(createMedicRowInformation(MedicMessages.EDIT_NR_CONTRACT_CNAS.getMessage(), ""));
			
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
		 
		 userTypeComboViewer.add("");
		 List<UserType> list=this.utilizatorModel.getUserTypes();
		 Iterator<UserType> itt=list.iterator();
		 while(itt.hasNext()){
			 UserType ut=itt.next();
			 userTypeComboViewer.add(ut.getName());
		 }
		 
	    
	 }
	 private void createListeners(){
		
		 UtilizatorNouAction action=new UtilizatorNouAction();
		 action.setUserButton(userButton);
		 action.setSaveButton(saveButton);
		 action.setMedicHeadComposite(medicHeadComposite);
		 action.setTableComposite(tableComposite);
		 action.setUsernameText(usernameText);
		 action.setPasswordText(passwordText);
		 action.setNumeText(numeText);
		 action.setPrenumeText(prenumeText);
		 action.setUserTypeComboViewer(userTypeComboViewer);
		 action.setModel(utilizatorModel);
		 action.setTableViewer(tableViewer);
		 
		 
		 saveButton.addListener(SWT.Selection,action);
		 userButton.addListener(SWT.Selection,action);
	   }
	@Override
	public void setFocus() {
		
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
