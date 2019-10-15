package Juego;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel {
	
	private int x = 0;
	private int y;
	Image img;
	ImageIcon icon;
	
	public Fondo() {
		icon = new ImageIcon(getClass().getResource("/Imagen/Fondo.png"));
		img = icon.getImage();
	}
	
	public void mover() {
		x--;
		if(x==-1196) x=0;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(img, x, 0, 3596, 600, this);
	}
		
}
