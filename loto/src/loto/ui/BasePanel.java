package loto.ui;


	import javax.swing.*;

import java.awt.Color;
	import java.awt.Graphics;
	@SuppressWarnings("serial")
	public class BasePanel extends JPanel{

	    public BasePanel(){
	        this(Color.BLACK,3);    
	    }

	    public BasePanel(Color color,int size){
	        this.setBorder(BorderFactory.createLineBorder(color, size));
	        this.setBackground(Color.WHITE);
	    }

	    public void paintComponent(Graphics g){
	        super.paintComponent(g);
	    
	    }
	
}
