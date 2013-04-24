package com.medweb.ui.medicamente;

import medweb.psconf.daos.Medicament;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.medweb.ui.pacient.PacientMessages;

@SuppressWarnings("serial")
public class MedicamenteInfoAction implements Listener {

	private MedicamneteModel model;
	private TableViewer tableViewer;
	
	public MedicamenteInfoAction(MedicamneteModel medicamentModel,TableViewer tableViewer) {
		super();
		this.model=medicamentModel;
		this.tableViewer=tableViewer;
	}

	@Override
	public void handleEvent(Event event) {
		IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		TableItem[] tableItem= tableViewer.getTable().getSelection();
		 
		
		 if(tableItem.length>0)
		    {
			   Medicament medicament;
		      
			   try {
				   medicament=(Medicament)tableItem[0].getData();
				   model.setMedicament(medicament);
			
				   model.setInfoToMedicament();
				   MedicamenteInfoDialog dialog=new MedicamenteInfoDialog(window.getShell(),model);
				   dialog.open();
				   
			} catch (ClassCastException e) {
				MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(), 
						"xxxxxxxxxxxxxx");
			}
			   
		      
		   
		    }
		    else{
		    	MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(),
		    			"xxxxxxxxxxxx");
		    }
		
		
		
	}

}
