package Co.empresa.eclipseExamen.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Co.empresa.eclipseExamen.Dao.CandidatoDao;
import Co.empresa.eclipseExamen.Dao.CandidatoPostgreSQL;
import Co.empresa.eclipseExamen.modelo.Candidato;

/**
 * Servlet implementation class CandidatoServlet
 */
@WebServlet("/")
public class CandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CandidatoDao candidatoDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CandidatoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	public void init(ServletConfig config) throws ServletException {
		this.candidatoDao = new CandidatoPostgreSQL();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertarCandidato(request, response);
			break;
		case "/delete":
			eliminarCandidato(request, response);
			break;
		case "/update":
			actualizarCandidato(request, response);
			break;
		case "/edit":
			showeditForm(request, response);
			break;
		default:
			metodoDefecto(request, response);
			break;
		}
	}

	private void metodoDefecto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void showeditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	private void actualizarCandidato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	private void eliminarCandidato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	private void insertarCandidato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String documento = request.getParameter("documento");
		int numero = Integer.parseInt(request.getParameter("numero"));
		int eleccion = Integer.parseInt(request.getParameter("eleccion"));
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Elecciones.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
