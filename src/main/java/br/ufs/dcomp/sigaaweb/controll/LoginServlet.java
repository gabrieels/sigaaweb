package br.ufs.dcomp.sigaaweb.controll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		out.println("Ola: " + nome);

	}

}
