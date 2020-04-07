package mppa.folha.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "documento_margem")
public class DocumentoMargem {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private int numero_controle;
	@Column(nullable = false)
	private Date data_emissao;
	@Column(nullable = false)
	private BigDecimal margem_consignavel;
	private String observacao;
	private Boolean cancelamento;
	@OneToOne
	private VinculoFuncional vinculoRequerente;
	@OneToOne
	private VinculoFuncional vinculoDeclarante;
	@OneToMany(mappedBy = "documento_margem")
	private Collection<Quitacao> quitacoes;
	
	public DocumentoMargem() {
		
	}
	
	public int getNumero_controle() {
		return numero_controle;
	}

	public void setNumero_controle(int numero_controle) {
		this.numero_controle = numero_controle;
	}

	public Date getData_emissao() {
		return data_emissao;
	}

	public void setData_emissao(Date data_emissao) {
		this.data_emissao = data_emissao;
	}

	public BigDecimal getMargem_consignavel() {
		return margem_consignavel;
	}

	public void setMargem_consignavel(BigDecimal margem_consignavel) {
		this.margem_consignavel = margem_consignavel;
	}

	@Override
	public String toString() {
		
		Calendar dataCalendar = Calendar.getInstance();
		dataCalendar.setTime(data_emissao);
		
		return 
				"margem nº " + numero_controle + "/" + dataCalendar.get(Calendar.YEAR) + "\n" +
				"valor: R$ " + margem_consignavel;
	}
	
}