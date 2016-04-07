package logica;

import java.util.ArrayList;

public class Calcular {
	
	/*
	 * funcion para calcular el promedio de numero 
	 * resivel de parametros un ArrayList decimal
	 * y retorna un valor decimal
	 * */
	public static double promedio( ArrayList<Double> numero){
		// inicio de atributo del resultado
		double resultado = 0;
		// sumando numeros del ArrayList
		for( double x: numero){
			resultado += x;
		}
		// retornando resultado 
		return resultado / numero.size();
	}

	/*
	 * funcion para calcula la diferencia del lista con el promedio
	 * resive parametros de un ArrayList decimal y double 
	 * y retorna un valor decimal
	 * */
	public static ArrayList<Double> calcular( double media, ArrayList<Double> numero){
		// inicio de numero temporal
		double num = 0;
		// creando lista para retornar
		ArrayList<Double> resultado = new ArrayList<Double>();
		// creando lista de las potenciacion
		for( double x: numero){
			num = ( x - media) * ( x - media );
			resultado.add( num);
		}
		// retornando lista de la potenciacion
		return resultado;
	}

	/*
	 * funcion para calcula la suma de varios numero
	 * resive parametros de un ArrayList decimal 
	 * y retorna un valor decimal
	 * */
	public static double sumatoria( ArrayList<Double> numero){
		// incion del atributo para el resultado
		double resultado = 0;
		// sumando todo los numero
		for( double x: numero){
			resultado += x;
		}
		// restonar suma de todos los numero
		return resultado;
	}

	/*
	 * funcion para calcula la derivacion estandar
	 * resive parametros de un ArrayList decimal
	 * y retorna un valor decimal
	 * */
	public static double desviacionEstandar( ArrayList<Double>  numero){
		// calcular el promedio de numeros
		double promedio = promedio( numero);
		// creando lista de diferencia de numero
		ArrayList<Double> diferencia = calcular( promedio, numero);
		// sumar todos los numeros
		double sumar = sumatoria( diferencia);
		// calcular raiz cuadrada del suma delos numero
		double resultado = Math.sqrt( sumar / ( diferencia.size() -1 ));		
		return resultado;
	}
}
