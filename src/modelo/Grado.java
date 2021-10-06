package modelo;

import java.sql.Date;

public class Grado {
	private int GRA_CODIGO;
	private int PRO_CODIGO_SNIES;
	private int PER_NUMEROIDENTIFICACION;
	private int GRA_NO_SEMES_APROB;
	private String GRA_ESTADO_GRADO;
	private Date GRA_FECHA_GRADO;
	private int GRA_NO_TARJETA_P;
	
	public Grado(int gRA_CODIGO, int pRO_CODIGO_SNIES, int pER_NUMEROIDENTIFICACION, int gRA_NO_SEMES_APROB,
			String gRA_ESTADO_GRADO, Date gRA_FECHA_GRADO, int gRA_NO_TARJETA_P) {
		super();
		GRA_CODIGO = gRA_CODIGO;
		PRO_CODIGO_SNIES = pRO_CODIGO_SNIES;
		PER_NUMEROIDENTIFICACION = pER_NUMEROIDENTIFICACION;
		GRA_NO_SEMES_APROB = gRA_NO_SEMES_APROB;
		GRA_ESTADO_GRADO = gRA_ESTADO_GRADO;
		GRA_FECHA_GRADO = gRA_FECHA_GRADO;
		GRA_NO_TARJETA_P = gRA_NO_TARJETA_P;
	}

	public int getGRA_CODIGO() {
		return GRA_CODIGO;
	}

	public int getPRO_CODIGO_SNIES() {
		return PRO_CODIGO_SNIES;
	}

	public int getPER_NUMEROIDENTIFICACION() {
		return PER_NUMEROIDENTIFICACION;
	}

	public int getGRA_NO_SEMES_APROB() {
		return GRA_NO_SEMES_APROB;
	}

	public String getGRA_ESTADO_GRADO() {
		return GRA_ESTADO_GRADO;
	}

	public Date getGRA_FECHA_GRADO() {
		return GRA_FECHA_GRADO;
	}

	public int getGRA_NO_TARJETA_P() {
		return GRA_NO_TARJETA_P;
	}

	public void setGRA_CODIGO(int gRA_CODIGO) {
		GRA_CODIGO = gRA_CODIGO;
	}

	public void setPRO_CODIGO_SNIES(int pRO_CODIGO_SNIES) {
		PRO_CODIGO_SNIES = pRO_CODIGO_SNIES;
	}

	public void setPER_NUMEROIDENTIFICACION(int pER_NUMEROIDENTIFICACION) {
		PER_NUMEROIDENTIFICACION = pER_NUMEROIDENTIFICACION;
	}

	public void setGRA_NO_SEMES_APROB(int gRA_NO_SEMES_APROB) {
		GRA_NO_SEMES_APROB = gRA_NO_SEMES_APROB;
	}

	public void setGRA_ESTADO_GRADO(String gRA_ESTADO_GRADO) {
		GRA_ESTADO_GRADO = gRA_ESTADO_GRADO;
	}

	public void setGRA_FECHA_GRADO(Date gRA_FECHA_GRADO) {
		GRA_FECHA_GRADO = gRA_FECHA_GRADO;
	}

	public void setGRA_NO_TARJETA_P(int gRA_NO_TARJETA_P) {
		GRA_NO_TARJETA_P = gRA_NO_TARJETA_P;
	}
	
}
