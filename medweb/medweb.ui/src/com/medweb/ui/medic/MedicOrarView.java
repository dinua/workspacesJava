package com.medweb.ui.medic;

import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.Orar;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.medweb.ui.help.ImageID;
import com.medweb.ui.help.WidgetFactory;

public class MedicOrarView extends ViewPart{
	public static final String ID = "com.medweb.ui.medic.medicOrarView";
	
	 private Color color=new Color(Display.getCurrent(),253,245,204 );
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
	private Button button;
	 private MedicModel medicModel;
	@Override
	public void createPartControl(Composite parent) {
		 parent.setLayout(new GridLayout(6,true));
		 Display display=PlatformUI.getWorkbench().getDisplay();
		 Image img= new Image(display,ImageID.IMAGE_BACKGROUND_ORAR.toString());
		
		 addWightBlankLabels(parent, 12);
		 
		
		 
		Composite leftComposite=new Composite(parent, SWT.None);
		leftComposite.setLayout(new GridLayout(1,true));
		GridData data=new GridData(SWT.CENTER, SWT.FILL, false, true);
		data.heightHint=330;
		data.widthHint=100;
		leftComposite.setLayoutData(data);
		leftComposite.setBackgroundImage(img);
		
		Composite composite=new Composite(parent, SWT.None);
		composite.setLayout(new GridLayout(8,true));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,4,1));
		composite.setBackground(color);
		createOrarView(composite);
		
		
		Composite rightComposite=new Composite(parent, SWT.None);
		rightComposite.setLayout(new GridLayout(1,true));
		rightComposite.setLayoutData(data);
		rightComposite.setBackgroundImage(img);
		
		createBindings();
		createListner();
	}
	


