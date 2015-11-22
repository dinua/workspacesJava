
package com.medweb.ui.pacient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import medweb.psconf.daos.CasaAsigurari;
import medweb.psconf.daos.CategorieAsigurat;
import medweb.psconf.daos.Pacient;
import medweb.psconf.daos.PacientInfo;

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

public class PacientNewView extends ViewPart{

	public static final String ID = "com.medweb.ui.pacient.pacientNewView";
	private PacientModel patientModel;
	private Composite tableComposite;
	private TableViewer tableViewer;
	private Button saveButton;
	private Text numePacientText;
	private Text prenumePacientText;
	private ComboViewer sexComboViewer;
	private ComboViewer casaAsigComboViewer;
	private ComboViewer catAsigComboViewer;
	private Button asiguratButton;
	
	
	@Override
	public void createPartControl(Composite parent) {
		
		parent.setLayout(new GridLayout(1,true));
		Composite composite=new Composite(parent,SWT.FILL);
		composite.setLayout(new GridLayout(12,true));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		//get info about patient
	////////////////////////////////////////////////////////////////	
		// patientModel.getAllInfoForPatient();
		
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
		 
		   saveButton = WidgetFactory.createButton(parent, "saveButton",PacientMessages.EDIT_SAVE.getMessage(), false,ImageID.IMAGE_SAVE);
		   GridData data =new GridData(SWT.FILL,SWT.BOTTOM,false,false,1,1);
		   data.widthHint=80;
		   saveButton.setLayoutData(data);
		   
		}
	
	private void createHeadComposite(Group composite){
		//grid 8 cell 
		Label numePacientLabel=WidgetFactory.createLabel(composite, "numePacientLabel",PacientMessages.EDIT_NUME.getMessage());
		 numePacientLabel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));
		 
		 numePacientText = WidgetFactory.createText(composite, "numePacientText", 100, false);
		 numePacientText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		addBlankLabels(composite, 2);
		
		asiguratButton = WidgetFactory.createCheckBox(composite, "", PacientMessages.EDIT_ASIGURAT.getMessage(), false);
		asiguratButton.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));
		
		addBlankLabels(composite, 2);
		
		Label prenumePacientLabel=WidgetFactory.createLabel(composite, "prenumePacientLabel",PacientMessages.EDIT_PRENUME.getMessage());
		prenumePacientLabel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));
		
		prenumePacientText = WidgetFactory.createText(composite, "prenumePacientText", 100, false);
		prenumePacientText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		
		addBlankLabels(composite, 5);
		
		 Label sexLabel=WidgetFactory.createLabel(composite, "sexLabel",PacientMessages.EDIT_INFO_SEX.getMessage());
		 sexLabel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));
         
		 sexComboViewer = WidgetFactory.createComboViewer(composite, "sexComboViewer", false);
		 addBlankLabels(composite, 6);
		 
		 Label casaAsigLabel=WidgetFactory.createLabel(composite, "casaAsigLabel",PacientMessages.EDIT_CASA_ASIGURARI.getMessage());
		 casaAsigLabel.setLayoutData(new GridData(SWT.LEFT,SWT.FILL,true,false,2,1));
         
		 casaAsigComboViewer = WidgetFactory.createComboViewer(composite, "casaAsigComboViewer", false);
		 
		 Label catAsigLabel=WidgetFactory.createLabel(composite, "catAsigLabel",PacientMessages.EDIT_CATEGORIE_ASIGURARE.getMessage());
		 catAsigLabel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,2,1));
         
		 catAsigComboViewer = WidgetFactory.createComboViewer(composite, "catAsigComboViewer", false);
		
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
			
			
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_CNP.getMessage(),""));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_SERIE_BULETIN.getMessage(),""));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_NR_BULETIN.getMessage(), ""));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_NR_CONTRACT_CNAS.getMessage(), ""));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_GRUPA_SANGUINA.getMessage(),""));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_RH.getMessage(), "" ));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_BIRTHDAY.getMessage(), ""));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_BDAY_PLACE.getMessage(), ""));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_STARE_CIVILA.getMessage(),""));
			//list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_ADRESA.getMessage(), ""));
			list.add(createPatientRowInformation(PacientMessages.EDIT_JUDET.getMessage(), ""));
			list.add(createPatientRowInformation(PacientMessages.EDIT_LOCALITATE.getMessage(),""));
			list.add(createPatientRowInformation(PacientMessages.EDIT_STRADA.getMessage(), ""));
			list.add(createPatientRowInformation(PacientMessages.EDIT_NUMAR.getMessage(), ""));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_COD_POSTAL.getMessage(), ""));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_TELEFON.getMessage(), ""));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_EMAIL.getMessage(),""));
			
			return list;
		}
	 
	 private PatientRowInformation createPatientRowInformation(String rowName,String value){
		 PatientRowInformation patientRowInformation =new PatientRowInformation();
		 patientRowInformation.setRowName(rowName);
		 if(value==null)
			 value="";
		 patientRowInformation.setValue(value);
		 return patientRowInformation;
	 }
	 private void createBindings(){
		 
		
//................sexComboViewer............................................		 
		 sexComboViewer.add(PatientSexEnum.SEX_MALE.toString());
		 sexComboViewer.add(PatientSexEnum.SEX_FEMELE.toString());
		
//....................categorie asigurat.......................................		
         
		 Iterator<CategorieAsigurat> itCat=this.patientModel.getAllCategorieAsigurat().iterator();
	     while(itCat.hasNext()){
	    	 CategorieAsigurat categorieAsigurat=itCat.next();
	    	 catAsigComboViewer.add(categorieAsigurat.getNume());
	    	
	    	 
	     }
	   
//....................casa de asigurari .............................................
	    
	     Iterator<CasaAsigurari> itCasa=this.patientModel.getAllCasaAsigurari().iterator();
	     while(itCasa.hasNext()){
	    	 CasaAsigurari casaAsig=itCasa.next();
	    	 casaAsigComboViewer.add(casaAsig.getNume());
	    	
	     }
	    
	 }
	 private void createListeners(){
		
		 SaveAction saveAction=new SaveAction();
		 saveAction.setNumePacientText(numePacientText);
		 saveAction.setPrenumePacientText(prenumePacientText);
		 saveAction.setSexComboViewer(sexComboViewer);
		 saveAction.setCasaAsigComboViewer(casaAsigComboViewer);
		 saveAction.setCatAsigComboViewer(catAsigComboViewer);
		 saveAction.setAsiguratButton(asiguratButton);
		 saveAction.setTableViewer(tableViewer);
		 saveAction.setPacientInfo(new PacientInfo());
		 saveAction.setPacient(new Pacient());
		 saveAction.setModel(patientModel);
		 patientModel.setNewPatient(true);
		 
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
	 * @return the patientModel
	 */
	public PacientModel getPatientModel() {
		return patientModel;
	}

	/**
	 * @param patientModel the patientModel to set
	 */
	public void setPatientModel(final PacientModel patientModel) {
		this.patientModel = patientModel;
	}

}

