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
	
	public UnidadeAdministrativa setDenominacao(String denominacao) {
		
		if(denominacao.equals(""))
			throw new IllegalArgumentException("A denominação informada é inválida");
		
		this.denominacao = denominacao;
		return this;
	}
	
	@Override
	public String toString() {
		
		return 
				"id: " + id + "\n" +
				"denominacao: " + denominacao;
	}
	
}
