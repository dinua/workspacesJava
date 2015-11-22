package com.medweb.ui.table;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

@SuppressWarnings("serial")
public class TableViewFiltersAction implements Listener {

	private TableViewer tableViewer;
	private Label infoLabel;
	
	public TableViewFiltersAction(TableViewer tableViewer) {
		super();
		this.tableViewer = tableViewer;
	}
	
	@Override
	public void handleEvent(Event event) {
		ViewerFilter[] viewerFilter=(ViewerFilter[]) tableViewer.getFilters();
		IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		
		if(viewerFilter==null || viewerFilter.length==0)
		{
			MessageDialog.openInformation(window.getShell(), TableMessages.EDIT_INFO.getMessage(), TableMessages.EDIT_ERROR_NO_FILTER.getMessage());
		}
		else{
			FilterInformationDialog dialog=new FilterInformationDialog(window.getShell(),viewerFilter);
			dialog.setTableViewer(tableViewer);
			dialog.open();
			resetNrOfFilters();
			
		}
		

	}
	private void resetNrOfFilters(){
		
		String infoText=infoLabel.getText();
		String[] vec=infoText.split(":");
		String nrOfFilers=""+tableViewer.getFilters().length;
		infoText=infoText.replace(vec[1], nrOfFilers);
		infoLabel.setText(infoText);
	}

	/**
	 * @param infoLabel the infoLabel to set
	 */
	public void setInfoLabel(Label infoLabel) {
		this.infoLabel = infoLabel;
	}
}
