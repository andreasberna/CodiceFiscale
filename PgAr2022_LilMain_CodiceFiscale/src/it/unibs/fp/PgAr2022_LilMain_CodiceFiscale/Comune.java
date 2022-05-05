package it.unibs.fp.PgAr2022_LilMain_CodiceFiscale;

public class Comune {
	private String nome;
	private String codice;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	
	public Comune(String nome, String codice) {
		super();
		this.nome = nome;
		this.codice = codice;
	}
}
