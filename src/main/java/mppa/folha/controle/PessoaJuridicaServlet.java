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
import mppa.folha.dao.PessoaJuridicaDao;
import mppa.folha.modelo.PessoaJuridica;
import mppa.folha.modelo.enumeracoes.Esferas;
import mppa.folha.modelo.enumeracoes.Poderes;

@WebServlet(urlPatterns = { "/pessoa-juridica/*" })
public class PessoaJuridicaServlet extends HttpServlet {

	DAO<PessoaJuridica> dao = PessoaJuridicaDao.getInstancia();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURI().substring(req.getContextPath().length() + 1);
		String[] componentesUrl = url.split("/");
		
		if(componentesUrl.length == 1)
			resp.sendRedirect("pessoa-juridica/listar");

		DAO<PessoaJuridica> dao = PessoaJuridicaDao.getInstancia();

		switch (componentesUrl[1]) {

		case "novo":

			req.setAttribute("pessoaJuridica", new PessoaJuridica());
			req.getRequestDispatcher("/WEB-INF/jsp/form-pessoa-juridica.jsp").forward(req, resp);

			break;

		case "criar":

			try {
				req.setAttribute("pessoaJuridica", criarPessoaJuridica(req.getParameterMap()));
				resp.sendRedirect("listar");
			} catch (Exception e) {
				tratarExcecao(e, req, resp);
			}
			
			break;

		case "editar":

			req.setAttribute("pessoaJuridica", buscarPessoaJuridica(req.getParameter("id")));
			req.getRequestDispatcher("/WEB-INF/jsp/form-pessoa-juridica.jsp").forward(req, resp);
			break;

		case "atualizar":

			try {
				atualizarPessoaJuridica(req.getParameterMap());
				resp.sendRedirect("listar");
			} catch (Exception e) {
				tratarExcecao(e, req, resp);
			}
			break;

		case "remover":

			removerPessoaJuridica(req.getParameter("id"));
			resp.sendRedirect("listar");
			break;

		case "listar":

			req.getRequestDispatcher("/WEB-INF/jsp/lista-pessoa-juridica.jsp").forward(req, resp);
			break;

		default:
			resp.sendRedirect("listar");
		}

	}

	private PessoaJuridica criarPessoaJuridica(Map<String, String[]> parametros) throws IllegalArgumentException, ParseException {

		PessoaJuridica pessoaJuridica = new PessoaJuridica()
				.setNome_fantasia(parametros.get("nome_fantasia")[0])
				.setRazao_social(parametros.get("razao_social")[0])
				.setAcronimo(parametros.get("acronimo")[0])
				.setCnpj(parametros.get("cnpj")[0])
				.setEsfera(Esferas.valueOf(parametros.get("esfera")[0]))
				.setPoder(Poderes.valueOf(parametros.get("poder")[0]));

		return dao.criar(pessoaJuridica);
		
	}

	private void removerPessoaJuridica(String id) {

		dao.excluir(buscarPessoaJuridica(id));

	}

	private void atualizarPessoaJuridica(Map<String, String[]> parametros)
			throws IllegalArgumentException, ParseException {

		PessoaJuridica pessoaJuridica = buscarPessoaJuridica(parametros.get("id")[0]);

		pessoaJuridica.setNome_fantasia(parametros.get("nome_fantasia")[0])
		.setRazao_social(parametros.get("razao_social")[0])
		.setAcronimo(parametros.get("acronimo")[0])
		.setCnpj(parametros.get("cnpj")[0])
		.setEsfera(Esferas.valueOf(parametros.get("esfera")[0]))
		.setPoder(Poderes.valueOf(parametros.get("poder")[0]));

		dao.atualizar(pessoaJuridica);

	}

	private PessoaJuridica buscarPessoaJuridica(String id) {

		return dao.buscar(Long.parseLong(id));

	}
	
	private void tratarExcecao(Exception e, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setAttribute("erro", e.getMessage());
		req.getRequestDispatcher("/WEB-INF/jsp/erro.jsp").forward(req, resp);

	}
	
}