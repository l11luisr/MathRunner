package Juego;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Resultado extends JPanel {
	
	String[] nombre = new String[5];
	String[] puntaje = new String[5];
  
	public Resultado(String[] nombreGanador, String[] puntajeString, int numGanador) {
	
		for(int i=0;i<5;i++)
		{
			nombre[i] = new String(nombreGanador[i]);
			puntaje[i] = new String(puntajeString[i]);
		}
		
	}
	
	public void paint(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 1200, 600);
		g.setColor(Color.white);
		
		for(int i=0;i<5;i++)
		{
			g.drawString(nombre[i], 300*i, 200);
			g.drawString(puntaje[i], 500*i, 200);
		}
		
	}
	
}
