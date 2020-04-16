package mppa.folha.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	public PessoaFisica setNome(String nome) throws IllegalArgumentException {

		if(nome.equals(""))
			throw new IllegalArgumentException("O nome informado é inávlido");
		
		this.nome = nome;
		
		return this;
		
	}
	
	public PessoaFisica setDataNascimento(String data) throws ParseException {
		
		if(data.equals("")) {
			this.data_nascimento = null;
			return this;
		}
			
		
		try {
			
			SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");			
			this.data_nascimento = formatoData.parse(data);
			
			return this;
			
		} catch (ParseException e) {
			throw new ParseException("A data informada é inválida", e.getErrorOffset());
		}
		
	}
	
	public PessoaFisica setSexo(Character sexo) {
		this.sexo = sexo;
		return this;
	}
	
	public PessoaFisica setCPF(String cpf) {
		
		this.cpf = cpf.equals("") ? null : cpf;
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