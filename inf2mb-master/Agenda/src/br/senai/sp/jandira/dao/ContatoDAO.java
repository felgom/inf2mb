package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.dbUtils.Conexao;
import br.senai.sp.jandira.model.Contato;

public class ContatoDAO {
	private Contato contato;
	private PreparedStatement stm;
	private ResultSet rs;
	
	public void gravar(){
		String sql = "INSERT INTO contatos(nome, dtNasc, email, endereco, telefone, celular, sexo)"
				+ "VALUES(?, ? , ?, ?, ?, ?, ?)";
		
		
		stm = null;
		
		try {
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getDtNasc());
			stm.setString(3, contato.getEmail());
			stm.setString(4, contato.getEndereco());
			stm.setString(5, contato.getTelefone());
			stm.setString(6, contato.getCelular());
			stm.setString(7, contato.getSexo());
			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Contato gravado com sucelso", "Gravação", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
				
	}

	public void atualizar(int id){
		String sql = "UPDATE contatos SET nome = ?, dtNasc = ?, email = ?, endereco = ?, telefone = ?, celular = ?, sexo = ? WHERE id = ?";
		
		
		stm = null;
		
		try {
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getDtNasc());
			stm.setString(3, contato.getEmail());
			stm.setString(4, contato.getEndereco());
			stm.setString(5, contato.getTelefone());
			stm.setString(6, contato.getCelular());
			stm.setString(7, contato.getSexo());
			stm.setInt(8, id);
			
			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Contato editado com sucelso", "Edição", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void excluir(int id){
		String sql = "DELETE FROM contatos WHERE id = ?";
		
		
		stm = null;
		
		try {
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setInt(1, id);
			
			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Contato deletado com sucelso", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public Contato getContato(int id){
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contato = new Contato();
		String sql ="SELECT * FROM contatos WHERE id = ?";
		try{
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			rs.next();
			
			contato.setId(rs.getInt("id"));
			contato.setNome(rs.getString("nome"));
			contato.setDtNasc(df.format(rs.getDate("dtNasc")));
			contato.setEmail(rs.getString("email"));
			contato.setCelular(rs.getString("celular"));
			contato.setEndereco(rs.getString("endereco"));
			contato.setTelefone(rs.getString("telefone"));
			contato.setSexo(rs.getString("sexo"));
			Conexao.abrirConexao().close();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		return contato;
	}
	public ArrayList<Contato> getContatos(){
		ArrayList<Contato> contatos = new ArrayList<>();
		
		String sql = "SELECT * FROM contatos ORDER BY nome";
		
		stm = null;	
		rs= null;
		
		try{
			stm = Conexao.abrirConexao().prepareStatement(sql);
			rs = stm.executeQuery();
			
			while(rs.next()){
				contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setDtNasc(rs.getString("dtNasc"));
				contato.setEmail(rs.getString("email"));
				contato.setCelular(rs.getString("celular"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setSexo(rs.getString("sexo"));
				
				contatos.add(contato);
			}
			Conexao.abrirConexao().close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
		return contatos;
		
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
}
