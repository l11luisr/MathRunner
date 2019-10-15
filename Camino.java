package Juego;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Camino extends JPanel{
	
	private int x = 0;
	private int y;
	Image img;
	ImageIcon icon;
	
	public Camino() {
		icon = new ImageIcon(getClass().getResource("/Imagen/Camino.png"));
		img = icon.getImage();
	}
	
	public void mover() {
		x--;
		if(x==-2700) x=0;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d=(Graphics2D)g;
		g2d.drawImage(img, x, 476, 4075, 62, this);
		g2d.drawImage(img, x, 538, 4075, 62, this);
		g2d.drawImage(img, x, 600, 4075, 62, this);
		g2d.drawImage(img, x, 662, 4075, 62, this);
		
		
	}
	
}
