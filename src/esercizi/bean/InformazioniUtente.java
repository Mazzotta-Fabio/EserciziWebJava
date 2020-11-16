package esercizi.bean;

public class InformazioniUtente {
	
	private String nome;
	private String password;
	private String argomento;
	
	public InformazioniUtente(String nome, String password, String argomento) {
		this.nome = nome;
		this.password = password;
		this.argomento = argomento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getArgomento() {
		return argomento;
	}

	public void setArgomento(String argomento) {
		this.argomento = argomento;
	}
	
	
	
}
