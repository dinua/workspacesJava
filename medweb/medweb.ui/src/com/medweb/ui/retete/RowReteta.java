package com.medweb.ui.retete;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RowReteta implements Serializable {
	
	private String cod;
	private String nume;
	private String cantitate;
	private String administrare;
	/**
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}
	/**
	 * @param cod the cod to set
	 */
	public void setCod(String cod) {
		this.cod = cod;
	}
	/**
	 * @return the nume
	 */
	public String getNume() {
		return nume;
	}
	/**
	 * @param nume the nume to set
	 */
	public void setNume(String nume) {
		this.nume = nume;
	}
	/**
	 * @return the cantitate
	 */
	public String getCantitate() {
		return cantitate;
	}
	/**
	 * @param cantitate the cantitate to set
	 */
	public void setCantitate(String cantitate) {
		this.cantitate = cantitate;
	}
	/**
	 * @return the administrare
	 */
	public String getAdministrare() {
		return administrare;
	}
	/**
	 * @param administrare the administrare to set
	 */
	public void setAdministrare(String administrare) {
		this.administrare = administrare;
	}
	
	

}
