package com.medweb.ui.medic;

import java.util.Iterator;

import medweb.psconf.daos.CasaAsigurari;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.medweb.ui.help.ImageID;
import com.medweb.ui.help.WidgetFactory;

public class CasaAsigurariView extends ViewPart {
	public static final String ID = "com.medweb.ui.medic.casaAsigurariView";
	private Color color=new Color(Display.getCurrent(),253,245,204 );
	 private Text numeText;
	 private Text adresaText;
	 private Text codFiscalText;
	 private Text contBancaText;
	 private Text telefonText;
	 private Text emailText;
	 private ComboViewer casaAsigComboViewer;
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
		createCasaAsigInfo(composite);
		
		
		Composite rightComposite=new Composite(parent, SWT.None);
		rightComposite.setLayout(new GridLayout(1,true));
		rightComposite.setLayoutData(data);
		rightComposite.setBackgroundImage(img);
		
		createBindings();
		createListner();
	}
	
	private void createCasaAsigInfo(Composite composite){
		addBlankLabels(composite, 24);
		
		Group header=new Group(composite, SWT.NONE);
		header.setLayout(new GridLayout(3,true));
		header.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,8,1));
		header.setText("Casa de asigurari");
		header.setBackground(color);
		
		Label casaAsigLabel=WidgetFactory.createLabel(header, "casaAsigLabel","Casa asigurari:");
		 casaAsigLabel.setLayoutData(new GridData(SWT.LEFT,SWT.FILL,true,false,1,1));
       casaAsigLabel.setBackground(color);
		 casaAsigComboViewer = WidgetFactory.createComboViewer(header, "casaAsigComboViewer", false);
		 addBlankLabels(header, 4);
		
		
		//////////////////////////////////////////////////////////////////
		
		Label numeLabel=WidgetFactory.createLabel(composite, "numeLabel", "Nume");
		numeLabel.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		numeLabel.setBackground(color);
		
		numeText = WidgetFactory.createText(composite, "numeText", 100, false);
		numeText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		numeText.setEditable(false);
		
		addBlankLabels(composite, 1);
		/////////////////////////////////////////////////////////////////////////
		Label codFiscalLabel=WidgetFactory.createLabel(composite, "codFiscalLabel", "Cod fiscal");
		codFiscalLabel.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		codFiscalLabel.setBackground(color);

		codFiscalText = WidgetFactory.createText(composite, "codFiscalText", 100, false);
		codFiscalText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		
		addBlankLabels(composite, 1);
		/////////////////////////////////////////////////////////////////////////	
		Label adresaLabel=WidgetFactory.createLabel(composite, "adresaLabel", "Adresa");
		adresaLabel.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		adresaLabel.setBackground(color);
		
		adresaText = WidgetFactory.createText(composite, "adresaText", 100, false);
		adresaText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,4,1));
		adresaText.setEditable(false);
		
		addBlankLabels(composite, 11);
		/////////////////////////////////////////////////////////////////////////	
		Label contBancaLabel=WidgetFactory.createLabel(composite, "contBancaLabel", "Cont bancar");
		contBancaLabel.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,2,1));
		contBancaLabel.setBackground(color);

		contBancaText = WidgetFactory.createText(composite, "contBancaText", 100, false);
		contBancaText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,4,1));
		contBancaText.setEditable(false);
		addBlankLabels(composite, 2);
		/////////////////////////////////////////////////////////////////////////	
		Label telefonLabel=WidgetFactory.createLabel(composite, "contBancaLabel", "Telefon");
		telefonLabel.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,2,1));
		telefonLabel.setBackground(color);

		telefonText = WidgetFactory.createText(composite, "telefonText", 100, false);
		telefonText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		telefonText.setEditable(false);
		addBlankLabels(composite, 4);
		/////////////////////////////////////////////////////////////////////////	
		Label emailLabel=WidgetFactory.createLabel(composite, "emailLabel", "Email");
		emailLabel.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,2,1));
		emailLabel.setBackground(color);

		emailText = WidgetFactory.createText(composite, "emailText", 100, false);
		emailText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		emailText.setEditable(false);
		addBlankLabels(composite, 4);
		
	}
	private void createBindings() {
         
		CasaAsigurari casaAsigurari=this.medicModel.getMedicPrimar().getCasaAsigurari();
		
		 int index=0;
	     Iterator<CasaAsigurari> itCasa= this.getMedicModel().getAllCasaAsigurari().iterator();
	     String numeCasaAsig=casaAsigurari.getNume();
	     while(itCasa.hasNext()){
	    	 CasaAsigurari casaAsig=itCasa.next();
	    	 casaAsigComboViewer.add(casaAsig.getNume());
	    	 if(numeCasaAsig.equals(casaAsig.getNume()))
	    		 casaAsigComboViewer.getCombo().select(index);
	    	 index++;
	     }
	
	   numeText.setText(casaAsigurari.getNume());
	   codFiscalText.setText(casaAsigurari.getCodFiscal());
	   adresaText.setText(casaAsigurari.getAdresa());
	   contBancaText.setText(casaAsigurari.getContBancar());
	   telefonText.setText(casaAsigurari.getTelefon());
	   emailText.setText(casaAsigurari.getEmail());
	}
	private void createListner(){
		
		ComboSelectionListener action=new ComboSelectionListener();
		action.setModel(medicModel);
		action.setNumeText(numeText);
		action.setAdresaText(adresaText);
		action.setCodFiscalText(codFiscalText);
		action.setContBancaText(contBancaText);
		action.setTelefonText(telefonText);
		action.setEmailText(emailText);
		
		casaAsigComboViewer.addSelectionChangedListener(action);
	}
	private void addBlankLabels(Composite parent,int number){
		for(int i=0;i<number;i++){
			Label label=WidgetFactory.createLabel(parent, "");
			label.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		    label.setBackground(color);
		   //label.setText("#");
			
		    
		}
	}

	private void addWightBlankLabels(Composite parent,int number){
		for(int i=0;i<number;i++){
			Label label=WidgetFactory.createLabel(parent, "");
			label.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
			// label.setText("#");
		    
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
