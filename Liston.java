package Juego;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Liston extends JPanel {
	
	private int x = 0;
	private int y;
	Image img;
	ImageIcon icon;
	
	public Liston(){
		icon = new ImageIcon(getClass().getResource("/Imagen/Liston.png"));
		//icon = new ImageIcon(getClass().getResource("/Imagen/Marcador.png"));
		img = icon.getImage();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d=(Graphics2D)g;
		g2d.drawImage(img, -40, -70, 400, 400, this);
	}
	
}
