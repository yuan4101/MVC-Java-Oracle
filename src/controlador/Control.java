package controlador;

import modelo.Database;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Control {

	public static void main(String[] args) throws IOException, SQLException {

		int varOpcion = -1;
		String varSql = "";
		Database varDatabase = new Database();
		
		BufferedReader varIn = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.println("1. Insertar un usuario");
			System.out.println("2. Mostrar todos los usarios");
			System.out.println("digite la opcion");
			varOpcion = Integer.parseInt(varIn.readLine());
			switch (varOpcion) {
			case 1:
				varSql = "INSERT INTO usuario VALUES(" + ",'" + "','"
						+ "')";
				int varRowCount = varDatabase.execute(varSql);
				System.out.println("Success - " + varRowCount + " rows affected.");
				varSql = "";
				break;
			case 2:
				ResultSet varResultado = null;
				varSql = "SELECT * FROM usuario";
				varResultado = varDatabase.query(varSql);
				
				do {

				} while (varResultado.next());
				varSql = "";
				break;
			default:
				System.out.println("Opcion Incorrecta");
			}
		} while (varOpcion != 3);
	}
}
