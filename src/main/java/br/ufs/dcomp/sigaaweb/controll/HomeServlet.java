package br.ufs.dcomp.sigaaweb.controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufs.dcomp.sigaaweb.model.Semestre;
import br.ufs.dcomp.sigaaweb.service.SemestreService;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet(name = "homeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Semestre> semestre;
	SemestreService semestreService = new SemestreService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.semestre = semestreService.buscarSemestre();
		
		HttpSession session = req.getSession();
		session.setAttribute("semestre", this.semestre);
		
		resp.sendRedirect("home/home.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
