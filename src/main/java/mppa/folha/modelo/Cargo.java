package mppa.folha.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import mppa.folha.modelo.enumeracoes.FORMAS_NOMEACAO;

@Entity(name = "cargo")
public class Cargo {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private FORMAS_NOMEACAO forma_nomeacao;
	@Column(nullable = false)
	private String denominacao;
	@OneToOne
	private PessoaJuridica organizacao;
	
	public Cargo() {	
		
	}
	
	public Cargo(String denominacao, FORMAS_NOMEACAO forma_nomeacao, PessoaJuridica organizacao) {
		this.denominacao = denominacao;
		this.forma_nomeacao = forma_nomeacao;
		this.organizacao = organizacao;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getDenominacao() {
		return denominacao;
	}
	
	public Cargo setDenominacao(String denominacao) {
		this.denominacao = denominacao;
		return this;
	}
	
	public Cargo setForma_nomeacao(FORMAS_NOMEACAO forma_nomeacao) {
		this.forma_nomeacao = forma_nomeacao;
		return this;
	}
	
	public Cargo setOrganizacao(PessoaJuridica organizacao) {
		this.organizacao = organizacao;
		return this;
	}
	
	@Override
	public String toString() {
		return 
				"id: " + id + "\n" +
				"denominacao: " + denominacao + "\n" +
				"organizacao: " + organizacao;
	}
	
}
