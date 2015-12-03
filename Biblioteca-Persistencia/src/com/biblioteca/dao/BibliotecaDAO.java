package com.biblioteca.dao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.biblioteca.modelo.entidades.Libro;

public class BibliotecaDAO implements IBibliotecaDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int insertLibro(Libro libro) throws SQLException {
		Session sesion = sessionFactory.openSession();
		sesion.getTransaction().begin();
		
		Integer id = (Integer) sesion.save(libro);
		
		sesion.getTransaction().commit();
		sesion.close();
		
		return id;
	}

	@Override
	public Collection<Libro> getAllLibros() throws SQLException {
		Session sesion = sessionFactory.openSession();
		sesion.getTransaction().begin();
		
		Query q = sesion.createQuery("from Libro");  
		List<Libro> reviews = q.list();
		
		sesion.getTransaction().commit();
		sesion.close();
		return reviews;
	}

	@Override
	public Libro getLibroById(int isbn) throws SQLException {
		Session sesion = sessionFactory.openSession();
		Libro libro = (Libro)sesion.get(Libro.class, isbn);
		sesion.close();
		return libro;
	}

}
