package mppa.folha.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import mppa.folha.modelo.enumeracoes.ESFERAS;
import mppa.folha.modelo.enumeracoes.PODERES;

@Entity(name = "pessoa_juridica")
public class PessoaJuridica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String razao_social;
	@Column(nullable = false)
	private String nome_fantasia;
	private String acronimo;
	@Column(unique = true)
	private String cnpj;
	@Enumerated(EnumType.STRING)
	private ESFERAS esfera;
	@Enumerated(EnumType.STRING)
	private PODERES poder;

	public PessoaJuridica() {

	}
	
	public String getRazao_social() {
		return razao_social;
	}
	
	public PessoaJuridica setRazao_social(String razao_social) {
		this.razao_social = razao_social;
		return this;
	}

	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public PessoaJuridica setNome_fantasia(String nome_fantasia) throws IllegalArgumentException {
		
		if(nome_fantasia.equals(""))
			throw new IllegalArgumentException("O nome fantasia informado é inválido");
		
		this.nome_fantasia = nome_fantasia;
		return this;
	}

	public String getAcronimo() {
		return acronimo;
	}

	public PessoaJuridica setAcronimo(String acronimo) {
		this.acronimo = acronimo;
		return this;
	}

	public String getCnpj() {
		return cnpj;
	}

	public PessoaJuridica setCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	public ESFERAS getEsfera() {
		return esfera;
	}

	public PessoaJuridica setEsfera(ESFERAS esfera) {
		this.esfera = esfera;
		return this;
	}

	public PODERES getPoder() {
		return poder;
	}

	public PessoaJuridica setPoder(PODERES poder) {
		this.poder = poder;
		return this;
	}
	
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "id: " + id + 
				"\n" + "nome_fantasia: " + nome_fantasia + 
				"\n" + "cnpj: " + cnpj + "\n";
	}

}