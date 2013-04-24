package com.medweb.ui.table;

import java.util.List;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.medweb.ui.table.ColumnDescriptor;

@SuppressWarnings("serial")
public final class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
	 
	private List<ColumnDescriptor> columnDescriptors;
	public static int index=0;
	
	  public TableLabelProvider(List<ColumnDescriptor> columnDescriptors){
		  this.columnDescriptors=columnDescriptors;
		 index=0;
	  }
	
	  public Image getColumnImage(Object element, int columnIndex) {
	    return null;
	  }
	 
	  public String getColumnText(Object element, int columnIndex) {
	  
		  if(!(element.getClass().toString().contains("java.lang.Object"))){
			  if(columnIndex==0){
				  return ""+(++index);
			  }
			  else
			  {
				  String name=columnDescriptors.get(columnIndex-1).getColumnName();
			      return  new ClassType(element, name).getValue();  
			  }
		  }
		 
			  return "";
		 		  
	  }
	 
	}