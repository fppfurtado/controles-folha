package mppa.folha.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "lotacao")
public class Lotacao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private VinculoFuncional vinculoFuncional;
	@OneToOne
	private UnidadeAdministrativa unidadeAdministrativa;
	private Date data_inicio;
	private Date data_fim;
	
	public Lotacao() {
	
	}
	
	public VinculoFuncional getVinculoFuncional() {
		return vinculoFuncional;
	}
	
	public void setVinculoFuncional(VinculoFuncional vinculoFuncional) {
		this.vinculoFuncional = vinculoFuncional;
	}
	
	public UnidadeAdministrativa getUnidadeAdministrativa() {
		return unidadeAdministrativa;
	}
	
	public void setUnidadeAdministrativa(UnidadeAdministrativa unidadeAdministrativa) {
		this.unidadeAdministrativa = unidadeAdministrativa;
	}
	
}