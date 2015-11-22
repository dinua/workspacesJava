package com.medweb.ui.medicamente;



import medweb.psconf.daos.MedicamentInfo;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.medweb.ui.help.WidgetFactory;


@SuppressWarnings("serial")
public class MedicamenteInfoDialog extends Dialog{
	
	
	private Label firmaLabel;
	private Label taraLabel;
	private Label formaAmbLabel;
	private Label prescriereLabel;
	private Label pret1Label;
	private Label pret2Label;
	private Label pret3Label;
	private Label pret4Label;
    private MedicamneteModel model;
	
    public MedicamenteInfoDialog(final Shell parentShell) {
	    super(parentShell);
		  
	}
	
	public MedicamenteInfoDialog(final Shell shell, MedicamneteModel model) {
		 super(shell);
		 this.model=model;
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
	    final Composite container = (Composite) super.createDialogArea(parent);
	    container.setLayout(new GridLayout(4, true));
	    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	     
	    Display display=PlatformUI.getWorkbench().getDisplay();
         Font font=new Font(display,"Arial",13,SWT.BOLD);
         
	    Label info1Label=WidgetFactory.createLabel(container, "info1Label",MedicamenteMessages.EDIT_INFO_FIRMA.getMessage());
	    info1Label.setLayoutData(new GridData(SWT.LEFT,SWT.FILL,true,false,1,1));
	    info1Label.setFont(font);
	    
	    firmaLabel = WidgetFactory.createLabel(container, "firmaLabel","");
	    firmaLabel.setLayoutData(new GridData(SWT.CENTER,SWT.FILL,true,false,2,1));
	    addBlankLabels(container, 1);
       /////////////////////////////////////////////////////////////////////////////// 
	    Label info2Label=WidgetFactory.createLabel(container, "info2Label",MedicamenteMessages.EDIT_INFO_TARA.getMessage());
	    info2Label.setLayoutData(new GridData(SWT.LEFT,SWT.FILL,true,false,1,1));
	    info2Label.setFont(font);
	    
	    taraLabel = WidgetFactory.createLabel(container, "taraLabel","XXxxxxxxxxxxxxxxxxxxx");
	    taraLabel.setLayoutData(new GridData(SWT.CENTER,SWT.FILL,true,false,2,1));
	    addBlankLabels(container, 1);
	    //////////////////////////////////////////////////////////////////////
	    Label info3Label=WidgetFactory.createLabel(container, "info3Label",MedicamenteMessages.EDIT_INFO_AMBALARE.getMessage());
	    info3Label.setLayoutData(new GridData(SWT.LEFT,SWT.FILL,true,false,1,1));
	    info3Label.setFont(font);
	    
	    formaAmbLabel = WidgetFactory.createLabel(container, "formaAmbLabel","XXxxxxxxxxxxxxxxxxxxx");
	    formaAmbLabel.setLayoutData(new GridData(SWT.CENTER,SWT.FILL,true,false,3,1));
	    //addBlankLabels(container, 1);
	   ////////////////////////////////////////////////////////////////////////////// 
	   
	    Label info4Label=WidgetFactory.createLabel(container, "info4Label",MedicamenteMessages.EDIT_INFO_PRESCRIERE.getMessage());
	    info4Label.setLayoutData(new GridData(SWT.LEFT,SWT.FILL,true,false,1,1));
	    info4Label.setFont(font);
	    
	    prescriereLabel = WidgetFactory.createLabel(container, "prescriereLabel","XXxxxxxxxxxxxxxxxxxxx");
	    prescriereLabel.setLayoutData(new GridData(SWT.CENTER,SWT.FILL,true,false,2,1));
	    addBlankLabels(container, 1);
	   ////////////////////////////////////////////////////////////////////////////// 
	    Label info5Label=WidgetFactory.createLabel(container, "info5Label",MedicamenteMessages.EDIT_INFO_PRET1.getMessage());
	    info5Label.setLayoutData(new GridData(SWT.LEFT,SWT.FILL,true,false,2,1));
	    info5Label.setFont(font);
	    
	    pret1Label = WidgetFactory.createLabel(container, "pret1Label","1111111");
	    pret1Label.setLayoutData(new GridData(SWT.CENTER,SWT.FILL,true,false,1,1));
	    addBlankLabels(container, 1);
	   ////////////////////////////////////////////////////////////////////////////// 
	    
	    Label info6Label=WidgetFactory.createLabel(container, "info6Label",MedicamenteMessages.EDIT_INFO_PRET2.getMessage());
	    info6Label.setLayoutData(new GridData(SWT.LEFT,SWT.FILL,true,false,2,1));
	    info6Label.setFont(font);
	    
	    pret2Label = WidgetFactory.createLabel(container, "pret2Label","1111111");
	    pret2Label.setLayoutData(new GridData(SWT.CENTER,SWT.FILL,true,false,1,1));
	    addBlankLabels(container, 1);
	   ////////////////////////////////////////////////////////////////////////////// 
	    
	    Label info7Label=WidgetFactory.createLabel(container, "info7Label",MedicamenteMessages.EDIT_INFO_PRET3A.getMessage());
	    info7Label.setLayoutData(new GridData(SWT.LEFT,SWT.FILL,true,false,4,1));
	    info7Label.setFont(font);
	    
	    Label info8Label=WidgetFactory.createLabel(container, "info8Label",MedicamenteMessages.EDIT_INFO_PRET3B.getMessage());
	    info8Label.setLayoutData(new GridData(SWT.LEFT,SWT.FILL,true,false,2,1));
	    info8Label.setFont(font);
	    
	    pret3Label = WidgetFactory.createLabel(container, "pret3Label","1111111");
	    pret3Label.setLayoutData(new GridData(SWT.CENTER,SWT.FILL,true,false,1,1));
	   	    
	    Label info9Label=WidgetFactory.createLabel(container, MedicamenteMessages.EDIT_INFO_PRET3C.getMessage());
	    info9Label.setLayoutData(new GridData(SWT.LEFT,SWT.FILL,true,false,4,1));
	    info9Label.setFont(font);
	    
	   ////////////////////////////////////////////////////////////////////////////// 
	    
	    Label info10Label=WidgetFactory.createLabel(container, "info10Label",MedicamenteMessages.EDIT_INFO_PRET4.getMessage());
	    info10Label.setLayoutData(new GridData(SWT.LEFT,SWT.FILL,true,false,2,1));
	    info10Label.setFont(font);
	  
	    pret4Label = WidgetFactory.createLabel(container, "pret4Label","1111111");
	    pret4Label.setLayoutData(new GridData(SWT.CENTER,SWT.FILL,true,false,1,1));
	   
	    createBindings();
	    
	    return container;
	}
	public void setValuesInfo(String firma,String tara,String formaAmbalare,String prescriere,
			String pret1,String pret2,String pret3,String pret4){
		this.firmaLabel.setText(firma);
		this.taraLabel.setText(tara);
		this.formaAmbLabel.setText(formaAmbalare);
		this.prescriereLabel.setText(prescriere);
		this.pret1Label.setText(pret1);
		this.pret2Label.setText(pret2);
		this.pret3Label.setText(pret3);
		this.pret4Label.setText(pret4);
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
	    return new Point(600, 400);
	}
	 private void createBindings(){
		    MedicamentInfo info=model.getMedicamentInfo();
		    
		    firmaLabel.setText(info.getFirma());
		    taraLabel.setText(info.getTara());
		    formaAmbLabel.setText(info.getFormaAmbalare());
		    prescriereLabel.setText(info.getPrescriere());
		    pret1Label.setText(""+info.getPretAmanuntulMax());
		    pret2Label.setText(""+info.getPretAmanuntulMaxUt());
		    pret3Label.setText(""+info.getValSuprotataCnas());
		    pret4Label.setText(""+info.getValSuprotataCnasAdulti());
	 }
	 private void addBlankLabels(Composite parent,int number){
			for(int i=0;i<number;i++){
				Label label=WidgetFactory.createLabel(parent, "");
				label.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
			   // label.setText("#");
			}
		}
}
