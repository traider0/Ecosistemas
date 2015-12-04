package com.ejemplo.concordion;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class SaludoTest {
	
	private Saludador saludador = new Saludador();
	
	//El parametro nombre es el datoDePruebaDeEntrada
	//El datoDePruebaEsperado no será necesario dentro de esta clase de test,
	//ya que las aserciones no se hacen aqui, sino en el HTML
	public String greetingFor(String datoDePruebaDeEntrada){
		
		//Probando el SUT
		String datoDePruebaObtenido = saludador.saludar(datoDePruebaDeEntrada);
		
		
		return datoDePruebaObtenido;
	}
	
}
