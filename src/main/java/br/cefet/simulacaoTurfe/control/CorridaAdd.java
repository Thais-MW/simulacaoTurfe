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
 * Servlet implementation class CorridaAdd
 */
public class CorridaAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CorridaAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Float taxaInscricao = Float.valueOf(request.getParameter("taxaInscricao"));
		String stringDataHora = request.getParameter("dataHora");
		java.time.LocalDateTime javaDataHora = java.time.LocalDateTime.parse(stringDataHora);
		java.sql.Timestamp dataHora = java.sql.Timestamp.valueOf(javaDataHora);

		Corrida corrida = new Corrida(dataHora, taxaInscricao);

		boolean corridaCadastrada = true;
		request.setAttribute("corridaCadastrada", corridaCadastrada);
		request.setAttribute("corrida", corrida);

		CorridaDao cDao = new CorridaDao();

		try {
			cDao.adicionar(corrida);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("corrida/cadastro.jsp");
		rd.forward(request, response);
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

}
