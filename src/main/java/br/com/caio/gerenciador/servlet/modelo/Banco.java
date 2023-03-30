package br.com.caio.gerenciador.servlet.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista =  new ArrayList<>();
	private static List<Usuario> listaUsuario =  new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("GunzFarm");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa.setNome("Tempeiro da Z7");
		lista.add(empresa);
		lista.add(empresa2);
		
		Usuario usuario1 = new Usuario();
		usuario1.setLogin("Caio");
		usuario1.setSenha("12345");
		Usuario usuario2 = new Usuario();
		usuario2 .setLogin("Joelma");
		usuario2.setSenha("123");
		
		listaUsuario.add(usuario1);
		listaUsuario.add(usuario2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		lista.add(empresa);
	}

	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		
		Iterator<Empresa> it = lista.iterator();
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaPeloId(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for(Usuario u : listaUsuario) {
			if(u.ehIgual(login, senha)) {
				return u;
			}
		}
		return null;
	}
	
}
