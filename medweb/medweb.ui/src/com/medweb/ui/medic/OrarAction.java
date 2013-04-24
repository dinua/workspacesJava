package com.medweb.ui.medic;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

@SuppressWarnings("serial")
public class OrarAction implements Listener{
	private ComboViewer combo1Day1;
	private ComboViewer combo2Day1;
	private ComboViewer combo1Day2;
	private ComboViewer combo2Day2;
	private ComboViewer combo1Day3;
	private ComboViewer combo2Day3;
	private ComboViewer combo1Day4;
	private ComboViewer combo2Day4;
	private ComboViewer combo1Day5;
	private ComboViewer combo2Day5;
	private ComboViewer combo1Day6;
	private ComboViewer combo2Day6;
	private ComboViewer combo1Day7;
	private ComboViewer combo2Day7;
	
	@Override
	public void handleEvent(Event event) {

     String ora1=combo1Day1.getSelection().toString();
     String ora2=combo2Day1.getSelection().toString();
	 checkHour(ora1, ora2, "1");
	 
	  ora1=combo1Day2.getSelection().toString();
      ora2=combo2Day2.getSelection().toString();
	  checkHour(ora1, ora2, "2");
	  
	  ora1=combo1Day3.getSelection().toString();
      ora2=combo2Day3.getSelection().toString();
	  checkHour(ora1, ora2, "3");
	  
	  ora1=combo1Day4.getSelection().toString();
      ora2=combo2Day4.getSelection().toString();
	  checkHour(ora1, ora2, "4");
	  
	  ora1=combo1Day5.getSelection().toString();
      ora2=combo2Day5.getSelection().toString();
	  checkHour(ora1, ora2, "5");
	  
	  ora1=combo1Day6.getSelection().toString();
      ora2=combo2Day6.getSelection().toString();
	  checkHour(ora1, ora2, "6");
	  
	  ora1=combo1Day7.getSelection().toString();
      ora2=combo2Day7.getSelection().toString();
	  checkHour(ora1, ora2, "7");
	}
	
	
	private void checkHour(String hour1,String hour2,String day){
		hour1=hour1.substring(1,hour1.length()-1);
		hour2=hour2.substring(1,hour2.length()-1);
	 int h1=HourEnum.fromString(hour1).getOrdinalValue();
	 int h2=HourEnum.fromString(hour2).getOrdinalValue();
	 
	 if(h1!=HourEnum.Close.getOrdinalValue()){
		 if(h1==HourEnum.UNKNOWN.getOrdinalValue()){
			 System.err.println("s-a gresit pe ziua "+day);
		 }
		 if(h2==HourEnum.UNKNOWN.getOrdinalValue()){
			 System.err.println("s-a gresit pe ziua "+day);
			 h2=99;
		 }
		 if(h1>h2){
			 System.err.println("s-a gresit pe ziua "+day);
		 }
		 if(h1==h2){
			 System.err.println("s-a gresit pe ziua "+day);
		 }
	 }
	}
	/**
	 * @return the combo1Day1
	 */
	public ComboViewer getCombo1Day1() {
		return combo1Day1;
	}
	/**
	 * @param combo1Day1 the combo1Day1 to set
	 */
	public void setCombo1Day1(ComboViewer combo1Day1) {
		this.combo1Day1 = combo1Day1;
	}
	/**
	 * @return the combo2Day1
	 */
	public ComboViewer getCombo2Day1() {
		return combo2Day1;
	}
	/**
	 * @param combo2Day1 the combo2Day1 to set
	 */
	public void setCombo2Day1(ComboViewer combo2Day1) {
		this.combo2Day1 = combo2Day1;
	}
	/**
	 * @return the combo1Day2
	 */
	public ComboViewer getCombo1Day2() {
		return combo1Day2;
	}
	/**
	 * @param combo1Day2 the combo1Day2 to set
	 */
	public void setCombo1Day2(ComboViewer combo1Day2) {
		this.combo1Day2 = combo1Day2;
	}
	/**
	 * @return the combo2Day2
	 */
	public ComboViewer getCombo2Day2() {
		return combo2Day2;
	}
	/**
	 * @param combo2Day2 the combo2Day2 to set
	 */
	public void setCombo2Day2(ComboViewer combo2Day2) {
		this.combo2Day2 = combo2Day2;
	}
	/**
	 * @return the combo1Day3
	 */
	public ComboViewer getCombo1Day3() {
		return combo1Day3;
	}
	/**
	 * @param combo1Day3 the combo1Day3 to set
	 */
	public void setCombo1Day3(ComboViewer combo1Day3) {
		this.combo1Day3 = combo1Day3;
	}
	/**
	 * @return the combo2Day3
	 */
	public ComboViewer getCombo2Day3() {
		return combo2Day3;
	}
	/**
	 * @param combo2Day3 the combo2Day3 to set
	 */
	public void setCombo2Day3(ComboViewer combo2Day3) {
		this.combo2Day3 = combo2Day3;
	}
	/**
	 * @return the combo1Day4
	 */
	public ComboViewer getCombo1Day4() {
		return combo1Day4;
	}
	/**
	 * @param combo1Day4 the combo1Day4 to set
	 */
	public void setCombo1Day4(ComboViewer combo1Day4) {
		this.combo1Day4 = combo1Day4;
	}
	/**
	 * @return the combo2Day4
	 */
	public ComboViewer getCombo2Day4() {
		return combo2Day4;
	}
	/**
	 * @param combo2Day4 the combo2Day4 to set
	 */
	public void setCombo2Day4(ComboViewer combo2Day4) {
		this.combo2Day4 = combo2Day4;
	}
	/**
	 * @return the combo1Day5
	 */
	public ComboViewer getCombo1Day5() {
		return combo1Day5;
	}
	/**
	 * @param combo1Day5 the combo1Day5 to set
	 */
	public void setCombo1Day5(ComboViewer combo1Day5) {
		this.combo1Day5 = combo1Day5;
	}
	/**
	 * @return the combo2Day5
	 */
	public ComboViewer getCombo2Day5() {
		return combo2Day5;
	}
	/**
	 * @param combo2Day5 the combo2Day5 to set
	 */
	public void setCombo2Day5(ComboViewer combo2Day5) {
		this.combo2Day5 = combo2Day5;
	}
	/**
	 * @return the combo1Day6
	 */
	public ComboViewer getCombo1Day6() {
		return combo1Day6;
	}
	/**
	 * @param combo1Day6 the combo1Day6 to set
	 */
	public void setCombo1Day6(ComboViewer combo1Day6) {
		this.combo1Day6 = combo1Day6;
	}
	/**
	 * @return the combo2Day6
	 */
	public ComboViewer getCombo2Day6() {
		return combo2Day6;
	}
	/**
	 * @param combo2Day6 the combo2Day6 to set
	 */
	public void setCombo2Day6(ComboViewer combo2Day6) {
		this.combo2Day6 = combo2Day6;
	}
	/**
	 * @return the combo1Day7
	 */
	public ComboViewer getCombo1Day7() {
		return combo1Day7;
	}
	/**
	 * @param combo1Day7 the combo1Day7 to set
	 */
	public void setCombo1Day7(ComboViewer combo1Day7) {
		this.combo1Day7 = combo1Day7;
	}
	/**
	 * @return the combo2Day7
	 */
	public ComboViewer getCombo2Day7() {
		return combo2Day7;
	}
	/**
	 * @param combo2Day7 the combo2Day7 to set
	 */
	public void setCombo2Day7(ComboViewer combo2Day7) {
		this.combo2Day7 = combo2Day7;
	}
	
	
	
}
