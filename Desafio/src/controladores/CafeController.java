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
	 * Testa se a lotação máxima da sala cafe.
	 * True para lotação maxima não atigida, False para lotação maxima atingida
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
	 * Tras o nome da sala de cafe, lotação maxima e os participantes 
	 * Caso não encontrada faz um print "Sala Café não encontrada!"
	 * @param salaCafe
	 */
	public void consultarCafe(String salaCafe) {
		for(Cafe caf : cafes) {
			if(caf.getSalaCafe().equals(salaCafe)) {
				System.out.println("Sala Café consultada: " + caf.getSalaCafe());
				System.out.println("Lotação Maxima: "+caf.getLotacaoCafe());
				listagemPessoas(caf);
				return;
			} 
		}
		System.err.println("Sala Café não encontrada!");
		
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
	 * Adiciona pessoa na sala cafe (definida através do index)
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
