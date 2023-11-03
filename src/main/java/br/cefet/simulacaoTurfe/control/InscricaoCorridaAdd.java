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
import br.cefet.simulacaoTurfe.model.Cavalo;
import br.cefet.simulacaoTurfe.model.Corrida;
import br.cefet.simulacaoTurfe.model.InscricaoCorrida;

/**
 * Servlet implementation class InscricaoCorridaAdd
 */
public class InscricaoCorridaAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscricaoCorridaAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCavalo = Integer.valueOf(request.getParameter("idCavalo"));
		int idCorrida = Integer.valueOf(request.getParameter("idCorrida"));
		
		CavaloDao caDao = new CavaloDao();
		Cavalo cavalo = null;
		
		try {
			cavalo = caDao.buscarUm(idCavalo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		CorridaDao coDao = new CorridaDao();
		Corrida corrida = null;
		
		try {
			corrida = coDao.buscarUm(idCorrida);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		InscricaoCorrida inscricao = new InscricaoCorrida(cavalo, corrida);
		
		boolean inscricaoCadastrada = true;
		request.setAttribute("inscricaoCadastrada", inscricaoCadastrada);
		request.setAttribute("inscricao", inscricao);
		
		InscricaoCorridaDao iDao = new InscricaoCorridaDao();
		
		try {
			iDao.adicionar(inscricao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("CavaloList?next=CorridaList?next=cavalo/inscricaoCorrida.jsp");
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
