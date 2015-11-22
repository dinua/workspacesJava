package medweb.psconf.daos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RetetaLinie implements Serializable{

	private int idRetetaLinie;
	private Medicament medicament;
	private int idReteta;
	private String cantitate;
	private String modAdministrare;
	
	/**
	 * @return the idRetetaLinie
	 */
	public int getIdRetetaLinie() {
		return idRetetaLinie;
	}
	/**
	 * @param idRetetaLinie the idRetetaLinie to set
	 */
	public void setIdRetetaLinie(int idRetetaLinie) {
		this.idRetetaLinie = idRetetaLinie;
	}
	/**
	 * @return the medicament
	 */
	public Medicament getMedicament() {
		return medicament;
	}
	/**
	 * @param medicament the medicament to set
	 */
	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
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
	 * @return the modAdministrare
	 */
	public String getModAdministrare() {
		return modAdministrare;
	}
	/**
	 * @param modAdministrare the modAdministrare to set
	 */
	public void setModAdministrare(String modAdministrare) {
		this.modAdministrare = modAdministrare;
	}
	/**
	 * @return the idReteta
	 */
	public int getIdReteta() {
		return idReteta;
	}
	/**
	 * @param idReteta the idReteta to set
	 */
	public void setIdReteta(int idReteta) {
		this.idReteta = idReteta;
	}
	
	
}
