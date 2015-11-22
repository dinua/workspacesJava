package com.medweb.ui.help;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public final class ChangeViewPage {

	public static void changeView(String primaryId,String secondaryId){
		IViewReference[] viewReference=(IViewReference[]) PlatformUI.getWorkbench()
				            .getActiveWorkbenchWindow().getActivePage().getViewReferences(); 
		boolean alreadyOpen=false;
		
		for(int i=0;i<viewReference.length;i++){
	        if(secondaryId==null){
	        	secondaryId="single";
	        }
			if(secondaryId.equals("single")){
	        	  secondaryId=viewReference[i].getSecondaryId();
	          }
			if(primaryId.equals(viewReference[i].getId()) ){
				
				if(secondaryId==null || viewReference[i].getSecondaryId()==null)
				{
					alreadyOpen=true;
					primaryId=viewReference[i].getId();
					secondaryId=viewReference[i].getSecondaryId();
				}
				else if(secondaryId.equals(viewReference[i].getSecondaryId())){
					   alreadyOpen=true;
					   primaryId=viewReference[i].getId();
						secondaryId=viewReference[i].getSecondaryId();
				      }
				  
			}
					
		}
		if(alreadyOpen)
		{
		reactivate(primaryId, secondaryId);	
		}
		else{
			changeNewPage(primaryId, secondaryId);
		}
	}
	protected static void changeNewPage(String primaryID,String secondaryID){
		  IWorkbench iw=PlatformUI.getWorkbench();
	      IWorkbenchWindow window=iw.getActiveWorkbenchWindow(); 
	      try {
				window.getActivePage().showView(primaryID, secondaryID, IWorkbenchPage.VIEW_ACTIVATE);
			} catch (PartInitException e) {
				MessageDialog.openError(window.getShell(), "Error", "Error opening view:" + e.getMessage());
			}
	}
	protected static void reactivate(String primaryID,String secondaryID){
		IWorkbench iw=PlatformUI.getWorkbench();
		 IWorkbenchWindow  window=iw.getActiveWorkbenchWindow(); 
	      try {
				window.getActivePage().showView(primaryID, secondaryID, IWorkbenchPage.VIEW_ACTIVATE);
			} catch (PartInitException e) {
				MessageDialog.openError(window.getShell(), "Error", "Error opening view:" + e.getMessage());
			}
	}	
}
