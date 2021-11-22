package Co.empresa.eclipseExamen.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Co.empresa.eclipseExamen.Dao.EleccionDao;
import Co.empresa.eclipseExamen.Dao.EleccionPostgreSQL;
import Co.empresa.eclipseExamen.modelo.Eleccion;

/**
 * Servlet implementation class EleccionServlet
 */
@WebServlet("/EleccionServlet")
public class EleccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EleccionDao eleccionDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EleccionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.eleccionDao = new EleccionPostgreSQL();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertarEleccion(request, response);
				break;
			case "/delete":
				eliminarEleccion(request, response);
				break;
			case "/update":
				actualizarEleccion(request, response);
				break;
			case "/edit":
				showeditForm(request, response);
				break;
			default:
				metodoDefecto(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void metodoDefecto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Eleccion> listElecciones = eleccionDao.buscarElecciones();
		request.setAttribute("metodoDefecto", listElecciones);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Eleccionlist.jsp");
		dispatcher.forward(request, response);
	}

	private void showeditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		int id = Integer.parseInt(request.getParameter("id"));
		Eleccion eleccionActual = eleccionDao.buscarEleccionId(id);
		request.setAttribute("eleccion", eleccionActual);
		RequestDispatcher dispatcher = request.getRequestDispatcher("elecciones.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarEleccion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException  {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		Date fechaInicio= sdf.parse(request.getParameter("fechaInicio"));
		Date fechaFin = sdf.parse(request.getParameter("fechaFin"));
		String cargo = request.getParameter("cargo");
		
		Eleccion eleccion = new Eleccion(id, nombre, fechaInicio,fechaFin, cargo);
		eleccionDao.actualizarEleccion(eleccion);
		response.sendRedirect("list");
	}

	private void eliminarEleccion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException  {
		int id = Integer.parseInt(request.getParameter("id"));
		eleccionDao.eliminarEleccion(id);
		response.sendRedirect("list");
	}

	private void insertarEleccion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException  {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nombre = request.getParameter("nombre");
		Date fechaInicio= sdf.parse(request.getParameter("fechaInicio"));
		Date fechaFin = sdf.parse(request.getParameter("fechaFin"));
		String cargo = request.getParameter("cargo");
		response.sendRedirect("list");
		
		Eleccion eleccion = new Eleccion(nombre, fechaInicio, fechaFin, cargo);
		eleccionDao.insertarEleccion(eleccion);
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Elecciones.jsp");
		dispatcher.forward(request, response);
	}

}
