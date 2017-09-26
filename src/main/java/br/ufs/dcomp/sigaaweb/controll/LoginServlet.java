package br.ufs.dcomp.sigaaweb.controll;

import java.io.IOException;
import java.io.PrintWriter;

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
	AlunoService alunoService;
	AlunoBean alunoBean;
	RequestDispatcher dispatcher;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/login/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try (PrintWriter out = resp.getWriter()) {
			alunoBean = new AlunoBean();
			alunoService = new AlunoService();
			long matricula = Long.parseLong(req.getParameter("usermatricula"));

			alunoBean = alunoService.autenticar(matricula);
			if (alunoBean != null) {
				HttpSession session = req.getSession(true);
				session.setAttribute("alunoLogado", alunoBean);

				req.getRequestDispatcher("login/login.jsp").forward(req, resp);
			} else {
				req.setAttribute("msgError", "Matrícula inválida!");
				resp.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
