package mppa.folha.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "quitacao")
public class Quitacao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer parcelas_pagas;
	private Integer total_parcelas;
	private BigDecimal valor;
	@ManyToOne
	private DocumentoMargem documento_margem;
	
	public Quitacao() {
	
	}
	
	@Override
	public String toString() {
		return 
				"id: " + id + "\n" +
				"parcelas pagas: " + parcelas_pagas + "\n" +
				"total parcelas: " + total_parcelas + "\n" +
				"valor: " + valor;
	}

}