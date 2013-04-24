package medweb.psconf.daos;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Reteta implements Serializable{

	private int idReteta;
	private Consult consult;
	private String dataPrescriere;
	private String unitateSanitara;
	private String codFiscalReteta;
	private List<RetetaLinie> listaMedicamente;
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
	/**
	 * @return the consult
	 */
	public Consult getConsult() {
		return consult;
	}
	/**
	 * @param consult the consult to set
	 */
	public void setConsult(Consult consult) {
		this.consult = consult;
	}
	/**
	 * @return the dataPrescriere
	 */
	public String getDataPrescriere() {
		return dataPrescriere;
	}
	/**
	 * @param dataPrescriere the dataPrescriere to set
	 */
	public void setDataPrescriere(String dataPrescriere) {
		this.dataPrescriere = dataPrescriere;
	}
	/**
	 * @return the unitateSanitara
	 */
	public String getUnitateSanitara() {
		return unitateSanitara;
	}
	/**
	 * @param unitateSanitara the unitateSanitara to set
	 */
	public void setUnitateSanitara(String unitateSanitara) {
		this.unitateSanitara = unitateSanitara;
	}
	/**
	 * @return the codFiscalReteta
	 */
	public String getCodFiscalReteta() {
		return codFiscalReteta;
	}
	/**
	 * @param codFiscalReteta the codFiscalReteta to set
	 */
	public void setCodFiscalReteta(String codFiscalReteta) {
		this.codFiscalReteta = codFiscalReteta;
	}
	/**
	 * @return the listaMedicamente
	 */
	public List<RetetaLinie> getListaMedicamente() {
		return listaMedicamente;
	}
	/**
	 * @param listaMedicamente the listaMedicamente to set
	 */
	public void setListaMedicamente(List<RetetaLinie> listaMedicamente) {
		this.listaMedicamente = listaMedicamente;
	}
	
	
	
}
