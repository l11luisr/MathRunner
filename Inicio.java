package Juego;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.JPanel;

public class Inicio extends JPanel  {
	
	private int tipoCarril;
	private int resultado;
	Obstaculo obstaculo[] = new Obstaculo[4];
	Fondo fondo = new Fondo();
	Camino camino = new Camino();
	Operacion ope = new Operacion();
	Jugador jugador = new Jugador(this,ope.getResultado());
	Corona corona = new Corona();
	Instruccion instruccion = new Instruccion();
	Marco marco = new Marco();
	Liston liston = new Liston();
	Victoria victoria = new Victoria();
	int puntos = 0, estadoInstruccion = 0, ganador = 0;
	int ganadorPuntos = 3;
	int []puntaje = new int[5];
	int numGanador = 0; 
	long velocidad = 60;
	int aleatorio;
	boolean flag = true;
	String[] nombreGanador = new String[5];
	String ganadorHistorial = "sd",ganadorPuntaje;
	String[] puntajeString = new String[5]; 
	String textPuntaje = "Puntaje:", textPunto="0";
	boolean estadoLogica = true, estadoRepaint = true;
	
	public Inicio(Sonidos sonido) {
		
		//ruta1=getClass().getResource("/Sonido/Game_Over.wav");
        //sonido_fin=Applet.newAudioClip(ruta1);
		ganadorHistorial = Archivo.leeArchivoString();
		ganadorPuntos = Archivo.leeArchivoInt();
		ganadorPuntaje = String.valueOf(ganadorPuntos);
        
		obstaculo[0] = new Obstaculo(this,476,1,ope.resultado,sonido);
		obstaculo[1] = new Obstaculo(this,538,2,ope.resultado,sonido);
		obstaculo[2] = new Obstaculo(this,600,3,ope.resultado,sonido);
		obstaculo[3] = new Obstaculo(this,662,4,ope.resultado,sonido);
		resultado = ope.getResultado();
		
		this.addKeyListener(new KeyListener() {
 
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				jugador.KeyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				jugador.keyReleased(e);
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}
			
		});
		this.setFocusable(true);
	}
	
	public void reiniciarobstaculo() {
		ope.ejecutarOperacion();
		tipoCarril = (int) (Math.random()*4)+1;
		for(int i=0;i<4;i++) {
			if(obstaculo[i].tipo==tipoCarril)
				obstaculo[i].resultado=ope.getResultado();
			else
				obstaculo[i].resultado = (int) (Math.random()*99);
			obstaculo[i].cambiaResultado();
		}
		resultado = ope.getResultado();
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
	
		Graphics2D g2 = (Graphics2D) g;
		
		if(estadoRepaint) {
			
			fondo.paint(g2);
			camino.paint(g2);
			jugador.paint(g2);
			ope.paint(g2);
			corona.paint(g2);
			marco.paint(g2);
			liston.paint(g2);
			g.setFont(new Font("Consolas",Font.PLAIN,40));
			g.setColor(Color.black);
			g.drawString(textPuntaje,50,150);
			g.drawString(textPunto, 230,150);
			g.drawString(Validacion.stringNivel(velocidad), 590, 165);		
			for(int i=0;i<4;i++)
			{
				obstaculo[i].paint(g2);
			}
		
			
			g.setFont(new Font("Consolas",Font.ROMAN_BASELINE,20));
			for(int i=0;i<5;i++)
			{
				if(nombreGanador[i]!=null)
					g.drawString(nombreGanador[i], 1105, 40*i+120);
			}
			
			for(int i=0;i<5;i++)
			{
				if(nombreGanador[i]!=null)
				{
					g.drawString(textPuntaje, 1230, 40*i+120);
					g.drawString(puntajeString[i], 1320, 40*i+120);
				}
			}
			System.out.println(puntos);
			if(estadoInstruccion==0)
				instruccion.paint(g2);
		if(ganador==1) 
		{
			g.drawString("El primer lugar es: ",400,400);
			g.drawString(nombreGanador[0], 100, 500);
			g.drawString(textPuntaje, 400, 600);
			g.drawString(puntajeString[0], 400, 700);
		}
		
		g.drawString(ganadorHistorial, 650, 45);
		g.drawString(ganadorPuntaje, 730, 80);
		g.drawString(textPuntaje, 620, 80);
		}
		else 
		{	
			victoria.paint(g2);
			g.setColor(Color.black);
			g.setFont(new Font("Consolas",Font.ROMAN_BASELINE,50));
			g.drawString(ganadorHistorial, 500, 300);
			g.drawString(ganadorPuntaje, 800, 300);
			g.drawString(nombreGanador[0], 500, 410);
			g.drawString(nombreGanador[1], 500, 490);
			g.drawString(nombreGanador[2], 500, 560);
			g.drawString(nombreGanador[3], 500, 630);
			g.drawString(nombreGanador[4], 500, 700);
			g.drawString(puntajeString[0], 800, 410);
			g.drawString(puntajeString[1], 800, 490);
			g.drawString(puntajeString[2], 800, 560);
			g.drawString(puntajeString[3], 800, 630);
			g.drawString(puntajeString[4], 800, 700);
		}
	System.out.print(ganadorPuntaje);
	}
	
	public void validaArchivo() {
		ganadorHistorial = Archivo.leeArchivoString();
		ganadorPuntos = Archivo.leeArchivoInt();
		System.out.println("Ganador puntos es :"+ganadorPuntos);
		ganadorPuntaje = String.valueOf(ganadorPuntos);
	}
	
	public void valida() {
		flag = Validacion.revisionVida(jugador.vida, flag);
		velocidad = Validacion.Nivel(obstaculo[0], puntos, velocidad);
		validaArchivo();
		
	}
	
	public void mover() {
		if(estadoLogica) {
			valida();
			jugador.mover();
			for(int i=0;i<4;i++) {
				obstaculo[i].mover();
			}
			fondo.mover();
			camino.mover();
			if(this.jugador.vida<=0) 
			{
				this.jugador.vida=0;
			}
			if(obstaculo[0].x<=100) {
				reiniciarobstaculo();
			textPunto = String.valueOf(puntos);	
				System.out.println("El resultado es: "+resultado);
			}
		}
		
		
		
	}
	public int getResultado() {
		return resultado;
	}

}


