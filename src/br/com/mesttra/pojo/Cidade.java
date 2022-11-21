package br.com.mesttra.pojo;

public class Cidade {

	private int ddd;
	private String nome;
	private int nroHabitantes;
	private double rendaPerCapita;
	private boolean capital;
	private String estado;
	private String nomePrefeito;

	public Cidade() {
		
	}
	
	public Cidade(int ddd, String nome, int nroHabitantes, double rendaPerCapita, boolean capital, String estado,
			String nomePrefeito) {
		this.ddd = ddd;
		this.nome = nome;
		this.nroHabitantes = nroHabitantes;
		this.rendaPerCapita = rendaPerCapita;
		this.capital = capital;
		this.estado = estado;
		this.nomePrefeito = nomePrefeito;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("--------------------------------" + "\n");
		if (capital) {
			sb.append(nome + " - Capital\n");
		} else {
			sb.append(nome + " - " + estado + "\n");
		}
		
		sb.append("DDD: " + ddd + "\n");
		sb.append("Número de habitantes: " + nroHabitantes + "\n");
		sb.append(String.format("Renda per capita: %.2f\n", rendaPerCapita));
		sb.append("Nome prefeito: " + nomePrefeito + "\n");
		
		return sb.toString();
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNroHabitantes() {
		return nroHabitantes;
	}

	public void setNroHabitantes(int nroHabitantes) {
		this.nroHabitantes = nroHabitantes;
	}

	public double getRendaPerCapita() {
		return rendaPerCapita;
	}

	public void setRendaPerCapita(double rendaPerCapita) {
		this.rendaPerCapita = rendaPerCapita;
	}

	public boolean isCapital() {
		return capital;
	}

	public void setCapital(boolean capital) {
		this.capital = capital;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNomePrefeito() {
		return nomePrefeito;
	}

	public void setNomePrefeito(String nomePrefeito) {
		this.nomePrefeito = nomePrefeito;
	}

}
