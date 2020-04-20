package mppa.folha.modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "lotacao")
public class Lotacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private UnidadeAdministrativa unidadeAdministrativa;
	@Temporal(TemporalType.DATE)
	private Date data_inicio;
	@Temporal(TemporalType.DATE)
	private Date data_fim;

	public Lotacao() {

	}

	public UnidadeAdministrativa getUnidadeAdministrativa() {
		return unidadeAdministrativa;
	}

	public void setUnidadeAdministrativa(UnidadeAdministrativa unidadeAdministrativa) {
		this.unidadeAdministrativa = unidadeAdministrativa;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public Lotacao setData_inicio(String data_inicio) throws ParseException {

		if (data_inicio.equals("")) {
			this.data_inicio = null;
			return this;
		}

		try {

			SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
			this.data_inicio = formatoData.parse(data_inicio);

			return this;

		} catch (ParseException e) {
			throw new ParseException("A data informada é inválida", e.getErrorOffset());
		}

	}

	public Date getData_fim() {
		return data_fim;
	}

	public Lotacao setData_fim(String data_fim) throws ParseException {

		if (data_fim.equals("")) {
			this.data_fim = null;
			return this;
		}

		try {

			SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
			this.data_fim = formatoData.parse(data_fim);

			return this;

		} catch (ParseException e) {
			throw new ParseException("A data informada é inválida", e.getErrorOffset());
		}

	}

}