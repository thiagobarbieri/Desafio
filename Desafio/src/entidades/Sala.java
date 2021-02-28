package entidades;

import java.util.LinkedList;

public class Sala {

	private String nomeSala;
	private Integer lotacao;
	public LinkedList<Pessoa> etapa1 = new LinkedList<Pessoa>();
	public LinkedList<Pessoa> etapa2 = new LinkedList<Pessoa>();

	
	/**
	 * @param nomeSala
	 * @param lotacao
	 */
	public Sala(String nomeSala, Integer lotacao) {
		setNomeSala(nomeSala);
		setLotacao(lotacao);
	}
	
	/**
	 * default constructor
	 */
	public Sala() {
	}

	/**
	 * @return the nomeSala
	 */
	public String getNomeSala() {
		return nomeSala;
	}
	
	/**
	 * @param nomeSala the nomeSala to set
	 */
	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}
	
	/**
	 * @return the lotacao
	 */
	public Integer getLotacao() {
		return lotacao;
	}
	
	/**
	 * @param lotacao the lotacao to set
	 */
	public void setLotacao(Integer lotacao) {
		this.lotacao = lotacao;
	}
    
    /**
     * Adiciona pessoa em LinkedList<Pessoa> etapa1
     * @param pessoa
     */
    public void adicionarEtapa1Pes(Pessoa pessoa){
        this.etapa1.add(pessoa);
    }
    
    /**
     * Adiciona pessoa em LinkedList<Pessoa> etapa2
     * @param pessoa
     */
    public void adicionarEtapa2Pes(Pessoa pessoa){
        this.etapa2.add(pessoa);
    }
}
