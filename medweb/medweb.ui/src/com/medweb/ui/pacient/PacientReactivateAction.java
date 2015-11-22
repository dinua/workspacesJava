package com.medweb.ui.pacient;

import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.Pacient;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

@SuppressWarnings("serial")
public class PacientReactivateAction implements Listener{
	private TableViewer tableViewer;
	@Override
	public void handleEvent(Event event) {
		 TableItem[] tableItem= getTableViewer().getTable().getSelection();
		 IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		    if(tableItem.length>0)
		    {
			   Pacient pacient;
		      
			   try {
				   pacient=(Pacient)tableItem[0].getData();
				   PacinetInactivView view=(PacinetInactivView) window.getActivePage().findView(PacinetInactivView.ID);
				   view.getPatientModel().setPacient(pacient);
			
				   String message="Doriti sa reactivati pacientul "+pacient.getNume()+" "+pacient.getPrenume()+" ?";
					//message=message.replace("%a", pacient.getNume()+" "+pacient.getPrenume());
					boolean bool=MessageDialog.openConfirm(window.getShell(), PacientMessages.EDIT_DELETE_TITLE.getMessage(), message);
			        if(bool){
			        	 //PacinetView view=(PacinetView) window.getActivePage().findView(PacinetView.ID);
			        	// view.getPatientModel().getBusinessService().deletePatient(pacient);
			        	 view.getPatientModel().getBusinessService().setPatientActiv(pacient.getIdPacient());
			        	 tableViewer.remove(pacient);
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
