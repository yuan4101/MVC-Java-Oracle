package modelo;

public class Departamento {
	private int DEP_CODIGO;
	private int PAI_CODIGO;
	private String DEP_NOMBRE;

	public Departamento(int dEP_CODIGO, int pAI_CODIGO, String dEP_NOMBRE) {
		super();
		DEP_CODIGO = dEP_CODIGO;
		PAI_CODIGO = pAI_CODIGO;
		DEP_NOMBRE = dEP_NOMBRE;
	}

	public int getDEP_CODIGO() {
		return DEP_CODIGO;
	}

	public int getPAI_CODIGO() {
		return PAI_CODIGO;
	}

	public String getDEP_NOMBRE() {
		return DEP_NOMBRE;
	}

	public void setDEP_CODIGO(int dEP_CODIGO) {
		DEP_CODIGO = dEP_CODIGO;
	}

	public void setPAI_CODIGO(int pAI_CODIGO) {
		PAI_CODIGO = pAI_CODIGO;
	}

	public void setDEP_NOMBRE(String dEP_NOMBRE) {
		DEP_NOMBRE = dEP_NOMBRE;
	}
	
}
