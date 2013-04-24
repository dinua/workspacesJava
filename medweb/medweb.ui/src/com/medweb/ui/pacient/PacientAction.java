package com.medweb.ui.pacient;

import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.Pacient;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.medweb.ui.help.ChangeViewPage;

@SuppressWarnings("serial")
public class PacientAction implements Listener {

	private Button newVisit;
	private Button delete;
	private Button info;
	private TableViewer tableViewer;
	
	@Override
	public void handleEvent(Event event) {
		Button button=(Button)event.widget;
	    TableItem[] tableItem= tableViewer.getTable().getSelection();
	    IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	    
	    if(tableItem.length>0)
	    {
		   Pacient pacient;
	      
		   try {
			   pacient=(Pacient)tableItem[0].getData();
			   PacinetView view=(PacinetView) window.getActivePage().findView(PacinetView.ID);
			   view.getPatientModel().setPacient(pacient);
		
			   if(button.equals(newVisit)){
				   System.out.println("s-a apasat new wisit");
			   }
		 
			   else if(button.equals(delete)){
				   System.out.println("s-a apasat deltee");
				   deletePatient(window, pacient);
			         }
			   else if(button.equals(info)){
				   System.out.println("s-a apasat info");
				   ChangeViewPage.changeView(PacientInfoView.ID, ""+pacient.getIdPacient());
			         }
			   
		} catch (ClassCastException e) {
			MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(), 
					PacientMessages.EDIT_ERROR_NO_ELEM_SELECT.getMessage());
		}
		   
	      
	   
	    }
	    else{
	    	MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(),
	    			PacientMessages.EDIT_ERROR_NO_ELEM_SELECT.getMessage());
	    }
	}

	private void deletePatient(IWorkbenchWindow window, Pacient pacient){
		String message=PacientMessages.EDIT_DELETE_TEXT.getMessage();
		message=message.replace("%a", pacient.getNume()+" "+pacient.getPrenume());
		boolean bool=MessageDialog.openConfirm(window.getShell(), PacientMessages.EDIT_DELETE_TITLE.getMessage(), message);
        if(bool){
        	 PacinetView view=(PacinetView) window.getActivePage().findView(PacinetView.ID);
        	// view.getPatientModel().getBusinessService().deletePatient(pacient);
        	 try {
				view.getPatientModel().getBusinessService().setPatientInactiv(pacient.getIdPacient());
			} catch (BusinessSQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 tableViewer.remove(pacient);
        }
	}
	/**
	 * @return the newVisit
	 */
	public Button getNewVisit() {
		return newVisit;
	}

	/**
	 * @param newVisit the newVisit to set
	 */
	public void setNewVisit(Button newVisit) {
		this.newVisit = newVisit;
	}

	

	/**
	 * @return the delete
	 */
	public Button getDelete() {
		return delete;
	}

	/**
	 * @param delete the delete to set
	 */
	public void setDelete(Button delete) {
		this.delete = delete;
	}

	/**
	 * @return the info
	 */
	public Button getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(Button info) {
		this.info = info;
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
