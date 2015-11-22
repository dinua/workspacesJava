package com.medweb.ui.retete;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.Adeverinta;
import medweb.psconf.daos.Consult;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.medweb.ui.pacient.PacientMessages;

@SuppressWarnings("serial")
public class AdeverintaAction implements Listener {

	private Button saveButton;
	private RetetaModel model;
	
	private Text ocupatiePacient;
	private Text suferindV1Text;
	private Text recomndareV1Text;
	private Text eliberatPtV1Test;
	private Text concluziiText;
	private Text radiologieText;
	private Text serologiatext;
	private Text recomandariV2Text;
	private Text aptText;
	
	@Override
	public void handleEvent(Event event) {
		Button button=(Button) event.widget;
		if(button.equals(saveButton)){
		saveAdeverinta();
		}
		
   
	}
	
	private void saveAdeverinta(){
		Consult consult=new Consult();
		consult.setFisa(model.getFisa());
		
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	     Date date = new Date();
	     consult.setDataConsult(dateFormat.format(date));
	     
	    Adeverinta adeverinta=new Adeverinta();
	    adeverinta.setOcupatie(ocupatiePacient.getText());
	    adeverinta.setSuferind(suferindV1Text.getText());
	    adeverinta.setRecomandare1(recomndareV1Text.getText());
	    adeverinta.setMotivEliberare(eliberatPtV1Test.getText());
	    adeverinta.setConcluzii(concluziiText.getText());
	    adeverinta.setRadiologie(radiologieText.getText());
	    adeverinta.setSerologie(serologiatext.getText());
	    adeverinta.setRecomandare2(recomandariV2Text.getText());
	    adeverinta.setApt(aptText.getText());
	    adeverinta.setDataEliberarii(dateFormat.format(date));
	    adeverinta.setConsult(consult);
		
		try {
			model.getBusinessService().saveAdeverinta(adeverinta);
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(), 
				"Datele au fost salvate");
	}
	/**
	 * @return the ocupatiePacient
	 */
	public Text getOcupatiePacient() {
		return ocupatiePacient;
	}

	/**
	 * @param ocupatiePacient the ocupatiePacient to set
	 */
	public void setOcupatiePacient(Text ocupatiePacient) {
		this.ocupatiePacient = ocupatiePacient;
	}

	/**
	 * @return the suferindV1Text
	 */
	public Text getSuferindV1Text() {
		return suferindV1Text;
	}

	/**
	 * @param suferindV1Text the suferindV1Text to set
	 */
	public void setSuferindV1Text(Text suferindV1Text) {
		this.suferindV1Text = suferindV1Text;
	}

	/**
	 * @return the recomndareV1Text
	 */
	public Text getRecomndareV1Text() {
		return recomndareV1Text;
	}

	/**
	 * @param recomndareV1Text the recomndareV1Text to set
	 */
	public void setRecomndareV1Text(Text recomndareV1Text) {
		this.recomndareV1Text = recomndareV1Text;
	}

	/**
	 * @return the eliberatPtV1Test
	 */
	public Text getEliberatPtV1Test() {
		return eliberatPtV1Test;
	}

	/**
	 * @param eliberatPtV1Test the eliberatPtV1Test to set
	 */
	public void setEliberatPtV1Test(Text eliberatPtV1Test) {
		this.eliberatPtV1Test = eliberatPtV1Test;
	}

	/**
	 * @return the concluziiText
	 */
	public Text getConcluziiText() {
		return concluziiText;
	}

	/**
	 * @param concluziiText the concluziiText to set
	 */
	public void setConcluziiText(Text concluziiText) {
		this.concluziiText = concluziiText;
	}

	/**
	 * @return the radiologieText
	 */
	public Text getRadiologieText() {
		return radiologieText;
	}

	/**
	 * @param radiologieText the radiologieText to set
	 */
	public void setRadiologieText(Text radiologieText) {
		this.radiologieText = radiologieText;
	}

	/**
	 * @return the serologiatext
	 */
	public Text getSerologiatext() {
		return serologiatext;
	}

	/**
	 * @param serologiatext the serologiatext to set
	 */
	public void setSerologiatext(Text serologiatext) {
		this.serologiatext = serologiatext;
	}

	/**
	 * @return the recomandariV2Text
	 */
	public Text getRecomandariV2Text() {
		return recomandariV2Text;
	}

	/**
	 * @param recomandariV2Text the recomandariV2Text to set
	 */
	public void setRecomandariV2Text(Text recomandariV2Text) {
		this.recomandariV2Text = recomandariV2Text;
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
	 * @return the model
	 */
	public RetetaModel getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(RetetaModel model) {
		this.model = model;
	}

	/**
	 * @return the aptText
	 */
	public Text getAptText() {
		return aptText;
	}

	/**
	 * @param aptText the aptText to set
	 */
	public void setAptText(Text aptText) {
		this.aptText = aptText;
	}

}
