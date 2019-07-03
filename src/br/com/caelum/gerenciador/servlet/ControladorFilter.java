package br.com.caelum.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.acao.Acao;

//@WebFilter("/entrada")
public class ControladorFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		System.out.println("ControladorFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramAcao = request.getParameter("acao");

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