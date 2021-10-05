package vista;

public class Usuario {
	private int atrCodigo;
	private String atrUsername;
	private String atrPassword;

	public Usuario() {
	}

	public Usuario(int prmCodigo, String prmUsername, String prmPassword) {
		this.atrCodigo = prmCodigo;
		this.atrUsername = prmUsername;
		this.atrPassword = prmPassword;
	}

	public int getCodigo() {
		return atrCodigo;
	}

	public void setCodigo(int prmCodigo) {
		this.atrCodigo = prmCodigo;
	}

	public String getUsername() {
		return atrUsername;
	}

	public void setUsername(String prmUsername) {
		this.atrUsername = prmUsername;
	}

	public String getPassword() {
		return atrPassword;
	}

	public void setPassword(String prmPassword) {
		this.atrPassword = prmPassword;
	}
}