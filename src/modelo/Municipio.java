package modelo;

public class Municipio {
	private int MUN_CODIGO;
	private int DEP_CODIGO;
	private String MUN_NOMBRE;
	
	public Municipio(int mUN_CODIGO, int dEP_CODIGO, String mUN_NOMBRE) {
		super();
		MUN_CODIGO = mUN_CODIGO;
		DEP_CODIGO = dEP_CODIGO;
		MUN_NOMBRE = mUN_NOMBRE;
	}

	public int getMUN_CODIGO() {
		return MUN_CODIGO;
	}

	public int getDEP_CODIGO() {
		return DEP_CODIGO;
	}

	public String getMUN_NOMBRE() {
		return MUN_NOMBRE;
	}

	public void setMUN_CODIGO(int mUN_CODIGO) {
		MUN_CODIGO = mUN_CODIGO;
	}

	public void setDEP_CODIGO(int dEP_CODIGO) {
		DEP_CODIGO = dEP_CODIGO;
	}

	public void setMUN_NOMBRE(String mUN_NOMBRE) {
		MUN_NOMBRE = mUN_NOMBRE;
	}
	
}
