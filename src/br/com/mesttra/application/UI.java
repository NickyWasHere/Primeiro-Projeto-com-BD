package br.com.mesttra.application;
import java.util.Scanner;

import br.com.mesttra.pojo.Cidade;

public class UI {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static int menu() {
		System.out.println("--------------------------------");
		System.out.println("              Menu");
		System.out.println();
		
		System.out.println("1-Inserir cidade");
		System.out.println("2-Remover cidade");
		System.out.println("3-Ver todas as cidades");
		System.out.println("4-Ver cidade");
		System.out.println("5-Filtrar por nome");
		System.out.println("6-Filtrar por estado");
		System.out.println("7-Filtrar por capital");
		System.out.println("8-Sair");
		System.out.println();
		System.out.println("--------------------------------");
		
		System.out.print("Escolha uma opção: ");
		return sc.nextInt();		
	}
	
	public static Cidade inserirCidade() {
		System.out.println("--------------------------------");
		System.out.println("        Cadastrar cidade");
		System.out.println();
		
		System.out.print("DDD: ");
		int ddd = sc.nextInt();
		
		System.out.print("Nome: ");
		sc.nextLine();
		String nome = sc.nextLine();
		
		System.out.print("Número de habitantes: ");
		int nroHabitantes = sc.nextInt();
		
		System.out.print("Renda per capita: ");
		double rendaPerCapita = sc.nextDouble();
		
		System.out.print("É capital (s/n)? ");
		char cap = sc.next().charAt(0);
		boolean capital;
		if (cap=='s' || cap=='S') {
			capital = true;
		} else {
			capital = false;
		}
		
		System.out.print("Estado: ");
		String estado = sc.next();
		
		System.out.print("Nome do prefeito: ");
		sc.nextLine();
		String nomePrefeito = sc.nextLine();
		
		return new Cidade(ddd, nome, nroHabitantes, rendaPerCapita, capital, estado, nomePrefeito);
	}
	
	public static int removerCidade() {		
		System.out.println("--------------------------------");
		System.out.println("         Remover cidade");
		System.out.println();
		
		System.out.print("Insira o DDD da cidade: ");
		return sc.nextInt();
	}
	
	public static int verCidade() {
		System.out.println("--------------------------------");
		System.out.println("           Ver cidade");
		System.out.println();
		
		System.out.print("Insira o DDD da cidade: ");
		return sc.nextInt();
	}
	
	public static String pesquisarCidade() {
		System.out.println("--------------------------------");
		System.out.println("         Filtrar cidade");
		System.out.println();
		
		System.out.print("Insira o nome a pesquisar: ");
		sc.nextLine();
		return sc.nextLine();
	}
	
	public static String pesquisarEstado() {
		System.out.println("--------------------------------");
		System.out.println("         Filtrar estado");
		System.out.println();
		
		System.out.print("Insira estado a pesquisar: ");
		return sc.next();
	}
	
	public static boolean pesquisarCapital() {
		System.out.println("--------------------------------");
		System.out.println("         Filtrar capital");
		System.out.println();
		
		System.out.print("Filtrar capitais (s/n)? ");
		char resp = sc.next().charAt(0);
		
		if (resp=='s' || resp=='S') {
			return true;
		} else if (resp=='n' || resp=='N'){
			return false;
		} else {
			System.out.println("Opção inválida");
			voltar();
		}
		
		return false;
	}
	
	public static void voltar() {
		System.out.println("--------------------------------");
		System.out.print("Voltar ao menu (s/n)? ");
		char voltar = sc.next().charAt(0);
		
		if (voltar=='s' || voltar=='S') {
			return;
		} else {
			sair();
		}
	}
	
	public static void sair() {
		System.out.println();
		System.out.println("Programa finalizado");
		
		sc.close();
		System.exit(0);
	}
}
