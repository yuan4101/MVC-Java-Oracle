package modelo;

public class PaisModel {
	private int PAI_CODIGO;
	private String PAI_NOMBRE;
	
	public PaisModel(int pAI_CODIGO, String pAI_NOMBRE) {
		super();
		PAI_CODIGO = pAI_CODIGO;
		PAI_NOMBRE = pAI_NOMBRE;
	}
	
	public int getPAI_CODIGO() {
		return PAI_CODIGO;
	}

	public String getPAI_NOMBRE() {
		return PAI_NOMBRE;
	}

	public void setPAI_CODIGO(int pAI_CODIGO) {
		PAI_CODIGO = pAI_CODIGO;
	}

	public void setPAI_NOMBRE(String pAI_NOMBRE) {
		PAI_NOMBRE = pAI_NOMBRE;
	}
	
}
