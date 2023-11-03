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

import br.cefet.simulacaoTurfe.dao.InscricaoCorridaDao;
import br.cefet.simulacaoTurfe.model.InscricaoCorrida;

/**
 * Servlet implementation class InscricaoCorridaList
 */
public class InscricaoCorridaList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscricaoCorridaList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = request.getParameter("next");
		String msg;
		InscricaoCorridaDao iDao = new InscricaoCorridaDao();
		List<InscricaoCorrida> inscricoes = null;
		
		try {
			inscricoes = iDao.listarTodos();
		} catch (SQLException e) {
			next = "error/index.jsp";
			msg = "Erro inesperado ao listar os cavalos";
			request.setAttribute("msg", msg);
			request.setAttribute("e", e);
		}
		
		request.setAttribute("inscricoes", inscricoes);
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
