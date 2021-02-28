package entidades;

import java.util.LinkedList;

public class Cafe {

	private String salaCafe;
	private Integer lotacaoCafe;
	public LinkedList<Pessoa> pessoasCafe = new LinkedList<Pessoa>();

	/**
	 * @param salaCafe
	 */
	public Cafe(String salaCafe, Integer lotacaoCafe) {
		setSalaCafe(salaCafe);
		setLotacaoCafe(lotacaoCafe);
	}

	/**
	 * @return the salaCafe
	 */
	public String getSalaCafe() {
		return salaCafe;
	}

	/**
	 * @param salaCafe the salaCafe to set
	 */
	public void setSalaCafe(String salaCafe) {
		this.salaCafe = salaCafe;
	}
	
	/**
	 * 
	 * @return the lotacaoCafe
	 */
	public Integer getLotacaoCafe() {
		return lotacaoCafe;
	}

	/**
	 * @param lotacaoCafe the lotacaoCafe to set
	 */
	public void setLotacaoCafe(Integer lotacaoCafe) {
		this.lotacaoCafe = lotacaoCafe;
	}
	
	/**
	 * 
	 * @param pessoa
	 */
	public void adicionar(Pessoa pessoa) {
		this.pessoasCafe.add(pessoa);
	}
}
