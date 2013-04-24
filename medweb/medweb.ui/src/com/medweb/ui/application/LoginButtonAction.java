package com.medweb.ui.application;

import medweb.businessService.BusinessService;
import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.MedicPrimar;
import medweb.psconf.daos.User;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;

import com.medweb.ui.medic.MedicModel;

@SuppressWarnings("serial")
public class LoginButtonAction implements Listener {

	private BusinessService bService;
	private MedicModel model;
	
	public LoginButtonAction(BusinessService businessService,
			MedicModel medicModel) {
		super();
		this.bService=businessService;
		this.model=medicModel;

	}

	@Override
	public void handleEvent(Event event) {
    LoginView loginView=(LoginView )PlatformUI.getWorkbench().
    		getActiveWorkbenchWindow().getActivePage().findView(LoginView.ID); 
	
    //TODO
    String username=loginView.getUserText().getText();
    String password=loginView.getPasswordText().getText();
   
   // String username="boral";
  //  String password="boral";
  
   User user=null;
    try {
		 user=loginView.getBusinessService().isAUser(username, password);
	} catch (BusinessSQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
    if(user!=null){
    	if(user.isActiv()){
    		this.model.setUser(user);
    	    loginView.getMessage().setText("");
    	    MedicPrimar medicPrimar = null;
    		try {
    			medicPrimar = bService.getMedicPrimarByID(user.getIdUser());
    		} catch (BusinessSQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	    model.setMedicPrimar(medicPrimar);
    	    int type=user.getUserType().getIdUserType();
    	    switch (type) {
			case 2:
				model.setIdMedicRezident(medicPrimar.getIdMedicPrimar());
				model.setRestricted(false);
				break;
			case 3:
				try {
					int id=this.model.getBusinessService().getIdMedicRezident(medicPrimar.getIdMedicPrimar());
					model.setIdMedicRezident(id);
					model.setRestricted(true);
				} catch (BusinessSQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			default:
				break;
			}
    	    isRightLogt();  	
    	  }
    	else{
    		
    		loginView.getMessage().setText(LoginMessages.ERROR_MESSAGE_INACTIVE.getMessage());
    		
    	}
    }
    else{
    	
    	loginView.getMessage().setText(LoginMessages.ERROR_MESSAGE_INCORECT.getMessage());
    }
   

	}
	
	private void isRightLogt(){
		 IWorkbench iw=PlatformUI.getWorkbench();
	        try {
	        	iw.getActiveWorkbenchWindow().getActivePage().closeAllPerspectives(false, false);
				iw.showPerspective(new com.medweb.ui.menu.ApplicationWorkbenchAdvisor().getInitialWindowPerspectiveId(),iw.getActiveWorkbenchWindow());
			} catch (WorkbenchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
