package loto.ui;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{

	private final static int height=600;
	private final static int width=800;
	private JPanel menuPanel;
	private JPanel dataPanel;
	
	  // Constructor:
	  public MainFrame() {
		setTitle("LOTO");
		setSize(width,height); 
        setLocationRelativeTo(null);
        FlowLayout data=new FlowLayout(FlowLayout.LEFT);
        setLayout(data);
        int errH=50;
        int errW=20;
        
        menuPanel=new MenuPanel();
        menuPanel.setPreferredSize(new Dimension(width/4-errW,height-errH));
        add(menuPanel);
        
        dataPanel=new DisplayPanel();
       dataPanel.setPreferredSize(new Dimension((3*width)/4-errW, height-errH));
        add(dataPanel);
        
		// Window Listeners
		addWindowListener(new WindowAdapter() {
		  	public void windowClosing(WindowEvent e) {
			   System.exit(0);
		  	} //windowClosing
		} );
	  setVisible(true);
	  } 
	} //class EmptyFrame1
	
