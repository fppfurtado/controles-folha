package mppa.folha.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import mppa.folha.modelo.enumeracoes.FormasNomeacao;

@Entity(name = "cargo")
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private FormasNomeacao forma_nomeacao;
	@Column(nullable = false)
	private String denominacao;

	public Cargo() {

	}

	public Long getId() {
		return id;
	}

	public String getDenominacao() {
		return denominacao;
	}

	public Cargo setDenominacao(String denominacao) throws IllegalArgumentException {

		if (denominacao.equals(""))
			throw new IllegalArgumentException("A denominação informada é inválida");

		this.denominacao = denominacao;
		return this;
	}
	
	public FormasNomeacao getForma_nomeacao() {
		return forma_nomeacao;
	}
	
	public Cargo setForma_nomeacao(FormasNomeacao forma_nomeacao) {
		this.forma_nomeacao = forma_nomeacao;
		return this;
	}

	@Override
	public String toString() {
		return "id: " + id + "\n" + "denominacao: " + denominacao;
	}

}