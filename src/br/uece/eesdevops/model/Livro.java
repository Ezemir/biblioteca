package br.uece.eesdevops.model;

public class Livro {

	private Integer id;
	private String titulo;
	private String autor;
	private String resumo;
	private String ano;
	
	public Livro() {
		super();
	}

	public Livro(Integer id, String titulo, String autor, String resumo,
			String ano) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.resumo = resumo;
		this.ano = ano;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
}
