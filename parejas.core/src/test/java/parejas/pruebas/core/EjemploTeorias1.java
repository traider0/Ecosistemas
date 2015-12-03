package parejas.pruebas.core;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class EjemploTeorias1 {
	@DataPoint
	public static String color="ROJO";
	@DataPoint
	public static String sabor="SALADO";
	@DataPoint
	public static String aroma="DULCE";
	
	@Theory
	public void test(String cad1, String cad2) {
		System.out.println(cad1+"->"+cad2);
		//hariamos asertos de viabilidad
		//assert
		
	}

}
