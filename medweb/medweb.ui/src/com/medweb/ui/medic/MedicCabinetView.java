package com.medweb.ui.medic;

import java.util.Iterator;

import medweb.psconf.daos.CabinetMedical;
import medweb.psconf.daos.CasaAsigurari;

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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.medweb.ui.help.ImageID;
import com.medweb.ui.help.WidgetFactory;

public class MedicCabinetView extends ViewPart{
	public static final String ID = "com.medweb.ui.medic.medicCabinetView";
	 private Color color=new Color(Display.getCurrent(),253,245,204 );
	 private Text numeText;
	 private Text adresaText;
	 private Text codFiscalText;
	 private Text nrContractText;
	 private ComboViewer casaAsigComboViewer;
	 private MedicModel medicModel;
	 private Button saveButton;
	 
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
		
		createToolbarButtons(composite);
		createCabinetInfo(composite);
		
		Composite rightComposite=new Composite(parent, SWT.None);
		rightComposite.setLayout(new GridLayout(1,true));
		rightComposite.setLayoutData(data);
		rightComposite.setBackgroundImage(img);
		
		createBindings();
		createListner();
		
	}
	private void createToolbarButtons(Composite parent){
		 
		    addBlankLabels(parent, 8);
		   saveButton = WidgetFactory.createButton(parent, "saveButton","Save", false,ImageID.IMAGE_SAVE);
		   GridData data =new GridData(SWT.FILL,SWT.BOTTOM,false,false,1,1);
		   data.widthHint=80;
		   saveButton.setLayoutData(data);
		   addBlankLabels(parent, 7);
		   
		}
	private void createCabinetInfo(Composite composite){
		addBlankLabels(composite, 16);
		//////////////////////////////////////////////////////////////////
		Label numeLabel=WidgetFactory.createLabel(composite, "numeLabel", "Nume");
		numeLabel.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		numeLabel.setBackground(color);
		
		numeText = WidgetFactory.createText(composite, "numeText", 100, false);
		numeText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		
		addBlankLabels(composite, 5);
		
		/////////////////////////////////////////////////////////////////////////	
		Label codFiscalLabel=WidgetFactory.createLabel(composite, "codFiscalLabel", "Cod fiscal");
		codFiscalLabel.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		codFiscalLabel.setBackground(color);

		codFiscalText = WidgetFactory.createText(composite, "codFiscalText", 100, false);
		codFiscalText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		addBlankLabels(composite, 5);
		/////////////////////////////////////////// 
		Label adresaLabel=WidgetFactory.createLabel(composite, "adresaLabel", "Adresa");
		adresaLabel.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		adresaLabel.setBackground(color);
		
		adresaText = WidgetFactory.createText(composite, "adresaText", 100, false);
		adresaText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,4,1));
		addBlankLabels(composite, 11);
		/////////////////////////////////////////////////////////////////////////
		
		Label contractLabel=WidgetFactory.createLabel(composite, "contractLabel", "Nr contr CNAS");
		contractLabel.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,2,1));
		contractLabel.setBackground(color);

		nrContractText = WidgetFactory.createText(composite, "nrContractText", 100, false);
		nrContractText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		addBlankLabels(composite, 4);
		/////////////////////////////////////////
		Label casaAsigLabel=WidgetFactory.createLabel(composite, "casaAsigLabel","Casa asigurari:");
		 casaAsigLabel.setLayoutData(new GridData(SWT.LEFT,SWT.FILL,true,false,2,1));
        casaAsigLabel.setBackground(color);
		 casaAsigComboViewer = WidgetFactory.createComboViewer(composite, "casaAsigComboViewer", false);
		 addBlankLabels(composite, 5);
		
		
	}
	private void createBindings(){
		CabinetMedical cabinet=this.medicModel.getMedicPrimar().getCabinetMedical();
		
		numeText.setText(cabinet.getNume());
		codFiscalText.setText(cabinet.getCodFiscal());
		adresaText.setText(cabinet.getAdresa());
		nrContractText.setText(cabinet.getNrContractCNAS());
		
		int index=0;
	     Iterator<CasaAsigurari> itCasa= this.medicModel.getAllCasaAsigurari().iterator();
	     String numeCasaAsig=cabinet.getCasaAsigurari().getNume();
	     while(itCasa.hasNext()){
	    	 CasaAsigurari casaAsig=itCasa.next();
	    	 casaAsigComboViewer.add(casaAsig.getNume());
	    	 if(numeCasaAsig.equals(casaAsig.getNume()))
	    		 casaAsigComboViewer.getCombo().select(index);
	    	 index++;
	     }
	}
	private void createListner(){
		SaveAction saveAction=new SaveAction();
		saveAction.setNumeCabinet(numeText);
		saveAction.setSaveCabinet(saveButton);
		saveAction.setMedicModel(medicModel);
		
		 
		 this.saveButton.addListener(SWT.Selection, saveAction);
	}
	private void addBlankLabels(Composite parent,int number){
		for(int i=0;i<number;i++){
			Label label=WidgetFactory.createLabel(parent, "");
			label.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		    label.setBackground(color);
		   // label.setText("#");
			
		    
		}
	}

	private void addWightBlankLabels(Composite parent,int number){
		for(int i=0;i<number;i++){
			Label label=WidgetFactory.createLabel(parent, "");
			label.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
			 //label.setText("#");
		    
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
