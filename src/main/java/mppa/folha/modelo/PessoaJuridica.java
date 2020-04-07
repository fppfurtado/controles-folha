package mppa.folha.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import mppa.folha.modelo.enumeracoes.ESFERAS;
import mppa.folha.modelo.enumeracoes.PODERES;

@Entity(name = "pessoa_juridica")
public class PessoaJuridica {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String razao_social;
	@Column(nullable = false)
	private String nome_fantasia;
	private String acronimo;
	@Column(unique = true)
	private String cnpj;
	@Enumerated
	private ESFERAS esfera;
	@Enumerated
	private PODERES poder;
	
	public PessoaJuridica() {

	}
	
	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}

	@Override
	public String toString() {
		return 
				"id: " + id + "\n" +
				"nome_fantasia: " + nome_fantasia + "\n" +
				"cnpj: " + cnpj + "\n";
	}

}
