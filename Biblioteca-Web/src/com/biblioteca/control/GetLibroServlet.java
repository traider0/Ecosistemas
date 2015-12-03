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
 * Servlet implementation class GetLibroServlet
 */
public class GetLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DataSource dataSource = null;

	private SessionFactory sessionFactory;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetLibroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// JDBC
		// try {
		// Context contextoInicial = new InitialContext();
		//
		// Context contexto = (Context) contextoInicial
		// .lookup("java:comp/env");
		// dataSource = (DataSource) contexto.lookup("jdbc/biblioteca");
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		// HIBERNATE

		sessionFactory = new Configuration().configure(
				"com/biblioteca/dao/hibernate.cfg.xml").buildSessionFactory();

	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		BibliotecaDAO dao = new BibliotecaDAO();
		// JDBC
		// dao.setDataSource(dataSource);

		// HIBERNATE
		dao.setSessionFactory(sessionFactory);

		BibliotecaLN ln = new BibliotecaLN();
		ln.setDao(dao);

		Libro libro = null;

		try {
			libro = ln.getLibroById(Integer.parseInt(id));
			request.setAttribute("id", id);
			request.setAttribute("libro", libro);
		} catch (Exception e) {
			request.setAttribute("error", e);
			request.setAttribute("id", id);
		}

		request.getRequestDispatcher("/WEB-INF/resultadoBuscarLibro.jsp")
				.forward(request, response);

	}

}
