package br.com.mesttra.application;
import java.util.List;

import br.com.mesttra.dao.CidadeDAO;
import br.com.mesttra.pojo.Cidade;

public class Main {

	public static void main(String[] args) {
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		while (true) {
			int resp = UI.menu();	
			
			switch (resp) {
			case 1:
				Cidade cidade = UI.inserirCidade();
				cidadeDAO.inserirCidade(cidade);
				
				UI.voltar();
				break;
				
			case 2:
				int ddd = UI.removerCidade();
				cidadeDAO.removerCidade(ddd);
				
				UI.voltar();
				break;
				
			case 3:
				List<Cidade> cidades = cidadeDAO.verCidades();
				
				if (cidades.size()==0) {
					System.out.println("Nenhuma cidade encontrada");
					
				} else {
					for (Cidade c : cidades) {
						System.out.println(c);
					}
				}
				
				UI.voltar();
				break;
				
			case 4:
				ddd = UI.verCidade();
				cidades = cidadeDAO.verCidade(ddd);
				
				if (cidades.size()==0) {
					System.out.println("Nenhuma cidade encontrada");
					
				} else {
					for (Cidade c : cidades) {
						System.out.println(c);
					}
				}
				
				UI.voltar();
				break;
				
			case 5:
				String search = UI.pesquisarCidade();
				cidades = cidadeDAO.procurarCidade(search);
				
				if (cidades.size()==0) {
					System.out.println("Nenhuma cidade encontrada");
					
				} else {
					for (Cidade c : cidades) {
						System.out.println(c);
					}
				}
				
				UI.voltar();
				break;
				
			case 6:
				String estado = UI.pesquisarEstado();
				cidades = cidadeDAO.procurarEstado(estado);
				
				if (cidades.size()==0) {
					System.out.println("Nenhuma cidade encontrada");
					
				} else {
					System.out.println("--------------------------------");
					System.out.println(cidades.size() + " cidades encontradas");
					for (Cidade c : cidades) {
						System.out.println(c);
					}
				}
				
				UI.voltar();
				break;
				
			case 7:
				if (UI.pesquisarCapital()) {
					cidades = cidadeDAO.filtrarCapital(true);
				} else {
					cidades = cidadeDAO.filtrarCapital(false);
				}
				
				if (cidades.size()==0) {
					System.out.println("Nenhuma cidade encontrada");
					
				} else {
					System.out.println("--------------------------------");
					System.out.println(cidades.size() + " cidades encontradas");
					for (Cidade c : cidades) {
						System.out.println(c);
					}
				}
				
				UI.voltar();
				break;
				
			case 8:
				UI.sair();
				break;
				
			default:
				System.out.println("Esta opção não é válida");
				System.out.println();
				
				UI.menu();
				break;
			}			
		}
	}

}
