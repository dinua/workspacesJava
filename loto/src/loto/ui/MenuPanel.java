package loto.ui;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MenuPanel extends BasePanel{

	public MenuPanel(){
		super();
		this.setLayout(new GridLayout(5, 1,50,20));
		addButton("adsdasdsad", null);
		addButton("adsdasdsad", null);
		addButton("adsdasdsad", null);
	}
	
	private void addButton(String name,ActionListener listener){
		JButton button =new JButton();
		button.setText(name);
        button.addActionListener(listener);
        add(button);
	}
}
