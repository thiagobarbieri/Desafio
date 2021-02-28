package controladores;

import java.util.LinkedList;

import entidades.Pessoa;
import entidades.Sala;

public class SalaController {
	LinkedList<Sala> salas = new LinkedList<Sala>();

	/**
	 * Insere uma sala em LinkedList<Sala> salas.
	 * @param nomeSala
	 * @param lotacao
	 */
	public void inserirSala(String nomeSala, Integer lotacao) {
		salas.add(new Sala(nomeSala, lotacao));
	}
	
	/**
	 * Testa se a lota��o m�xima da sala em ambas as etapas foi atingida.
	 * True para lota��o maxima n�o atigida, False para lota��o maxima atingida
	 * @param index
	 * @return true||false
	 */
	public boolean testarLotacao(int index) {
		Sala sala = salas.get(index);
		int qtdAtt1 = sala.etapa1.size();
		int qtdAtt2 = sala.etapa2.size();
		int lotacao = sala.getLotacao();
		boolean teste;

		if(lotacao > qtdAtt1 || lotacao > qtdAtt2) {
			teste = true;
		} else {
			teste = false;
		}
		
		return teste;
	}

	/**
	 * Adiciona uma pessoa a sala (defina pelo index) na etapa 1
	 * @param index
	 * @param pessoa
	 */
	public void adicionarEtapa1(int index, Pessoa pessoa) {
		Sala sala = salas.get(index);
		sala.adicionarEtapa1Pes(pessoa);
	}

	/**
	 * Adiciona uma pessoa a sala (defina pelo index) na etapa 2
	 * @param index
	 * @param pessoa
	 */
	public void adicionarEtapa2(int index, Pessoa pessoa) {
		Sala sala = salas.get(index);
		sala.adicionarEtapa2Pes(pessoa);
	}
	
	/**
	 * Tras os dados da primeira etapa da sala informada
	 * @param sala
	 */
	public void etapa1(Sala sala) {
		System.out.println(sala.getNomeSala() + " - Etapa 1");
		for (Pessoa pess : sala.etapa1) {
			String nome = pess.getNome() + " " + pess.getSobrenome();
			System.out.println("\tParticipante: " + nome);
		}
	}

	/**
	 * Tras os dados da segunda etapa da sala informada
	 * @param sala
	 */
	public void etapa2(Sala sala) {
		System.out.println(sala.getNomeSala() + " - Etapa 2");
		for (Pessoa pess : sala.etapa2) {
			String nome = pess.getNome() + " " + pess.getSobrenome();
			System.out.println("\tParticipante: " + nome);
		}
	}

	/**
	 * Tras o nome da sala consultada, a lota��o maxima e os participantes da etapa 1 e 2.
	 * Caso n�o encontrada faz um print "Sala n�o encontrada"
	 * @param nomeSala
	 */
	public void consultarSala(String nomeSala){
		for (Sala sal : salas) {
			if (sal.getNomeSala().equals(nomeSala)) {
				System.out.println("------------ "+ sal.getNomeSala() + " ------------");
				System.out.println("Lota��o M�xima: " + sal.getLotacao());
				etapa1(sal);
				etapa2(sal);
				return;
			} 
		}
		System.err.println("Sala n�o encontrada!");
	}

	/**
	 * Metodo para calculo de quantas salas existem 
	 * @return retorna um inteiro
	 */
	public int todasSalas() {
		return salas.size();
	}

	/**
	 * Metodo que pega uma sala pelo ind informado
	 * @param ind
	 * @return retorna uma Sala
	 */
	public Sala indexSala(int ind) {
		return salas.get(ind);
	}
}
