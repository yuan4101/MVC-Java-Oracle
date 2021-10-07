package Access;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.PaisModel;
import modelo.clsDatabase;

public class PaisDAO extends clsMensajero{
	
	private clsDatabase varDatabase = null;
	
	public ArrayList<PaisModel> obtenerPaises(){
		ArrayList<PaisModel> listPaisModel = new ArrayList<PaisModel>();
		try {
			String varSql = "SELECT * FROM pais";
			PreparedStatement varStatement = varDatabase.varConnection.prepareStatement(varSql);
			ResultSet varResultado = varStatement.executeQuery(varSql);
			while (varResultado.next()) {
				PaisModel varPaisModel = new PaisModel(varResultado.getInt("PAI_CODIGO"), varResultado.getString("PAI_NOMBRE"));
				listPaisModel.add(varPaisModel);
			}
		} catch (SQLException e) {
			atrMensaje = "ERROR: " + e.getMessage();
		}
		return listPaisModel;
	}
	
	public PaisModel obtenerPais(int prmCodigo) {
		return null;
	}
	
	public void agregarPais(PaisModel prmPais) {
		try {
			String varSql = "INSERT INTO pais(PAI_CODIGO, PAI_NOMBRE)"
					+ " VALUES(?, ?)";
			PreparedStatement varStatement = varDatabase.varConnection.prepareStatement(varSql);
			varStatement.setInt(1, prmPais.getPAI_CODIGO());
			varStatement.setString(2, prmPais.getPAI_NOMBRE());
			int rowsInserted = varStatement.executeUpdate();
			atrMensaje = rowsInserted + " rows affected";
		} catch (SQLException e) {
			atrMensaje = "ERROR: " + e.getMessage();
		}
	}
	
	public void actualizarPais(PaisModel prmPais) {
		try {
			String varSql = "UPDATE pais SET PAI_NOMBRE = ? WHERE PAI_CODIGO = ?";
			PreparedStatement varStatement = varDatabase.varConnection.prepareStatement(varSql);
			varStatement.setInt(2, prmPais.getPAI_CODIGO());
			varStatement.setString(1, prmPais.getPAI_NOMBRE());
			int rowsUpdated = varStatement.executeUpdate();
			atrMensaje = rowsUpdated + " rows affected";
		} catch (SQLException e) {
			atrMensaje = "ERROR: " + e.getMessage();
		}
	}
	
	public void eliminarPais(int prmCodigo) {
		
	}

	public clsDatabase getVarDatabase() {
		return varDatabase;
	}

	public void setVarDatabase(clsDatabase varDatabase) {
		this.varDatabase = varDatabase;
	}
	
}
