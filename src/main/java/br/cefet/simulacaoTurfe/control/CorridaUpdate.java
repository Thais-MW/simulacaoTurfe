package br.cefet.simulacaoTurfe.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import br.cefet.simulacaoTurfe.dao.CorridaDao;
import br.cefet.simulacaoTurfe.model.Corrida;

/**
 * Servlet implementation class CorridaUpdate
 */
public class CorridaUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorridaUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Float taxaInscricao = Float.valueOf(request.getParameter("taxaInscricao"));
		String stringDataHora = request.getParameter("dataHora");
		java.time.LocalDateTime javaDataHora = java.time.LocalDateTime.parse(stringDataHora);
		java.sql.Timestamp dataHora = java.sql.Timestamp.valueOf(javaDataHora);
		
		Corrida c = null;
		CorridaDao dao = new CorridaDao();
		boolean alterado = false;
		
		try {
			c = dao.buscarUm(id);
			c.setData(dataHora);
			c.setInscricao(taxaInscricao);
			dao.alterar(c);
			alterado = true;
			request.setAttribute("corrida", c);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("alterado", alterado);
			RequestDispatcher rd = request.getRequestDispatcher("corrida/atualizar.jsp");
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
