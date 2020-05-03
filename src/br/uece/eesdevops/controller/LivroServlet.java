package br.uece.eesdevops.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uece.eesdevops.dao.LivroDAO;
import br.uece.eesdevops.model.Livro;

@WebServlet ("/livroServlet")
public class LivroServlet extends HttpServlet{

	public LivroServlet() {
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String acao = req.getParameter("acao");
		Livro livro = new Livro();
		String id = req.getParameter("id");
		LivroDAO livroDAO = new LivroDAO();
		if(acao.equals("excluir")){

			if (id != null) {
				livro.setId(Integer.parseInt(id));
			}

			livroDAO.deletar(livro);
			req.setAttribute("mensagem", "Livro excluído com sucesso!");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/listar.jsp");
			dispatcher.forward(req, resp);
		}else if (acao.equals("editar")) {
			if (id != null) {
				livro.setId(Integer.parseInt(id));
			}
			Integer idLivro = Integer.parseInt(id);
			Livro livro1 = livroDAO.buscarId(idLivro);
			livroDAO.atualizar(livro1);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/editar.jsp");
			dispatcher.forward(req, resp);
			req.setAttribute("mensagem", "Livro atualizado com sucesso!");

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String titulo = req.getParameter("titulo");
		String autor  = req.getParameter("autor");
		String resumo = req.getParameter("resumo");
		String ano  = req.getParameter("ano");
		Livro livro = new Livro();
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setResumo(resumo);
		livro.setAno(ano);

		LivroDAO livroDAO = new LivroDAO();
		livroDAO.cadastrar(livro);
		req.setAttribute("mensagem", "Livro cadastrado com sucesso!");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cadastrar.jsp");
		dispatcher.forward(req, resp);

	}
}
