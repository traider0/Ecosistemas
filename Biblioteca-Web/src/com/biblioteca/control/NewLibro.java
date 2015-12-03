package com.biblioteca.control;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.biblioteca.dao.BibliotecaDAO;
import com.biblioteca.modelo.entidades.Libro;
import com.biblioteca.modelo.ln.BibliotecaLN;

/**
 * Servlet implementation class NewLibro
 */
public class NewLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//private DataSource dataSource = null;
	private SessionFactory sessionFactory = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewLibro() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {

		//JDBC
//		try {
//			Context contextoInicial = new InitialContext();
//
//			Context contexto = (Context) contextoInicial
//					.lookup("java:comp/env");
//			dataSource = (DataSource) contexto.lookup("jdbc/biblioteca");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//HIBERNATE
		sessionFactory  = new Configuration().
				configure("com/biblioteca/dao/hibernate.cfg.xml").
				buildSessionFactory();
		 
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		
		BibliotecaDAO dao = new BibliotecaDAO();
		//JDBC
		//dao.setDataSource(dataSource);
		
		//HIBERNATE
		dao.setSessionFactory(sessionFactory);

		BibliotecaLN ln = new BibliotecaLN();
		ln.setDao(dao);
		
		Libro libro = new Libro(titulo, autor);
		
		try {
			int id = ln.insertLibro(libro);
			request.setAttribute("id", id);
			request.setAttribute("libro", libro);
		} catch (Exception e) {
			request.setAttribute("error", e);
			request.setAttribute("libro", libro);
		}
		
		request.getRequestDispatcher("/WEB-INF/resultadoInsertarLibro.jsp").forward(request, response);
	}

}
