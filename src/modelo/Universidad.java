package modelo;

public class Universidad {
	private int UNI_CODIGO_IES;
	private String UNI_NOMBRE;
	
	public Universidad(int uNI_CODIGO_IES, String uNI_NOMBRE) {
		super();
		UNI_CODIGO_IES = uNI_CODIGO_IES;
		UNI_NOMBRE = uNI_NOMBRE;
	}

	public int getUNI_CODIGO_IES() {
		return UNI_CODIGO_IES;
	}

	public String getUNI_NOMBRE() {
		return UNI_NOMBRE;
	}

	public void setUNI_CODIGO_IES(int uNI_CODIGO_IES) {
		UNI_CODIGO_IES = uNI_CODIGO_IES;
	}

	public void setUNI_NOMBRE(String uNI_NOMBRE) {
		UNI_NOMBRE = uNI_NOMBRE;
	}
	
}
