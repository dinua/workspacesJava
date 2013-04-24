package com.medweb.ui.medic;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MedicRowInformation implements Serializable{
	private String rowName ;
	private String value;
	/**
	 * @return the rowName
	 */
	public String getRowName() {
		return rowName;
	}
	/**
	 * @param rowName the rowName to set
	 */
	public void setRowName(String rowName) {
		this.rowName = rowName;
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
