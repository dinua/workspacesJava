package medweb.psconf.daos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Orar implements Serializable{

	private int idOrar;
	private MedicPrimar medicPrimar;
	private String day1;
	private String day2;
	private String day3;
	private String day4;
	private String day5;
	private String day6;
	private String day7;
	/**
	 * @return the idOrar
	 */
	public int getIdOrar() {
		return idOrar;
	}
	/**
	 * @param idOrar the idOrar to set
	 */
	public void setIdOrar(int idOrar) {
		this.idOrar = idOrar;
	}
	/**
	 * @return the day1
	 */
	public String getDay1() {
		return day1;
	}
	/**
	 * @param day1 the day1 to set
	 */
	public void setDay1(String day1) {
		this.day1 = day1;
	}
	/**
	 * @return the day2
	 */
	public String getDay2() {
		return day2;
	}
	/**
	 * @param day2 the day2 to set
	 */
	public void setDay2(String day2) {
		this.day2 = day2;
	}
	/**
	 * @return the day3
	 */
	public String getDay3() {
		return day3;
	}
	/**
	 * @param day3 the day3 to set
	 */
	public void setDay3(String day3) {
		this.day3 = day3;
	}
	/**
	 * @return the day4
	 */
	public String getDay4() {
		return day4;
	}
	/**
	 * @param day4 the day4 to set
	 */
	public void setDay4(String day4) {
		this.day4 = day4;
	}
	/**
	 * @return the day5
	 */
	public String getDay5() {
		return day5;
	}
	/**
	 * @param day5 the day5 to set
	 */
	public void setDay5(String day5) {
		this.day5 = day5;
	}
	/**
	 * @return the day6
	 */
	public String getDay6() {
		return day6;
	}
	/**
	 * @param day6 the day6 to set
	 */
	public void setDay6(String day6) {
		this.day6 = day6;
	}
	/**
	 * @return the day7
	 */
	public String getDay7() {
		return day7;
	}
	/**
	 * @param day7 the day7 to set
	 */
	public void setDay7(String day7) {
		this.day7 = day7;
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
	
	
}
