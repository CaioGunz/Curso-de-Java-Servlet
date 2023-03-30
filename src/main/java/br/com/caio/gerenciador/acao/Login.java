package br.com.caio.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caio.gerenciador.servlet.modelo.Banco;
import br.com.caio.gerenciador.servlet.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		System.out.println("Logando " + login);
		
		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(login, senha);
		
		if(usuario != null) {
			System.out.println("Usuario existe");
			return "redirect:entrada?acao=ListaEmpresa";
		} else {
			return "redirect:entrada?acao=LoginForm";
		}
	
	}

}
