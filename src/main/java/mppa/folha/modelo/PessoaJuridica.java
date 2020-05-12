package mppa.folha.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import mppa.folha.modelo.enumeracoes.Esferas;
import mppa.folha.modelo.enumeracoes.Poderes;

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
	private Esferas esfera;
	@Enumerated(EnumType.STRING)
	private Poderes poder;
	@OneToMany
	private List<UnidadeAdministrativa> unidadesAdministrativas;
	@OneToMany
	private List<Cargo> cargos;
	@OneToMany
	private List<VinculoFuncional> vinculosFuncionais;
	
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

	public Esferas getEsfera() {
		return esfera;
	}

	public PessoaJuridica setEsfera(Esferas esfera) {
		this.esfera = esfera;
		return this;
	}

	public Poderes getPoder() {
		return poder;
	}

	public PessoaJuridica setPoder(Poderes poder) {
		this.poder = poder;
		return this;
	}
	
	public Long getId() {
		return id;
	}
	
	public List<UnidadeAdministrativa> getUnidadesAdministrativas() {
		return unidadesAdministrativas;
	}
	
	public List<Cargo> getCargos() {
		return cargos;
	}
	
	public List<VinculoFuncional> getVinculosFuncionais() {
		return vinculosFuncionais;
	}
	
		@Override
	public String toString() {
		return "id: " + id + 
				"\n" + "nome_fantasia: " + nome_fantasia + 
				"\n" + "cnpj: " + cnpj + "\n";
	}

}