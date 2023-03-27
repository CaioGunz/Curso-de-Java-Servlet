package br.com.caio.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caio.gerenciador.acao.AlteraEmpresa;
import br.com.caio.gerenciador.acao.ListaEmpresa;
import br.com.caio.gerenciador.acao.MostraEmpresa;
import br.com.caio.gerenciador.acao.NovaEmpresa;
import br.com.caio.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao =  request.getParameter("acao");
		
		if(paramAcao.equals("ListaEmpresa")) {
			
			ListaEmpresa acao = new ListaEmpresa();
			acao.executa(request, response);
			
		} else if(paramAcao.equals("RemoveEmpresa")) {
			
			RemoveEmpresa acao = new RemoveEmpresa();
			acao.excuta(request, response);
			
		} else if(paramAcao.equals("MostraEmpresa")) {
			
			MostraEmpresa acao = new MostraEmpresa();
			acao.executa(request, response);
		} else if(paramAcao.equals("AlteraEmpresa")) {
			
			AlteraEmpresa acao  = new AlteraEmpresa();
			acao.excuta(request, response);
		} else if(paramAcao.equals("NovaEmpresa")) {
			
			NovaEmpresa acao  = new NovaEmpresa();
			acao.excuta(request, response);
		}
	}

}
