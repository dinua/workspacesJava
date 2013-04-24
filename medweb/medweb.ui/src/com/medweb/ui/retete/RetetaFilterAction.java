package com.medweb.ui.retete;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.Consult;
import medweb.psconf.daos.Medicament;
import medweb.psconf.daos.Reteta;
import medweb.psconf.daos.RetetaLinie;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.medweb.ui.help.Constants;
import com.medweb.ui.medicamente.SublistaEnum;
import com.medweb.ui.pacient.PacientMessages;
import com.medweb.ui.table.TableLabelProvider;

@SuppressWarnings("serial")
public class RetetaFilterAction implements Listener,IDoubleClickListener {

	private Text numeMedicamnet;
	private Button serach;
	private Button reset;
	private ListViewer list;
	private List<String> lista;
	private TableViewer tableViewer;
	private int indexEl=0;
	private RetetaModel retetaModel;
	private Button saveButton;
	private Text observatiiText;
	private Label unitateLabel;
	private Label codFiscalLabel;
	private List<Medicament> listMedicamente=new ArrayList<Medicament>();
	@Override
	public void handleEvent(Event event) {
		Button button=(Button)event.widget;
		if(button.equals(serach)){
			String text=numeMedicamnet.getText();	
		    list.getList().removeAll();
		    Iterator<String> it=lista.iterator();
			while(it.hasNext()){
				String s=it.next();
				if(s.toUpperCase().contains(text.toUpperCase())){
					list.add(s);
				}
			
			}
			
			
		}
		else if (button.equals(reset)){
			for(int i=0;i<10;i++){
				 RowReteta row=(RowReteta) tableViewer.getElementAt(i);
				    row.setCod("");
				    row.setNume("");
				    row.setAdministrare("");
				    row.setCantitate("");
				    TableLabelProvider.index=0;
				    tableViewer.refresh();
				    TableLabelProvider.index=0;
				    listMedicamente=new ArrayList<Medicament>();
			}
			indexEl=0;
		}
		else if(button.equals(saveButton))
		{
			if(listMedicamente.size()!=0)
			              saveReteta();
			else
				System.out.println("nu puteti salva nu sunt medicamnete");
		}

	}

	

