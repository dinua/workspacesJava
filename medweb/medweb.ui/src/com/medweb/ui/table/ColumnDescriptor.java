package com.medweb.ui.table;

public class ColumnDescriptor {

	private String columnName;
	private int weight;
	private ColumnType columnType;
	private String widgetName;
	private boolean editableColumn;
   
	
	public ColumnDescriptor(String columnName, int weight,
			ColumnType columnType, String widgetName,boolean editableColumn) {
		super();
		this.columnName = columnName;
		this.weight = weight;
		this.columnType = columnType;
		this.widgetName = widgetName;
		this.editableColumn=editableColumn;
	}
	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}
	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
	 * @return the columnType
	 */
	public ColumnType getColumnType() {
		return columnType;
	}
	/**
	 * @param columnType the columnType to set
	 */
	public void setColumnType(ColumnType columnType) {
		this.columnType = columnType;
	}
	/**
	 * @return the widgetName
	 */
	public String getWidgetName() {
		return widgetName;
	}
	/**
	 * @param widgetName the widgetName to set
	 */
	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}
	/**
	 * @return the editableColumn
	 */
	public boolean isEditableColumn() {
		return editableColumn;
	}
	/**
	 * @param editableColumn the editableColumn to set
	 */
	public void setEditableColumn(boolean editableColumn) {
		this.editableColumn = editableColumn;
	}
	
	
}
