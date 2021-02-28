package controladores;

import java.util.LinkedList;

import entidades.Cafe;
import entidades.Pessoa;

public class CafeController {
	LinkedList<Cafe> cafes = new LinkedList<Cafe>();  
	
	/**
	 * Insere uma salaCafe em LinkedList<Cafe> cafes.
	 * @param salaCafe
	 */
	public void inserirCafe(String salaCafe, Integer lotacaoCafe) {
		cafes.add(new Cafe(salaCafe, lotacaoCafe));
	}
	
	/**
	 * Testa se a lota��o m�xima da sala cafe.
	 * True para lota��o maxima n�o atigida, False para lota��o maxima atingida
	 * @param index
	 * @return true||false
	 */
	public boolean testarLotacaoCafe(int index) {
		Cafe cafe = cafes.get(index);
		int qtdAtt1 = cafe.pessoasCafe.size();
		int lotacao = cafe.getLotacaoCafe();
		boolean teste;

		if(lotacao > qtdAtt1) {
			teste = true;
		} else {
			teste = false;
		}
		
		return teste;
	}
	
	/**
	 * Tras o nome da sala de cafe, lota��o maxima e os participantes 
	 * Caso n�o encontrada faz um print "Sala Caf� n�o encontrada!"
	 * @param salaCafe
	 */
	public void consultarCafe(String salaCafe) {
		for(Cafe caf : cafes) {
			if(caf.getSalaCafe().equals(salaCafe)) {
				System.out.println("Sala Caf� consultada: " + caf.getSalaCafe());
				System.out.println("Lota��o Maxima: "+caf.getLotacaoCafe());
				listagemPessoas(caf);
				return;
			} 
		}
		System.err.println("Sala Caf� n�o encontrada!");
		
	}
	
	/**
	 * Metodo que lista todas as pessoas existentes na sala cafe informada
	 * @param cafe
	 */
	public void listagemPessoas(Cafe cafe) {
		for(Pessoa pess : cafe.pessoasCafe) {
			String nome = pess.getNome() +" "+pess.getSobrenome();
			System.out.println("\tParticipante: "+nome);
		}
	
	}
	
	/**
	 * Adiciona pessoa na sala cafe (definida atrav�s do index)
	 * @param index
	 * @param pessoa
	 */
	public void adicionarPessoas(int index, Pessoa pessoa){
        cafes.get(index).adicionar(pessoa);
    }
	
	/**
	 * Metodo para calculo de quantas salas cafes existem
	 * @return retorna um inteiro
	 */
	public int todosCafes() {
		return cafes.size();
	}
	
	/**
	 * Metodo que pega uma sala cafe pelo ind informado
	 * @param ind
	 * @return retorna uma sala Cafe
	 */
	public Cafe indexCafe(int ind) {
		return cafes.get(ind);
	}
}
