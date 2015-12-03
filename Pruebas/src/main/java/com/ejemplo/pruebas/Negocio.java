package com.ejemplo.pruebas;

public class Negocio {
	
	//Dependencia
	private IPersistencia persitencia;
	
	//Inyeccion por Set
	public void setPersitencia(IPersistencia persitencia) {
		this.persitencia = persitencia;
	}
	
	//Inyerccion por constructor
	public Negocio(IPersistencia persitencia) {
		super();
		this.persitencia = persitencia;
	}
	
	public int alta(Object objeto){
		
		//Comprobar que los datos que le llegan son validos
		
		//insertar en una bse datos
		return persitencia.insercion(objeto);
		
		//Avisar que se ha realizado la operacion
		
		
		
	}

	

	
}
