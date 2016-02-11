

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class ImageButton extends JButton{
		private String imdbID;
		private String posterLink; 
		private static final int IMAGE_WIDTH = 130;
		private static final int IMAGE_HEIGHT = 175;
		BufferedImage img = null;
		
		public ImageButton(String id, String posterLink){// tt0050083
			this.imdbID = id;
			this.posterLink = posterLink;
			loadImage();
		}
		
		public void loadImage(){
			try {
				img = ImageIO.read(new File("images/" + posterLink));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(img, 0 ,0, super.getWidth(), super.getHeight(), null);
		}
		
		public String getImdbID() {
			return imdbID;
		}
		
		public void setId(String imdbID) {
			this.imdbID = imdbID;
		}
		
	}