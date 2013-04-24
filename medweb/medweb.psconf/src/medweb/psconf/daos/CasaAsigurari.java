package medweb.psconf.daos;

import java.io.Serializable;
/**
 * 
 * @author adi
 *
 */
@SuppressWarnings("serial")
public class CasaAsigurari implements Serializable{

	
	private int idCasaAsigurari;
	private String nume;
	private String adresa;
	private String codFiscal;
	private String contBancar;
	private String telefon;
	private String email;
	/**
	 * @return the idCasaAsigurari
	 */
	public int getIdCasaAsigurari() {
		return idCasaAsigurari;
	}
	/**
	 * @param idCasaAsigurari the idCasaAsigurari to set
	 */
	public void setIdCasaAsigurari(int idCasaAsigurari) {
		this.idCasaAsigurari = idCasaAsigurari;
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
	 * @return the codFiscal
	 */
	public String getCodFiscal() {
		return codFiscal;
	}
	/**
	 * @param codFiscal the codFiscal to set
	 */
	public void setCodFiscal(String codFiscal) {
		this.codFiscal = codFiscal;
	}
	/**
	 * @return the contBancar
	 */
	public String getContBancar() {
		return contBancar;
	}
	/**
	 * @param contBancar the contBancar to set
	 */
	public void setContBancar(String contBancar) {
		this.contBancar = contBancar;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
