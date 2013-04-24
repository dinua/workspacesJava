package com.medweb.ui.retete;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.Adeverinta;
import medweb.psconf.daos.CabinetMedical;
import medweb.psconf.daos.Fisa;
import medweb.psconf.daos.Pacient;
import medweb.psconf.daos.PacientInfo;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.medweb.ui.help.ImageID;
import com.medweb.ui.help.WidgetFactory;

@SuppressWarnings("serial")
public class AdeverintaDialogView extends Dialog {
    
	final private RetetaModel retetaModel;
	private int wightDialog=550;
	private int heightDialog=1200;
	
	
	private Text ocupatiePacient;
	private Text suferindV1Text;
	private Text recomndareV1Text;
	private Text eliberatPtV1Test;
	
	
	private Label judetCabinetLabel;
	private Label localtateCabinetLabel;
	private Label numeCabinetLabel;
	private Label nrFisaLabel;
	
	private Label numePacinet;
	private Label sexPacient;
	private Label anPacient;
	private Label lunaPacient;
	private Label ziuaPacient;
	private Label judPacient;
	private Label locPacient;
	private Label strPacient;
	private Label dataEliberarii;
	
	
	private Text concluziiText;
	private Text radiologieText;
	private Text serologiatext;
	private Text recomandariV2Text;
	private Text aptText;
	private Button saveButton;
	private Label numarStadaLabel;
	private Adeverinta adeverinta;
	
