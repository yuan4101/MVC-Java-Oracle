package Access;

import java.sql.ResultSet;

public class clsMensajero {
	protected static String atrMensaje;
	protected static ResultSet atrResultado;
	public static String darMensaje() { return atrMensaje; }
	public static ResultSet darResultado() { return atrResultado; }
}
