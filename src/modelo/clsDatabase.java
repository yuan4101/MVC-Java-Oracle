package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Access.clsMensajero;

import java.sql.DriverManager;

public class clsDatabase extends clsMensajero{
	
	public Connection varConnection = null;

	public Boolean connect(String prmUser, String prmPassword) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			varConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", prmUser, prmPassword);
			atrMensaje = "Se conecto a la base de datos correctamente - " + varConnection.getSchema();
			return true;
		} catch (Exception e) {
			atrMensaje = "ERROR: " + e.getMessage();
			return false;
		}
	}

	public void closedConnection() throws SQLException {
		varConnection.close();
		atrMensaje = "Se cerro la conexion";
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
			atrMensaje = "ERROR: " + e.getMessage();
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
			atrMensaje = "ERROR: " + e.getMessage();
		}
		return 0;
	}
}