	public AdeverintaDialogView(final Shell parentShell,final RetetaModel model) {
	    super(parentShell);
	    this.retetaModel=model;
		  
	}
	public AdeverintaDialogView(final Shell parentShell,final RetetaModel model,Adeverinta adeverinta) {
	    super(parentShell);
	    this.retetaModel=model;
	    this.adeverinta=adeverinta;
		//openAdeverinta(adeverinta);  
	}
	@Override
	protected Control createDialogArea(final Composite parent) {
	    final Composite container = (Composite) super.createDialogArea(parent);
	    container.setLayout(new GridLayout(1, true));
	    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    parent.setLayout(new GridLayout(1,true));
		
	    
	    Composite composite=new Composite(parent,SWT.FILL | SWT.V_SCROLL);
		composite.setLayout(new GridLayout(12,true));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
	    
	   saveButton=WidgetFactory.createButton(composite, "saveButton", "Save", false,ImageID.IMAGE_SAVE);
	   saveButton.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false,1,1));
	   
	   addBlankLabels(composite, 10);
	   
	    GridData dataDialog=new GridData(SWT.FILL, SWT.FILL, true, false,6,1);
		dataDialog.widthHint=(wightDialog-50)/2;
		
		    GridData dataDialog2=new GridData(SWT.FILL, SWT.FILL, true, false,6,1);
			dataDialog2.widthHint=(wightDialog-50)/2;
		
			Group view1Group=new Group(composite,SWT.TOP);
			view1Group.setLayout(new GridLayout(8,true));
			view1Group.setLayoutData(dataDialog);
			createView1Composte(view1Group);
		    
		
			
			Group view2Group=new Group(composite,SWT.TOP);
			view2Group.setLayout(new GridLayout(8,true));
			view2Group.setLayoutData(dataDialog2);
			createView2Composite(view2Group);
		 
		
		createListeners();
		createBindings();
		if(adeverinta!=null)
			openAdeverinta(adeverinta);
	    return container;
	}
	private void createView1Composte(Group parent){
		
		Display display=PlatformUI.getWorkbench().getDisplay();
         Font font1=new Font(display,"Arial",14,SWT.BOLD);
         Font font2=new Font(display, "Arial", 13, SWT.ITALIC | SWT.BOLD);
         Font font3=new Font(display, "Arial", 9, SWT.NORMAL);
		
		//////////////////zeil 1//////////////////////////////
		Label label1=WidgetFactory.createLabel(parent, "label1",RetetaMessages.EDIT_JUDETUL.getMessage());
		label1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,1,1));
		
		judetCabinetLabel=WidgetFactory.createLabel(parent, "judetCabinetLabel","");
		judetCabinetLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		judetCabinetLabel.setFont(font2);
		
		addBlankLabels(parent, 2);
		
		Label label2=WidgetFactory.createLabel(parent, "label2",RetetaMessages.EDIT_NUMAR_FISA_MEDICALA.getMessage());
		label2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,3,1));
		///////////////zeil 2///////////////////////////////////////////
		Label label3=WidgetFactory.createLabel(parent, "label3",RetetaMessages.EDIT_LOCALITATEA.getMessage());
		label3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,1,1));
		
		localtateCabinetLabel=WidgetFactory.createLabel(parent, "localtateCabinetLabel","");
		localtateCabinetLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		localtateCabinetLabel.setFont(font2);
		
		addBlankLabels(parent, 2);
		
		nrFisaLabel=WidgetFactory.createLabel(parent, "nrFisaLabel", "");
		nrFisaLabel.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, true, false,3,1));
		nrFisaLabel.setFont(font2);
		//////////////////zeil 3///////////////////////////////
		
		Label label4=WidgetFactory.createLabel(parent, "label4",RetetaMessages.EDIT_NUME_CABINET.getMessage());
		label4.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		
		
		numeCabinetLabel=WidgetFactory.createLabel(parent, "numeCabinetLabel","");
		numeCabinetLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		numeCabinetLabel.setFont(font2);
		addBlankLabels(parent, 4);
		
		///////////////////zeil4///////////////////////////////////////
		
		addBlankLabels(parent, 2);
		Label label5=WidgetFactory.createLabel(parent, "label5",RetetaMessages.EDIT_ADEVERINTA.getMessage());
		label5.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, true, false,4,1));
		label5.setFont(font1);
		addBlankLabels(parent, 2);
		
		/////////////////////zeil 5/////////////////////////////////////
		
		Label label6=WidgetFactory.createLabel(parent, "label6",RetetaMessages.EDIT_INFO1.getMessage());
		label6.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		
		numePacinet=WidgetFactory.createLabel(parent, "numePacinet", "");
		numePacinet.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,4,1));
		numePacinet.setFont(font2);
		
		Label label7=WidgetFactory.createLabel(parent, "label7",RetetaMessages.EDIT_INFO2.getMessage());
		label7.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, false,1,1));
		
		sexPacient=WidgetFactory.createLabel(parent, "sexPacient", "X");
		sexPacient.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false,1,1));
		sexPacient.setFont(font2);
			
		///////////////////////zeil6///////////////////////////////////
		addBlankLabels(parent, 2);	
		Label label8=WidgetFactory.createLabel(parent, "label8",RetetaMessages.EDIT_INFO3.getMessage());
		label8.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, true, false,4,1));
		label8.setFont(font3);
		addBlankLabels(parent, 2);
		
		//////////////////////zeil7//////////////////////////////////////
		
		Label label9=WidgetFactory.createLabel(parent, "label9",RetetaMessages.EDIT_INFO4.getMessage());
		label9.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		
		anPacient=WidgetFactory.createLabel(parent, "anPacient", "");
		anPacient.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false,1,1));
		anPacient.setFont(font2);
		
		Label label10=WidgetFactory.createLabel(parent, "label10",RetetaMessages.EDIT_INFO5.getMessage());
		label10.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,1,1));
		
		lunaPacient=WidgetFactory.createLabel(parent, "anPacient", "");
		lunaPacient.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false,2,1));
		lunaPacient.setFont(font2);
		
		Label label11=WidgetFactory.createLabel(parent, "label11",RetetaMessages.EDIT_INFO6.getMessage());
		label11.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,1,1));
		
		ziuaPacient=WidgetFactory.createLabel(parent, "ziuaPacient", "");
		ziuaPacient.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false,1,1));
		ziuaPacient.setFont(font2);
		
		//////////////////////////zeil8////////////////////////////////////////////
		
		Label label12=WidgetFactory.createLabel(parent, "label12",RetetaMessages.EDIT_INFO7.getMessage());
		label12.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		
		judPacient=WidgetFactory.createLabel(parent, "judPacient", "");
		judPacient.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false,1,1));
		judPacient.setFont(font2);
		
		Label label13=WidgetFactory.createLabel(parent, "label13",RetetaMessages.EDIT_INFO8.getMessage());
		label13.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, false,1,1));
		
		locPacient=WidgetFactory.createLabel(parent, "judPacient", "");
		locPacient.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,1,1));
		locPacient.setFont(font2);
		
		Label label14=WidgetFactory.createLabel(parent, "label14",RetetaMessages.EDIT_INFO9.getMessage());
		label14.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, false,1,1));
		
		strPacient=WidgetFactory.createLabel(parent, "strPacient", "");
		strPacient.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false,1,1));
		strPacient.setFont(font2);
		
		numarStadaLabel = WidgetFactory.createLabel(parent, "label15",RetetaMessages.EDIT_INFO10.getMessage());
		numarStadaLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,1,1));
		
		/////////////zeil 9/////////////////////////////////////////
		Label label16=WidgetFactory.createLabel(parent, "label16",RetetaMessages.EDIT_INFO11.getMessage());
		label16.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		
		ocupatiePacient=WidgetFactory.createText(parent, "ocupatiePacient", 100, false);
		ocupatiePacient.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,5,1));
		addBlankLabels(parent, 1);
		
		//////////////zeil10////////////////////////////////////
		Label label17=WidgetFactory.createLabel(parent, "label17",RetetaMessages.EDIT_INFO21.getMessage());
		label17.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		
		suferindV1Text=WidgetFactory.createText(parent, "suferindV1Text", 100, false);
		suferindV1Text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,5,1));
		addBlankLabels(parent, 1);
		//////////////zeil11////////////////////////////////////
		Label label18=WidgetFactory.createLabel(parent, "label18",RetetaMessages.EDIT_INFO12.getMessage());
		label18.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
	
		recomndareV1Text=WidgetFactory.createText(parent, "recomndareV1Text", 100, false);
		recomndareV1Text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,5,1));
		addBlankLabels(parent, 1);
		//////////////zeil12////////////////////////////////////
		Label label19=WidgetFactory.createLabel(parent, "label19",RetetaMessages.EDIT_INFO13.getMessage());
		label19.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,4,1));

		eliberatPtV1Test=WidgetFactory.createText(parent, "eliberatPtV1Test", 100, false);
		eliberatPtV1Test.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,3,1));
		addBlankLabels(parent, 1);
		
		////////////////zeil13///////////////////////////////////////////////////
		//addBlankLabels(parent, 1);
		Label label20=WidgetFactory.createLabel(parent, "label20",RetetaMessages.EDIT_INFO14.getMessage());
		label20.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
		
		dataEliberarii=WidgetFactory.createLabel(parent, "dataEliberarii", "XXXX:XX:XX");
		dataEliberarii.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false,2,1));
		dataEliberarii.setFont(font2);
		
		addBlankLabels(parent, 12);
	}

	private void createView2Composite(Group parent){
		
		////////////////////////////zeil1//////////////////////////////////
		Label label1=WidgetFactory.createLabel(parent, "label1", RetetaMessages.EDIT_INFO15.getMessage());
		label1.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false,8,1));
	      
		concluziiText=WidgetFactory.createTextArea(parent, "concluziiText", 1000, false);
		GridData data= new GridData(SWT.LEFT, SWT.FILL, false, false,8,1);
	    data.heightHint=60;
	     data.widthHint=550;
		concluziiText.setLayoutData(data);
		/////////////////////////////zeil2///////////////////////////////////
		Label label2=WidgetFactory.createLabel(parent, "label2", RetetaMessages.EDIT_INFO16.getMessage());
		label2.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false,8,1));
		/////////////////////////////zeil3///////////////////////////////////
		Label label3=WidgetFactory.createLabel(parent, "label3", RetetaMessages.EDIT_INFO17.getMessage());
		label3.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false,1,1));

	    radiologieText=WidgetFactory.createText(parent, "radiologieText", 100, false);
	    radiologieText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,3,1));
	    addBlankLabels(parent, 4);
	    /////////////////////////////zeil4///////////////////////////////////
	    Label label4=WidgetFactory.createLabel(parent, "label4", RetetaMessages.EDIT_INFO18.getMessage());
	    label4.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false,1,1));

	    serologiatext=WidgetFactory.createText(parent, "serologiatext", 100, false);
	    serologiatext.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false,3,1));
	    addBlankLabels(parent, 2);
	    ////////////////////////////zeil5//////////////////////////////////
	    Label label5=WidgetFactory.createLabel(parent, "label5", RetetaMessages.EDIT_INFO19.getMessage());
	    label5.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false,8,1));

	    recomandariV2Text=WidgetFactory.createTextArea(parent, "recomandariV2Text", 1000, false);
	    recomandariV2Text.setLayoutData(data);
	    
	    ////////////////////////////zeil6//////////////////////////////////
	    Label label6=WidgetFactory.createLabel(parent, "label6", RetetaMessages.EDIT_INFO20.getMessage());
	    label6.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false,8,1));

	    aptText=WidgetFactory.createTextArea(parent, "aptText", 100, false);
	    GridData dataApt= new GridData(SWT.LEFT, SWT.FILL, false, false,8,1);
	    dataApt.heightHint=50;
	    dataApt.widthHint=550;
	    aptText.setLayoutData(dataApt);
	    
	   
	}
	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(final Composite parent) {
	    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.get().OK_LABEL, true);
	}
	
	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
	    return new Point(heightDialog,wightDialog);
	}
	private void createBindings(){
		Pacient pacient=retetaModel.getPatientModel().getPacient();
		String nume=pacient.getNume()+"  "+pacient.getPrenume(); 
		numePacinet.setText(nume);
		
		PacientInfo infop=retetaModel.getPatientModel().getPacientInfo();
		sexPacient.setText(infop.getSex());
		String[] vec=infop.getAdresa().split("%");
		judPacient.setText(vec[0]);
		locPacient.setText(vec[1]);
		strPacient.setText(vec[2]);
		numarStadaLabel.setText("XNr."+vec[3]);
		
		String[]data={" "," "," "};
		if(infop.getDataNastere()!=null){
			data=infop.getDataNastere().split("-");
		}
		
		anPacient.setText(data[0]);
		lunaPacient.setText(data[1]);
		ziuaPacient.setText(data[2]);
			
		CabinetMedical cabinet=retetaModel.getMedicModel().getMedicPrimar().getCabinetMedical();
		
		String[] v=cabinet.getAdresa().split("%");
		judetCabinetLabel.setText(v[0]);
		localtateCabinetLabel.setText(v[1]);
		numeCabinetLabel.setText(cabinet.getNume());
		
		int idPacient=retetaModel.getPatientModel().getPacient().getIdPacient();
		int idMedic=retetaModel.getMedicModel().getMedicPrimar().getIdMedicPrimar();
		Fisa fisa = null;
		try {
			fisa = retetaModel.getBusinessService().getFisaPacinet(idPacient,idMedic);
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		retetaModel.setFisa(fisa);
		
		nrFisaLabel.setText(""+fisa.getIdFisa());
		
		 DateFormat dateFormat = new SimpleDateFormat("yyyy\\MM\\dd");
	     Date date = new Date();
	     dataEliberarii.setText(dateFormat.format(date));
		
	}
	private void createListeners(){
		AdeverintaAction action=new AdeverintaAction();
		action.setSaveButton(saveButton);
		action.setModel(retetaModel);
		action.setOcupatiePacient(ocupatiePacient);
		action.setSuferindV1Text(suferindV1Text);
		action.setRecomndareV1Text(recomndareV1Text);
		action.setEliberatPtV1Test(eliberatPtV1Test);
		action.setConcluziiText(concluziiText);
	    action.setRadiologieText(radiologieText);
	    action.setSerologiatext(serologiatext);
	    action.setRecomandariV2Text(recomandariV2Text);
	    action.setAptText(aptText);
	 
	    saveButton.addListener(SWT.Selection, action); 
	}
	public void openAdeverinta(Adeverinta adeverinta){
		ocupatiePacient.setText(adeverinta.getOcupatie());
		suferindV1Text.setText(adeverinta.getSuferind());
		recomndareV1Text.setText(adeverinta.getRecomandare1());
		eliberatPtV1Test.setText(adeverinta.getMotivEliberare());
		concluziiText.setText(adeverinta.getConcluzii());
		radiologieText.setText(adeverinta.getRadiologie());
		serologiatext.setText(adeverinta.getSerologie());
		recomandariV2Text.setText(adeverinta.getRecomandare2());
		aptText.setText(adeverinta.getApt());
		dataEliberarii.setText(adeverinta.getDataEliberarii());
		
		saveButton.setVisible(false);
		ocupatiePacient.setEditable(false);
		suferindV1Text.setEditable(false);
		recomndareV1Text.setEditable(false);
		eliberatPtV1Test.setEditable(false);
		concluziiText.setEditable(false);
		radiologieText.setEditable(false);
		serologiatext.setEditable(false);
		recomandariV2Text.setEditable(false);
		aptText.setEditable(false);
	}
	 private void addBlankLabels(Composite parent,int number){
			for(int i=0;i<number;i++){
				Label label=WidgetFactory.createLabel(parent, "");
				label.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
			    //label.setText("#");
			}
		}

	/**
	 * @return the retetaModel
	 */
	public RetetaModel getRetetaModel() {
		return retetaModel;
	}

	
}