private void createOrarView(Composite composite){
	addBlankLabels(composite, 33);
	//*********ziua1*************************************
	Label day1=WidgetFactory.createLabel(composite, "day1","Luni");
	day1.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false));
	day1.setBackground(color);
	combo1Day1 = WidgetFactory.createComboViewer(composite, "combo1Day1", false);
	createValuesCombo(combo1Day1);
	addBlankLabels(composite, 1);
	createSeparatorLabel(composite);
	combo2Day1 = WidgetFactory.createComboViewer(composite, "combo2Day1", false);
	createValuesCombo(combo2Day1);
	addBlankLabels(composite, 3);
	
	//*********ziua2*************************************
	Label day2=WidgetFactory.createLabel(composite, "day2","Marti");
	day2.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false));
	day2.setBackground(color);
	combo1Day2 = WidgetFactory.createComboViewer(composite, "combo1Day2", false);
	createValuesCombo(combo1Day2);
	addBlankLabels(composite, 1);
	createSeparatorLabel(composite);
	combo2Day2 = WidgetFactory.createComboViewer(composite, "combo2Day2", false);
	createValuesCombo(combo2Day2);
	addBlankLabels(composite, 3);
	//*********ziua3*************************************
	Label day3=WidgetFactory.createLabel(composite, "day3","Miercuri");
	day3.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false));
	day3.setBackground(color);
	combo1Day3 = WidgetFactory.createComboViewer(composite, "combo1Day3", false);
	createValuesCombo(combo1Day3);
	addBlankLabels(composite, 1);
	createSeparatorLabel(composite);
	combo2Day3 = WidgetFactory.createComboViewer(composite, "combo2Day3", false);
	createValuesCombo(combo2Day3);
	addBlankLabels(composite, 3);
	//*********ziua4*************************************
	Label day4=WidgetFactory.createLabel(composite, "day4","Joi");
	day4.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false));
	day4.setBackground(color);
	combo1Day4 = WidgetFactory.createComboViewer(composite, "combo1Day4", false);
	createValuesCombo(combo1Day4);
	addBlankLabels(composite, 1);
	createSeparatorLabel(composite);
	combo2Day4 = WidgetFactory.createComboViewer(composite, "combo2Day4", false);
	createValuesCombo(combo2Day4);
	addBlankLabels(composite, 3);
		
	//*********ziua5*************************************
	Label day5=WidgetFactory.createLabel(composite, "day5","Vineri");
	day5.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false));
	day5.setBackground(color);
	combo1Day5 = WidgetFactory.createComboViewer(composite, "combo1Day5", false);
	createValuesCombo(combo1Day5);
	addBlankLabels(composite, 1);
	createSeparatorLabel(composite);
	combo2Day5 = WidgetFactory.createComboViewer(composite, "combo2Day5", false);
	createValuesCombo(combo2Day5);
	addBlankLabels(composite, 3);
	//*********ziua6*************************************
	Label day6=WidgetFactory.createLabel(composite, "day6","Sambata");
	day6.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false));
	day6.setBackground(color);
	combo1Day6 = WidgetFactory.createComboViewer(composite, "combo1Day6", false);
	createValuesCombo(combo1Day6);
	addBlankLabels(composite, 1);
	createSeparatorLabel(composite);
	combo2Day6 = WidgetFactory.createComboViewer(composite, "combo2Day6", false);
	createValuesCombo(combo2Day6);
	addBlankLabels(composite, 3);
	//*********ziua7*************************************
	Label day7=WidgetFactory.createLabel(composite, "day7","Duminica");
	day7.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false));
	day7.setBackground(color);
	combo1Day7 = WidgetFactory.createComboViewer(composite, "combo1Day7", false);
	createValuesCombo(combo1Day7);
	addBlankLabels(composite, 1);
	createSeparatorLabel(composite);
	combo2Day7 = WidgetFactory.createComboViewer(composite, "combo2Day7", false);
	createValuesCombo(combo2Day7);
	addBlankLabels(composite, 15);
	
	button = WidgetFactory.createButton(composite, "button", "Save", false,ImageID.IMAGE_SAVE);
	button.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		
}
private void createSeparatorLabel(Composite parent){
	Label toLabel=WidgetFactory.createLabel(parent, "toLabel","TO");
	toLabel.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false));
	toLabel.setBackground(color);
}
private void createValuesCombo(ComboViewer combo){
	combo.add(HourEnum.UNKNOWN.toString());
	combo.add(HourEnum.HOUR_08.toString());
	combo.add(HourEnum.HOUR_10.toString());
	combo.add(HourEnum.HOUR_12.toString());
	combo.add(HourEnum.HOUR_14.toString());
	combo.add(HourEnum.HOUR_16.toString());
	combo.add(HourEnum.HOUR_18.toString());
	combo.add(HourEnum.HOUR_20.toString());
	combo.add(HourEnum.Close.toString());
	
}
private void createBindings() {

	Orar orar = null;
	try {
		orar = this.medicModel.getBusinessService().getOrarMedic(this.medicModel.getMedicPrimar());
	} catch (BusinessSQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setBinding(orar.getDay1(), combo1Day1, combo2Day1);
	setBinding(orar.getDay2(), combo1Day2, combo2Day2);
	setBinding(orar.getDay3(), combo1Day3, combo2Day3);
	setBinding(orar.getDay4(), combo1Day4, combo2Day4);
	setBinding(orar.getDay5(), combo1Day5, combo2Day5);
	setBinding(orar.getDay6(), combo1Day6, combo2Day6);
	setBinding(orar.getDay7(), combo1Day7, combo2Day7);
}
private void setBinding(String value,ComboViewer combo1,ComboViewer combo2){
	String[] vec=value.split("-");
	
	int id1=Integer.parseInt(vec[0]);
	combo1.getCombo().select(id1);
	if(id1<HourEnum.Close.getOrdinalValue() && id1>HourEnum.UNKNOWN.getOrdinalValue()){
		int id2=Integer.parseInt(vec[1]);
		combo2.getCombo().select(id2);
	}
}
private void createListner(){
	OrarAction action=new OrarAction();
	action.setCombo1Day1(combo1Day1);
	action.setCombo1Day2(combo1Day2);
	action.setCombo1Day3(combo1Day3);
	action.setCombo1Day4(combo1Day4);
	action.setCombo1Day5(combo1Day5);
	action.setCombo1Day6(combo1Day6);
	action.setCombo1Day7(combo1Day7);
	action.setCombo2Day1(combo2Day1);
	action.setCombo2Day2(combo2Day2);
	action.setCombo2Day3(combo2Day3);
	action.setCombo2Day4(combo2Day4);
	action.setCombo2Day5(combo2Day5);
	action.setCombo2Day6(combo2Day6);
	action.setCombo2Day7(combo2Day7);
	
	button.addListener(SWT.Selection, action);
}
private void addBlankLabels(Composite parent,int number){
	for(int i=0;i<number;i++){
		Label label=WidgetFactory.createLabel(parent, "");
		label.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
	    label.setBackground(color);
		
	    
	}
}

private void addWightBlankLabels(Composite parent,int number){
	for(int i=0;i<number;i++){
		Label label=WidgetFactory.createLabel(parent, "");
		label.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
	 
	    
	}
}
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}



	/**
	 * @return the medicModel
	 */
	public MedicModel getMedicModel() {
		return medicModel;
	}



	/**
	 * @param medicModel the medicModel to set
	 */
	public void setMedicModel(MedicModel medicModel) {
		this.medicModel = medicModel;
	}

}
