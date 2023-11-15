package br.cefet.simulacaoTurfe.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.cefet.simulacaoTurfe.dao.CavaloDao;
import br.cefet.simulacaoTurfe.dao.CorridaDao;
import br.cefet.simulacaoTurfe.dao.InscricaoCorridaDao;
import br.cefet.simulacaoTurfe.model.InscricaoCorrida;

/**
 * Servlet implementation class InscricaoCorridaUpdate
 */
public class InscricaoCorridaUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscricaoCorridaUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int idCavalo = Integer.parseInt(request.getParameter("idCavalo"));
		int idCorrida = Integer.parseInt(request.getParameter("idCorrida"));
		
		InscricaoCorridaDao dao = new InscricaoCorridaDao();
		CavaloDao c = new CavaloDao();
		CorridaDao cr = new CorridaDao();
		
		boolean alterado = false;
		
		try {
			InscricaoCorrida inscricao = dao.buscarUm(id);
			inscricao.setCavalo(c.buscarUm(idCavalo));
			inscricao.setCorrida(cr.buscarUm(idCorrida));
			dao.alterar(inscricao);
			alterado = true;
			request.setAttribute("inscricao", inscricao);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("alterado", alterado);
			RequestDispatcher rd = request.getRequestDispatcher("inscricaoCavalo/index.jsp");
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
