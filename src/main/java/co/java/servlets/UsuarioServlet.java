package co.java.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.java.dao.UsuarioDao;
import co.java.dao.ReporteDao;
import co.java.dao.TokenDao;
import co.java.entity.Reporte;
import co.java.entity.Rol;
import co.java.entity.TipoDB;
import co.java.entity.Token;
import co.java.entity.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDao userDao;
	private TokenDao tokenDao;
	private ReporteDao reporteDao;
	private Usuario usuario = new Usuario();

	public void init() {
		userDao = new UsuarioDao();
		tokenDao = new TokenDao();
		reporteDao = new ReporteDao();
	}

	public UsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
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
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/newToken":
				showNew(request, response);
				break;
			case "/insertToken":
				insertToken(request, response);
				break;
			case "/deleteToken":
				deleteToken(request, response);
				break;
			case "/editToken":
				showEdit(request, response);
				break;
			case "/updateToken":
				updateToken(request, response);
				break;
			case "/lisToken":
				listToken(request, response);
				break;
			case "/newReporte":
				showNewReporte(request, response);
				break;
			case "/insertReporte":
				insertReporte(request, response);
				break;
			case "/deleteReporte":
				deleteReporte(request, response);
				break;
			case "/editReporte":
				showEditReporte(request, response);
				break;
			case "/updateReporte":
				updateReporte(request, response);
				break;
			case "/lisReporte":
				listReporte(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

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

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Usuario> listaUsuario = userDao.getUsers();
		request.setAttribute("listaUsuario", listaUsuario);
		RequestDispatcher dispatcher = request.getRequestDispatcher("userList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Usuario user = userDao.getUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
		request.setAttribute("user", user);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		int state = Integer.parseInt(request.getParameter("state"));
		String rol = request.getParameter("rol");
		Rol role = new Rol();
		role.setDescription(rol);
		Usuario usuarioNuevo = new Usuario(name, email, pass, role, state);
		userDao.createUser(usuarioNuevo);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		int state = Integer.parseInt(request.getParameter("state"));
		String rol = request.getParameter("rol");
		Rol role = new Rol();
		role.setDescription(rol);
		Usuario user = new Usuario(id, name, email, pass, role, state);
		userDao.updateUser(user);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("list");
	}

	private void listToken(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Token> listaToken = tokenDao.getTokens();
		request.setAttribute("listaToken", listaToken);
		RequestDispatcher dispatcher = request.getRequestDispatcher("tokenList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNew(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("token.jsp");
		dispatcher.forward(request, response);
	}

	private void showEdit(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Token token = tokenDao.getToken(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("token.jsp");
		request.setAttribute("token", token);
		dispatcher.forward(request, response);

	}

	private void insertToken(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String host = request.getParameter("host");
		String userdb = request.getParameter("email");
		String pass = request.getParameter("pass");
		String db = request.getParameter("db");
		String token = request.getParameter("token");
		Integer port = Integer.parseInt(request.getParameter("port"));
		String userRol = request.getParameter("userRol");
		Integer state = Integer.parseInt(request.getParameter("state"));
		String typedb = request.getParameter("typedb");
		Usuario userR = new Usuario();
		userR.setUsuario(userRol);
		TipoDB tipo = new TipoDB();
		tipo.setDescripcion(typedb);
		Token tokenNuevo = new Token(host, userdb, pass, db, token, port, userR, state, tipo);
		tokenDao.createToken(tokenNuevo);
		response.sendRedirect("listToken");
	}

	private void updateToken(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String host = request.getParameter("host");
		String userdb = request.getParameter("email");
		String pass = request.getParameter("pass");
		String db = request.getParameter("db");
		String token = request.getParameter("token");
		Integer port = Integer.parseInt(request.getParameter("port"));
		String userRol = request.getParameter("userRol");
		Integer state = Integer.parseInt(request.getParameter("state"));
		String typedb = request.getParameter("typedb");
		Usuario userR = new Usuario();
		userR.setUsuario(userRol);
		TipoDB tipo = new TipoDB();
		tipo.setDescripcion(typedb);
		Token tokenNuevo = new Token(host, userdb, pass, db, token, port, userR, state, tipo);
		tokenDao.updateToken(tokenNuevo);
		response.sendRedirect("listToken");
	}

	private void deleteToken(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		tokenDao.deleteToken(id);
		response.sendRedirect("listToken");
	}
	
	private void listReporte(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Reporte> listareporte = reporteDao.getReportes();
		request.setAttribute("listareporte", listareporte);
		RequestDispatcher dispatcher = request.getRequestDispatcher("reporteList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewReporte(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("reporte.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditReporte(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Reporte reporte = reporteDao.getReporte(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("reporte.jsp");
		request.setAttribute("reporte", reporte);
		dispatcher.forward(request, response);

	}

	private void insertReporte(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String documento = request.getParameter("file");
		String fecha = request.getParameter("dataCreate");
		String state = request.getParameter("state");
		String descripcion = request.getParameter("description");
		String name = request.getParameter("name");
		String conexion = request.getParameter("conexion");
		Token tokenR = new Token();
		tokenR.setDb(conexion);
		Reporte reporteNuevo = new Reporte(documento, tokenR,fecha, state, descripcion, name);
		reporteDao.createReporte(reporteNuevo);
		response.sendRedirect("listReporte");
	}

	private void updateReporte(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String documento = request.getParameter("file");
		String fecha = request.getParameter("dataCreate");
		String state = request.getParameter("state");
		String descripcion = request.getParameter("description");
		String name = request.getParameter("name");
		String conexion = request.getParameter("conexion");
		Token tokenR = new Token();
		tokenR.setDb(conexion);
		Reporte reporteNuevo = new Reporte(id,documento, tokenR,fecha, state, descripcion, name);
		reporteDao.updateReporte(reporteNuevo);
		response.sendRedirect("listReporte");
	}

	private void deleteReporte(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		reporteDao.deleteReporte(id);
		response.sendRedirect("listReporte");
	}
}
