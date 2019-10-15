package Juego;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Instruccion extends JPanel{
	
	private int x = 0;
	private int y;
	Image img;
	ImageIcon icon;
	
	public Instruccion(){
		icon = new ImageIcon(getClass().getResource("/Imagen/Instrucciones.png"));
		img=icon.getImage();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d=(Graphics2D)g;
		g2d.drawImage(img, 0, 0,1366,768, this);
	}
}
