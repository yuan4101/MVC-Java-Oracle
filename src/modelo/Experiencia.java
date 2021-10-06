package modelo;

import java.sql.Date;

public class Experiencia {
	private int EMP_CODIGO;
	private int PER_NUMEROIDENTIFICACION;
	private Date EXP_FECHA_INGRESO;
	private Date EXP_FECHA_EGRESO;
	private String EXP_ACTUAL;
	private String EXP_CARGO;
	private String EXP_DEPENDENCIA;
	
	public Experiencia(int eMP_CODIGO, int pER_NUMEROIDENTIFICACION, Date eXP_FECHA_INGRESO, Date eXP_FECHA_EGRESO,
			String eXP_ACTUAL, String eXP_CARGO, String eXP_DEPENDENCIA) {
		super();
		EMP_CODIGO = eMP_CODIGO;
		PER_NUMEROIDENTIFICACION = pER_NUMEROIDENTIFICACION;
		EXP_FECHA_INGRESO = eXP_FECHA_INGRESO;
		EXP_FECHA_EGRESO = eXP_FECHA_EGRESO;
		EXP_ACTUAL = eXP_ACTUAL;
		EXP_CARGO = eXP_CARGO;
		EXP_DEPENDENCIA = eXP_DEPENDENCIA;
	}

	public int getEMP_CODIGO() {
		return EMP_CODIGO;
	}

	public int getPER_NUMEROIDENTIFICACION() {
		return PER_NUMEROIDENTIFICACION;
	}

	public Date getEXP_FECHA_INGRESO() {
		return EXP_FECHA_INGRESO;
	}

	public Date getEXP_FECHA_EGRESO() {
		return EXP_FECHA_EGRESO;
	}

	public String getEXP_ACTUAL() {
		return EXP_ACTUAL;
	}

	public String getEXP_CARGO() {
		return EXP_CARGO;
	}

	public String getEXP_DEPENDENCIA() {
		return EXP_DEPENDENCIA;
	}

	public void setEMP_CODIGO(int eMP_CODIGO) {
		EMP_CODIGO = eMP_CODIGO;
	}

	public void setPER_NUMEROIDENTIFICACION(int pER_NUMEROIDENTIFICACION) {
		PER_NUMEROIDENTIFICACION = pER_NUMEROIDENTIFICACION;
	}

	public void setEXP_FECHA_INGRESO(Date eXP_FECHA_INGRESO) {
		EXP_FECHA_INGRESO = eXP_FECHA_INGRESO;
	}

	public void setEXP_FECHA_EGRESO(Date eXP_FECHA_EGRESO) {
		EXP_FECHA_EGRESO = eXP_FECHA_EGRESO;
	}

	public void setEXP_ACTUAL(String eXP_ACTUAL) {
		EXP_ACTUAL = eXP_ACTUAL;
	}

	public void setEXP_CARGO(String eXP_CARGO) {
		EXP_CARGO = eXP_CARGO;
	}

	public void setEXP_DEPENDENCIA(String eXP_DEPENDENCIA) {
		EXP_DEPENDENCIA = eXP_DEPENDENCIA;
	}
	
}
