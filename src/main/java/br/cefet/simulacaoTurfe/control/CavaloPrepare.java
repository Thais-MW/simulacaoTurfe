package br.cefet.simulacaoTurfe.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.cefet.simulacaoTurfe.dao.CavaloDao;
import br.cefet.simulacaoTurfe.dao.ProprietarioDao;
import br.cefet.simulacaoTurfe.model.Cavalo;
import br.cefet.simulacaoTurfe.model.Proprietario;

/**
 * Servlet implementation class CavaloPrepare
 */
public class CavaloPrepare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CavaloPrepare() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String next = "cavalo/atualizar.jsp";
		Cavalo c = null;
		CavaloDao dao = new CavaloDao();
		ProprietarioDao pdao = new ProprietarioDao();
		
		try {
			c = dao.buscarUm(id);
			if (c == null) {
				throw new Exception("Cavalo não encontrado.");
			}
			request.setAttribute("proprietarios", pdao.listarTodos());
			request.setAttribute("cavalo", c);
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
