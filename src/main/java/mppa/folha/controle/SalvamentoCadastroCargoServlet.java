package mppa.folha.controle;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
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
import mppa.folha.modelo.Cargo;
import mppa.folha.modelo.PessoaJuridica;
import mppa.folha.modelo.enumeracoes.ESFERAS;
import mppa.folha.modelo.enumeracoes.FORMAS_NOMEACAO;
import mppa.folha.modelo.enumeracoes.PODERES;

@WebServlet("/cadastro/salvar-cargo")
public class SalvamentoCadastroCargoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String queryString = req.getQueryString();
		String[] parametrosRequisicao = queryString.split("&");

		Map<String, String> parametros = new HashMap<String, String>();
		int indice;

		for (int i = 0; i < parametrosRequisicao.length; i++) {

			indice = parametrosRequisicao[i].indexOf("=");

			parametros.put(URLDecoder.decode(parametrosRequisicao[i].substring(0, indice), "UTF-8"),
					URLDecoder.decode(parametrosRequisicao[i].substring(indice + 1), "UTF-8"));

		}
		
		try {
			
			DAO<PessoaJuridica> daoPj = PessoaJuridicaDao.getInstancia();			
			PessoaJuridica organizacao = daoPj.buscar(Long.parseLong(parametros.get("organizacao")));
			
			Cargo cargo = new Cargo()
					.setDenominacao(parametros.get("denominacao"))
					.setForma_nomeacao(FORMAS_NOMEACAO.valueOf(parametros.get("forma_nomeacao")))
					.setOrganizacao(organizacao);
			
			DAO<Cargo> daoCargo = CargoDao.getInstancia();			
			daoCargo.criar(cargo);
			
		} catch (Exception e) {
			
			req.getSession().setAttribute("erro", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/jsp/erro.jsp").forward(req, resp);;
			
		}
		
	}

}