package com.medweb.ui.pacient;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.medweb.ui.retete.AdeverintaDialogView;
import com.medweb.ui.retete.RetetaDialogView;
import com.medweb.ui.retete.RetetaModel;

@SuppressWarnings("serial")
public class RetetaAction implements Listener {

	private Button retetaButton;
	private Button adeverintaButton;
	private RetetaModel retetaModel;
	@Override
	public void handleEvent(Event event) {
		Button button=(Button) event.widget;
		IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if(button.equals(retetaButton)){
			RetetaDialogView dialog=new RetetaDialogView(window.getShell(),retetaModel);
			dialog.open();
		}
		else if(button.equals(adeverintaButton)){
			AdeverintaDialogView dialog=new AdeverintaDialogView(window.getShell(),retetaModel);
			dialog.open();
		}
	}
	/**
	 * @return the retetaButton
	 */
	public Button getRetetaButton() {
		return retetaButton;
	}
	/**
	 * @param retetaButton the retetaButton to set
	 */
	public void setRetetaButton(Button retetaButton) {
		this.retetaButton = retetaButton;
	}
	/**
	 * @return the adeverintaButton
	 */
	public Button getAdeverintaButton() {
		return adeverintaButton;
	}
	/**
	 * @param adeverintaButton the adeverintaButton to set
	 */
	public void setAdeverintaButton(Button adeverintaButton) {
		this.adeverintaButton = adeverintaButton;
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
