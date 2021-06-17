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
import co.java.entity.Rol;
import co.java.entity.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsuarioDao userDao;
	private Usuario usuario = new Usuario();
    
	   
	 public void init() {
	        userDao = new UsuarioDao();
	    } 
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	 private void listUser(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        List <Usuario> listaUsuario = userDao.getUsers();
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

			    private void insertUser(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        String name = request.getParameter("nombre");
			        String email = request.getParameter("email");
			        String pass = request.getParameter("pass");
			        int state = Integer.parseInt(request.getParameter("state"));
			        String rol = request.getParameter("rol");
			        Rol role = new Rol();
			        role.setDescription(rol);
			        Usuario usuarioNuevo = new Usuario(name, email, pass,role,state);
			        userDao.createUser(usuarioNuevo);
			        response.sendRedirect("list");
			    }

			    private void updateUser(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        String name = request.getParameter("nombre");
			        String email = request.getParameter("email");
			        String pass = request.getParameter("pass");
			        int state = Integer.parseInt(request.getParameter("state"));
			        String rol = request.getParameter("rol");
			        Rol role = new Rol();
			        role.setDescription(rol);
			        Usuario user = new Usuario(id,name, email, pass,role,state);
			        userDao.updateUser(user);
			        response.sendRedirect("list");
			    }

			    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        userDao.deleteUser(id);
			        response.sendRedirect("list");
			    }
}
