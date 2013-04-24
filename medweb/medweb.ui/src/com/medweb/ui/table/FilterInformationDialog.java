package com.medweb.ui.table;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.medweb.ui.help.ImageID;
import com.medweb.ui.help.WidgetFactory;

@SuppressWarnings("serial")
public class FilterInformationDialog extends Dialog {

	private  ViewerFilter[] viewerFilter;
	private  TableViewer tableViewer;
	
	public FilterInformationDialog(final Shell parentShell,ViewerFilter[] viewerFilter) {
	    super(parentShell);
	    this.setViewerFilter(viewerFilter);
	  
	}
	
	@Override
	protected Control createDialogArea(final Composite parent) {
	    final Composite container = (Composite) super.createDialogArea(parent);
	    container.setLayout(new GridLayout(4, true));
	    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	     
	    Display display=PlatformUI.getWorkbench().getDisplay();
         Font font=new Font(display,"Arial",14,SWT.BOLD);
         
	    Label columnFilterLabel=WidgetFactory.createLabel(container, "columnFilterLabel",TableMessages.EDIT_COLUMN.getMessage());
	    columnFilterLabel.setLayoutData(new GridData(SWT.CENTER,SWT.FILL,true,false,1,1));
        columnFilterLabel.setFont(font);
        
		 Label criteriaFilterLabel=WidgetFactory.createLabel(container, "criteriaFilterLabel",TableMessages.EDIT_CRITERIA.getMessage());
		 criteriaFilterLabel.setLayoutData(new GridData(SWT.CENTER,SWT.FILL,true,false,1,1));
         criteriaFilterLabel.setFont(font);
		 
         Label valueFilterLabel=WidgetFactory.createLabel(container, "valueFilterLabel",TableMessages.EDIT_VALUE.getMessage());
         valueFilterLabel.setLayoutData(new GridData(SWT.CENTER,SWT.FILL,true,false,1,1));
         valueFilterLabel.setFont(font);
         
		 Label removeFilterLabel=WidgetFactory.createLabel(container, "removeFilterLabel",TableMessages.EDIT_REMOVE_FILTER.getMessage());
		 removeFilterLabel.setLayoutData(new GridData(SWT.CENTER,SWT.FILL,true,false,1,1));
         removeFilterLabel.setFont(font);
		 
         GridData buttonGrid=new GridData(SWT.CENTER, SWT.FILL, true, false,1,1);
         buttonGrid.widthHint=70;
         
         for(int i=0;i<getViewerFilter().length;i++){
        	 TableViewFilter tableViewerFilter=(TableViewFilter) getViewerFilter()[i];
        	 Label columnName=WidgetFactory.createLabel(container, "columnName",tableViewerFilter.getColumn());
        	 columnName.setLayoutData(new GridData(SWT.CENTER,SWT.FILL,true,false,1,1));
            
        	 Label criteriaName=WidgetFactory.createLabel(container, "criteriaName",tableViewerFilter.getCriteria());
        	 criteriaName.setLayoutData(new GridData(SWT.CENTER,SWT.FILL,true,false,1,1));
            
        	 Label valueFilter=WidgetFactory.createLabel(container, "valueFilter",tableViewerFilter.getValue());
        	 valueFilter.setLayoutData(new GridData(SWT.CENTER,SWT.FILL,true,false,1,1));
            
        	 Button removeButton =WidgetFactory.createButton(container, "removeButton", TableMessages.EDIT_REMOVE.getMessage(), false,ImageID.IMAGE_NEW);
        	 removeButton.setLayoutData(buttonGrid);
        	 removeButton.addListener(SWT.Selection, new TableRemoveFilterAction(getTableViewer(), getViewerFilter()[i]));
         
         }
         
	    return container;
	}
	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(final Composite parent) {
	    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.get().OK_LABEL, true);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
	    return new Point(600, 400);
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
	 * @return the viewerFilter
	 */
	public ViewerFilter[] getViewerFilter() {
		return viewerFilter;
	}

	/**
	 * @param viewerFilter the viewerFilter to set
	 */
	public void setViewerFilter(ViewerFilter[] viewerFilter) {
		this.viewerFilter = viewerFilter;
	}

}
