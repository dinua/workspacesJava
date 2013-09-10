package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel1 extends JPanel{
 
	
	private BufferedImage img;
	
	public Panel1(){
		this.setBackground(Color.red);
	
	}
	
	public void paint(Graphics g) {
        //g.drawImage(img, 0, 0, null); 
		int w=this.getWidth();
		int h=this.getHeight();
        g.drawImage(getImg(),0,0, w, h,Color.white,null);
		//System.out.println(this.getWidth());
    }

	/**
	 * @return the img
	 */
	public BufferedImage getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(BufferedImage img) {
		this.img = img;
	}
}
