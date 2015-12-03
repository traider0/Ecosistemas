package com.biblioteca.modelo.ln;

import java.util.Collection;

import com.biblioteca.modelo.entidades.Libro;

public interface IBibliotecaLN {
	public int insertLibro(Libro libro) throws Exception;
	public Collection<Libro> getAllLibros() throws Exception;
	public Libro getLibroById(int isbn) throws Exception;
}
