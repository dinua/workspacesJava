package medweb.psconf.daos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Fisa implements Serializable {

	private int idFisa;
	private  Pacient pacient;
	private MedicPrimar medic;
	private String dataEmitere;
	/**
	 * @return the idFisa
	 */
	public int getIdFisa() {
		return idFisa;
	}
	/**
	 * @param idFisa the idFisa to set
	 */
	public void setIdFisa(int idFisa) {
		this.idFisa = idFisa;
	}
	/**
	 * @return the dataEmitere
	 */
	public String getDataEmitere() {
		return dataEmitere;
	}
	/**
	 * @param dataEmitere the dataEmitere to set
	 */
	public void setDataEmitere(String dataEmitere) {
		this.dataEmitere = dataEmitere;
	}
	/**
	 * @return the pacient
	 */
	public Pacient getPacient() {
		return pacient;
	}
	/**
	 * @param pacient the pacient to set
	 */
	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}
	/**
	 * @return the medic
	 */
	public MedicPrimar getMedic() {
		return medic;
	}
	/**
	 * @param medic the medic to set
	 */
	public void setMedic(MedicPrimar medic) {
		this.medic = medic;
	}
	
	
}
