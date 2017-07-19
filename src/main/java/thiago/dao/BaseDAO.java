package thiago.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	
	protected Connection getConnection() throws SQLException {
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/detran?useSSL=false", "root", "root");
		return conn;
	}
}
