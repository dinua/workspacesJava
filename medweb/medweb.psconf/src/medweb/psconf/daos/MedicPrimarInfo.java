package medweb.psconf.daos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MedicPrimarInfo implements Serializable{

	private int idInfoMedicPrimar;
	private MedicPrimar medicPrimar;
	private String CNP;
	private String initiala;
	private String adresa;
	private String telefon;
	private String codParafa;
	private String nrLicenta;
	private String nrContractCNAS;
	private int idMedicRezident;
	/**
	 * @return the idInfoMedicPrimar
	 */
	public int getIdInfoMedicPrimar() {
		return idInfoMedicPrimar;
	}
	/**
	 * @param idInfoMedicPrimar the idInfoMedicPrimar to set
	 */
	public void setIdInfoMedicPrimar(int idInfoMedicPrimar) {
		this.idInfoMedicPrimar = idInfoMedicPrimar;
	}
	/**
	 * @return the medicPrimar
	 */
	public MedicPrimar getMedicPrimar() {
		return medicPrimar;
	}
	/**
	 * @param medicPrimar the medicPrimar to set
	 */
	public void setMedicPrimar(MedicPrimar medicPrimar) {
		this.medicPrimar = medicPrimar;
	}
	/**
	 * @return the cNP
	 */
	public String getCNP() {
		return CNP;
	}
	/**
	 * @param cNP the cNP to set
	 */
	public void setCNP(String cNP) {
		CNP = cNP;
	}
	/**
	 * @return the initiala
	 */
	public String getInitiala() {
		return initiala;
	}
	/**
	 * @param initiala the initiala to set
	 */
	public void setInitiala(String initiala) {
		this.initiala = initiala;
	}
	/**
	 * @return the adresa
	 */
	public String getAdresa() {
		return adresa;
	}
	/**
	 * @param adresa the adresa to set
	 */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	/**
	 * @return the telefon
	 */
	public String getTelefon() {
		return telefon;
	}
	/**
	 * @param telefon the telefon to set
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	/**
	 * @return the codParafa
	 */
	public String getCodParafa() {
		return codParafa;
	}
	/**
	 * @param codParafa the codParafa to set
	 */
	public void setCodParafa(String codParafa) {
		this.codParafa = codParafa;
	}
	/**
	 * @return the nrLicenta
	 */
	public String getNrLicenta() {
		return nrLicenta;
	}
	/**
	 * @param nrLicenta the nrLicenta to set
	 */
	public void setNrLicenta(String nrLicenta) {
		this.nrLicenta = nrLicenta;
	}
	/**
	 * @return the nrContractCNAS
	 */
	public String getNrContractCNAS() {
		return nrContractCNAS;
	}
	/**
	 * @param nrContractCNAS the nrContractCNAS to set
	 */
	public void setNrContractCNAS(String nrContractCNAS) {
		this.nrContractCNAS = nrContractCNAS;
	}
	/**
	 * @return the idMedicRezident
	 */
	public int getIdMedicRezident() {
		return idMedicRezident;
	}
	/**
	 * @param idMedicRezident the idMedicRezident to set
	 */
	public void setIdMedicRezident(int idMedicRezident) {
		this.idMedicRezident = idMedicRezident;
	}
	
	
}
