package modelo;

public class Competencia {
	private String COM_ORAL;
	private String COM_ESCRITA;
	private String COM_LECTORA;
	private int COM_CODIGO;
	private int IDI_CODIGO;

	public Competencia(String cOM_ORAL, String cOM_ESCRITA, String cOM_LECTORA, int cOM_CODIGO, int iDI_CODIGO) {
		super();
		COM_ORAL = cOM_ORAL;
		COM_ESCRITA = cOM_ESCRITA;
		COM_LECTORA = cOM_LECTORA;
		COM_CODIGO = cOM_CODIGO;
		IDI_CODIGO = iDI_CODIGO;
	}

	public String getCOM_ORAL() {
		return COM_ORAL;
	}

	public String getCOM_ESCRITA() {
		return COM_ESCRITA;
	}

	public String getCOM_LECTORA() {
		return COM_LECTORA;
	}

	public int getCOM_CODIGO() {
		return COM_CODIGO;
	}

	public int getIDI_CODIGO() {
		return IDI_CODIGO;
	}

	public void setCOM_ORAL(String cOM_ORAL) {
		COM_ORAL = cOM_ORAL;
	}

	public void setCOM_ESCRITA(String cOM_ESCRITA) {
		COM_ESCRITA = cOM_ESCRITA;
	}

	public void setCOM_LECTORA(String cOM_LECTORA) {
		COM_LECTORA = cOM_LECTORA;
	}

	public void setCOM_CODIGO(int cOM_CODIGO) {
		COM_CODIGO = cOM_CODIGO;
	}

	public void setIDI_CODIGO(int iDI_CODIGO) {
		IDI_CODIGO = iDI_CODIGO;
	}
	
}
