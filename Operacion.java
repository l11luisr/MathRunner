package Juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Operacion {
	private final int min = 1;
	private final int max = 9;
	private final int range = 10;
	private int tipo;//tipo de operacion;
	char[] stringIgual;
	char signo[] = new char[4];
	int num1, num2, resultado;
	Random rand;
	String stringNum1, stringNum2, stringSigno;
	ImageIcon img;
	Image imagen;
	private Inicio juego;
	
	public Operacion() {
		signo[0]='+';
		signo[1]='-';
		signo[2]='x';
		signo[3]='=';
		this.juego = juego;
		rand = new Random();
		img = new ImageIcon(getClass().getResource("/Imagen/Pizarrón.png"));
		imagen = img.getImage();
		ejecutarOperacion();	
		
	}
	
	public void ejecutarOperacion() {
		
		tipo=(int) (Math.random()*3);
		num1=(int) rand.nextInt(range);
		num2=(int) (Math.random()*range);
		if(tipo==0) resultado = num1 + num2; 
		if(tipo==1) resultado = num1 - num2;
		if(tipo==2) resultado = num1 * num2;
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(resultado);
		
	}
	
	public void paint(Graphics g)
	{	
		g.drawImage(imagen, 10, 180, 300, 200, null);
		stringNum1 = String.valueOf(num1);
		stringNum2 = String.valueOf(num2);
		stringSigno = String.valueOf(signo[tipo]);
	//	stringIgual=String.valueOf(stringIgual);
		
		g.setColor(Color.white);
		g.setFont(new Font("Consolas",Font.PLAIN,60));
		g.drawChars(signo, tipo, 1, 120, 287);
		g.drawChars(signo, 3, 1, 240, 287);
		g.drawString(stringNum1, 60, 287);
		g.drawString(stringNum2, 180, 287);
		
	}

	public int getNum1() {
		return num1;
	}
	public int getNum2() {
		return num2;
	}
	public int getResultado() {
		return resultado;
	}
	
}
