package br.ufs.dcomp.sigaaweb.controll;

import br.ufs.dcomp.sigaaweb.model.AlunoBean;
import br.ufs.dcomp.sigaaweb.model.SemestreBean;
import br.ufs.dcomp.sigaaweb.service.AlunoService;
import br.ufs.dcomp.sigaaweb.service.SemestreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SemestreService semestreService = new SemestreService();
    private AlunoService alunoService = new AlunoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SemestreBean> semestre = semestreService.buscarSemestre();

        HttpSession session = req.getSession();
        session.setAttribute("semestre", semestre);

        resp.sendRedirect("home/home.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
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