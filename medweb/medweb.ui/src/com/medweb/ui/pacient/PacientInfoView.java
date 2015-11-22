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
import com.medweb.ui.retete.RetetaModel;
import com.medweb.ui.table.ColumnDescriptor;
import com.medweb.ui.table.ColumnType;
import com.medweb.ui.table.TableMessages;

public class PacientInfoView extends ViewPart{

	public static final String ID = "com.medweb.ui.pacient.pacientInfoView";
	private PacientModel patientModel;
	private RetetaModel retetaModel;
	private Composite tableComposite;
	private TableViewer tableViewer;
	private Button saveButton;
	private Text numePacientText;
	private Text prenumePacientText;
	private ComboViewer sexComboViewer;
	private ComboViewer casaAsigComboViewer;
	private ComboViewer catAsigComboViewer;
	private Button asiguratButton;
	private Button retetaButton;
	private Button adeverintaButton;
	
	
	@Override
	public void createPartControl(Composite parent) {
		
		parent.setLayout(new GridLayout(1,true));
		Composite composite=new Composite(parent,SWT.FILL);
		composite.setLayout(new GridLayout(12,true));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		//get info about patient
		 patientModel.getAllInfoForPatient();
		
		createToolbarButtons(composite);
		
		
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
		   GridData data =new GridData(SWT.CENTER,SWT.BOTTOM,false,false,1,1);
		   data.widthHint=80;
		   saveButton.setLayoutData(data);
		   
		   retetaButton = WidgetFactory.createButton(parent, "retetaButton",PacientMessages.EDIT_RETETA.getMessage(), false,ImageID.IMAGE_EDITOR);
		   retetaButton.setLayoutData(data);
		  
		   adeverintaButton = WidgetFactory.createButton(parent, "adeverintaButton",PacientMessages.EDIT_ADEVERINTA.getMessage(), false,ImageID.IMAGE_EDITOR_GRAY);
		   GridData data2 =new GridData(SWT.CENTER,SWT.BOTTOM,false,false,1,1);
		   data.widthHint=120;
		   adeverintaButton.setLayoutData(data2);
		   
		   retetaButton.setVisible(!retetaModel.getMedicModel().isRestricted());
		   adeverintaButton.setVisible(!retetaModel.getMedicModel().isRestricted());
		   addBlankLabels(parent, 21);
		}
	
	private void createHeadComposite(Group composite){
		//grid 8 cell 
		Label numePacientLabel=WidgetFactory.createLabel(composite, "numePacientLabel",PacientMessages.EDIT_NUME.getMessage());
		 numePacientLabel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));
		 
		 numePacientText = WidgetFactory.createText(composite, "numePacientText", 100, false);
		 numePacientText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		addBlankLabels(composite, 1);
		
		asiguratButton = WidgetFactory.createCheckBox(composite, "", PacientMessages.EDIT_ASIGURAT.getMessage(), false);
		asiguratButton.setLayoutData(new GridData(SWT.LEFT,SWT.FILL,true,false,1,1));
		
		addBlankLabels(composite, 3);
		
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
		 casaAsigLabel.setLayoutData(new GridData(SWT.LEFT,SWT.FILL,true,false,1,1));
         
		 casaAsigComboViewer = WidgetFactory.createComboViewer(composite, "casaAsigComboViewer", false);
		 
		 Label catAsigLabel=WidgetFactory.createLabel(composite, "catAsigLabel",PacientMessages.EDIT_CATEGORIE_ASIGURARE.getMessage());
		 catAsigLabel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));
         
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
			
			PacientInfo info=patientModel.getPacientInfo();
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_CNP.getMessage(), info.getCnp()));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_SERIE_BULETIN.getMessage(), info.getSerieBuletin()));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_NR_BULETIN.getMessage(), info.getNrBuletin()));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_NR_CONTRACT_CNAS.getMessage(), info.getNrContractCNAS()));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_GRUPA_SANGUINA.getMessage(), info.getGrupaSanguina()));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_RH.getMessage(), PatientRhEnum.fromInteger(info.getRh()).toString() ));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_BIRTHDAY.getMessage(), info.getDataNastere()));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_BDAY_PLACE.getMessage(), info.getLocNastere()));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_STARE_CIVILA.getMessage(),info.getStareCivila()));
			//list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_ADRESA.getMessage(), info.getAdresa()));
			String[]vec=info.getAdresa().split("%");
			list.add(createPatientRowInformation(PacientMessages.EDIT_JUDET.getMessage(), vec[0]));
			list.add(createPatientRowInformation(PacientMessages.EDIT_LOCALITATE.getMessage(), vec[1]));
			list.add(createPatientRowInformation(PacientMessages.EDIT_STRADA.getMessage(), vec[2]));
			list.add(createPatientRowInformation(PacientMessages.EDIT_NUMAR.getMessage(), vec[3]));
			
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_COD_POSTAL.getMessage(), info.getCodPostal()));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_TELEFON.getMessage(), info.getTelefon()));
			list.add(createPatientRowInformation(PacientMessages.EDIT_INFO_EMAIL.getMessage(), info.getEmail()));
			
			
			
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
		 
		
		 Pacient pacient=patientModel.getPacient();
		 PacientInfo info=patientModel.getPacientInfo();
		 
		 numePacientText.setText(pacient.getNume());
		 prenumePacientText.setText(pacient.getPrenume());
		 asiguratButton.setSelection(pacient.isAsigurat());
