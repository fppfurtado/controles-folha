package mppa.folha.controle;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mppa.folha.dao.CargoDao;
import mppa.folha.dao.DAO;
import mppa.folha.dao.PessoaFisicaDao;
import mppa.folha.dao.PessoaJuridicaDao;
import mppa.folha.dao.VinculoFuncionalDao;
import mppa.folha.modelo.Cargo;
import mppa.folha.modelo.PessoaFisica;
import mppa.folha.modelo.PessoaJuridica;
import mppa.folha.modelo.VinculoFuncional;

@WebServlet(urlPatterns = { "/pessoa-juridica/vinculos-funcionais/*" })
public class VinculoFuncionalServlet extends HttpServlet {

	DAO<VinculoFuncional> dao = VinculoFuncionalDao.getInstancia();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURI().substring(req.getContextPath().length() + 1);
		String[] componentesUrl = url.split("/");
		
		DAO<VinculoFuncional> dao = VinculoFuncionalDao.getInstancia();
	
		switch (componentesUrl[componentesUrl.length-1]) {

		case "novo":

			PessoaJuridica pj = PessoaJuridicaDao.getInstancia().buscar(Long.parseLong(req.getParameter("id_pj")));
			req.setAttribute("vinculoFuncional", new VinculoFuncional().setPessoa_juridica(pj));
			req.getRequestDispatcher("/WEB-INF/jsp/form-vinculo-funcional.jsp").forward(req, resp);

			break;

		case "criar":
		
			try {
				criarVinculoFuncional(req.getParameterMap());
				resp.sendRedirect("listar?id_pj="+req.getParameter("id_pj"));
			} catch (Exception e) {
				tratarExcecao(e, req, resp);
			}
			
			break;

		case "editar":
			
			req.setAttribute("vinculoFuncional", buscarVinculoFuncional(req.getParameter("id")));
			req.getRequestDispatcher("/WEB-INF/jsp/form-vinculo-funcional.jsp").forward(req, resp);
			break;

		case "atualizar":

			try {
				atualizarVinculoFuncional(req.getParameterMap());
				resp.sendRedirect("listar?id_pj="+req.getParameter("pessoa_juridica"));
			} catch (Exception e) {
				tratarExcecao(e, req, resp);
			}
			break;

		case "remover":
			
			VinculoFuncional vinculoFuncional = VinculoFuncionalDao.getInstancia().buscar(Long.parseLong(req.getParameter("id")));

			removerVinculoFuncional(req.getParameter("id"));
			resp.sendRedirect("listar?id_pj="+vinculoFuncional.getPessoa_juridica().getId());
			break;
			
		case "listar":
			
			PessoaJuridica pessoaJuridica = PessoaJuridicaDao.getInstancia().buscar(Long.parseLong(req.getParameter("id_pj")));
			
			req.setAttribute("pj", pessoaJuridica);
			req.getRequestDispatcher("/WEB-INF/jsp/lista-vinculos-funcionais.jsp").forward(req, resp);
			break;

		default:
			resp.sendRedirect("/controles-folha/pessoa-juridica/vinculos/listar");
		}

	}

	private VinculoFuncional criarVinculoFuncional(Map<String, String[]> parametros) throws IllegalArgumentException, ParseException {

		PessoaJuridica pessoaJuridica = PessoaJuridicaDao
				.getInstancia()
				.buscar(Long.parseLong(parametros.get("id_pj")[0]));
		
		PessoaFisica pessoaFisica = PessoaFisicaDao
				.getInstancia()
				.buscar(Long.parseLong(parametros.get("pessoa_fisica")[0]));
		
		Cargo cargo = CargoDao
				.getInstancia()
				.buscar(Long.parseLong(parametros.get("cargo")[0]));

		
		VinculoFuncional vinculoFuncional = new VinculoFuncional()
				.setPessoa_juridica(pessoaJuridica)
				.setPessoa_fisica(pessoaFisica)
				.setCargo(cargo)
				.setMatricula(parametros.get("matricula")[0])
				.setData_inicio(parametros.get("data_inicio")[0])
				.setData_fim(parametros.get("data_fim")[0]);

		return dao.criar(vinculoFuncional);
		
	}

	private void removerVinculoFuncional(String id) {

		dao.excluir(buscarVinculoFuncional(id));

	}

	private void atualizarVinculoFuncional(Map<String, String[]> parametros)
			throws IllegalArgumentException, ParseException {

		PessoaJuridica pessoaJuridica = PessoaJuridicaDao
				.getInstancia()
				.buscar(Long.parseLong(parametros.get("pessoa_juridica")[0]));
		
		PessoaFisica pessoaFisica = PessoaFisicaDao
				.getInstancia()
				.buscar(Long.parseLong(parametros.get("pessoa_fisica")[0]));
		
		Cargo cargo = CargoDao
				.getInstancia()
				.buscar(Long.parseLong(parametros.get("cargo")[0]));

		
		VinculoFuncional vinculoFuncional = dao.buscar(Long.parseLong(parametros.get("id")[0]))
				.setPessoa_juridica(pessoaJuridica)
				.setPessoa_fisica(pessoaFisica)
				.setCargo(cargo)
				.setMatricula(parametros.get("matricula")[0])
				.setData_inicio(parametros.get("data_inicio")[0])
				.setData_fim(parametros.get("data_fim")[0]);

		dao.atualizar(vinculoFuncional);

	}

	private VinculoFuncional buscarVinculoFuncional(String id) {

		return dao.buscar(Long.parseLong(id));

	}
	
	private void tratarExcecao(Exception e, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setAttribute("erro", e.getMessage());
		req.getRequestDispatcher("/WEB-INF/jsp/erro.jsp").forward(req, resp);

	}
	
}