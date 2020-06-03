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
import mppa.folha.dao.UnidadeAdmDao;
import mppa.folha.modelo.UnidadeAdministrativa;
import mppa.folha.modelo.enumeracoes.FormasNomeacao;

@WebServlet(urlPatterns = { "/unidade-adm/*" })
public class UnidadeAdministrativaServlet extends HttpServlet {

	DAO<UnidadeAdministrativa> dao = UnidadeAdmDao.getInstancia();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURI().substring(req.getContextPath().length() + 1);
		String[] componentesUrl = url.split("/");
		
		DAO<UnidadeAdministrativa> dao = UnidadeAdmDao.getInstancia();

		switch (componentesUrl[componentesUrl.length-1]) {

		case "novo":

			req.setAttribute("unidadeAdm", new UnidadeAdministrativa());
			req.getRequestDispatcher("/WEB-INF/jsp/form-unidade-adm.jsp").forward(req, resp);

			break;

		case "criar":

			try {
				req.setAttribute("unidadeAdm", criarUnidadeAdministrativa(req.getParameterMap()));
				resp.sendRedirect("listar");
			} catch (Exception e) {
				tratarExcecao(e, req, resp);
			}
			
			break;

		case "editar":

			req.setAttribute("unidadeAdm", buscarUnidadeAdministrativa(req.getParameter("id")));
			req.getRequestDispatcher("/WEB-INF/jsp/form-unidade-adm.jsp").forward(req, resp);
			break;

		case "atualizar":

			try {
				atualizarUnidadeAdministrativa(req.getParameterMap());
				resp.sendRedirect("listar");
			} catch (Exception e) {
				tratarExcecao(e, req, resp);
			}
			break;

		case "remover":

			removerUnidadeAdministrativa(req.getParameter("id"));
			resp.sendRedirect("listar");
			break;

		case "listar":

			req.getRequestDispatcher("/WEB-INF/jsp/lista-unidade-adm.jsp").forward(req, resp);
			break;

		default:
			resp.sendRedirect("/controles-folha/unidade-adm/listar");
		}

	}

	private UnidadeAdministrativa criarUnidadeAdministrativa(Map<String, String[]> parametros) throws IllegalArgumentException, ParseException {

		UnidadeAdministrativa unidadeAdm = new UnidadeAdministrativa()
				.setDenominacao(parametros.get("denominacao")[0]);
		
		return dao.criar(unidadeAdm);
		
	}

	private void removerUnidadeAdministrativa(String id) {

		dao.excluir(buscarUnidadeAdministrativa(id));

	}

	private void atualizarUnidadeAdministrativa(Map<String, String[]> parametros)
			throws IllegalArgumentException, ParseException {

		UnidadeAdministrativa unidadeAdm = buscarUnidadeAdministrativa(parametros.get("id")[0]);

		unidadeAdm.setDenominacao(parametros.get("denominacao")[0]);
		
		dao.atualizar(unidadeAdm);

	}

	private UnidadeAdministrativa buscarUnidadeAdministrativa(String id) {

		return dao.buscar(Long.parseLong(id));

	}
	
	private void tratarExcecao(Exception e, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setAttribute("erro", e.getMessage());
		req.getRequestDispatcher("/WEB-INF/jsp/erro.jsp").forward(req, resp);

	}
	
}