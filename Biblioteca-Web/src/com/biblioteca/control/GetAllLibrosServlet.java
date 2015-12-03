package com.biblioteca.control;

import java.io.IOException;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
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
 * Servlet implementation class GetAllLibrosServlet
 */
public class GetAllLibrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//private DataSource dataSource = null;

	private SessionFactory sessionFactory;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllLibrosServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// JDBC
		/*try {
			Context contextoInicial = new InitialContext();

			Context contexto = (Context) contextoInicial
					.lookup("java:comp/env");
			dataSource = (DataSource) contexto.lookup("jdbc/biblioteca");
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		// HIBERNATE
		  sessionFactory = new Configuration().
		  configure("com/biblioteca/dao/hibernate.cfg.xml").
		  buildSessionFactory();
		 

	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		BibliotecaDAO dao = new BibliotecaDAO();
		// JDBC
		//dao.setDataSource(dataSource);

		// HIBERNATE
		dao.setSessionFactory(sessionFactory);

		BibliotecaLN ln = new BibliotecaLN();
		ln.setDao(dao);

		Collection<Libro> libros = null;

		try {
			libros = ln.getAllLibros();
			request.setAttribute("libros", libros);
		} catch (Exception e) {
			request.setAttribute("error", e);
		}

		request.getRequestDispatcher("/WEB-INF/resultadoListarLibro.jsp")
				.forward(request, response);
	}

}
