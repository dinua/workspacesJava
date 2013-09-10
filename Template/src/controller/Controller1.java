package controller;

import java.awt.image.BufferedImage;
import java.io.File;

import model.Model;
import view.MainFrame;

public class Controller1 {

	private Model model;
	private MainFrame frame;
	public Controller1(Model m, MainFrame frame) {
		// TODO Auto-generated constructor stub
		this.model=m;
		this.frame=frame;
		
		
		frame.getPanel2().getJb1().addMouseListener(new ActionButton(this));
		frame.getPanel2().getJb2().addMouseListener(new ActionButton(this));
		
		
		File f=new File("C:/Users/adi/Downloads/clau/QSlideshow/resources/back.png");
		BufferedImage bi=model.getImageFile(f);
		
		frame.getPanel1().setImg(bi);
		frame.getPanel1().repaint();
	}

	public void setAction4But1(){
		System.out.println("action1");
		//get image from model for action 1 
		//set image in panel1
		frame.getPanel1().removeAll();
		BufferedImage i=frame.getPanel1().getImg();
		
		
		
		File f=new File("C:/Users/adi/Downloads/clau/QSlideshow/resources/delete.png");
		i=model.getImageFile(f);
		
		frame.getPanel1().setImg(i);
		frame.getPanel1().repaint();
		
	}
	public void setAction4But2(){
		System.out.println("action2");
		//get image from model for action 2 
		//set image in panel1
		
		File f=new File("C:/Users/adi/Downloads/clau/QSlideshow/resources/next.png");
		BufferedImage bi=model.getImageFile(f);
		
		frame.getPanel1().setImg(bi);
		frame.getPanel1().repaint();
	}
}
