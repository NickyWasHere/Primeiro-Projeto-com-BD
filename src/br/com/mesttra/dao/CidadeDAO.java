package br.com.mesttra.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mesttra.factory.ConnectionFactory;
import br.com.mesttra.pojo.Cidade;

public class CidadeDAO {

	private Connection conn;
	
	public CidadeDAO() {
		this.conn = new ConnectionFactory().getConnection();
		System.out.println("Conectado");
		System.out.println();
	}
	
	public void inserirCidade(Cidade cidade) {
		String sql = "INSERT INTO cidade VALUES (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, cidade.getDdd());
			stmt.setString(2, cidade.getNome());
			stmt.setInt(3, cidade.getNroHabitantes());
			stmt.setDouble(4, cidade.getRendaPerCapita());
			stmt.setBoolean(5, cidade.isCapital());
			stmt.setString(6, cidade.getEstado());
			stmt.setString(7, cidade.getNomePrefeito());
			stmt.execute();
			stmt.close();
			
			System.out.println();
			System.out.println("Cidade inserida com sucesso");
			System.out.println();
			
		} catch (SQLException e) {
			System.err.println("Não foi possível inserir esta cidade");
			e.printStackTrace();
		}

	}
	
	public void removerCidade(int ddd) {
		String sql = "DELETE FROM cidade WHERE ddd = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ddd);
			stmt.execute();
			stmt.close();
			
			System.out.println();
			System.out.println("Cidade deletada com sucesso");
			System.out.println();
			
		} catch (SQLException e) {
			System.err.println("Não foi possível remover esta cidade");
			e.printStackTrace();
		}
	}
	
	public List<Cidade> verCidades() {
		String sql = "SELECT * FROM cidade";
		List<Cidade> cidades = new ArrayList<>();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Cidade cidade = new Cidade();
				
				cidade.setDdd(rs.getInt("ddd"));
				cidade.setNome(rs.getString("nome"));
				cidade.setNroHabitantes(rs.getInt("nro_habitantes"));
				cidade.setRendaPerCapita(rs.getDouble("renda_per_capita"));
				cidade.setCapital(rs.getBoolean("capital"));
				cidade.setEstado(rs.getString("estado"));
				cidade.setNomePrefeito(rs.getString("nome_prefeito"));
				
				cidades.add(cidade);
			}
			
		} catch (SQLException e) {
			System.err.println("Não foi possível ver as cidades");
			e.printStackTrace();
		}
		
		return cidades;
	}
	
	public Cidade verCidade(int ddd) {
		String sql = "SELECT * FROM cidade WHERE ddd = ?";
		Cidade cidade = new Cidade();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ddd);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				cidade.setDdd(rs.getInt("ddd"));
				cidade.setNome(rs.getString("nome"));
				cidade.setNroHabitantes(rs.getInt("nro_habitantes"));
				cidade.setRendaPerCapita(rs.getDouble("renda_per_capita"));
				cidade.setCapital(rs.getBoolean("capital"));
				cidade.setEstado(rs.getString("estado"));
				cidade.setNomePrefeito(rs.getString("nome_prefeito"));
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			System.err.println("Não foi possível ver esta cidade");
			e.printStackTrace();
		}
		
		return cidade;
	}
	
	public Cidade procurarCidade(String search) {
		String sql = "SELECT * FROM cidade WHERE nome LIKE ?";
		Cidade cidade = new Cidade();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, search + '%');
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {			
				cidade.setDdd(rs.getInt("ddd"));
				cidade.setNome(rs.getString("nome"));
				cidade.setNroHabitantes(rs.getInt("nro_habitantes"));
				cidade.setRendaPerCapita(rs.getDouble("renda_per_capita"));
				cidade.setCapital(rs.getBoolean("capital"));
				cidade.setEstado(rs.getString("estado"));
				cidade.setNomePrefeito(rs.getString("nome_prefeito"));
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			System.err.println("Não foi possível pesquisar uma cidade");
			e.printStackTrace();
		}
	
		return cidade;
	}
	
	public List<Cidade> procurarEstado(String estado) {
		String sql = "SELECT * FROM cidade WHERE estado = ?";
		List<Cidade> cidades = new ArrayList<>();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, estado);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cidade cidade = new Cidade();
				
				cidade.setDdd(rs.getInt("ddd"));
				cidade.setNome(rs.getString("nome"));
				cidade.setNroHabitantes(rs.getInt("nro_habitantes"));
				cidade.setRendaPerCapita(rs.getDouble("renda_per_capita"));
				cidade.setCapital(rs.getBoolean("capital"));
				cidade.setEstado(rs.getString("estado"));
				cidade.setNomePrefeito(rs.getString("nome_prefeito"));
				
				cidades.add(cidade);
			}
			
			rs.close();
			
		} catch (SQLException e) {
			System.err.println("Não foi possível pesquisar um estado");
			e.printStackTrace();
		}
		
		return cidades;
	}
}
