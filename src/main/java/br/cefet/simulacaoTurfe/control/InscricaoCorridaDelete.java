package br.cefet.simulacaoTurfe.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import br.cefet.simulacaoTurfe.dao.InscricaoCorridaDao;
import br.cefet.simulacaoTurfe.model.InscricaoCorrida;

/**
 * Servlet implementation class InscricaoCorridaDelete
 */
public class InscricaoCorridaDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscricaoCorridaDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		InscricaoCorridaDao dao = new InscricaoCorridaDao();
		boolean apagado = false;
		
		try {
			dao.apagar(id);
			InscricaoCorrida p = dao.buscarUm(id);
			if (p == null) {
				apagado = true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("apagado", apagado);
			RequestDispatcher rd = request.getRequestDispatcher("InscricaoCorridaList?next=corrida/inscricoes.jsp");
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
