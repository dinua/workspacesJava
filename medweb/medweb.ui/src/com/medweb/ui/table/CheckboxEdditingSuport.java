package com.medweb.ui.table;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

@SuppressWarnings("serial")
public class CheckboxEdditingSuport extends EditingSupport{
	
	private CheckboxCellEditor cellEditor = null;

	public CheckboxEdditingSuport(ColumnViewer viewer) {
        super(viewer);
       cellEditor=new CheckboxCellEditor((Composite)getViewer().getControl(),SWT.READ_ONLY);
       cellEditor.setValue("");
        /*
        cellEditor = new ComboBoxViewerCellEditor((Composite) getViewer().getControl(), SWT.READ_ONLY);
        cellEditor.setLabelProvider(new LabelProvider());
        cellEditor.setContenProvider(new ArrayContentProvider());
        cellEditor.setInput(input);*/
    }

	@Override
	protected CellEditor getCellEditor(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean canEdit(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Object getValue(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {
		// TODO Auto-generated method stub
		
	}
 
}
