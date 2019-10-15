package Juego;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class Archivo {
	
	private static String texto;

	public static int leeArchivoInt() {
	  int num = 0;
	  String texto,texto1;
	  FileReader archivo;
      BufferedReader lector;    
      try {
      	archivo = new FileReader("Archivo.txt");
      	if(archivo.ready()) {
      		lector = new BufferedReader(archivo);
      		String cadena;
      		
      		texto = lector.readLine();
      		texto1 = lector.readLine();
      		//num=lector.read();
      		num = Integer.parseInt(texto1);
      		System.out.println(texto);
      		System.out.println(num);
      	}
      		else System.out.println("Archivo invalido ...");    
      } catch(Exception err){
          
     System.out.println(err.getMessage());	  
	}
	return num;
}
	
	public static String leeArchivoString() {
		  int num;
	//	  String texto,texto1;
		  FileReader archivo;
	      BufferedReader lector;    
	      try {
	      	archivo = new FileReader("Archivo.txt");
	      	if(archivo.ready()) {
	      		lector = new BufferedReader(archivo);
	      
	      		
	      		String texto = lector.readLine();
	      		return texto;
	     
	      	}
	      		else System.out.println("Archivo invalido ...");    
	      } catch(Exception err){
	          
	     System.out.println(err.getMessage());	  
		}
		return texto;
	}
	
	public static void escribeiArchivo(int puntaje,String nombreGanador) {
		  String texto;
	        try {
	           PrintWriter pw = new PrintWriter("Archivo.txt");
	          Integer numero = new Integer(puntaje);
	          texto = numero.toString();
	           pw.println(nombreGanador);
	           pw.println(texto);
	           pw.close();
	        }catch(Exception err){
	            
	        }
	       
	}
	
}



