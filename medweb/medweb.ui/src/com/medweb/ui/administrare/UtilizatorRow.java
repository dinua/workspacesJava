package com.medweb.ui.administrare;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UtilizatorRow implements Serializable{
    
	private int idUser;
	private String username;
	private String nume;
	private String prenume;
	private String tip;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @return the prenume
	 */
	public String getPrenume() {
		return prenume;
	}
	/**
	 * @param prenume the prenume to set
	 */
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	/**
	 * @return the tip
	 */
	public String getTip() {
		return tip;
	}
	/**
	 * @param tip the tip to set
	 */
	public void setTip(String tip) {
		this.tip = tip;
	}
	/**
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}
	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	
}
