package mppa.folha.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "unidade_administrativa")
public class UnidadeAdministrativa {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String denominacao;
	
	public UnidadeAdministrativa() {
	
	}
	
	public String getDenominacao() {
		return denominacao;
	}
	
	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}
	
	@Override
	public String toString() {
		
		return 
				"id: " + id + "\n" +
				"denominacao: " + denominacao;
	}
	
}
