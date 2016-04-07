package logica;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CalcularTest {

	@Test
	public void test() {
		Calcular cal = new Calcular();
		ArrayList<Double> datos = new ArrayList<Double>();
		double[] vector = { 186, 699, 132, 272, 291, 331, 199, 1890, 788, 1601};
		for( double x: vector){
			datos.add(x);
		}
		double resultadoEsperado = 625.6339806770231;
		double resultado = cal.desviacionEstandar( datos);
		assertEquals( resultadoEsperado, resultado, 0.01);	
	}

}
