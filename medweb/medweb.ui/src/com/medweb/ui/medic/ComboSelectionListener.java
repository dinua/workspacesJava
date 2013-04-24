package com.medweb.ui.medic;

import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.CasaAsigurari;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Text;

public class ComboSelectionListener implements ISelectionChangedListener {

	private MedicModel model;
	 private Text numeText;
	 private Text adresaText;
	 private Text codFiscalText;
	 private Text contBancaText;
	 private Text telefonText;
	 private Text emailText;
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		ComboViewer combo=(ComboViewer) event.getSource();
		String value=combo.getSelection().toString();
		value=value.substring(1,value.length()-1);
		
		CasaAsigurari casa = null;
		try {
			casa = model.getBusinessService().getCasaAsigurariByName(value);
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		numeText.setText(casa.getNume());
		codFiscalText.setText(casa.getCodFiscal());
		adresaText.setText(casa.getAdresa());
		contBancaText.setText(casa.getContBancar());
		telefonText.setText(casa.getTelefon());
		emailText.setText(casa.getTelefon());
	}
	/**
	 * @return the model
	 */
	public MedicModel getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(MedicModel model) {
		this.model = model;
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
	 * @return the codFiscalText
	 */
	public Text getCodFiscalText() {
		return codFiscalText;
	}
	/**
	 * @param codFiscalText the codFiscalText to set
	 */
	public void setCodFiscalText(Text codFiscalText) {
		this.codFiscalText = codFiscalText;
	}
	/**
	 * @return the adresaText
	 */
	public Text getAdresaText() {
		return adresaText;
	}
	/**
	 * @param adresaText the adresaText to set
	 */
	public void setAdresaText(Text adresaText) {
		this.adresaText = adresaText;
	}
	/**
	 * @return the contBancaText
	 */
	public Text getContBancaText() {
		return contBancaText;
	}
	/**
	 * @param contBancaText the contBancaText to set
	 */
	public void setContBancaText(Text contBancaText) {
		this.contBancaText = contBancaText;
	}
	/**
	 * @return the telefonText
	 */
	public Text getTelefonText() {
		return telefonText;
	}
	/**
	 * @param telefonText the telefonText to set
	 */
	public void setTelefonText(Text telefonText) {
		this.telefonText = telefonText;
	}
	/**
	 * @return the emailText
	 */
	public Text getEmailText() {
		return emailText;
	}
	/**
	 * @param emailText the emailText to set
	 */
	public void setEmailText(Text emailText) {
		this.emailText = emailText;
	}

}
