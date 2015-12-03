package com.biblioteca.dao;

import java.sql.SQLException;
import java.util.Collection;

import com.biblioteca.modelo.entidades.Libro;

public interface IBibliotecaDAO {
	public int insertLibro(Libro libro) throws SQLException;
	public Collection<Libro> getAllLibros() throws SQLException;
	public Libro getLibroById(int isbn) throws SQLException;
}
