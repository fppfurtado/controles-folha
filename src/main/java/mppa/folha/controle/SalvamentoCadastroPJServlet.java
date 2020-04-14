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

import mppa.folha.dao.DAO;
import mppa.folha.modelo.PessoaJuridica;
import mppa.folha.modelo.enumeracoes.ESFERAS;
import mppa.folha.modelo.enumeracoes.PODERES;

@WebServlet("/cadastro/salvar-pessoa-juridica")
public class SalvamentoCadastroPJServlet extends HttpServlet {

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
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica()
				.setNome_fantasia(parametros.get("nome_fantasia"))
				.setRazao_social(parametros.get("razao_social"))
				.setAcronimo(parametros.get("acronimo"))
				.setCnpj(parametros.get("cnpj"))
				.setEsfera(ESFERAS.valueOf(parametros.get("esfera")))
				.setPoder(PODERES.valueOf(parametros.get("poder")));
		
		DAO dao = DAO.getInstancia();
		dao.criar(pessoaJuridica);
		
	}

}