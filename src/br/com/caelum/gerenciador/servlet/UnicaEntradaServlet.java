package br.com.caelum.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.acao.Acao;

//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		
//		HttpSession sessao = request.getSession();
//		boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado") == null;
//		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//
//		if (ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
//
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//
//		}
		
		String nomeClasse = "br.com.caelum.gerenciador.acao." + paramAcao;

		String nomeDoJsp;

		try {

			Class classe = Class.forName(nomeClasse);// carrega a classe com o nome da String nomeClasse
			Acao acao = (Acao) classe.newInstance();
			nomeDoJsp = acao.executa(request, response);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {

			throw new ServletException(e);

		}

		String[] tipoEEndereco = nomeDoJsp.split(":");

		if (tipoEEndereco[0].equals("forward")) {

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);

		} else {

			response.sendRedirect(tipoEEndereco[1]);

		}

	}

}
