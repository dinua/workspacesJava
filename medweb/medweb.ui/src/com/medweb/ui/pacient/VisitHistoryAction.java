package com.medweb.ui.pacient;

import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.Adeverinta;
import medweb.psconf.daos.Consult;
import medweb.psconf.daos.Pacient;
import medweb.psconf.daos.PacientInfo;
import medweb.psconf.daos.Reteta;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.medweb.ui.retete.AdeverintaDialogView;
import com.medweb.ui.retete.RetetaDialogView;
import com.medweb.ui.retete.RetetaModel;

@SuppressWarnings("serial")
public class VisitHistoryAction implements Listener{

	private TableViewer tableViewer;
	private Button reteteElibButton;
	private Button adeverinteElibButton;
	private RetetaModel retetaModel;
	private PacientModel pacinetModel;
	@Override
	public void handleEvent(Event event) {
		Button button=(Button)event.widget;
	    TableItem[] tableItem= tableViewer.getTable().getSelection();
	    IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	    if(tableItem.length>0)
	    {
	    	Consult consult ;
	    
			   try {
			   consult=(Consult)tableItem[0].getData();
			   if(button.equals(adeverinteElibButton)){
			  
				  Adeverinta adeverinta=retetaModel.getBusinessService().getAdeverintaByConsultatie(consult);
			  
				  if(adeverinta!=null){
					  openAdeverintaView(window, consult,adeverinta);
				  }
				  else{
						MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(), 
								"La aceasta consultatie nu s-a eliberat nici o adeverinta!");
				  }
			   } 
			   else if(button.equals(reteteElibButton)){
				   Reteta reteta=retetaModel.getBusinessService().getRetetaByConsultatie(consult);
				  if(reteta!=null){
					  openRetetaView(window, consult, reteta);
				  }
				  else{
					  MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(), 
								"La aceasta consultatie nu s-a prescris nici o reteta!");
				  }
				  
			   }
			  
			
			   
		} catch (ClassCastException e) {
			MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(), 
					PacientMessages.EDIT_ERROR_NO_ELEM_SELECT.getMessage());
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	      
	   
	    }
	    else{
	    	MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(),
	    			PacientMessages.EDIT_ERROR_NO_ELEM_SELECT.getMessage());
	    }
		
	}
	
  private void openAdeverintaView(IWorkbenchWindow window,  Consult consult,Adeverinta adeverinta){
	   Pacient pacient=consult.getFisa().getPacient();
	   PacientInfo info;
	   try {
		pacient=pacinetModel.getBusinessService().getPatientByID(pacient.getIdPacient());
		info = pacinetModel.getBusinessService().getInfoPacient(pacient);
		 retetaModel.getPatientModel().setPacient(pacient);
		 retetaModel.getPatientModel().setPacientInfo(info);
	} catch (BusinessSQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  	
	  AdeverintaDialogView dialog=new AdeverintaDialogView(window.getShell(),getRetetaModel(),adeverinta);
  	   dialog.open();
	   
  }
  private void openRetetaView(IWorkbenchWindow window,  Consult consult,Reteta reteta){
	  Pacient pacient=consult.getFisa().getPacient();
	   PacientInfo info;
	   try {
		pacient=pacinetModel.getBusinessService().getPatientByID(pacient.getIdPacient());
		info = pacinetModel.getBusinessService().getInfoPacient(pacient);
		 retetaModel.getPatientModel().setPacient(pacient);
		 retetaModel.getPatientModel().setPacientInfo(info);
	} catch (BusinessSQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   if(consult.getObservatii()==null)
		   consult.setObservatii("");
	   RetetaDialogView dialog=new RetetaDialogView(window.getShell(), getRetetaModel(), reteta,consult.getObservatii());
	   dialog.open();
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
	 * @return the reteteElibButton
	 */
	public Button getReteteElibButton() {
		return reteteElibButton;
	}
	/**
	 * @param reteteElibButton the reteteElibButton to set
	 */
	public void setReteteElibButton(Button reteteElibButton) {
		this.reteteElibButton = reteteElibButton;
	}
	/**
	 * @return the adeverinteElibButton
	 */
	public Button getAdeverinteElibButton() {
		return adeverinteElibButton;
	}
	/**
	 * @param adeverinteElibButton the adeverinteElibButton to set
	 */
	public void setAdeverinteElibButton(Button adeverinteElibButton) {
		this.adeverinteElibButton = adeverinteElibButton;
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
	/**
	 * @return the pacinetModel
	 */
	public PacientModel getPacinetModel() {
		return pacinetModel;
	}
	/**
	 * @param pacinetModel the pacinetModel to set
	 */
	public void setPacinetModel(PacientModel pacinetModel) {
		this.pacinetModel = pacinetModel;
	}

}
