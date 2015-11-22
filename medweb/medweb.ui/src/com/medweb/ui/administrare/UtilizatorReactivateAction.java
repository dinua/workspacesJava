package com.medweb.ui.administrare;

import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.MedicPrimar;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.medweb.ui.pacient.PacientMessages;

@SuppressWarnings("serial")
public class UtilizatorReactivateAction implements Listener {

	private TableViewer tableViewer;
	
	@Override
	public void handleEvent(Event event) {
		 TableItem[] tableItem= getTableViewer().getTable().getSelection();
		 IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		    if(tableItem.length>0)
		    {
		    	 UtilizatorRow utilizatorRow=null;
		      
			   try {
				   utilizatorRow=(UtilizatorRow)tableItem[0].getData();
				   UtilizatoriInactiviView view=(UtilizatoriInactiviView) window.getActivePage().findView(UtilizatoriInactiviView.ID);
				   MedicPrimar medic=view.getUtilizatorModel().getBusinessService().getMedicPrimarByID(utilizatorRow.getIdUser());
				   view.getUtilizatorModel().setMedicPrimar(medic);
			
				   String message="Doriti sa reactivati user-ul "+utilizatorRow.getUsername()+" ?";
					boolean bool=MessageDialog.openConfirm(window.getShell(), PacientMessages.EDIT_DELETE_TITLE.getMessage(), message);
			        if(bool){
			        	
			        	view.getUtilizatorModel().getBusinessService().setUserActiv(utilizatorRow.getIdUser());
			        	tableViewer.remove(utilizatorRow);
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
