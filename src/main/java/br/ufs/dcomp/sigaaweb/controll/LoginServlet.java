package br.ufs.dcomp.sigaaweb.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufs.dcomp.sigaaweb.model.AlunoBean;
import br.ufs.dcomp.sigaaweb.service.AlunoService;

@WebServlet(name = "loginServlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL_ROOT = "/sigaaweb";
	AlunoService alunoService;
	AlunoBean alunoBean;
	RequestDispatcher dispatcher;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			alunoBean = new AlunoBean();
			alunoService = new AlunoService();
			long matricula = Long.parseLong(req.getParameter("usermatricula"));

			alunoBean = alunoService.autenticar(matricula);
			if (alunoBean != null) {
				HttpSession session = req.getSession(true);
				session.setAttribute("alunoLogado", alunoBean);

				resp.sendRedirect("/home");
			} else {
				req.setAttribute("msgError", "Matrícula inválida!");
				resp.sendRedirect( URL_ROOT + "/login");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
