package mppa.folha.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "pessoa_fisica")
public class PessoaFisica {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Temporal(TemporalType.DATE)
	private Date data_nascimento;
	private Character sexo;
	@Column(unique = true)
	private String cpf;
	
	public PessoaFisica() {
		
	}

	public String getNome() {
		return nome;
	}

	public PessoaFisica setNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public PessoaFisica setDataNascimento(Date dataNascimento) {
		this.data_nascimento = dataNascimento;
		return this;
	}
	
	public PessoaFisica setSexo(Character sexo) {
		this.sexo = sexo;
		return this;
	}
	
	public PessoaFisica setCPF(String cpf) {
		this.cpf = cpf;
		return this;
	}
	
	@Override
	public String toString() {
		
		return 
				"id: " + id + "\n" +
				"nome: " + nome + "\n" +
				"cpf: " + cpf;
		
	}
	
}