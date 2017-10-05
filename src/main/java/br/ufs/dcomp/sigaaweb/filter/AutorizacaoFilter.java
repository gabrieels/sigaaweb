package br.ufs.dcomp.sigaaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufs.dcomp.sigaaweb.model.AlunoBean;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
@WebFilter(filterName = "AutorizacaoFilter", urlPatterns = { "/home/*" })
public class AutorizacaoFilter implements Filter {
	private final String URL_ROOT = "/sigaaweb";
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		AlunoBean alunoBean = (AlunoBean) session.getAttribute("alunoLogado");
		
		if (alunoBean == null) {
			session.invalidate();
			//req.getRequestDispatcher("/").forward(request, response);
			res.sendRedirect(URL_ROOT);
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