	@Override
	public void doubleClick(DoubleClickEvent event) {
		String element=list.getSelection().toString();
	    element=element.substring(1,element.length()-1);
		////////////////////////
	    //###get medicamet in fct de de elem selectat
	    //*****************************************
	    String[] vec=element.split(" ");
	    //System.out.println(vec[0]+" %% "+vec[1]);
	    int nrSublista=SublistaEnum.fromString(vec[vec.length-1]).getOrdinalValue();
	    String aux="";
	    for(int i=1;i<vec.length-1;i++)
	    	aux=aux+vec[i]+" ";
	    
	    aux=aux.substring(0,aux.length()-1);
	    Medicament medicament = null;
		try {
			medicament = retetaModel.getBusinessService().getMedicamentByProperties(vec[0],aux, nrSublista);
		} catch (BusinessSQLException e) {
			IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(), 
					Constants.SQL_ERROR);
		}
	    listMedicamente.add(medicament);
	   if(indexEl<10){
	    RowReteta row=(RowReteta) tableViewer.getElementAt(indexEl);
	    row.setCod(medicament.getCodAtc());
	    row.setNume(medicament.getDenumireComerciala());
	    TableLabelProvider.index=0;
	    tableViewer.refresh();
	    indexEl++;
	    TableLabelProvider.index=0;
	   }
	}
	private void saveReteta() {
		IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		boolean bool=true;
		int i=0;
		Iterator<Medicament> it=listMedicamente.iterator();
		List<RetetaLinie> listReteta=new ArrayList<>();
		while(it.hasNext()){
			Medicament medicament=it.next();
		    RowReteta row=(RowReteta) tableViewer.getElementAt(i);
		    if(hasText(row.getCantitate())){
		    	if(hasText(row.getAdministrare())){
		    		
		    		RetetaLinie linie=new RetetaLinie();
		    		linie.setMedicament(medicament);
		    		linie.setCantitate(row.getCantitate());
		    		linie.setModAdministrare(row.getAdministrare());
		    		listReteta.add(linie);
		    			    		
		    	}
		    	else{
		    		bool=false;
		    		MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(), 
		     			"Nu a-ti completat modul de administrare pentru "+medicament.getDenumireComerciala());	 
		    	}
		    }
		    else{
		    	bool=false;
		    	MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(), 
						"Nu a-ti completat cantiatea pentru "+medicament.getDenumireComerciala());
		    }
		    
		
							
		    i++;
		}
		
		if(bool){
		
	    Consult consult=new Consult();
		consult.setFisa(retetaModel.getFisa());
		consult.setObservatii(observatiiText.getText());
		
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	     Date date = new Date();
	     consult.setDataConsult(dateFormat.format(date));
		
	     Reteta reteta=new Reteta();
	     reteta.setConsult(consult);
	     reteta.setListaMedicamente(listReteta);
	     reteta.setCodFiscalReteta(codFiscalLabel.getText());
	     reteta.setUnitateSanitara(unitateLabel.getText());
	     reteta.setDataPrescriere(dateFormat.format(date));
	     		    	     
	     try {
			this.retetaModel.getBusinessService().saveReteta(reteta);
			MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(), 
					"Datele au fost salvate");
		} catch (BusinessSQLException e) {
			MessageDialog.openInformation(window.getShell(), PacientMessages.EDIT_INFO.getMessage(), 
					Constants.SQL_ERROR);
		}
	 	
		}
	}
	/**
	 * @return the numeMedicamnet
	 */
	public Text getNumeMedicamnet() {
		return numeMedicamnet;
	}

	private boolean hasText(String value){
		if(value.equals("") || value.equals(" ")|| value==null)
			return false;
		return true;
	}
	/**
	 * @param numeMedicamnet the numeMedicamnet to set
	 */
	public void setNumeMedicamnet(Text numeMedicamnet) {
		this.numeMedicamnet = numeMedicamnet;
	}

	/**
	 * @return the serach
	 */
	public Button getSerach() {
		return serach;
	}

	/**
	 * @param serach the serach to set
	 */
	public void setSerach(Button serach) {
		this.serach = serach;
	}

	/**
	 * @return the list
	 */
	public ListViewer getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(ListViewer list) {
		this.list = list;
	}

	/**
	 * @return the lista
	 */
	public List<String> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<String> lista) {
		this.lista = lista;
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
	 * @return the reset
	 */
	public Button getReset() {
		return reset;
	}

	/**
	 * @param reset the reset to set
	 */
	public void setReset(Button reset) {
		this.reset = reset;
	}

	/**
	 * @return the retetaModel
	 */
	public RetetaModel getRetetaModel() {
		return retetaModel;
	}

	/**
	 * @param retetaModel the retetaModel to set
	 */
	public void setRetetaModel(RetetaModel retetaModel) {
		this.retetaModel = retetaModel;
	}

	/**
	 * @return the saveButton
	 */
	public Button getSaveButton() {
		return saveButton;
	}

	/**
	 * @param saveButton the saveButton to set
	 */
	public void setSaveButton(Button saveButton) {
		this.saveButton = saveButton;
	}



	/**
	 * @return the observatiiText
	 */
	public Text getObservatiiText() {
		return observatiiText;
	}



	/**
	 * @param observatiiText the observatiiText to set
	 */
	public void setObservatiiText(Text observatiiText) {
		this.observatiiText = observatiiText;
	}



	/**
	 * @return the unitateLabel
	 */
	public Label getUnitateLabel() {
		return unitateLabel;
	}



	/**
	 * @param unitateLabel the unitateLabel to set
	 */
	public void setUnitateLabel(Label unitateLabel) {
		this.unitateLabel = unitateLabel;
	}



	/**
	 * @return the codFiscalLabel
	 */
	public Label getCodFiscalLabel() {
		return codFiscalLabel;
	}



	/**
	 * @param codFiscalLabel the codFiscalLabel to set
	 */
	public void setCodFiscalLabel(Label codFiscalLabel) {
		this.codFiscalLabel = codFiscalLabel;
	}



	

	

}
