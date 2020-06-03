package mppa.folha.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "vinculo_funcional")
public class VinculoFuncional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private PessoaJuridica pessoa_juridica;
	private String matricula;
	@Temporal(TemporalType.DATE)
	private Date data_inicio;
	@Temporal(TemporalType.DATE)
	private Date data_fim;
	@OneToOne
	private PessoaFisica pessoa_fisica;
	@OneToOne
	private Cargo cargo;
	@OneToMany
	private List<Lotacao> lotacoes;
	@OneToMany
	private List<DocumentoMargem> documentosMargem;

	public VinculoFuncional() {

	}
	
	public Long getId() {
		return id;
	}

	public PessoaJuridica getPessoa_juridica() {
		return pessoa_juridica;
	}

	public VinculoFuncional setPessoa_juridica(PessoaJuridica pessoa_juridica) {
		this.pessoa_juridica = pessoa_juridica;
		return this;
	}

	public String getMatricula() {
		return matricula;
	}

	public VinculoFuncional setMatricula(String matricula) {
		this.matricula = matricula;
		return this;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public VinculoFuncional setData_inicio(String data_inicio) throws ParseException {

		if(data_inicio.equals("")) {
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

	public VinculoFuncional setData_fim(String data_fim) throws ParseException {

		if(data_fim.equals("")) {
			this.data_fim= null;
			return this;
		}
			
		try {
			
			SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");			
			this.data_fim= formatoData.parse(data_fim);
			
			return this;
			
		} catch (ParseException e) {
			throw new ParseException("A data informada é inválida", e.getErrorOffset());
		}
		
	}

	public PessoaFisica getPessoa_fisica() {
		return pessoa_fisica;
	}

	public VinculoFuncional setPessoa_fisica(PessoaFisica pessoa_fisica) {
		this.pessoa_fisica = pessoa_fisica;
		return this;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public VinculoFuncional setCargo(Cargo cargo) {
		this.cargo = cargo;
		return this;
	}

	public List<Lotacao> getLotacoes() {
		return lotacoes;
	}

	public VinculoFuncional setLotacoes(List<Lotacao> lotacoes) {
		this.lotacoes = lotacoes;
		return this;
	}

	public List<DocumentoMargem> getDocumentosMargem() {
		return documentosMargem;
	}

	public VinculoFuncional setDocumentosMargem(List<DocumentoMargem> documentosMargem) {
		this.documentosMargem = documentosMargem;
		return this;
	}

	@Override
	public String toString() {
		return "id: " + id + "\n" + "matricula: " + matricula;
	}

}