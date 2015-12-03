package com.biblioteca.modelo.ln;

import java.util.Collection;

import com.biblioteca.dao.IBibliotecaDAO;
import com.biblioteca.modelo.entidades.Libro;

public class BibliotecaLN implements IBibliotecaLN {

	private IBibliotecaDAO dao;
	
	public void setDao(IBibliotecaDAO dao) {
		this.dao = dao;
	}

	/**
	 * Funcionalidad que recibiendo un Libro, retorna
	 * 	La clave generada como entero.
	 * 	Una excepcion si algo va mal (en este caso si algo va mal en la BD)
	 */
	@Override
	public int insertLibro(Libro libro) throws Exception {
		int idGenerado = dao.insertLibro(libro);
		
		return idGenerado;
	}

	@Override
	public Collection<Libro> getAllLibros() throws Exception {
		return dao.getAllLibros();
	}

	@Override
	public Libro getLibroById(int isbn) throws Exception {
		return dao.getLibroById(isbn);
	}

}
