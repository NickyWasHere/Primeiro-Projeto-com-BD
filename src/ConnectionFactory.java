import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	//Classe responsável por gerar a conexão com o banco de dados

	public Connection getConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Eclipse", "postgres", "123");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
