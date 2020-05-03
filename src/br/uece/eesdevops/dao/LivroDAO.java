package br.uece.eesdevops.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.uece.eesdevops.model.Livro;
import br.uece.eesdevops.util.ConexaoFactory;

public class LivroDAO {

	private Connection con = ConexaoFactory.getConnection();
	Livro livro = null;

	public void cadastrar(Livro livro) {
		String sql = "INSERT INTO livro (titulo, autor, resumo, ano) VALUES (?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, livro.getTitulo());
			ps.setString(2, livro.getAutor());
			ps.setString(3, livro.getResumo());
			ps.setString(4, livro.getAno());

			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Livro livro) {
		String sql = "UPDATE livro SET titulo=?, autor=?, resumo=?, ano=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, livro.getTitulo());
			ps.setString(2, livro.getAutor());
			ps.setString(3, livro.getResumo());
			ps.setString(4, livro.getAno());
			ps.setInt(5, livro.getId());

			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(Livro livro){
		if (livro.getId() != null){
			atualizar(livro);
		}else{
			cadastrar(livro);
		}
	}

	public Livro buscarId(Integer id){
		Livro livro = null;
		String sql = "SELECT * FROM livro WHERE id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet resultado = ps.executeQuery();
			
			if(resultado.next()){

				livro = new Livro();
				livro.setId(resultado.getInt("id"));
				livro.setTitulo(resultado.getString("titulo"));
				livro.setAutor(resultado.getString("autor"));
				livro.setResumo(resultado.getString("resumo"));
				livro.setAno(resultado.getString("ano"));
				

				return livro;
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
	public List<Livro> buscarTodos(){
		String sql = "SELECT id, titulo, autor, resumo, ano FROM livro";
		List<Livro> livros = new ArrayList<>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()){

				Livro livro = new Livro();
				livro.setId(resultado.getInt("id"));
				livro.setTitulo(resultado.getString("titulo"));
				livro.setAutor(resultado.getString("autor"));
				livro.setResumo(resultado.getString("resumo"));
				livro.setAno(resultado.getString("ano"));
				livros.add(livro);
			}
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return livros;
	}
	
	public void deletar(Livro livro) {
		String sql = "DELETE FROM livro WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, livro.getId());

			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	

}
