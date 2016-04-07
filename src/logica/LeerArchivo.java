package logica;

import java.io.File;
import java.util.*;
import java.io.*;

public class LeerArchivo {

	/*
	 * funcion para leer en archivo
	 * resive un objeto File 
	 * y retorna una Arraylist double de los numero
	 * */
	public ArrayList<Double> leer(File rutaArchivo) {
		// creando lista de numeros
		ArrayList<Double> datos = new ArrayList<Double>();
		// vector para almacenar lienas del archivo
		String[] vector;
		// iniciar porceso de lectura de archivo
		try{
			// creando objeto de lectura de archivo
			FileReader archivo = new FileReader( rutaArchivo);
			// creando objeto de lectura de archivo
			BufferedReader lectura = new BufferedReader( archivo);
			// almacenar liena como una cadena de texto
			String linea = "";
			// leyendo cada liena por liena 
			while( linea != null){
				// almacenar liena del archivo
				linea = lectura.readLine();
				// veficicando no pase linea vacia
				if( linea != null){
					// separando numeros
					vector = linea.split( " ");
					// almacenar numeros a la lista
					for( String x: vector){
						datos.add( Double.parseDouble( x));
					}
				}
			}			
		}catch ( Exception e){
			// informando excepcion si ocurre algun error al leer archivo
			System.out.println( "erro de lectura excepcion: " + e);
		}
		// retornando datos del archivo
		return datos;
	}
}