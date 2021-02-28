package entidades;

public class Pessoa {

	private String nome;
	private String sobrenome;
	private String etapa1 = "";
	private String etapa2 = "";
	private String cafe = "";
	
	/**
	 * @param nome
	 * @param sobrenome
	 */
	public Pessoa(String nome, String sobrenome) {
		setNome(nome);
		setSobrenome(sobrenome);
	}
	
	/**
	 * default constructor
	 */
	public Pessoa() {
	}
	
	/*
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}
	
	/**
	 * @param sobrenome the sobrenome to set
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	/**
	 * @return the etapa1
	 */
	public String getEtapa1() {
		return etapa1;
	}

	/**
	 * @param etapa1 the etapa1 to set
	 */
	public void setEtapa1(String etapa1) {
		this.etapa1 = etapa1;
	}

	/**
	 * @return the etapa2
	 */
	public String getEtapa2() {
		return etapa2;
	}

	/**
	 * @param etapa2 the etapa2 to set
	 */
	public void setEtapa2(String etapa2) {
		this.etapa2 = etapa2;
	}

	/**
	 * @return the cafe
	 */
	public String getCafe() {
		return cafe;
	}

	/**
	 * @param cafe the cafe to set
	 */
	public void setCafe(String cafe) {
		this.cafe = cafe;
	}

    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }
}
