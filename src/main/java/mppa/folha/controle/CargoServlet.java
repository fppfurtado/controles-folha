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
import mppa.folha.dao.CargoDao;
import mppa.folha.modelo.Cargo;
import mppa.folha.modelo.enumeracoes.FormasNomeacao;

@WebServlet(urlPatterns = { "/cargo/*" })
public class CargoServlet extends HttpServlet {

	DAO<Cargo> dao = CargoDao.getInstancia();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURI().substring(req.getContextPath().length() + 1);
		String[] componentesUrl = url.split("/");
		
		if(componentesUrl.length == 1)
			resp.sendRedirect("cargo/listar");

		DAO<Cargo> dao = CargoDao.getInstancia();

		switch (componentesUrl[1]) {

		case "novo":

			req.setAttribute("cargo", new Cargo());
			req.getRequestDispatcher("/WEB-INF/jsp/form-cargo.jsp").forward(req, resp);

			break;

		case "criar":

			try {
				req.setAttribute("cargo", criarCargo(req.getParameterMap()));
				resp.sendRedirect("listar");
			} catch (Exception e) {
				tratarExcecao(e, req, resp);
			}
			
			break;

		case "editar":

			req.setAttribute("cargo", buscarCargo(req.getParameter("id")));
			req.getRequestDispatcher("/WEB-INF/jsp/form-cargo.jsp").forward(req, resp);
			break;

		case "atualizar":

			try {
				atualizarCargo(req.getParameterMap());
				resp.sendRedirect("listar");
			} catch (Exception e) {
				tratarExcecao(e, req, resp);
			}
			break;

		case "remover":

			removerCargo(req.getParameter("id"));
			resp.sendRedirect("listar");
			break;

		case "listar":

			req.getRequestDispatcher("/WEB-INF/jsp/lista-cargo.jsp").forward(req, resp);
			break;

		default:
			resp.sendRedirect("listar");
		}

	}

	private Cargo criarCargo(Map<String, String[]> parametros) throws IllegalArgumentException, ParseException {

		Cargo cargo = new Cargo()
				.setDenominacao(parametros.get("denominacao")[0])
				.setForma_nomeacao(FormasNomeacao.valueOf((parametros.get("forma_nomeacao")[0])));

		return dao.criar(cargo);
		
	}

	private void removerCargo(String id) {

		dao.excluir(buscarCargo(id));

	}

	private void atualizarCargo(Map<String, String[]> parametros)
			throws IllegalArgumentException, ParseException {

		Cargo cargo = buscarCargo(parametros.get("id")[0]);

		cargo.setDenominacao(parametros.get("denominacao")[0])
		.setForma_nomeacao(FormasNomeacao.valueOf(parametros.get("forma_nomeacao")[0]));

		dao.atualizar(cargo);

	}

	private Cargo buscarCargo(String id) {

		return dao.buscar(Long.parseLong(id));

	}
	
	private void tratarExcecao(Exception e, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setAttribute("erro", e.getMessage());
		req.getRequestDispatcher("/WEB-INF/jsp/erro.jsp").forward(req, resp);

	}
	
}