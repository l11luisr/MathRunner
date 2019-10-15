package Juego;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Corona extends JPanel {
	
	private int x = 0;
	private int y;
	Image img,img2;
	ImageIcon icon,icon2;
	
	public Corona() {
		icon = new ImageIcon(getClass().getResource("/Imagen/Corona.gif"));
		img = icon.getImage();
		icon2 = new ImageIcon(getClass().getResource("/Imagen/marcoGanador.jpg"));
		img2 = icon2.getImage();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d=(Graphics2D)g;
		g2d.drawImage(img, 425, 65, 100, 100, this);
		g2d.drawImage(img2, 550, 7, 250, 100, this);
	}
	
}