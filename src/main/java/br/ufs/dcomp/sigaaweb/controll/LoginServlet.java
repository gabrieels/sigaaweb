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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL_ROOT = "/sigaaweb";
	AlunoService alunoService;
	AlunoBean alunoBean;
	RequestDispatcher dispatcher;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("POST");
		long matricula = Long.parseLong(request.getParameter("usermatricula"));
		alunoBean = new AlunoBean();
		alunoService = new AlunoService();
		
		try {	
			alunoBean = alunoService.autenticar(matricula);

			if (alunoBean != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("alunoLogado", alunoBean);

				response.sendRedirect(URL_ROOT + "/home");

			} else {
				request.setAttribute("msgError", "matricula inválida!");
				request.getRequestDispatcher("login/login.jsp").forward(request, response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}