package modelo;

import java.sql.Date;

public class EducacionBasica {
	private int EDB_CODIGO;
	private String EDB_TITULO_OBTENIDO;
	private Date EDB_FECHA_GRADO;
	private String EDN_NIVEL_MAXIMO_OBTENIDO;

	public EducacionBasica(int eDB_CODIGO, String eDB_TITULO_OBTENIDO, Date eDB_FECHA_GRADO,
			String eDN_NIVEL_MAXIMO_OBTENIDO) {
		super();
		EDB_CODIGO = eDB_CODIGO;
		EDB_TITULO_OBTENIDO = eDB_TITULO_OBTENIDO;
		EDB_FECHA_GRADO = eDB_FECHA_GRADO;
		EDN_NIVEL_MAXIMO_OBTENIDO = eDN_NIVEL_MAXIMO_OBTENIDO;
	}

	public int getEDB_CODIGO() {
		return EDB_CODIGO;
	}

	public String getEDB_TITULO_OBTENIDO() {
		return EDB_TITULO_OBTENIDO;
	}

	public Date getEDB_FECHA_GRADO() {
		return EDB_FECHA_GRADO;
	}

	public String getEDN_NIVEL_MAXIMO_OBTENIDO() {
		return EDN_NIVEL_MAXIMO_OBTENIDO;
	}

	public void setEDB_CODIGO(int eDB_CODIGO) {
		EDB_CODIGO = eDB_CODIGO;
	}

	public void setEDB_TITULO_OBTENIDO(String eDB_TITULO_OBTENIDO) {
		EDB_TITULO_OBTENIDO = eDB_TITULO_OBTENIDO;
	}

	public void setEDB_FECHA_GRADO(Date eDB_FECHA_GRADO) {
		EDB_FECHA_GRADO = eDB_FECHA_GRADO;
	}

	public void setEDN_NIVEL_MAXIMO_OBTENIDO(String eDN_NIVEL_MAXIMO_OBTENIDO) {
		EDN_NIVEL_MAXIMO_OBTENIDO = eDN_NIVEL_MAXIMO_OBTENIDO;
	}
	
}