//................sexComboViewer............................................		 
		 sexComboViewer.add(PatientSexEnum.SEX_MALE.toString());
		 sexComboViewer.add(PatientSexEnum.SEX_FEMELE.toString());
		 if(info.getSex()!=null && info.getSex().equals(PatientSexEnum.SEX_MALE.toString()))
		              sexComboViewer.getCombo().select(0);
		 else
			 sexComboViewer.getCombo().select(0);
//....................categorie asigurat.......................................		
         int index=0;
		 Iterator<CategorieAsigurat> itCat=this.patientModel.getAllCategorieAsigurat().iterator();
	     String categAsig=pacient.getCategorieAsigurat().getNume();
	     while(itCat.hasNext()){
	    	 CategorieAsigurat categorieAsigurat=itCat.next();
	    	 catAsigComboViewer.add(categorieAsigurat.getNume());
	    	 if(categAsig.equals(categorieAsigurat.getNume()))
	    		 catAsigComboViewer.getCombo().select(index);
	    	index++; 
	     }
	   
//....................casa de asigurari .............................................
	     index=0;
	     Iterator<CasaAsigurari> itCasa=this.patientModel.getAllCasaAsigurari().iterator();
	     String numeCasaAsig=pacient.getCasaAsigurari().getNume();
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
		 saveAction.setNumePacientText(numePacientText);
		 saveAction.setPrenumePacientText(prenumePacientText);
		 saveAction.setSexComboViewer(sexComboViewer);
		 saveAction.setCasaAsigComboViewer(casaAsigComboViewer);
		 saveAction.setCatAsigComboViewer(catAsigComboViewer);
		 saveAction.setAsiguratButton(asiguratButton);
		 saveAction.setTableViewer(tableViewer);
		 saveAction.setPacientInfo(patientModel.getPacientInfo());
		 saveAction.setPacient(patientModel.getPacient());
		 saveAction.setModel(patientModel);
		 patientModel.setNewPatient(false);
		 
		 this.saveButton.addListener(SWT.Selection, saveAction);
		 
		// retetaModel.setPacinet(patientModel.getPacient());
		// retetaModel.setPatientInfo(patientModel.getPacientInfo());
		 RetetaAction action=new RetetaAction();
		 action.setAdeverintaButton(adeverintaButton);
		 action.setRetetaButton(retetaButton);
		 action.setRetetaModel(retetaModel);
		 
		 this.retetaButton.addListener(SWT.Selection, action);
		 this.adeverintaButton.addListener(SWT.Selection, action);
		
	   }
	private void addBlankLabels(Composite parent,int number){
		for(int i=0;i<number;i++){
			Label label=WidgetFactory.createLabel(parent, "");
			label.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		    //clabel.setText("#");
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
