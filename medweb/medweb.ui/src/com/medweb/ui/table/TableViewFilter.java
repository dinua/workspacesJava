package com.medweb.ui.table;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

@SuppressWarnings("serial")
public class TableViewFilter extends ViewerFilter{

	private String column;
	private String criteria;
	private String value;
	
	public TableViewFilter(String column,String criteria,String value){
	  super();
	  this.setColumn(column);
	  this.setCriteria(criteria);
	  this.setValue(value);
	}
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		
		String colValue=new ClassType(element, getColumn()).getValue();
		if(colValue!=null)
		{
			TableLabelProvider.index=0;	
			int n=(int) CriteriaType.fromString(getCriteria()).getOrdinal();
			boolean bool=true;
			switch (n) {
			// TODO Auto-generated method stub
			case 0:
				bool= true;
				break;
			case 1:
				if(colValue.equals(getValue()))
					bool=true;
				else
					bool= false;
				break;
			case 2:
				if(colValue.contains(getValue()))
					bool=true;
				else
					bool=false;
				break;
			case 3:
				if(colValue.contains(getValue()))
					bool=false;
				else
					bool=true;
				break;	
			default:
				bool=true;
			}
			return bool;
		// 
		}
		return true;
	}
	/**
	 * @return the column
	 */
	public String getColumn() {
		return column;
	}
	/**
	 * @param column the column to set
	 */
	public void setColumn(String column) {
		this.column = column;
	}
	/**
	 * @return the criteria
	 */
	public String getCriteria() {
		return criteria;
	}
	/**
	 * @param criteria the criteria to set
	 */
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
