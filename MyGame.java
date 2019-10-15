package Juego;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyGame {
	
	public MyGame() {
		
		int reinicia = 6;
		int fin = 3;
		
		JFrame ventana = new JFrame("MathRUNNER!");
		
		Sonidos sonido = new Sonidos();
		Inicio inicio = new Inicio(sonido);
	//	Menu menu=new Menu();
	//	ventana.add(menu);
		ventana.add(inicio);
	//	ventana.add(instruccion);
		ventana.setSize(1366, 768);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		Operacion operacion = new Operacion();
		//instruccion.repaint();
		inicio.aleatorio = (int) (Math.random()*4);
		sonido.sonido_jugando[inicio.aleatorio].play();
		JOptionPane.showMessageDialog(null, "¿Estás listo? :) ","MathRUNNER!",-1); 
		sonido.sonido_inicio.play();
		inicio.estadoInstruccion = 1;
		//instruccion.setVisible(false);
		while(true) {
	
			 if(!inicio.flag)
			 {	 inicio.estadoInstruccion = 0;	
				 sonido.sonido_jugando[inicio.aleatorio].stop();
				 sonido.sonido_fin.play();
				 inicio.nombreGanador[inicio.numGanador]=JOptionPane.showInputDialog("Introduce tu apodo");
				 inicio.puntaje[inicio.numGanador] = inicio.puntos;
				 inicio.puntajeString[inicio.numGanador]=String.valueOf(inicio.puntos);
				 if(inicio.puntaje[inicio.numGanador]>inicio.ganadorPuntos) {
					 Archivo.escribeiArchivo(inicio.puntos,inicio.nombreGanador[inicio.numGanador]);
				 }
				
				 inicio.numGanador++;
				 inicio.estadoInstruccion = 1;
				 inicio.repaint();
				 if(inicio.numGanador==5) {
					 
					 for (int i = 0; i < inicio.puntaje.length; i++) {
					        for (int j = 1; j < (inicio.puntaje.length - i); j++) {
					            if (inicio.puntaje[j - 1] < inicio.puntaje[j]) {
					                int temporal = inicio.puntaje[j - 1];
					                inicio.puntaje[j - 1] = inicio.puntaje[j];
					                inicio.puntaje[j] = temporal;
					                
					               String aux=inicio.puntajeString[j-1];
					               inicio.puntajeString[j-1] = inicio.puntajeString[j];
					               inicio.puntajeString[j]=aux;
					               
					               aux=inicio.nombreGanador[j-1];
					               inicio.nombreGanador[j-1]=inicio.nombreGanador[j];
					               inicio.nombreGanador[j]=aux;
					              
					            }
					        }
					        
					    }
					 for(int i=0;i<5;i++)
					 {
						 inicio.puntajeString[i]=String.valueOf(inicio.puntaje[i]);
					 }
					 inicio.ganador = 1;
					 inicio.estadoLogica = false;
		             inicio.estadoRepaint = false;
					 inicio.repaint();
					 sonido.sonido_ganaste.play();
				
					// fin=JOptionPane.showConfirmDialog(inicio, "Fin de juego no importa si presiona si o no ","se sale de juego",JOptionPane.YES_NO_OPTION);
					 JOptionPane.showMessageDialog(null, "¿Quién es el mejor?","TOP 5",-1);
					 inicio.ganador = 0;
					 
					 
				 }
			if(!inicio.flag)
				reinicia=JOptionPane.showConfirmDialog(inicio, "¿Deseas reiniciar el juego?","GAMEOVER",JOptionPane.YES_NO_OPTION);
			 inicio.estadoInstruccion=0;
			inicio.repaint();
			if(reinicia==0)JOptionPane.showMessageDialog(null, "Presiona OK para iniciar","MathRUNNER!",-1);
		
			inicio.estadoInstruccion = 1;
			sonido.sonido_fin.stop();
			if(reinicia==0)
       	 {
			if(inicio.estadoLogica) {
				sonido.sonido_inicio.play();
			}
			 inicio.velocidad=20;
       	 inicio.jugador.vida = 3;
       	 for(int i=0;i<4;i++) {
       		 inicio.obstaculo[i].x = 0;
       	 }
       	 inicio.puntos = 0;
       	 if(inicio.estadoLogica){
       		inicio.aleatorio=(int) (Math.random()*4);
          	 sonido.sonido_jugando[inicio.aleatorio].play();
       		 
       	 }
        	 inicio.jugador.setXY(100, 662);
        	inicio.flag=true;
				 
       	 }
            if(reinicia==1)
            {
            System.exit(0);
            }
			 
			 }
				
		
				else {
					if(fin==0 || fin==1)
					{
						System.exit(0);
					}
					inicio.mover();
					inicio.repaint();
					try {
						Thread.sleep(inicio.velocidad);
						//Thread.sleep(6);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			 
		}
	}
}