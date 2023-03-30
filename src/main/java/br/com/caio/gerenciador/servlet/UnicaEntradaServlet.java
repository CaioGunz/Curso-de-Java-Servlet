package br.com.caio.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caio.gerenciador.acao.Acao;
import br.com.caio.gerenciador.acao.AlteraEmpresa;
import br.com.caio.gerenciador.acao.ListaEmpresa;
import br.com.caio.gerenciador.acao.MostraEmpresa;
import br.com.caio.gerenciador.acao.NovaEmpresa;
import br.com.caio.gerenciador.acao.NovaEmpresaForm;
import br.com.caio.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao =  request.getParameter("acao");
		
		String nomeDaClasse = "br.com.caio.gerenciador.acao." + paramAcao;
		
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEndereco =  nome.split(":");
		if(tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}
		
		/* paramAcao.executa(req,res)
		
		String nome = null;
		if(paramAcao.equals("ListaEmpresa")) {
			
			ListaEmpresa acao = new ListaEmpresa();
			nome = acao.executa(request, response);
			
		} else if(paramAcao.equals("RemoveEmpresa")) {
			
			RemoveEmpresa acao = new RemoveEmpresa();
			nome = acao.excuta(request, response);
			
		} else if(paramAcao.equals("MostraEmpresa")) {
			
			MostraEmpresa acao = new MostraEmpresa();
			nome = acao.executa(request, response);
		} else if(paramAcao.equals("AlteraEmpresa")) {
			
			AlteraEmpresa acao  = new AlteraEmpresa();
			nome = acao.excuta(request, response);
		} else if(paramAcao.equals("NovaEmpresa")) {
			
			NovaEmpresa acao  = new NovaEmpresa();
			nome = acao.excuta(request, response);
		} else if (paramAcao.equals("NovaEmpresaForm")) {
			NovaEmpresaForm	acao = new NovaEmpresaForm();
			nome = acao.excuta(request, response);
		}  */

	}

}
