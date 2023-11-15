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
 * Servlet implementation class CavaloUpdate
 */
public class CavaloUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CavaloUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		int numero = Integer.valueOf(request.getParameter("numero"));
		String cor = request.getParameter("cor");
		float preco = Float.valueOf(request.getParameter("preco"));
		int velocidade = Integer.valueOf(request.getParameter("velocidade"));
		int resistencia = Integer.valueOf(request.getParameter("resistencia"));
		int idProprietario = Integer.valueOf(request.getParameter("idProprietario"));
		
		ProprietarioDao pDao = new ProprietarioDao();
		Proprietario proprietario = null;
		CavaloDao cDao = new CavaloDao();
		
		boolean alterado = false;
		
		try {
			proprietario = pDao.buscarUm(idProprietario);
			Cavalo cavalo = cDao.buscarUm(id);
			cavalo.setNome(nome);
			cavalo.setNumero(numero);
			cavalo.setCor(cor);
			cavalo.setPreco(preco);
			cavalo.setVelocidade(velocidade);
			cavalo.setResistencia(resistencia);
			cavalo.setProprietario(proprietario);

			cDao.alterar(cavalo);
			alterado = true;
			
			request.setAttribute("cavalo", cavalo);
			request.setAttribute("proprietarios", pDao.listarTodos());
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			request.setAttribute("alterado", alterado);
			RequestDispatcher rd = request.getRequestDispatcher("cavalo/atualizar.jsp");
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
