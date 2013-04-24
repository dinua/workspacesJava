package com.medweb.ui.administrare;

import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.MedicPrimar;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.medweb.ui.help.ChangeViewPage;
import com.medweb.ui.pacient.PacientMessages;

@SuppressWarnings("serial")
public class UtilizatorAction implements Listener{

	private Button delete;
	private Button info;
	private TableViewer tableViewer;
	@Override
	public void handleEvent(Event event) {
		Button button=(Button) event.widget;
		 TableItem[] tableItem= tableViewer.getTable().getSelection();
		 IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		
		 if(tableItem.length>0)
		    {
			   UtilizatorRow utilizatorRow=null;
		      
			   try {
				   utilizatorRow=(UtilizatorRow)tableItem[0].getData();
				   UtilizatoriActiviView view=(UtilizatoriActiviView) window.getActivePage().findView(UtilizatoriActiviView.ID);
				   MedicPrimar medic=view.getUtilizatorModel().getBusinessService().getMedicPrimarByID(utilizatorRow.getIdUser());
				   view.getUtilizatorModel().setMedicPrimar(medic);
				   if(button.equals(info)){
						ChangeViewPage.changeView(UtilizatorInfoView.ID, ""+medic.getIdMedicPrimar());
					}
					else{
						deleteUtilizator(window, utilizatorRow);
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
	private void deleteUtilizator(IWorkbenchWindow window, UtilizatorRow user){
		String message=UtilizatorMessages.EDIT_DELETE_INFO.getMessage();
		message=message.replace("%a",user.getUsername());
		boolean bool=MessageDialog.openConfirm(window.getShell(), PacientMessages.EDIT_DELETE_TITLE.getMessage(), message);
        if(bool){
        	 UtilizatoriActiviView view=(UtilizatoriActiviView) window.getActivePage().findView(UtilizatoriActiviView.ID);
        	 try {
        		 view.getUtilizatorModel().getBusinessService().setUserInactiv(user.getIdUser());
				
			} catch (BusinessSQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 tableViewer.remove(user);
        }
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
