import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		while (true) {
			int resp = UI.menu();	
			
			if (resp==1) {
				Cidade cidade = UI.inserirCidade();
				
				try {
					cidadeDAO.inserirCidade(cidade);
					UI.voltar();
				} catch (SQLException e) {
					System.err.println("Não foi possível inserir esta cidade");
					e.printStackTrace();
				}
				
			} else if (resp==2) {
				int ddd = UI.removerCidade();
				
				try {
					cidadeDAO.removerCidade(ddd);
					UI.voltar();
				} catch (SQLException e) {
					System.err.println("Não foi possível remover esta cidade");
					e.printStackTrace();
				}
				
			} else if (resp==3) {
				UI.sair();
			}
			
		}
	}

}
