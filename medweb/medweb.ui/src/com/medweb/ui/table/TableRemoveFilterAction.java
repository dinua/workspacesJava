package com.medweb.ui.table;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.PlatformUI;

import com.medweb.ui.help.ImageID;

@SuppressWarnings("serial")
public class TableRemoveFilterAction implements Listener {
	private final TableViewer tableViewer;
	private final ViewerFilter filter;
	private boolean remove;
	
	public TableRemoveFilterAction(TableViewer tableViewer, ViewerFilter filter) {
		super();
		this.tableViewer = tableViewer;
		this.filter = filter;
		remove=true;
	}


	@Override
	public void handleEvent(Event event) {

		Button button=(Button)event.widget;
		Display display=PlatformUI.getWorkbench().getDisplay();
		
		if(remove){
			tableViewer.removeFilter(filter);
			button.setText(TableMessages.EDIT_ADD.getMessage());
		    Image img= new Image(display,ImageID.IMAGE_NEW.toString());
		    button.setImage(img)	;
	    }
		else{
			tableViewer.addFilter(filter);
			button.setText(TableMessages.EDIT_REMOVE.getMessage());
		    Image img= new Image(display,ImageID.IMAGE_NEW.toString());
		    button.setImage(img)	;
		}
		remove=!remove;
	}




}
