package br.ufs.dcomp.sigaaweb.controll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufs.dcomp.sigaaweb.model.AlunoBean;
import br.ufs.dcomp.sigaaweb.model.SemestreBean;
import br.ufs.dcomp.sigaaweb.service.AlunoService;
import br.ufs.dcomp.sigaaweb.service.SemestreService;

/**
* Servlet implementation class HomeServlet
*/
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
	public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<SemestreBean> semestre;
	private SemestreService semestreService = new SemestreService();
	private AlunoService alunoService = new AlunoService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.semestre = semestreService.buscarSemestre();

		HttpSession session = req.getSession();
		session.setAttribute("semestre", this.semestre);

		resp.sendRedirect("home/home.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = null;
		try {
			out = resp.getWriter();
			String[] data = req.getParameter("primary").split(";");

			AlunoBean alunoBean = (AlunoBean) req.getSession().getAttribute("alunoLogado");
			List<AlunoBean> alunoBeans = alunoService.buscarAlunosByDisciplinaByTurma(data[0], data[1]);

			alunoBeans.add(alunoBean);

			req.setAttribute("alunosTurma", alunoBeans);

			req.getRequestDispatcher("home/turma.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}