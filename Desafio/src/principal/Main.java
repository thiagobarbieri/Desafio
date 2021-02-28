package principal;

import java.util.InputMismatchException;
import java.util.Scanner;

import controladores.CafeController;
import controladores.PessoaController;
import controladores.SalaController;
import entidades.Sala;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner scLine = new Scanner(System.in);

		SalaController salaCont = new SalaController();
		PessoaController pessoaCont = new PessoaController();
		CafeController cafeCont = new CafeController();
		Sala sala = new Sala();
		
		int escolha = 0;

		//MENU CADASTRO
		boolean ok = true;
		boolean esperandoResposta = false;
		do {
			esperandoResposta = false;
			while (esperandoResposta == false) {
				System.out.println("\n\t******************************************");
				System.out.println("\t**\t1 - Cadastro de Salas\t\t**");
				System.out.println("\t**\t2 - Cadastro de Participantes\t**");
				System.out.println("\t**\t3 - Cadastro de Salas de Cafe\t**");
				System.out.println("\t**\t4 - Encerrando Cadastro\t\t**");
				System.out.println("\t******************************************");
				try {
					Scanner sc1 = new Scanner(System.in);
					escolha = sc1.nextInt();
					esperandoResposta = true;
				} catch (InputMismatchException er) {
					System.err.println("Digite um número para selecionar a opção desejada!!!");
				}
			}

			switch (escolha) {
			case 1: 
				try {
					Menus.cadastroSalas(scLine, salaCont);
				} catch (InputMismatchException er) {
					System.err.println("É necessario um número para cadastrar a lotação máxima!!");
				}
				break;
			case 2: 
				Menus.cadastroParticipante(scLine, sc, pessoaCont);
				break;
			case 3: 
				try {
					Menus.cadastroCafe(scLine, cafeCont);
				} catch (InputMismatchException er) {
					System.err.println("É necessario um número para cadastrar a lotação máxima!!");
				}
				break;
			case 4:
				Menus.encerrarCadastro(scLine, sc, salaCont, cafeCont, pessoaCont, sala);
				ok = false;
				break;
			default:
				System.out.println("Opção Invalida...");
				break;
			}
		} while (ok);
		
		//MENU CONSULTA
		ok = true;
		esperandoResposta = false;
		do {
			esperandoResposta = false;
			while (esperandoResposta == false) {
				System.out.println("\n\t******************************************");
				System.out.println("\t**\t1 - Consulta de Salas\t\t**");
				System.out.println("\t**\t2 - Consulta de Participantes\t**");
				System.out.println("\t**\t3 - Consulta de Salas de Cafe\t**");
				System.out.println("\t**\t4 - Encerrar programa...\t**");
				System.out.println("\t******************************************");
				try {
					Scanner sc1 = new Scanner(System.in);
					escolha = sc1.nextInt();
					esperandoResposta = true;
				} catch (InputMismatchException er) {
					System.err.println("Digite um número para selecionar a opção desejada!!!");
				}
			}

			switch (escolha) {
			case 1: 
				Menus.consultaSala(scLine, sc, salaCont);
				break;
			case 2: 
				Menus.consultaParticipante(scLine, sc, pessoaCont);
				break;
			case 3: 
				Menus.consultaCafe(scLine, sc, cafeCont);
				break;
			case 4: 
				System.out.println("Programa Encerrado...");
				ok = false;
				break;
			default:
				System.out.println("Opção Invalida...");
				break;
			}
		} while (ok);
		
	}
}
