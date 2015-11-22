package com.medweb.ui.medic;

import medweb.psconf.daos.CabinetMedical;
import medweb.psconf.daos.CasaAsigurari;
import medweb.psconf.daos.MedicPrimar;
import medweb.psconf.daos.MedicPrimarInfo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

@SuppressWarnings("serial")
public class SaveAction implements Listener{

private Button saveInfo;
private Button saveCabinet;
private TableViewer tableViewer;
private Text numeMedicText;
private Text prenumeMedicText;
private Text numeCabinet;
private ComboViewer casaAsigComboViewer;
private MedicModel medicModel;

	@Override
	public void handleEvent(Event event) {
		Button button=(Button) event.widget;
		if(button.equals(saveInfo)){
			updateMedic();
		}
		else if(button.equals(saveCabinet)){
			MedicPrimar medic=medicModel.getMedicPrimar();
			CabinetMedical cabinet=new CabinetMedical();
			cabinet.setNume(numeCabinet.getText());
			medic.setCabinetMedical(cabinet);
			medicModel.setMedicPrimar(medic);
			medicModel.internalSave();
		}
		
	}
	
	private void updateMedic(){
		
		MedicPrimar medic=medicModel.getMedicPrimar();
		MedicPrimarInfo info=medicModel.getMedicPrimarInfo();
		
		String nume=numeMedicText.getText();
		String prenume=prenumeMedicText.getText();
		String casa=casaAsigComboViewer.getSelection().toString();
		casa=casa.substring(1,casa.length()-1);
		
		CasaAsigurari casaAsig=new CasaAsigurari();
		casaAsig.setNume(casa);
		
		medic.setNume(nume);
		medic.setPrenume(prenume);
		medic.setCasaAsigurari(casaAsig);
		
		TableItem[] tableItems=	tableViewer.getTable().getItems();
		 info=recreateInfoMedic(info, tableItems);
			
		 medicModel.setMedicPrimar(medic);
		 //info.setMedicPrimar(medic);
		 medicModel.setMedicPrimarInfo(info);
		 medicModel.internalSave();
		 
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
	 * @return the saveInfo
	 */
	public Button getSaveInfo() {
		return saveInfo;
	}
	/**
	 * @param saveInfo the saveInfo to set
	 */
	public void setSaveInfo(Button saveInfo) {
		this.saveInfo = saveInfo;
	}
	/**
	 * @return the saveCabinet
	 */
	public Button getSaveCabinet() {
		return saveCabinet;
	}
	/**
	 * @param saveCabinet the saveCabinet to set
	 */
	public void setSaveCabinet(Button saveCabinet) {
		this.saveCabinet = saveCabinet;
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
	 * @return the medicModel
	 */
	public MedicModel getMedicModel() {
		return medicModel;
	}

	/**
	 * @param medicModel the medicModel to set
	 */
	public void setMedicModel(MedicModel medicModel) {
		this.medicModel = medicModel;
	}

	/**
	 * @return the numeCabinet
	 */
	public Text getNumeCabinet() {
		return numeCabinet;
	}

	/**
	 * @param numeCabinet the numeCabinet to set
	 */
	public void setNumeCabinet(Text numeCabinet) {
		this.numeCabinet = numeCabinet;
	}

}
