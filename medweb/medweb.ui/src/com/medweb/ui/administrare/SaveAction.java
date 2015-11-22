package com.medweb.ui.administrare;

import medweb.psconf.daos.CasaAsigurari;
import medweb.psconf.daos.MedicPrimar;
import medweb.psconf.daos.MedicPrimarInfo;

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

import com.medweb.ui.medic.MedicMessages;
import com.medweb.ui.medic.MedicRowInformation;
import com.medweb.ui.pacient.PacientMessages;

@SuppressWarnings("serial")
public class SaveAction implements Listener{
	private Button saveButton;
	private TableViewer tableViewer;
	private Text numeMedicText;
	private Text prenumeMedicText;
	private ComboViewer casaAsigComboViewer;
	private UtilizatorModel model;
	
	@Override
	public void handleEvent(Event event) {
		Button button=(Button) event.widget;
		if(button.equals(getSaveButton())){
			updateMedic();
		}
		
	}
	
private void updateMedic(){
		
		MedicPrimar medic=getModel().getMedicPrimar();
		MedicPrimarInfo info=getModel().getMedicInfo();
		
		String nume=getNumeMedicText().getText();
		String prenume=getPrenumeMedicText().getText();
		String casa=getCasaAsigComboViewer().getSelection().toString();
		casa=casa.substring(1,casa.length()-1);
		
		CasaAsigurari casaAsig=new CasaAsigurari();
		casaAsig.setNume(casa);
		
		medic.setNume(nume);
		medic.setPrenume(prenume);
		medic.setCasaAsigurari(casaAsig);
		
		TableItem[] tableItems=	getTableViewer().getTable().getItems();
		 info=recreateInfoMedic(info, tableItems);
			
		 getModel().setMedicPrimar(medic);
		 //info.setMedicPrimar(medic);
		 getModel().setMedicInfo(info);
		 getModel().internalSave();
		 IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(), 
					"Datele au fost salvate");
		 
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
	 * @return the numeMedicText
	 */
	public Text getNumeMedicText() {
		return numeMedicText;
	}

	/**
	 * @param numeMedicText the numeMedicText to set
	 */
	public void setNumeMedicText(Text numeMedicText) {
		this.numeMedicText = numeMedicText;
	}

	/**
	 * @return the prenumeMedicText
	 */
	public Text getPrenumeMedicText() {
		return prenumeMedicText;
	}

	/**
	 * @param prenumeMedicText the prenumeMedicText to set
	 */
	public void setPrenumeMedicText(Text prenumeMedicText) {
		this.prenumeMedicText = prenumeMedicText;
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
	
}
