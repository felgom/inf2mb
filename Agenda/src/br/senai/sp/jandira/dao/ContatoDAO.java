package br.senai.sp.jandira.dao;

import java.util.ArrayList;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import br.senai.sp.jandira.model.Contato;

public class ContatoDAO {

	private Contato contato;
	
	public void gravar () {
		String sql = "INSERT INTO contatos"
				+ "(nome, dtNasc, email, endereco, telefone, celular, sexo)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	}
	
	
	
	public void atualizar () {
		
	}
	
	public void excluir () {
		
	}
	
	public Contato getContato (int id){
		
		return contato;
	}


	public ArrayList<Contato> getContatos (){
	
		ArrayList<Contato> contatos = new ArrayList<>();
		
		return contatos;
	}
	

}

