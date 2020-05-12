package mppa.folha.modelo.enumeracoes;

public enum Sexo {
	MASCULINO("M"),
	FEMININO("F");
	
	public String valor;
	
	Sexo(String sexo) {
		this.valor = sexo;
	}
	
	public String getValor() {
		return valor;
	}
	
}
