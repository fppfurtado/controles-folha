package mppa.folha.controle;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mppa.folha.dao.DAO;
import mppa.folha.dao.PessoaFisicaDao;
import mppa.folha.modelo.PessoaFisica;

@WebServlet(urlPatterns = { "/pessoa-fisica/*" })
public class PessoaFisicaServlet extends HttpServlet {

	DAO<PessoaFisica> dao = PessoaFisicaDao.getInstancia();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURI().substring(req.getContextPath().length() + 1);
		String[] componentesUrl = url.split("/");
		
		DAO<PessoaFisica> dao = PessoaFisicaDao.getInstancia();

		switch (componentesUrl[componentesUrl.length-1]) {

		case "novo":

			req.setAttribute("pessoaFisica", new PessoaFisica());
			req.getRequestDispatcher("/WEB-INF/jsp/form-pessoa-fisica.jsp").forward(req, resp);

			break;

		case "criar":

			try {
				req.setAttribute("pessoaFisica", criarPessoaFisica(req.getParameterMap()));
				resp.sendRedirect("listar");
			} catch (Exception e) {
				tratarExcecao(e, req, resp);
			}
			
			break;

		case "editar":

			req.setAttribute("pessoaFisica", buscarPessoaFisica(req.getParameter("id")));
			req.getRequestDispatcher("/WEB-INF/jsp/form-pessoa-fisica.jsp").forward(req, resp);
			break;

		case "atualizar":

			try {
				atualizarPessoaFisica(req.getParameterMap());
				resp.sendRedirect("listar");
			} catch (Exception e) {
				tratarExcecao(e, req, resp);
			}
			break;

		case "remover":

			removerPessoaFisica(req.getParameter("id"));
			resp.sendRedirect("listar");
			break;
			
		case "vinculos-funcionais":
			
			req.setAttribute("pessoaFisica", buscarPessoaFisica(req.getParameter("id")));
			req.getRequestDispatcher("/WEB-INF/jsp/lista-vinculos-funcionais");
			break;

		case "listar":

			req.getRequestDispatcher("/WEB-INF/jsp/lista-pessoa-fisica.jsp").forward(req, resp);
			break;

		default:
			resp.sendRedirect("/controles-folha/pessoa-fisica/listar");
		}

	}

	private PessoaFisica criarPessoaFisica(Map<String, String[]> parametros) throws IllegalArgumentException, ParseException {

		PessoaFisica pessoaFisica = new PessoaFisica()
				.setNome(parametros.get("nome")[0])
				.setDataNascimento(parametros.get("data_nascimento")[0])
				.setSexo(parametros.get("sexo")[0])
				.setCPF(parametros.get("cpf")[0]);

		return dao.criar(pessoaFisica);
		
	}

	private void removerPessoaFisica(String id) {

		dao.excluir(buscarPessoaFisica(id));

	}

	private void atualizarPessoaFisica(Map<String, String[]> parametros)
			throws IllegalArgumentException, ParseException {

		PessoaFisica pessoaFisica = buscarPessoaFisica(parametros.get("id")[0]);

		pessoaFisica.setNome(parametros.get("nome")[0])
		.setDataNascimento(parametros.get("data_nascimento")[0])
		.setSexo(parametros.get("sexo")[0])
		.setCPF(parametros.get("cpf")[0]);

		dao.atualizar(pessoaFisica);

	}

	private PessoaFisica buscarPessoaFisica(String id) {

		return dao.buscar(Long.parseLong(id));

	}
	
	private void tratarExcecao(Exception e, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setAttribute("erro", e.getMessage());
		req.getRequestDispatcher("/WEB-INF/jsp/erro.jsp").forward(req, resp);

	}
	
}