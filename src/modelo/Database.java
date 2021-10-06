package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class Database {
	Connection varConnection = null;

	public Database() {
		connect();
	}

	public void connect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			varConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hojaDeVida", "AnteDatabase");
			System.out.println("Se conecto a la base de datos correctamente");
		} catch (Exception e) {
			System.out.println("No se pudo conectar la base de datos " + e.getMessage());
		}
	}

	public void closedConnection() throws SQLException {
		varConnection.close();
		System.out.println("Se cerro la conexion");
	}

	public ResultSet query(String prmSql) {
		ResultSet varResultado = null;
		try {
			Statement varSentencia = varConnection.createStatement();
			varResultado = varSentencia.executeQuery(prmSql);
			if (varResultado.next()) {
				return varResultado;
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		return null;
	}

	public int execute(String prmSql) {
		int varResultado = -1;
		try {
			Statement varSentencia = varConnection.createStatement();
			varResultado = varSentencia.executeUpdate(prmSql);
			if (varResultado != 0) {
				return varResultado;
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		return 0;
	}
}