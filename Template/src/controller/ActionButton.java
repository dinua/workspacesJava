package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionButton implements MouseListener {

	Controller1 controller;
	public ActionButton(Controller1 controller1) {
		// TODO Auto-generated constructor stub
		this.controller=controller1;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouse event "+e.getComponent().getName());
		if(e.getComponent().getName().equals("1"))
			controller.setAction4But1();
		//.....
		else
			controller.setAction4But2();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
