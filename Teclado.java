package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener{
	
	private final int numeroTecla=120;
	
	private final boolean[] tecla=new boolean[numeroTecla];
 	boolean izquierda=false;
	boolean derecha=false;
	boolean arriba=false;
	boolean abajo=false;
	
	public void actualizar() {
		izquierda=tecla[KeyEvent.VK_A];
		derecha = tecla[KeyEvent.VK_D];
		arriba=tecla[KeyEvent.VK_W];
		abajo = tecla[KeyEvent.VK_S];
		
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		tecla[e.getKeyCode()]=true;
		
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		tecla[e.getKeyCode()]=false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
