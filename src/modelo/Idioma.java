package modelo;

public class Idioma {
	private int IDI_CODIGO;
	private int PER_NUMEROIDENTIFICACION;
	private String IDI_NOMBRE;
	
	public Idioma(int iDI_CODIGO, int pER_NUMEROIDENTIFICACION, String iDI_NOMBRE) {
		super();
		IDI_CODIGO = iDI_CODIGO;
		PER_NUMEROIDENTIFICACION = pER_NUMEROIDENTIFICACION;
		IDI_NOMBRE = iDI_NOMBRE;
	}

	public int getIDI_CODIGO() {
		return IDI_CODIGO;
	}

	public int getPER_NUMEROIDENTIFICACION() {
		return PER_NUMEROIDENTIFICACION;
	}

	public String getIDI_NOMBRE() {
		return IDI_NOMBRE;
	}

	public void setIDI_CODIGO(int iDI_CODIGO) {
		IDI_CODIGO = iDI_CODIGO;
	}

	public void setPER_NUMEROIDENTIFICACION(int pER_NUMEROIDENTIFICACION) {
		PER_NUMEROIDENTIFICACION = pER_NUMEROIDENTIFICACION;
	}

	public void setIDI_NOMBRE(String iDI_NOMBRE) {
		IDI_NOMBRE = iDI_NOMBRE;
	}
	
}
