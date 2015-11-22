package medweb.psconf.daos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CabinetMedical implements Serializable{

	private int idCabinet;
	private String nume;
	private String adresa;
	private String nrContractCNAS;
    private String codFiscal;
    private CasaAsigurari casaAsigurari;
	/**
	 * @return the idCabinet
	 */
	public int getIdCabinet() {
		return idCabinet;
	}
	/**
	 * @param idCabinet the idCabinet to set
	 */
	public void setIdCabinet(int idCabinet) {
		this.idCabinet = idCabinet;
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
	 * @return the casaAsigurari
	 */
	public CasaAsigurari getCasaAsigurari() {
		return casaAsigurari;
	}
	/**
	 * @param casaAsigurari the casaAsigurari to set
	 */
	public void setCasaAsigurari(CasaAsigurari casaAsigurari) {
		this.casaAsigurari = casaAsigurari;
	}
    
}
