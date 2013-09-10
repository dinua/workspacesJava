package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Model;

public class MainFrame extends JFrame{
	private Panel1 panel1;
	private Panel2 panel2;

	public MainFrame(String name,Model m){
		super(name);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(new Dimension(800,600));
	}
	
	public void showFrame(){
		
		panel1 = new Panel1();
		panel2 = new Panel2(new Dimension(100,100));
	
		this.add(panel1,BorderLayout.CENTER);
		this.add(panel2,BorderLayout.SOUTH);
		this.setVisible(true);
	}

	/**
	 * @return the panel1
	 */
	public Panel1 getPanel1() {
		return panel1;
	}

	/**
	 * @param panel1 the panel1 to set
	 */
	public void setPanel1(Panel1 panel1) {
		this.panel1 = panel1;
	}

	/**
	 * @return the panel2
	 */
	public Panel2 getPanel2() {
		return panel2;
	}

	/**
	 * @param panel2 the panel2 to set
	 */
	public void setPanel2(Panel2 panel2) {
		this.panel2 = panel2;
	}
	
}
