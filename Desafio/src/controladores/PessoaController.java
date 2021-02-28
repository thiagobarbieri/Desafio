package controladores;

import java.util.LinkedList;

import entidades.Pessoa;

public class PessoaController {
	LinkedList<Pessoa> pessoas = new LinkedList<Pessoa>();
	
	/**
	 * Insere uma Pessoa em LinkedList<Pessoa> pessoas.
	 * @param nome
	 * @param sobrenome
	 */
	public void inserirPessoa(String nome, String sobrenome) {
		pessoas.add(new Pessoa(nome, sobrenome));
	}

	/**
	 * Tras o nome da pessoa consultada, a sala que ela estará na primeira etapa e na segunda etapa, e a sala de cafe
	 * Caso não encontrada faz um print "Participante não encontrado"
	 * @param nome
	 * @param sobrenome
	 */
	public void consultarPessoa(String nome, String sobrenome) {
		for (Pessoa pes : pessoas) {
			// if(sobrenome.contains(pes.getSobrenome()) && nome.contains(pes.getNome())) {
			if ((pes.getSobrenome().equals(sobrenome)) && (pes.getNome().equals(nome))) {
				System.out.println("Nome do Participante Consultado: " + pes);
				System.out.println("Primeira Etapa: " + pes.getEtapa1());
				System.out.println("Segunda Etapa: " + pes.getEtapa2());
				System.out.println("Sala para Cafe: " + pes.getCafe());
				;
				return;
			}
		}
		System.err.println("Participante não encontrado!");
	}

	/**
	 * Metodo para calculo de quantas pessoas existem
	 * @return retorna um inteiro
	 */
	public int todasPessoas() {
		return pessoas.size();
	}


	public LinkedList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(LinkedList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
}
