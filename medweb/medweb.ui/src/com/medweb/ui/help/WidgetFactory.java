package com.medweb.ui.help;

import java.util.List;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import com.medweb.ui.table.ColumnDescriptor;
import com.medweb.ui.table.EditTableViewer;






public final class WidgetFactory {

	private static final String CUSTOM_WIDGET_ID="org.eclipse.rwt.UITests#customId"; 
	private static TableViewer tableViewer;
	private WidgetFactory(){
		super();
	}
	
	public static Label createLabel(final Composite parent,final String widgetName){
		Label label=new Label(parent, SWT.NONE);
		label.setData(CUSTOM_WIDGET_ID, widgetName);
		return label;
	}
	
	public static Label createLabel(final Composite parent,final String widgetName,final String text){
		Label label=new Label(parent, SWT.NONE);
		label.setData(CUSTOM_WIDGET_ID, widgetName);
		label.setText(text);
		return label;
	}
	
	public static Text createText(final Composite parent,final String widgetName,final int size,final boolean setFocus){
		Text text=new Text(parent,SWT.BORDER);
		text.setTextLimit(size);
		text.setData(CUSTOM_WIDGET_ID, widgetName);
		if(setFocus){
			text.setFocus();
		}
		return text;
	}
	public static Text createTextArea(final Composite parent,final String widgetName,final int size,final boolean setFocus){
		Text text=new Text(parent, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		text.setTextLimit(size);
		text.setData(CUSTOM_WIDGET_ID, widgetName);
		if(setFocus){
			text.setFocus();
		}
		return text;
	}
	public static Text createTextPassword(final Composite parent,final String widgetName,final int size,final boolean setFocus){
		Text text=new Text(parent,SWT.BORDER | SWT.PASSWORD);
		text.setTextLimit(size);
		text.setData(CUSTOM_WIDGET_ID, widgetName);
		if(setFocus){
			text.setFocus();
		}
		return text;
	}
	public static Button createButton(final Composite parent,final String widgetName,final String text,final boolean setFocus){
		Button button =new Button(parent,SWT.NONE);
		button.setText(text);
		button.setData(CUSTOM_WIDGET_ID, widgetName);
		if(setFocus)
		{
			button.setFocus();
		}
		return button;
	}
	public static Button createButton(final Composite parent,final String widgetName,final String text,final boolean setFocus,ImageID image){
		Button button =new Button(parent,SWT.NONE);
		button.setText(text);
		button.setData(CUSTOM_WIDGET_ID, widgetName);
		Display display=PlatformUI.getWorkbench().getDisplay();
	    Image img= new Image(display,image.toString());
	    button.setImage(img)	;
		if(setFocus)
		{
			button.setFocus();
		}
		return button;
	}
	
	public static Composite createTableViewer(final Composite parent,int style,List<ColumnDescriptor> columnDescriptors,List<Object> inputObject){
		
		EditTableViewer editTableViewer=new EditTableViewer(parent, style, columnDescriptors, inputObject);
	   Composite composite = editTableViewer.getComposite();
	   setTableViewer(editTableViewer.getTableViewer());
	   return composite;
		
	}
   public static Composite createTableViewer(final Composite parent,int style,List<ColumnDescriptor> columnDescriptors,List<Object> inputObject,int difSize,boolean space,boolean noFilter){
			
			EditTableViewer editTableViewer=new EditTableViewer(parent, style, columnDescriptors, inputObject,difSize,space,noFilter);
		   Composite composite = editTableViewer.getComposite();
		   setTableViewer(editTableViewer.getTableViewer());
		   return composite;
			
		}
   public static Composite createTableViewer(final Composite parent,int style,List<ColumnDescriptor> columnDescriptors,List<Object> inputObject,int difSize,boolean space){
			
			EditTableViewer editTableViewer=new EditTableViewer(parent, style, columnDescriptors, inputObject,difSize,space);
		   Composite composite = editTableViewer.getComposite();
		   setTableViewer(editTableViewer.getTableViewer());
		   return composite;
			
		}
   public static Composite createTableViewer(final Composite parent,int style,List<ColumnDescriptor> columnDescriptors,List<Object> inputObject,int difSize){
		
		EditTableViewer editTableViewer=new EditTableViewer(parent, style, columnDescriptors, inputObject,difSize);
	   Composite composite = editTableViewer.getComposite();
	   setTableViewer(editTableViewer.getTableViewer());
	   return composite;
		
	}
	 public static ComboViewer createComboViewer(final Composite parent, final String widgetName, final boolean setFocus) {
		    ComboViewer comboViewer = new ComboViewer(parent, SWT.READ_ONLY);
		    comboViewer.setData(CUSTOM_WIDGET_ID, widgetName);
		    if (setFocus) {
		      comboViewer.getControl().setFocus();
		    }

		    return comboViewer;
		  }

    public static Button createCheckBox(final Composite parent, final String widgetName, final String text,
            final boolean setFocus){
    	 Button button = new Button(parent, SWT.CHECK);
    	    button.setText(text);
    	    button.setData(CUSTOM_WIDGET_ID, widgetName);
    	    if (setFocus) {
    	      button.setFocus();
    	    }

    	    return button;
    }
    
    public static ListViewer createListViewer(final Composite parent, final String widgetName, final boolean setFocus,
            final boolean multiSelect) {
    	int style = SWT.BORDER | SWT.V_SCROLL;
    	if (multiSelect) {
    		style |= SWT.MULTI;
    	}
    	ListViewer listViewer = new ListViewer(parent, style);
    	listViewer.setData(CUSTOM_WIDGET_ID, widgetName);
    	if (setFocus) {
    		listViewer.getControl().setFocus();
    	}

    	return listViewer;
    }
	/**
	 * @return the tableViewer
	 */
	public static TableViewer getTableViewer() {
		return tableViewer;
	}

	/**
	 * @param tableViewer the tableViewer to set
	 */
	public static void setTableViewer(TableViewer tableViewer) {
		WidgetFactory.tableViewer = tableViewer;
	}

	

	

}
