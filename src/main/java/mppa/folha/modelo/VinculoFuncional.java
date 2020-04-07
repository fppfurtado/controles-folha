package mppa.folha.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "vinculo_funcional")
public class VinculoFuncional {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String matricula;
	private Date data_inicio;
	private Date data_fim;
	@OneToOne
	private PessoaFisica pessoa;
	@OneToOne
	private Cargo cargo;
	
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
