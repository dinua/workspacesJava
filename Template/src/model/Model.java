package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Model {

	
	public BufferedImage getImageFile(File f){
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(f);
		} catch (IOException e) {
		}
		
		return img;
	}

	
}
