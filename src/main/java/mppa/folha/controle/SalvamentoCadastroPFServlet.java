package mppa.folha.controle;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mppa.folha.dao.DAO;
import mppa.folha.modelo.PessoaFisica;

@WebServlet("/cadastro/salvar-pessoa-fisica")
public class SalvamentoCadastroPFServlet extends HttpServlet {

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

			PessoaFisica pf = new PessoaFisica().setNome(parametros.get("nome"))
					.setDataNascimento(extrairData(parametros.get("data_nascimento")))
					.setSexo(parametros.get("sexo").charAt(0)).setCPF(parametros.get("cpf"));

			DAO dao = DAO.getInstancia();
			dao.criar(pf);

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	private Date extrairData(String data) throws ParseException {

		String[] componentesData = data.split("-");

		DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

		data = componentesData[2] + "/" + componentesData[1] + "/" + componentesData[0];

		return formatoData.parse(data);

	}

}