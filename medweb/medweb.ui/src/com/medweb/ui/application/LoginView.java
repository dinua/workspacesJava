package com.medweb.ui.application;



import medweb.businessService.BusinessService;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import com.medweb.ui.help.WidgetFactory;
import com.medweb.ui.medic.MedicModel;


public class LoginView extends ViewPart{

	public static final String ID = "com.medweb.ui.application.loginView";
	private Composite composite;
	private Label userLabel,passwordLabel;
	private Text userText,passwordText;
	private Button loginButton;
	private BusinessService businessService;
	private MedicModel medicModel;
	private Label message;
	
	
	@Override
	public void createPartControl(Composite parent) {
		
		composite=new Group(parent,SWT.None);
		composite.setLayout(new GridLayout(6,true));
		
		addBlankLabels(composite, 32);
		
		setMessage(WidgetFactory.createLabel(composite, "message", ""));
		getMessage().setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,4,1));
		Color color=new Color(null, 255, 0, 0);
		getMessage().setForeground(color);
		
		addBlankLabels(composite, 2);
		
		userLabel=WidgetFactory.createLabel(composite, "userLabel", LoginMessages.EDIT_FORM_USER.getMessage());
		userLabel.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		
		setUserText(WidgetFactory.createText(composite, "userText", 20, true));
		getUserText().setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		
		addBlankLabels(composite,4);
		
		
		passwordLabel=WidgetFactory.createLabel(composite, "", LoginMessages.EDIT_FORM_PASSWORD.getMessage());
		passwordLabel.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		
		setPasswordText(WidgetFactory.createTextPassword(composite, "passwordText", 20, false));
		getPasswordText().setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		
		addBlankLabels(composite, 11);
		
		loginButton=WidgetFactory.createButton(composite, "loginButton", LoginMessages.EDIT_FORM_LOGIN.getMessage(), false);
		loginButton.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		
		createListeners();
	}

	
	private void createListeners(){
		LoginButtonAction action=new LoginButtonAction(businessService,medicModel);
		
		loginButton.addListener(SWT.Selection, action);
	}
	@Override
	public void setFocus() {
		
		
	}

	
	private void addBlankLabels(Composite parent,int number){
		for(int i=0;i<number;i++){
			Label label=WidgetFactory.createLabel(parent, "");
			label.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		    //label.setText("#");
		}
	}

	/**
	 * @return the businessService
	 */
	public BusinessService getBusinessService() {
		return businessService;
	}

	/**
	 * @param businessService the businessService to set
	 */
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	/**
	 * @return the userText
	 */
	public Text getUserText() {
		return userText;
	}

	/**
	 * @param userText the userText to set
	 */
	public void setUserText(Text userText) {
		this.userText = userText;
	}

	/**
	 * @return the passwordText
	 */
	public Text getPasswordText() {
		return passwordText;
	}

	/**
	 * @param passwordText the passwordText to set
	 */
	public void setPasswordText(Text passwordText) {
		this.passwordText = passwordText;
	}

	/**
	 * @return the message
	 */
	public Label getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(Label message) {
		this.message = message;
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
