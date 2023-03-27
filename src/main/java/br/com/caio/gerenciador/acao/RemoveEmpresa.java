package br.com.caio.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caio.gerenciador.servlet.modelo.Banco;

public class RemoveEmpresa {

	public void excuta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("Removendo empresa");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		banco.removeEmpresa(id);
		
		response.sendRedirect("entrada?acao=ListaEmpresa");
		
	}
	
}
