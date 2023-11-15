package br.cefet.simulacaoTurfe.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import br.cefet.simulacaoTurfe.dao.CavaloDao;
import br.cefet.simulacaoTurfe.dao.CorridaDao;
import br.cefet.simulacaoTurfe.dao.InscricaoCorridaDao;
import br.cefet.simulacaoTurfe.model.InscricaoCorrida;

/**
 * Servlet implementation class InscricaoCorridaPrepare
 */
public class InscricaoCorridaPrepare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscricaoCorridaPrepare() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String next = "inscricaoCavalo/index.jsp";
		InscricaoCorridaDao dao = new InscricaoCorridaDao();
		
		try {
			InscricaoCorrida i = dao.buscarUm(id);
			
			if (i == null) {
				throw new Exception("");
			}
			
			request.setAttribute("inscricao", i);
			request.setAttribute("cavalos", new CavaloDao().listarTodos());
			request.setAttribute("corridas", new CorridaDao().listarTodos());
		} catch (Exception e) {
			next = "error/index.jsp";
			request.setAttribute("e", e);
			request.setAttribute("msg", "Não foi possível concluir a operação desejada.");
			e.printStackTrace();
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
