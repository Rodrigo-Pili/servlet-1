package br.com.caelum.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private static Integer chaveSequencial = 1;

	static {

		Empresa empresa = new Empresa("Alura");
		empresa.setId(chaveSequencial++);
		Banco.lista.add(empresa);
		Empresa empresa2 = new Empresa("Caelum");
		empresa2.setId(chaveSequencial++);
		Banco.lista.add(empresa2);

		Usuario usuario = new Usuario("nico", "12345");
		Banco.listaUsuarios.add(usuario);
		Usuario usuario2 = new Usuario("ana", "12345");
		Banco.listaUsuarios.add(usuario2);
		
	}

	public void adiciona(Empresa empresa) {

		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);

	}

	public List<Empresa> getEmpresas() {

		return Banco.lista;

	}

	public void removeEmpresa(Integer id) {

		Iterator<Empresa> it = lista.iterator();

		while (it.hasNext()) {
			Empresa emp = it.next();

			if (emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaPeloId(Integer id) {

		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {

		for (Usuario usuario : listaUsuarios) {
			
			if(usuario.ehIgual(login, senha)) {
				
				return usuario;
			
			}
		}
		
		return null;
	}
	
}
