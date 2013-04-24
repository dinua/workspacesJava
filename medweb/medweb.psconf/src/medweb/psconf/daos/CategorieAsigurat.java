package medweb.psconf.daos;

import java.io.Serializable;
/**
 * 
 * @author adi
 *
 */
@SuppressWarnings("serial")
public class CategorieAsigurat implements Serializable{

	private int idCategorieAsigurat;
	private String nume;
	/**
	 * @return the idCategorieAsigurat
	 */
	public int getIdCategorieAsigurat() {
		return idCategorieAsigurat;
	}
	/**
	 * @param idCategorieAsigurat the idCategorieAsigurat to set
	 */
	public void setIdCategorieAsigurat(int idCategorieAsigurat) {
		this.idCategorieAsigurat = idCategorieAsigurat;
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
	
	
}
