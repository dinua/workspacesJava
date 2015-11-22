package com.medweb.ui.table;





import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

@SuppressWarnings("serial")
public class TableFilterAction implements Listener {

private ComboViewer  columnViewer;
private ComboViewer  criteriaViewer;
private TableViewer tableViewer;
private Text textt;	
private Label infoLabel;

	@Override
	public void handleEvent(Event event) {
			
		String columnName=columnViewer.getSelection().toString();
		columnName=columnName.substring(1,columnName.length()-1);
		String criteriaName=criteriaViewer.getSelection().toString();
		criteriaName=criteriaName.substring(1,criteriaName.length()-1);
		String value=textt.getText();
		IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		
		
		if(stringHasText(columnName)){
			if(stringHasText(criteriaName)){
				if(stringHasText(value)){
					tableViewer.addFilter(new TableViewFilter(columnName, criteriaName,value));
					String infoText=infoLabel.getText();
					String[] vec=infoText.split(":");
					int nrOfFilter=Integer.parseInt(vec[1]);
					String newChar=""+(++nrOfFilter);
					infoText=infoText.replace(vec[1], newChar);
					infoLabel.setText(infoText);
				}
				else
				{
					MessageDialog.openInformation(window.getShell(), TableMessages.EDIT_INFO.getMessage(), TableMessages.EDIT_ERROR_VALUE.getMessage());
				}
			}
			else{
				MessageDialog.openInformation(window.getShell(), TableMessages.EDIT_INFO.getMessage(),TableMessages.EDIT_ERROR_CRITERIA.getMessage());
			}
		}
		else{
			MessageDialog.openInformation(window.getShell(), TableMessages.EDIT_INFO.getMessage(), TableMessages.EDIT_ERROR_COLUMN.getMessage());
		}
		
		
	}

	
	private boolean stringHasText(String string){
		if(string!=null && string!="" && string!=" " && (!string.equals("empty selection")))
			return true;
		else
			return false;
	}
	
	/**
	 * @return the columnViewer
	 */
	public ComboViewer getColumnViewer() {
		return columnViewer;
	}

	/**
	 * @param columnViewer the columnViewer to set
	 */
	public void setColumnViewer(ComboViewer columnViewer) {
		this.columnViewer = columnViewer;
	}

	/**
	 * @return the criteriaViewer
	 */
	public ComboViewer getCriteriaViewer() {
		return criteriaViewer;
	}

	/**
	 * @param criteriaViewer the criteriaViewer to set
	 */
	public void setCriteriaViewer(ComboViewer criteriaViewer) {
		this.criteriaViewer = criteriaViewer;
	}

	/**
	 * @return the tableViewer
	 */
	public TableViewer getTableViewer() {
		return tableViewer;
	}

	/**
	 * @param tableViewer the tableViewer to set
	 */
	public void setTableViewer(TableViewer tableViewer) {
		this.tableViewer = tableViewer;
	}

	/**
	 * @return the textt
	 */
	public Text getTextt() {
		return textt;
	}

	/**
	 * @param textt the textt to set
	 */
	public void setTextt(Text textt) {
		this.textt = textt;
	}


	/**
	 * @return the infoLabel
	 */
	public Label getInfoLabel() {
		return infoLabel;
	}


	/**
	 * @param infoFilter1 the infoLabel to set
	 */
	public void setInfoLabel(Label infoFilter1) {
		this.infoLabel = infoFilter1;
	}


	

}
