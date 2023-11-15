package br.cefet.simulacaoTurfe.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import br.cefet.simulacaoTurfe.dao.ProprietarioDao;
import br.cefet.simulacaoTurfe.model.Proprietario;

/**
 * Servlet implementation class ProprietarioUpdate
 */
public class ProprietarioUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProprietarioUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String senha = request.getParameter("senha");
		
		
		Proprietario p = null;
		ProprietarioDao dao = new ProprietarioDao();
		
		boolean alterado = false;
		
		try {
			p = dao.buscarUm(id);
			p.setCpf(cpf);
			p.setEmail(email);
			p.setNome(nome);
			p.setTelefone(telefone);
			p.setSenha(senha);
			dao.alterar(p);
			alterado = true;
			request.setAttribute("proprietario", p);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("proprietarioAlterado", alterado);
			RequestDispatcher rd = request.getRequestDispatcher("proprietario/atualizar.jsp");
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
