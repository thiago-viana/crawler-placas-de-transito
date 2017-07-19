package thiago.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import thiago.model.Placa;

public class PlacaDAO extends BaseDAO {
	
	public void salvar(Placa placa) throws SQLException {
		
		Connection conn = null; 
		PreparedStatement stmt = null;
		
		try {
			
			conn = getConnection();
			stmt = conn.prepareStatement("INSERT INTO placas (sigla,titulo,descricao,imagem)"
					+ " VALUES(?,?,?,?)");
			stmt.setString(1, placa.getSigla());
			stmt.setString(2, placa.getTitulo());
			stmt.setString(3, placa.getDescricao());
			stmt.setString(4, placa.getImagem());
			stmt.executeUpdate();
			
		} finally {
			
			if (stmt != null)
				stmt.close();
			
			if (conn != null) {
				conn.close();
			}
		}
	}
}

