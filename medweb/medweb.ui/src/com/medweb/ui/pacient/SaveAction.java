package com.medweb.ui.pacient;

import medweb.psconf.daos.CasaAsigurari;
import medweb.psconf.daos.CategorieAsigurat;
import medweb.psconf.daos.Pacient;
import medweb.psconf.daos.PacientInfo;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;



@SuppressWarnings("serial")
public class SaveAction implements Listener{
   
	private Text numePacientText;
	private Text prenumePacientText;
	private ComboViewer sexComboViewer;
	private ComboViewer casaAsigComboViewer;
	private ComboViewer catAsigComboViewer;
	private Button asiguratButton;
	private TableViewer tableViewer;
	private PacientInfo pacientInfo;
	private Pacient pacient;
	private PacientModel model;
	private final String SEPARATOR="%";
	@Override
	public void handleEvent(Event event) {
		
		String nume=numePacientText.getText();
		String prenume=prenumePacientText.getText();
		boolean asigurat=asiguratButton.getSelection();
		String numeCat=catAsigComboViewer.getSelection().toString();
		String numeCasa=casaAsigComboViewer.getSelection().toString();
		String sex=sexComboViewer.getSelection().toString();
		numeCat=numeCat.substring(1,numeCat.length()-1);
		numeCasa=numeCasa.substring(1,numeCasa.length()-1);
		sex=sex.substring(1,sex.length()-1);
		
		CategorieAsigurat categorie=new CategorieAsigurat();
		categorie.setNume(numeCat);
		CasaAsigurari casa=new CasaAsigurari();
		casa.setNume(numeCasa);
		
		pacient.setNume(nume);
		pacient.setPrenume(prenume);
		pacient.setAsigurat(asigurat);
		pacient.setCasaAsigurari(casa);
		pacient.setCategorieAsigurat(categorie);
		
		
		TableItem[] tableItems=	tableViewer.getTable().getItems();
	    pacientInfo=recreateInfoPatient(pacientInfo, tableItems);
		model.setPacient(pacient);
		pacientInfo.setPacient(pacient);
		pacientInfo.setSex(sex);
		model.setPacientInfo(pacientInfo);
		model.internalSave();
		IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(), 
				"Datele au fost salvate");
	    
	}

	private PacientInfo recreateInfoPatient(PacientInfo info,TableItem[] tableItems){
		
		for(int i=0;i<tableItems.length;i++){
			if(tableItems[i].getData() instanceof PatientRowInformation){
				PatientRowInformation rowInfo=(PatientRowInformation) tableItems[i].getData();
				setNewValueInfo(info, rowInfo.getRowName(), rowInfo.getValue());
			}
		}
		
		return info;
	}
		
	private void setNewValueInfo(PacientInfo info,String rowName,String value){
		if(rowName.equals(PacientMessages.EDIT_INFO_CNP.getMessage())){
			info.setCnp(value);
		}
		else if(rowName.equals(PacientMessages.EDIT_INFO_BIRTHDAY.getMessage())){
			info.setDataNastere(value);
		}
		else if(rowName.equals(PacientMessages.EDIT_INFO_BDAY_PLACE.getMessage())){
			info.setLocNastere(value);
		}
		
		else if(rowName.equals(PacientMessages.EDIT_INFO_GRUPA_SANGUINA.getMessage())){
			info.setGrupaSanguina(value);
		}
		else if(rowName.equals(PacientMessages.EDIT_INFO_STARE_CIVILA.getMessage())){
			info.setStareCivila(value);
		}
		else if(rowName.equals(PacientMessages.EDIT_INFO_RH.getMessage())){
			info.setRh(PatientRhEnum.fromString(value).getOrdinalValue());
		}
		//else if(rowName.equals(PacientMessages.EDIT_INFO_ADRESA.getMessage())){
			//info.setAdresa(value);	
		//}
		else if(rowName.equals(PacientMessages.EDIT_JUDET.getMessage())){
			String address=convertAddress(info.getAdresa());
			String[] vec=address.split(SEPARATOR);
			String adresa=value+SEPARATOR+vec[1]+SEPARATOR+vec[2]+SEPARATOR+vec[3];
			info.setAdresa(adresa);
		}
		else if(rowName.equals(PacientMessages.EDIT_LOCALITATE.getMessage())){
			String[] vec=info.getAdresa().split(SEPARATOR);
			String adresa=vec[0]+SEPARATOR +value+SEPARATOR+vec[2]+SEPARATOR+vec[3];
			info.setAdresa(adresa);
		}
		else if(rowName.equals(PacientMessages.EDIT_STRADA.getMessage())){
			String[] vec=info.getAdresa().split(SEPARATOR);
			String adresa=vec[0]+SEPARATOR+vec[1]+SEPARATOR+value+SEPARATOR+vec[3];
			info.setAdresa(adresa);
		}
		else if(rowName.equals(PacientMessages.EDIT_NUMAR.getMessage())){
			String[] vec=info.getAdresa().split(SEPARATOR);
			String adresa=vec[0]+SEPARATOR+vec[1]+SEPARATOR+vec[2]+SEPARATOR+value;
			info.setAdresa(adresa);
		}
		//////////////////
		else if(rowName.equals(PacientMessages.EDIT_INFO_COD_POSTAL.getMessage())){
			info.setCodPostal(value);
		}
		else if(rowName.equals(PacientMessages.EDIT_INFO_TELEFON.getMessage())){
			info.setTelefon(value);
		}
		else if(rowName.equals(PacientMessages.EDIT_INFO_EMAIL.getMessage())){
			info.setEmail(value);
		}
		else if(rowName.equals(PacientMessages.EDIT_INFO_SERIE_BULETIN.getMessage())){
			info.setSerieBuletin(value);
		}
		else if(rowName.equals(PacientMessages.EDIT_INFO_NR_BULETIN.getMessage())){
			info.setNrBuletin(value);
		}
		else if(rowName.equals(PacientMessages.EDIT_INFO_NR_CONTRACT_CNAS.getMessage())){
			info.setNrContractCNAS(value);
		}
	}
	private String convertAddress(String address){
		if(address==null) 
			address="";
		String[]vec=address.split(SEPARATOR);
		if(vec.length==0) 
			address=" "+SEPARATOR+" "+SEPARATOR+" "+SEPARATOR+" ";
		else if(vec.length==1)
		{
			String app=" "+SEPARATOR+" "+SEPARATOR+" ";
			address=vec[0]+SEPARATOR+app;
		}
		else if(vec.length==2)
		{
			String app=" "+SEPARATOR+" ";
			address=vec[0]+SEPARATOR+vec[1]+SEPARATOR+app;
		}
		else if(vec.length==3)
		{
			String app=SEPARATOR+" "; 
			address=vec[0]+SEPARATOR+vec[1]+"%"+vec[1]+SEPARATOR+app;
		}
		return address;
	}
	/**
	 * @return the numePacientText
	 */
	public Text getNumePacientText() {
		return numePacientText;
	}

	/**
	 * @param numePacientText the numePacientText to set
	 */
	public void setNumePacientText(Text numePacientText) {
		this.numePacientText = numePacientText;
	}

	/**
	 * @return the prenumePacientText
	 */
	public Text getPrenumePacientText() {
		return prenumePacientText;
	}

	/**
	 * @param prenumePacientText the prenumePacientText to set
	 */
	public void setPrenumePacientText(Text prenumePacientText) {
		this.prenumePacientText = prenumePacientText;
	}

	/**
	 * @return the sexComboViewer
	 */
	public ComboViewer getSexComboViewer() {
		return sexComboViewer;
	}

	/**
	 * @param sexComboViewer the sexComboViewer to set
	 */
	public void setSexComboViewer(ComboViewer sexComboViewer) {
		this.sexComboViewer = sexComboViewer;
	}

	/**
	 * @return the casaAsigComboViewer
	 */
	public ComboViewer getCasaAsigComboViewer() {
		return casaAsigComboViewer;
	}

	/**
	 * @param casaAsigComboViewer the casaAsigComboViewer to set
	 */
	public void setCasaAsigComboViewer(ComboViewer casaAsigComboViewer) {
		this.casaAsigComboViewer = casaAsigComboViewer;
	}

	/**
	 * @return the catAsigComboViewer
	 */
	public ComboViewer getCatAsigComboViewer() {
		return catAsigComboViewer;
	}

	/**
	 * @param catAsigComboViewer the catAsigComboViewer to set
	 */
	public void setCatAsigComboViewer(ComboViewer catAsigComboViewer) {
		this.catAsigComboViewer = catAsigComboViewer;
	}

	/**
	 * @return the asiguratButton
	 */
	public Button getAsiguratButton() {
		return asiguratButton;
	}

	/**
	 * @param asiguratButton the asiguratButton to set
	 */
	public void setAsiguratButton(Button asiguratButton) {
		this.asiguratButton = asiguratButton;
	}

	/**
	 * @return the tableViewer
	 */
	public TableViewer getTableViewer() {
		return tableViewer;
	}

	/**
	 * @param tableViewer the tableViewer to set
	 */
	public void setTableViewer(TableViewer tableViewer) {
		this.tableViewer = tableViewer;
	}

	/**
	 * @return the pacientInfo
	 */
	public PacientInfo getPacientInfo() {
		return pacientInfo;
	}

	/**
	 * @param pacientInfo the pacientInfo to set
	 */
	public void setPacientInfo(PacientInfo pacientInfo) {
		this.pacientInfo = pacientInfo;
	}

	/**
	 * @return the pacient
	 */
	public Pacient getPacient() {
		return pacient;
	}

	/**
	 * @param pacient the pacient to set
	 */
	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}

	/**
	 * @return the model
	 */
	public PacientModel getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(PacientModel model) {
		this.model = model;
	}
	
	

}
