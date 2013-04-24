package com.medweb.ui.table;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

@SuppressWarnings("serial")
public class ComboEditingSupport extends EditingSupport  {
///////////////not finish//////////////////////////////////////////////
	//TODO
	 private ComboBoxViewerCellEditor cellEditor = null;
     private String columnName;
	   @SuppressWarnings("deprecation")
	public ComboEditingSupport(ColumnViewer viewer,String columnName,String[] input) {
	        super(viewer);
	        this.columnName=columnName;
	        
	        cellEditor = new ComboBoxViewerCellEditor((Composite) getViewer().getControl(), SWT.READ_ONLY);
	        cellEditor.setLabelProvider(new LabelProvider());
	        cellEditor.setContenProvider(new ArrayContentProvider());
	        cellEditor.setInput(input);
	    }
	     
	    @Override
	    protected CellEditor getCellEditor(Object element) {
	        return cellEditor;
	    }
	     
	    @Override
	    protected boolean canEdit(Object element) {
	        return true;
	    }
	    @Override
	    protected Object getValue(Object element) {
	       /* if (element instanceof ExampleData) {
	            ExampleData data = (ExampleData)element;
	            return data.getData();
	        }*/
	    	System.err.println(element);
	     ClassType classType=new ClassType(element, columnName);
	     return classType.getValue();
	    }
	     
	    @Override
	    protected void setValue(Object element, Object value) {
	     
	    new ClassType(element, columnName, value.toString());
//	    classType.setValue(value.toString());
//	    System.out.println("asdasd "+element+ "  asd "+value);	
	    }
}
