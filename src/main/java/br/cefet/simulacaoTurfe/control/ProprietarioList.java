package br.cefet.simulacaoTurfe.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.cefet.simulacaoTurfe.dao.ProprietarioDao;
import br.cefet.simulacaoTurfe.model.Proprietario;

/**
 * Servlet implementation class ProprietarioList
 */
public class ProprietarioList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProprietarioList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = request.getParameter("next");
		String msg;
		ProprietarioDao pDao = new ProprietarioDao();
		List<Proprietario> proprietarios = null;
		
		try {
			proprietarios = pDao.listarTodos();
		} catch (SQLException e) {
			next = "error/index.jsp";
			msg = "Erro inesperado ao listar os proprietários";
			request.setAttribute("msg", msg);
		}
		
		request.setAttribute("proprietarios", proprietarios);
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
