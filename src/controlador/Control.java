package controlador;

import modelo.Database;
import vista.Usuario;
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
		
		Usuario varUser = new Usuario();
		BufferedReader varIn = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.println("1. Insertar un usuario");
			System.out.println("2. Mostrar todos los usarios");
			System.out.println("digite la opcion");
			varOpcion = Integer.parseInt(varIn.readLine());
			switch (varOpcion) {
			case 1:
				varUser.setCodigo(1);
				varUser.setUsername("admin");
				varUser.setPassword("password");
				varSql = "INSERT INTO usuario VALUES(" + varUser.getCodigo() + ",'" + varUser.getUsername() + "','"
						+ varUser.getPassword() + "')";
				int varRowCount = varDatabase.execute(varSql);
				System.out.println("Success - " + varRowCount + " rows affected.");
				varSql = "";
				break;
			case 2:
				ResultSet varResultado = null;
				varSql = "SELECT * FROM usuario";
				varResultado = varDatabase.query(varSql);
				
				do {
					varUser.setCodigo(varResultado.getInt(1));
					varUser.setUsername(varResultado.getString(2));
					varUser.setPassword(varResultado.getNString(3));

					System.out.println("Codigo: " + varUser.getCodigo());
					System.out.println("User: " + varUser.getUsername());
					System.out.println("Password: " + varUser.getPassword());
				} while (varResultado.next());
				varSql = "";
				break;
			default:
				System.out.println("Opcion Incorrecta");
			}
		} while (varOpcion != 3);
	}
}
