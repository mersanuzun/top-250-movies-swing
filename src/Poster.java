import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Poster extends JPanel{
	private String posterLink;
	private BufferedImage img = null;
	
	public void setPosterLink(String posterLink){
		this.posterLink = posterLink;
		loadImage();
		repaint();
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
}
