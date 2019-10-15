package Juego;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Sonidos {
	
	URL ruta_fin,ruta_jugando1,ruta_punto,ruta_choque,ruta_inicio,ruta_ganaste;
	public AudioClip sonido_fin,sonido_jugando1,sonido_punto,sonido_choque,sonido_inicio,sonido_ganaste;
	public AudioClip[] sonido_jugando=new AudioClip[4];
	public URL[] ruta_jugando=new URL[4];
	
	public Sonidos() {
		
		ruta_fin = getClass().getResource("/Sonido/Game_Over.wav");
        sonido_fin=Applet.newAudioClip(ruta_fin);
        
        ruta_jugando[0] = getClass().getResource("/Sonido/Jugando1.wav");
        sonido_jugando[0]=Applet.newAudioClip(ruta_jugando[0]);
        
        ruta_jugando[1] = getClass().getResource("/Sonido/Jugando2.wav");
        sonido_jugando[1]=Applet.newAudioClip(ruta_jugando[1]);
        
        ruta_jugando[2] = getClass().getResource("/Sonido/Jugando3.wav");
        sonido_jugando[2]=Applet.newAudioClip(ruta_jugando[2]);
        
        ruta_jugando[3] = getClass().getResource("/Sonido/Jugando4.wav");
        sonido_jugando[3]=Applet.newAudioClip(ruta_jugando[3]);
        
        ruta_inicio = getClass().getResource("/Sonido/ReadyGo.wav");
        sonido_inicio=Applet.newAudioClip(ruta_inicio);
        
        ruta_choque = getClass().getResource("/Sonido/choque.wav");
        sonido_choque=Applet.newAudioClip(ruta_choque);
        
        ruta_ganaste = getClass().getResource("/Sonido/ganaste.wav");
        sonido_ganaste=Applet.newAudioClip(ruta_ganaste);
        
	}

}
