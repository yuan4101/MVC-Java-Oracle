package modelo;

public class Empresa {
	private int EMP_CODIGO;
	private int MUN_CODIGO;
	private String EMP_RAZONSOCIAL;
	private String EMP_TIPO;
	private String EMP_DIRECCION;
	private int EMP_TELEFONO;
	private String EMP_CORREO_ELECTRONICO;

	public Empresa(int eMP_CODIGO, int mUN_CODIGO, String eMP_RAZONSOCIAL, String eMP_TIPO, String eMP_DIRECCION,
			int eMP_TELEFONO, String eMP_CORREO_ELECTRONICO) {
		super();
		EMP_CODIGO = eMP_CODIGO;
		MUN_CODIGO = mUN_CODIGO;
		EMP_RAZONSOCIAL = eMP_RAZONSOCIAL;
		EMP_TIPO = eMP_TIPO;
		EMP_DIRECCION = eMP_DIRECCION;
		EMP_TELEFONO = eMP_TELEFONO;
		EMP_CORREO_ELECTRONICO = eMP_CORREO_ELECTRONICO;
	}

	public int getEMP_CODIGO() {
		return EMP_CODIGO;
	}

	public int getMUN_CODIGO() {
		return MUN_CODIGO;
	}

	public String getEMP_RAZONSOCIAL() {
		return EMP_RAZONSOCIAL;
	}

	public String getEMP_TIPO() {
		return EMP_TIPO;
	}

	public String getEMP_DIRECCION() {
		return EMP_DIRECCION;
	}

	public int getEMP_TELEFONO() {
		return EMP_TELEFONO;
	}

	public String getEMP_CORREO_ELECTRONICO() {
		return EMP_CORREO_ELECTRONICO;
	}

	public void setEMP_CODIGO(int eMP_CODIGO) {
		EMP_CODIGO = eMP_CODIGO;
	}

	public void setMUN_CODIGO(int mUN_CODIGO) {
		MUN_CODIGO = mUN_CODIGO;
	}

	public void setEMP_RAZONSOCIAL(String eMP_RAZONSOCIAL) {
		EMP_RAZONSOCIAL = eMP_RAZONSOCIAL;
	}

	public void setEMP_TIPO(String eMP_TIPO) {
		EMP_TIPO = eMP_TIPO;
	}

	public void setEMP_DIRECCION(String eMP_DIRECCION) {
		EMP_DIRECCION = eMP_DIRECCION;
	}

	public void setEMP_TELEFONO(int eMP_TELEFONO) {
		EMP_TELEFONO = eMP_TELEFONO;
	}

	public void setEMP_CORREO_ELECTRONICO(String eMP_CORREO_ELECTRONICO) {
		EMP_CORREO_ELECTRONICO = eMP_CORREO_ELECTRONICO;
	}
	
}
