package Juego;

public class Validacion {

	
	public static boolean revisionVida(int vida,boolean flag) {
		
		if(vida==0) flag = false;
		return flag;
	}
	
	public static long Nivel(Obstaculo obstaculo, int puntos, long velocidad){
		
			if(obstaculo.x==0) {
				
				if( puntos<=9) velocidad = 15;
				if(puntos>=10 &&puntos<15) velocidad = 13;
				if(puntos>=15 &&puntos<20) velocidad = 11;
				if(puntos>=20 &&puntos<25) velocidad = 9;
				if(puntos>=25 &&puntos<30) velocidad = 8;
				if(puntos>=30 &&puntos<35) velocidad = 7;
				if(puntos>=35 &&puntos<40) velocidad = 6;
				if(puntos>=40 &&puntos<45) velocidad = 5;
				if(puntos>=45 &&puntos<50) velocidad = 4;
				if(puntos>=50 &&puntos<55) velocidad = 3;
				if(puntos>=55 &&puntos<60) velocidad = 2;
				if(puntos>=60 &&puntos<65) velocidad = 1;
		}
			return velocidad;
	}
	
	public static String stringNivel(long velocidad) {
		
		String textoNivel = "";
		
		if(velocidad==20) textoNivel = "Nivel 0";
		if(velocidad==15) textoNivel = "Nivel 1";
		if(velocidad==13) textoNivel = "Nivel 2";
		if(velocidad==11) textoNivel = "Nivel 3";
		if(velocidad==9) textoNivel = "Nivel 4";
		if(velocidad==8) textoNivel = "Nivel 5";
		if(velocidad==7) textoNivel = "Nivel 6";
		if(velocidad==6) textoNivel = "Nivel 7";
		if(velocidad==5) textoNivel = "Nivel 8";
		if(velocidad==4) textoNivel = "Nivel 9";
		if(velocidad==3) textoNivel = "Nivel 10";
		if(velocidad==2) textoNivel = "Nivel 11";
		if(velocidad==1) textoNivel = "Nivel 12";
		
		return textoNivel;
	}
	
}
