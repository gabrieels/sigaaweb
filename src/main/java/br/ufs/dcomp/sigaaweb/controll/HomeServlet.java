package br.ufs.dcomp.sigaaweb.controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufs.dcomp.sigaaweb.model.AlunoBean;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet(name = "homeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//AlunoBean alunoBean = (AlunoBean) req.getSession().getAttribute("alunoLogado");
	
		resp.sendRedirect("home/home.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
