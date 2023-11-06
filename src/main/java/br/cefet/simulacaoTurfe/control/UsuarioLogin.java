package br.cefet.simulacaoTurfe.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import br.cefet.simulacaoTurfe.dao.UsuarioDao;
import br.cefet.simulacaoTurfe.model.Usuario;

/**
 * Servlet implementation class UsuarioLogin
 */
public class UsuarioLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = Usuario.sha256(request.getParameter("senha"));
		
		Usuario usuario = null;
		
		UsuarioDao dao = new UsuarioDao();
		
		HttpSession session = request.getSession();
		String next = "home/index.jsp";
		
		try {
			usuario = dao.buscarUm(email, senha);
			
			session.setAttribute("usuario", usuario);
		} catch(SQLException e) {
			next = "error/index.jsp";
			request.setAttribute("e", e);
			request.setAttribute("msg", "Não foi possível entrar com o usuário.");
			e.printStackTrace();
			session.invalidate();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher(next);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
