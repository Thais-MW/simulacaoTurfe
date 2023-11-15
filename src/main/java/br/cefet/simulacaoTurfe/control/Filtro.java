package br.cefet.simulacaoTurfe.control;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import br.cefet.simulacaoTurfe.model.Usuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Filtro
 */
@WebFilter("/*")
public class Filtro extends HttpFilter implements Filter {
       
	
	/*
	 * Se for trocado a url desses arquivos deve ser mudado aqui tbm pois ne são o filtro não vai funcionar corretamente
	 * */
	public static final String urlLogin = "/simulacaoTurfe/login/index.jsp";
	public static final String urlMainJs = "/simulacaoTurfe/scripts/main.js";
	public static final String urlError = "/simulacaoTurfe/error/index.jsp";
	public static final String urlCadastroUsuario = "/simulacaoTurfe/UsuarioAdd";
	public static final String urlLoginUsuario = "/simulacaoTurfe/UsuarioLogin";
	public static final String urlRedirect = urlLogin;
	public static final String[] urlsValidasSemLogin = {urlLogin, urlMainJs, urlError, urlCadastroUsuario, urlLoginUsuario};
    /**
     * @see HttpFilter#HttpFilter()
     */
    public Filtro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest rqt = (HttpServletRequest) request;
		HttpServletResponse rsp = (HttpServletResponse) response;
		
		String url = rqt.getRequestURI();
		HttpSession session = rqt.getSession();
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		
		if (autorizado(usuario, url)) {			
			chain.doFilter(rqt, rsp);
			return;
		}
		
		rsp.sendRedirect(urlRedirect);
	}
	
	public boolean autorizado(Usuario usuario, String url) {
		if (usuario == null) {
			if (urlValidaSemLogin(url)) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
	
	public boolean urlValidaSemLogin(String url) {
		
		for(int i = 0; i < urlsValidasSemLogin.length; i++) {
			if (url.equals(urlsValidasSemLogin[i])) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
