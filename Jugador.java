package Juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;

import javax.swing.ImageIcon;

public class Jugador {
	
	private int x = 100;
	private int y = 662;
	private int ancho;
	private int alto;
	public int vida = 3;
	private int dx;
	private int dy;
	private String nombre;
	Inicio inicio;
	int resultado;
	ImageIcon img;
	Image imagen;
	Area cuerpo, player;
	boolean izquierda, derecha, arriba, abajo, enter;
	Sonidos sonido = new Sonidos();
	// int aleatorio;
	
	public Jugador(Inicio inicio,int resultado) {
	this.inicio = inicio;
	this.alto = 50;
	this.ancho = 50;
	img = new ImageIcon(getClass().getResource("/Imagen/Mario.gif"));
	imagen = img.getImage();
	
	this.resultado = resultado;
	}
	
	public void mover() {
		if(x<=100) x = 101;
		else if(x>=1200)
			x = 1198;
		else x+=dx;
		if(y>=662) y = 661;
		else if(y<=476) y = 477;
		else y+=dy;
		
	}
	
	public int getAncho() {
		return ancho;
	}
	public int getAlto() {
		return alto;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getVida() {
		return vida;
	}
	
	public void keyReleased(KeyEvent e) {
	/*	if(e.getKeyCode()==KeyEvent.VK_LEFT)//izquierda
		{
			if(izquierda)
			x+=-62;
			izquierda=false;
		
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)//derecha
		{
			if(derecha)
				x+=62;
			derecha=false;
		
		}*/
		if(e.getKeyCode()==KeyEvent.VK_ENTER)//arriba
		{
			if(enter) {
				if(!inicio.estadoLogica)
				{
					//sonido.sonido_jugando[inicio.aleatorio].stop();
					sonido.sonido_inicio.play();
					inicio.aleatorio = (int) (Math.random()*4);
					sonido.sonido_jugando[inicio.aleatorio].play();
					for(int i=0;i<5;i++)
					 {
						inicio.nombreGanador[i]=null;
						 inicio.puntajeString[i]=null;
						 inicio.numGanador=0;
						 inicio.puntaje[i]=0;
					 }
				}
				inicio.estadoLogica = true;
				inicio.estadoRepaint = true;
				for(int i=0;i<5;i++)
					
				enter = false;
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) //arriba
		{
			if(arriba)
				y+=-62;
			    arriba = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) //abajo
		{
	        if(abajo)
	        	y+=62;
	            abajo = false;
	        
		}
	}
	
	public void KeyPressed(KeyEvent e) {
	/*	if(e.getKeyCode()==KeyEvent.VK_LEFT) //izquierda
		{
			izquierda=true;
		
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) //derecha
		{
			derecha=true;
		
		}*/
		if(e.getKeyCode()==KeyEvent.VK_ENTER)//arriba
		{
			enter=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP)//arriba
		{
			arriba=true;
		
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN)//abajo
		{
	        abajo=true;
	       
	 
		}
		
}
	
	public void paint(Graphics g) {
		/*g.setColor(Color.black);
		g.fillRect(x,y,alto, ancho);
		*/
		Graphics2D g2d = (Graphics2D)g;
	
			g2d.drawImage(imagen, x, y, ancho, alto,null);
		
		g.setColor(Color.red);
		if(vida==3)
		{
			g.drawImage(imagen, 0, 0, 50, 50, null);
			g.drawImage(imagen, 50, 0, 50, 50, null);
			g.drawImage(imagen, 100, 0, 50, 50, null);
		}
		if(vida==2)
		{
		
			g.drawImage(imagen, 0, 0, 50, 50, null);
			g.drawImage(imagen, 50, 0, 50, 50, null);
		}
		if(vida==1)
		{
		
			g.drawImage(imagen, 0, 0, 50, 50, null);
			
		}
	}
	
	public Area getBounds() {
		Rectangle figura = new Rectangle(x,y,50,50);
		cuerpo = new Area(figura);
		player = cuerpo;
		player.add(cuerpo);
		return player;
		
	}
	public void setXY(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
}
