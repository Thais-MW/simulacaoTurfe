package br.cefet.simulacaoTurfe.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.cefet.simulacaoTurfe.dao.ProprietarioDao;
import br.cefet.simulacaoTurfe.model.Proprietario;

/**
 * Servlet implementation class ProprietarioPrepare
 */
public class ProprietarioPrepare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProprietarioPrepare() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String next = "proprietario/atualizar.jsp";
		Proprietario p = null;
		ProprietarioDao dao = new ProprietarioDao();
		
		try {
			p = dao.buscarUm(id);
			if (p == null) {
				throw new Exception("Proprietário não encontrado.");
			}
			request.setAttribute("proprietario", p);
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
