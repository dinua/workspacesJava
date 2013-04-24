package medweb.psconf.daos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MedicamentInfo implements Serializable{

	private int idMedicamentInfo;
	private Medicament medicament;
	private String tara;
	private String firma;
	private String prescriere;
	private String formaAmbalare;
	private float pretAmanuntulMax;
	private float pretAmanuntulMaxUt;
	private float valSuprotataCnas;
	private float valSuprotataCnasAdulti;
	/**
	 * @return the idMedicamentInfo
	 */
	public int getIdMedicamentInfo() {
		return idMedicamentInfo;
	}
	/**
	 * @param idMedicamentInfo the idMedicamentInfo to set
	 */
	public void setIdMedicamentInfo(int idMedicamentInfo) {
		this.idMedicamentInfo = idMedicamentInfo;
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
	 * @return the tara
	 */
	public String getTara() {
		return tara;
	}
	/**
	 * @param tara the tara to set
	 */
	public void setTara(String tara) {
		this.tara = tara;
	}
	/**
	 * @return the firma
	 */
	public String getFirma() {
		return firma;
	}
	/**
	 * @param firma the firma to set
	 */
	public void setFirma(String firma) {
		this.firma = firma;
	}
	/**
	 * @return the prescriere
	 */
	public String getPrescriere() {
		return prescriere;
	}
	/**
	 * @param prescriere the prescriere to set
	 */
	public void setPrescriere(String prescriere) {
		this.prescriere = prescriere;
	}
	/**
	 * @return the formaAmbalare
	 */
	public String getFormaAmbalare() {
		return formaAmbalare;
	}
	/**
	 * @param formaAmbalare the formaAmbalare to set
	 */
	public void setFormaAmbalare(String formaAmbalare) {
		this.formaAmbalare = formaAmbalare;
	}
	/**
	 * @return the pretAmanuntulMax
	 */
	public float getPretAmanuntulMax() {
		return pretAmanuntulMax;
	}
	/**
	 * @param pretAmanuntulMax the pretAmanuntulMax to set
	 */
	public void setPretAmanuntulMax(float pretAmanuntulMax) {
		this.pretAmanuntulMax = pretAmanuntulMax;
	}
	/**
	 * @return the pretAmanuntulMaxUt
	 */
	public float getPretAmanuntulMaxUt() {
		return pretAmanuntulMaxUt;
	}
	/**
	 * @param pretAmanuntulMaxUt the pretAmanuntulMaxUt to set
	 */
	public void setPretAmanuntulMaxUt(float pretAmanuntulMaxUt) {
		this.pretAmanuntulMaxUt = pretAmanuntulMaxUt;
	}
	/**
	 * @return the valSuprotataCnas
	 */
	public float getValSuprotataCnas() {
		return valSuprotataCnas;
	}
	/**
	 * @param valSuprotataCnas the valSuprotataCnas to set
	 */
	public void setValSuprotataCnas(float valSuprotataCnas) {
		this.valSuprotataCnas = valSuprotataCnas;
	}
	/**
	 * @return the valSuprotataCnasAdulti
	 */
	public float getValSuprotataCnasAdulti() {
		return valSuprotataCnasAdulti;
	}
	/**
	 * @param valSuprotataCnasAdulti the valSuprotataCnasAdulti to set
	 */
	public void setValSuprotataCnasAdulti(float valSuprotataCnasAdulti) {
		this.valSuprotataCnasAdulti = valSuprotataCnasAdulti;
	}
	
	
}
