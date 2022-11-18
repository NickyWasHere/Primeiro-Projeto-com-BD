import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CidadeDAO {

	private Connection conn;
	
	public CidadeDAO() {
		this.conn = new ConnectionFactory().getConnection();
		System.out.println("Conectado");
		System.out.println();
	}
	
	public void inserirCidade(Cidade cidade) throws SQLException {
		String sql = "INSERT INTO cidade VALUES (?,?,?,?,?,?,?)";
		
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
	}
	
	public void removerCidade(int ddd) throws SQLException {
		String sql = "DELETE FROM cidade WHERE ddd = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, ddd);
		stmt.execute();
		stmt.close();
		
		System.out.println();
		System.out.println("Cidade deletada com sucesso");
		System.out.println();
	}
}
