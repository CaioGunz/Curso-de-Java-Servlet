package br.com.caio.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> lista =  new ArrayList<>();
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa.setNome("Tempeiro da Z7");
		lista.add(empresa);
		lista.add(empresa2);
	}
	
	public void adiciona(Empresa empresa) {
		lista.add(empresa);
	}

	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}
	
}
