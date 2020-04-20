package mppa.folha.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "vinculo_funcional")
public class VinculoFuncional {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String matricula;
	@Temporal(TemporalType.DATE)
	private Date data_inicio;
	@Temporal(TemporalType.DATE)
	private Date data_fim;
	@OneToOne
	private PessoaFisica pessoa;
	@OneToOne
	private Cargo cargo;
	@OneToMany
	private List<Lotacao> lotacoes;
	@OneToMany
	private List<DocumentoMargem> documentosMargem;
	
	public VinculoFuncional() {
	
	}
	
	public String getMatricula() {
		return matricula;
	}



	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return 
				"id: " + id + "\n" +
				"matricula: " + matricula;
	}

}
