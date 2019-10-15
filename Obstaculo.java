
package Juego;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;

public class Obstaculo {
	int cont = 0;
	int tipo, resultado;
	Random rand = new Random();
	private Inicio juego;
	int inicio = 1, fin = 4;
	private static int carril = 1;
	int x = 1100, y = 0;
	Area obstaculo,cuerpo;
	String texto1, texto2;
	boolean pintar = true, pintaMoneda = false;
	private ImageIcon img, imgMoneda;
	private Image imagen, imagenMoneda;
	Sonidos sonido;
	URL ruta_choque,ruta_punto;
	AudioClip sonido_choque,sonido_punto;
	
	public Obstaculo(Inicio juego, int y, int tipo, int resultado, Sonidos sonido) {
		
		this.juego = juego;
		this.y = y;
		this.tipo = tipo;
		texto1 = String.valueOf(tipo);
		this.resultado = resultado;
		
		img = new ImageIcon(getClass().getResource("/Imagen/Obstáculo.gif"));
		imagen = img.getImage();
		
		imgMoneda = new ImageIcon(getClass().getResource("/Imagen/Moneda.gif"));
		imagenMoneda = imgMoneda.getImage();
		
		
		texto2 = String.valueOf(resultado);
		ruta_choque = getClass().getResource("/Sonido/choque.wav");
        sonido_choque = Applet.newAudioClip(ruta_choque);
        ruta_punto = getClass().getResource("/Sonido/punto.wav");
        sonido_punto = Applet.newAudioClip(ruta_punto);
	}
	
	public void cambiaResultado() {
		this.texto2 = String.valueOf(resultado);
	}
	
	public Obstaculo(int resultado) {
		this.resultado = resultado;
	}
	
	public void mover() {
		
		if(x<300 && x>100)
		{
			if(juego.getResultado()==this.resultado)
			{
				pintar = false;
				pintaMoneda = true;
			}
		}
		
		if(x<0) {
			//carril=(int)((Math.random()*4)+1);
			x = 1200;
			pintar = true;
			pintaMoneda = false;
		}
		if(colision()) 
		{
			
			pintar = false;
			pintaMoneda = false;
			if(cont==0)
			{System.out.println("Chocaste ...");
			
			if(juego.getResultado()!=this.resultado)
				{
				
				juego.jugador.vida-=1;
				sonido_choque.play();
				System.out.println("Respuesta incorrecta ...");
				}
			if(juego.getResultado()==this.resultado) 
				{juego.puntos++;
				sonido_punto.play();
				}
			else juego.puntos = juego.puntos;
				cont=1;
			if(colision())
				cont = 1;
			
			}
		}
		if(!colision()) cont = 0;
		x-=4;
		
	//	System.out.println(cont);
		
	}
	
	
	public void paint(Graphics g) {
		g.setColor(Color.blue);
		
		if(pintaMoneda) g.drawImage(imagenMoneda,x,y,60,60,null);
		if(pintar) g.drawImage(imagen,x,y,60,60,null);
		
		g.setColor(Color.cyan);
		g.fillRect(0, y, 60, 60);
		g.setColor(Color.black);
		g.setFont(new Font("Consolas",Font.PLAIN,50));
	//	g.drawString(texto1, x, y+58);
		g.drawString(texto2, 0,y+58);
		
	}
	
	public boolean colision() {
		Area areaA = new Area(juego.jugador.getBounds());
		areaA.intersect(getBounds());
		return !areaA.isEmpty();
	}
	
	
	public Area getBounds() {
		Rectangle figura = new Rectangle(x,y,60,60);
		cuerpo = new Area(figura);
		obstaculo = cuerpo;
		obstaculo.add(cuerpo);
		return obstaculo;
	}
	
} 
