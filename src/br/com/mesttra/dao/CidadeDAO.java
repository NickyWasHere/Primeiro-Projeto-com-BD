package br.com.mesttra.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public ArrayList<Cidade> verCidades() {
		String sql = "SELECT * FROM cidade";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			return setCidades(stmt);
			
		} catch (SQLException e) {
			System.err.println("Não foi possível ver as cidades");
		}
			
		return null;
	}
	
	public ArrayList<Cidade> verCidade(int ddd) {
		String sql = "SELECT * FROM cidade WHERE ddd = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ddd);
			return setCidades(stmt);
			
		} catch (SQLException e) {
			System.err.println("Não foi possível ver esta cidade");
		}
			
		return null;
	}
	
	public ArrayList<Cidade> procurarCidade(String search) {
		String sql = "SELECT * FROM cidade WHERE nome LIKE ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, search + '%');
			return setCidades(stmt);
			
		} catch (SQLException e) {
			System.err.println("Não foi possível pesquisar uma cidade");
		}
			
		return null;
	}
	
	public ArrayList<Cidade> procurarEstado(String estado) {
		String sql = "SELECT * FROM cidade WHERE estado = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, estado);
			return setCidades(stmt);
			
		} catch (SQLException e) {
			System.err.println("Não foi possível pesquisar um estado");
		}
			
		return null;
	}
	
	public ArrayList<Cidade> filtrarCapital(boolean capital) {
		String sql = "SELECT * FROM cidade WHERE capital = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setBoolean(1, capital);
			return setCidades(stmt);
			
		} catch (SQLException e) {
			System.err.println("Não foi possível filtrar as capitais");
		}
		
		return null;
	}
	
	private ArrayList<Cidade> setCidades(PreparedStatement stmt) {
		ArrayList<Cidade> cidades = new ArrayList<>();
		
		try {			
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
			e.printStackTrace();
		}
		
		return cidades;
	}
}
