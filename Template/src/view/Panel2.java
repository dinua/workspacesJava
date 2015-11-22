package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel2 extends JPanel {

 private JButton jb1,jb2;	
	
	public Panel2(Dimension d){
		this.setBackground(Color.blue);
		this.setPreferredSize(d);
		
		jb1=new JButton();
		jb1.setText("but1");
		jb1.setName("1");
		
		jb2=new JButton();
		jb2.setText("but2");
		jb2.setName("2");
		
		this.add(jb1);
		this.add(jb2);
		
	}

	/**
	 * @return the jb1
	 */
	public JButton getJb1() {
		return jb1;
	}

	/**
	 * @param jb1 the jb1 to set
	 */
	public void setJb1(JButton jb1) {
		this.jb1 = jb1;
	}

	/**
	 * @return the jb2
	 */
	public JButton getJb2() {
		return jb2;
	}

	/**
	 * @param jb2 the jb2 to set
	 */
	public void setJb2(JButton jb2) {
		this.jb2 = jb2;
	}
	
}
