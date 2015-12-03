package parejas.presentacion;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import parejas.modelo.Persona;
import parejas.negocio.ServicioBusquedaParejas;
import parejas.negocio.ServicioBusquedaParejasImpl;
import parejas.persistencia.PersonaDao;
import parejas.persistencia.PersonaDaoMemoriaImpl;


@WebServlet("/ControlBusquedas")
public class ControlBusquedas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicioBusquedaParejas buscador;
	private PersonaDaoMemoriaImpl personaDao;
	
	@PostConstruct
	public void inicializar(){
		personaDao=new PersonaDaoMemoriaImpl();
		inicializarDatos();
		buscador=new ServicioBusquedaParejasImpl(personaDao);
	}

	private void inicializarDatos() {
		//preparar el entorno
		List<Persona> personas = Arrays.asList(
			new Persona(1L,"pepe",77,1.67f,Persona.HOMBRE),
			new Persona(2L,"luis",62,1.77f,Persona.HOMBRE),
			new Persona(3L,"ana",71,1.77f,Persona.MUJER),
			new Persona(4L,"maria",79,1.57f,Persona.MUJER));
		for (Persona persona : personas) {
			personaDao.guardar(persona);
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recibimos los datos desde la vista
		Persona usuario=new Persona();
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setEdad(Integer.parseInt(request.getParameter("edad")));
		usuario.setAltura(Float.parseFloat(request.getParameter("altura")));;
		usuario.setSexo(request.getParameter("sexo").trim().toUpperCase().charAt(0));
		
		//buscamos su pareja ideal
		Persona ideal = buscador.encontrarIdeal(usuario);
		//recursos generales de la peticion
		String pantalla="resultados.jsp";
		String msg="";
		Map<String,Object> datos=new HashMap<>();
		
		//realizamos los casos de uso
		msg="Enhorabuena "+usuario.getNombre();
		datos.put("ideal",ideal);
		if(ideal==null){
			msg="Lastima "+usuario.getNombre();
			datos.put("afines",buscador.encontrarAfines(usuario));

		}
		//pasamos la informacion del controlador a la vista
		request.setAttribute("msg", msg);
		request.setAttribute("datos", datos);
		//decidimos la vista a mostrar
		request.getRequestDispatcher(pantalla)
			.forward(request, response);
				
	}

}
