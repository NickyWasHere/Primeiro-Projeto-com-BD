import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		System.out.println("Teste salvar em banco de dados");
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
		
		Cidade cidade = new Cidade(ddd, nome, nroHabitantes, rendaPerCapita, capital, estado, nomePrefeito);
		
		try {
			cidadeDAO.inserirCidade(cidade);
		} catch (SQLException e) {
			System.err.println("Não foi possível inserir esta cidade");
			e.printStackTrace();
		}
		
		System.out.print("Insira o DDD de uma cidade a ser deletada: ");
		int del = sc.nextInt();
		
		try {
			cidadeDAO.removerCidade(del);
		} catch (SQLException e) {
			System.err.println("Não foi possível remover esta cidade");
			e.printStackTrace();
		}
				
		sc.close();
	}

}
