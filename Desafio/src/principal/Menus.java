package principal;

import java.util.Scanner;

import controladores.CafeController;
import controladores.PessoaController;
import controladores.SalaController;
import entidades.Pessoa;
import entidades.Sala;

public class Menus {

	public static void cadastroSalas(Scanner scLine, SalaController salaCont) {
		Scanner sc = new Scanner(System.in);
		Integer lotacao = 0;
		System.out.println("Nome sala: ");
		String nomeSala = scLine.nextLine();
		System.out.println("lotação máxima: ");
		lotacao = sc.nextInt();

		salaCont.inserirSala(nomeSala, lotacao);
	}

	public static void cadastroParticipante(Scanner scLine, Scanner sc, PessoaController pessoaCont) {
		String nome = null;
		String sobrenome = null;

		while (true) {
			System.out.println("Nome: ");
			nome = sc.next();
			System.out.println("sobrenome: ");
			sobrenome = scLine.nextLine();
			if ((!nome.matches(".*\\d.*")) && (!sobrenome.matches(".*\\d.*"))) {
				break;
			} else {
				System.err.println("Nome ou Sobrenome contém número!!!");
			}
		}

		pessoaCont.inserirPessoa(nome, sobrenome);
	}

	public static void cadastroCafe(Scanner scLine, CafeController cafeCont) {
		Scanner sc = new Scanner(System.in);
		Integer lotacao = 0;
		System.out.println("Nome salas café: ");
		String nomeCafe = scLine.nextLine();
		System.out.println("lotação máxima: ");
		lotacao = sc.nextInt();

		cafeCont.inserirCafe(nomeCafe, lotacao);

	}

	public static void consultaSala(Scanner scLine, Scanner sc, SalaController salaCont) {
		System.out.println("Nome da sala: ");
		String nomeSala = scLine.nextLine();

		salaCont.consultarSala(nomeSala);
	}

	public static void consultaParticipante(Scanner scLine, Scanner sc, PessoaController pessoaCont) {
		String nome = null;
		String sobrenome = null;

		while (true) {
			System.out.println("Nome: ");
			nome = sc.next();
			System.out.println("sobrenome: ");
			sobrenome = scLine.nextLine();
			if ((!nome.matches(".*\\d.*")) && (!sobrenome.matches(".*\\d.*"))) {
				break;
			} else {
				System.err.println("Nome ou Sobrenome contém número!!!");
			}
		}

		pessoaCont.consultarPessoa(nome, sobrenome);
	}

	public static void consultaCafe(Scanner scLine, Scanner sc, CafeController cafeCont) {
		System.out.println("Nome da sala de cafe: ");
		String nomeCafe = scLine.nextLine();

		cafeCont.consultarCafe(nomeCafe);
	}

	public static void encerrarCadastro(Scanner scLine, Scanner sc, SalaController salaCont, CafeController cafeCont,
			PessoaController pessoaCont, Sala sala) {

		int pessoasTotal = pessoaCont.todasPessoas();
		int salasTotal = salaCont.todasSalas();
		int cafesTotal = cafeCont.todosCafes();
		String nomeCafe = null;

		int cont = 0;
		int auxSala = 0;
		int auxCafe = 0;
		int temp2 = 0;
		int metadeSala = pessoasTotal / 2;
		for (Pessoa pessoaAtt : pessoaCont.getPessoas()) {
			
			int salaAtt = cont % salasTotal;
			//teste de lotacao sala
			while (!salaCont.testarLotacao(salaAtt)) {
				salaAtt = auxSala % salasTotal;
				auxSala++;
			}
			
			int cafeAtt = cont % cafesTotal;
			//teste de lotacao cafe
			while (!cafeCont.testarLotacaoCafe(cafeAtt)) {
				cafeAtt = auxCafe % cafesTotal;
				auxCafe++;
			}

			salaCont.adicionarEtapa1(salaAtt, pessoaAtt);
			String nomeSala = salaCont.indexSala(salaAtt).getNomeSala();
			pessoaCont.getPessoas().get(cont).setEtapa1(nomeSala);
			String nomeSala2 = salaCont.indexSala(salaAtt).getNomeSala();
			nomeCafe = cafeCont.indexCafe(cafeAtt).getSalaCafe();

			//troca de pessoas etapa 1 e 2
			if (cont >= metadeSala) {
				int segSala = (salaAtt + 1) % salasTotal;
				while (!salaCont.testarLotacao(segSala)) {
					segSala = temp2 % salasTotal;
					temp2++;
				}
				salaCont.adicionarEtapa2(segSala, pessoaAtt);
				nomeSala2 = salaCont.indexSala(segSala).getNomeSala();
				pessoaAtt.setEtapa2(nomeSala2);
			} else {
				salaCont.adicionarEtapa2(salaAtt, pessoaAtt);
				pessoaAtt.setEtapa2(nomeSala2);
			}

			cafeCont.adicionarPessoas(cafeAtt, pessoaAtt);
			pessoaAtt.setCafe(nomeCafe);
			cont++;

		}
	}

}
