package br.ufs.dcomp.sigaaweb.controll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufs.dcomp.sigaaweb.dao.AlunoDao;
import br.ufs.dcomp.sigaaweb.model.AlunoBean;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	AlunoDao alunoDao = new AlunoDao();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AlunoBean alunoBean = new AlunoBean();
		
		long matricula = Long.parseLong(req.getParameter("usermatricula"));
		
		alunoBean = alunoDao.findByMatricula(matricula);

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		out.println("Ola: " + alunoBean.getNomeAluno());

	}

}
