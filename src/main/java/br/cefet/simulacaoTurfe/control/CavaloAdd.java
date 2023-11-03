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
import br.cefet.simulacaoTurfe.dao.ProprietarioDao;
import br.cefet.simulacaoTurfe.model.Cavalo;
import br.cefet.simulacaoTurfe.model.Proprietario;

/**
 * Servlet implementation class CavaloAdd
 */
public class CavaloAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CavaloAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		int numero = Integer.valueOf(request.getParameter("numero"));
		String cor = request.getParameter("cor");
		float preco = Float.valueOf(request.getParameter("preco"));
		int velocidade = Integer.valueOf(request.getParameter("velocidade"));
		int resistencia = Integer.valueOf(request.getParameter("resistencia"));
		int idProprietario = Integer.valueOf(request.getParameter("idProprietario"));
		
		ProprietarioDao pDao = new ProprietarioDao();
		Proprietario proprietario = null;
		
		try {
			proprietario = pDao.buscarUm(idProprietario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Cavalo cavalo = new Cavalo(nome, numero, cor, preco, velocidade, resistencia, proprietario);
		
		boolean cavaloCadastrado = true;
		request.setAttribute("cavaloCadastrado", cavaloCadastrado);
		request.setAttribute("cavalo", cavalo);
		
		CavaloDao cDao = new CavaloDao();
		
		try {
			cDao.adicionar(cavalo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("ProprietarioList?next=cavalo/cadastro.jsp");
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
