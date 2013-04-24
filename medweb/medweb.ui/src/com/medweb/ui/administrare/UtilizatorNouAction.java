package com.medweb.ui.administrare;

import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.MedicPrimar;
import medweb.psconf.daos.MedicPrimarInfo;
import medweb.psconf.daos.User;
import medweb.psconf.daos.UserType;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.medweb.ui.medic.MedicMessages;
import com.medweb.ui.medic.MedicRowInformation;
import com.medweb.ui.pacient.PacientMessages;

@SuppressWarnings("serial")
public class UtilizatorNouAction implements Listener{
	private Button userButton;
	private Button saveButton;
	private Composite tableComposite;
	private Group medicHeadComposite; 
	private Text usernameText;
	private Text passwordText;
	private Text numeText;
	private Text prenumeText;
	private ComboViewer userTypeComboViewer;
	private UtilizatorModel model;
	private TableViewer tableViewer;
	
	@Override
	public void handleEvent(Event event) {
		Button button=(Button) event.widget;
		if(button.equals(userButton)){
			String selection=userTypeComboViewer.getSelection().toString();
			selection=selection.substring(1,selection.length()-1);
			
			if(hasText(usernameText.getText()) && hasText(passwordText.getText())&& 
					hasText(selection)){
			tableComposite.setVisible(true);
			medicHeadComposite.setVisible(true);
			}
			else{
				IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(), 
						"Datele nu au fost completate corect!");
			}
		}
		else if(button.equals(saveButton)){
			if(hasText(numeText.getText())&& hasText(prenumeText.getText())){
				saveUser();
			}
			else{
				IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(), 
						"Datele nu au fost completate corect!");
			}
		}
		
	}
private void saveUser(){
		
	    UserType userType=null;
	try {
		String selection=userTypeComboViewer.getSelection().toString();
		selection=selection.substring(1,selection.length()-1);
	    userType=this.model.getBusinessService().getUserTypeByName(selection);
	} catch (BusinessSQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    User user= new User();
	    user.setUsername(usernameText.getText());
	    user.setPassword(passwordText.getText());
	    user.setUserType(userType);
	    user.setActiv(true);
	    
		MedicPrimar medic=new MedicPrimar();
		MedicPrimarInfo info=new MedicPrimarInfo();
		
		medic.setNume(numeText.getText());
		medic.setPrenume(prenumeText.getText());
		
		
		TableItem[] tableItems=	getTableViewer().getTable().getItems();
		 info=recreateInfoMedic(info, tableItems);
			
		 getModel().setMedicPrimar(medic);
		 //info.setMedicPrimar(medic);
		 getModel().setMedicInfo(info);
		 //getModel().internalSave();
		 try {
			this.model.getBusinessService().saveUser(user, medic, info);
			IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(), 
					"Datele au fost salvate");
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	private MedicPrimarInfo recreateInfoMedic(MedicPrimarInfo info,TableItem[] tableItems){
		
		for(int i=0;i<tableItems.length;i++){
			if(tableItems[i].getData() instanceof MedicRowInformation){
				MedicRowInformation rowInfo=(MedicRowInformation) tableItems[i].getData();
				setNewValueInfo(info, rowInfo.getRowName(), rowInfo.getValue());
			}
		}
		
		return info;
	}
	private void setNewValueInfo(MedicPrimarInfo info, String rowName,
			String value) {
		if(rowName.equals(MedicMessages.EDIT_INFO_CNP.getMessage())){
			info.setCNP(value);
		}
		else if(rowName.equals(MedicMessages.EDIT_NR_CONTRACT_CNAS.getMessage())){
			info.setNrContractCNAS(value);
		}
		else if(rowName.equals(MedicMessages.EDIT_INITIALA.getMessage())){
			info.setInitiala(value);
		}
		else if(rowName.equals(MedicMessages.EDIT_INFO_ADRESA.getMessage())){
			info.setAdresa(value);
		}
		else if(rowName.equals(MedicMessages.EDIT_INFO_TELEFON.getMessage())){
			info.setTelefon(value);
		}
		else if(rowName.equals(MedicMessages.EDIT_COD_PARAFA.getMessage())){
			info.setCodParafa(value);
		}
		else if(rowName.equals(MedicMessages.EDIT_NR_LICENTA.getMessage())){
			info.setNrLicenta(value);
		}
	}

	private boolean hasText(String value){
		if(value.equals("") || value.equals(" ")||value.equals("empty selection")|| value==null)
		         return false;
		return true;
	}
	/**
	 * @return the userButton
	 */
	public Button getUserButton() {
		return userButton;
	}


	/**
	 * @param userButton the userButton to set
	 */
	public void setUserButton(Button userButton) {
		this.userButton = userButton;
	}


	/**
	 * @return the saveButton
	 */
	public Button getSaveButton() {
		return saveButton;
	}


	/**
	 * @param saveButton the saveButton to set
	 */
	public void setSaveButton(Button saveButton) {
		this.saveButton = saveButton;
	}


	/**
	 * @return the tableComposite
	 */
	public Composite getTableComposite() {
		return tableComposite;
	}


	/**
	 * @param tableComposite the tableComposite to set
	 */
	public void setTableComposite(Composite tableComposite) {
		this.tableComposite = tableComposite;
	}


	/**
	 * @return the medicHeadComposite
	 */
	public Group getMedicHeadComposite() {
		return medicHeadComposite;
	}


	/**
	 * @param medicHeadComposite the medicHeadComposite to set
	 */
	public void setMedicHeadComposite(Group medicHeadComposite) {
		this.medicHeadComposite = medicHeadComposite;
	}


	/**
	 * @return the usernameText
	 */
	public Text getUsernameText() {
		return usernameText;
	}


	/**
	 * @param usernameText the usernameText to set
	 */
	public void setUsernameText(Text usernameText) {
		this.usernameText = usernameText;
	}


	/**
	 * @return the passwordText
	 */
	public Text getPasswordText() {
		return passwordText;
	}


	/**
	 * @param passwordText the passwordText to set
	 */
	public void setPasswordText(Text passwordText) {
		this.passwordText = passwordText;
	}


	/**
	 * @return the numeText
	 */
	public Text getNumeText() {
		return numeText;
	}


	/**
	 * @param numeText the numeText to set
	 */
	public void setNumeText(Text numeText) {
		this.numeText = numeText;
	}


	/**
	 * @return the userTypeComboViewer
	 */
	public ComboViewer getUserTypeComboViewer() {
		return userTypeComboViewer;
	}


	/**
	 * @param userTypeComboViewer the userTypeComboViewer to set
	 */
	public void setUserTypeComboViewer(ComboViewer userTypeComboViewer) {
		this.userTypeComboViewer = userTypeComboViewer;
	}


	/**
	 * @return the prenumeText
	 */
	public Text getPrenumeText() {
		return prenumeText;
	}


	/**
	 * @param prenumeText the prenumeText to set
	 */
	public void setPrenumeText(Text prenumeText) {
		this.prenumeText = prenumeText;
	}
	/**
	 * @return the model
	 */
	public UtilizatorModel getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(UtilizatorModel model) {
		this.model = model;
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


	

}
