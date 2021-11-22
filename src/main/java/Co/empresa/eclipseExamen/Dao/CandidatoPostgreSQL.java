package Co.empresa.eclipseExamen.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Co.empresa.eclipseExamen.modelo.Candidato;
import Co.empresa.eclipseExamen.util.ConexionPostgreSQL;

public class CandidatoPostgreSQL implements CandidatoDao {
	private ConexionPostgreSQL conexion;
	private static final String insertarCandidatoSQL = "INSERT INTO candidato(nombre, apellido, eleccion, numero) VALUES (?, ?, ?, ?)";
	private static final String eliminarCandidatoSQL = "DELETE FROM candidato WHERE id=?";
	private static final String actualizarCandidatoSQL = "UPDATE candidato SET nombre=?, apellido=?, eleccion=?, numero=? WHERE id=?";
	private static final String buscarCandidatoId = "SELECT * FROM candidato WHERE id=?";
	private static final String buscarCandidatos = "SELECT * FROM candidato";

	@Override
	public void insertarCandidato(Candidato candidato) throws SQLException {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(insertarCandidatoSQL);
			preparedStatement.setString(1, candidato.getNombre());
			preparedStatement.setString(1, candidato.getApellido());
			preparedStatement.setInt(1, candidato.getEleccion());
			preparedStatement.setInt(1, candidato.getNumero());
			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminarCandidato(int id) throws SQLException {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(eliminarCandidatoSQL);
			preparedStatement.setInt(1, id);
			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizarCandidato(Candidato candidato) throws SQLException {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(actualizarCandidatoSQL);
			preparedStatement.setString(1, candidato.getNombre());
			preparedStatement.setString(2, candidato.getApellido());
			preparedStatement.setString(3, candidato.getDocumento());
			preparedStatement.setInt(4, candidato.getNumero());
			preparedStatement.setInt(5, candidato.getEleccion());
			preparedStatement.setInt(6, candidato.getId());
			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Candidato> buscarCandidatos() {
		List<Candidato> candidato= new ArrayList<>();
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(buscarCandidatos);
			ResultSet rs = conexion.query();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String documento = rs.getString("documento");
				int numero = rs.getInt("numero");
				int eleccion = rs.getInt("eleccion");
				candidato.add(new Candidato(id, nombre, apellido, documento, numero, eleccion));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return candidato;
	}

	@Override
	public Candidato buscarCandidatoId(int id) {
		Candidato candidato = null;
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(buscarCandidatoId);

			preparedStatement.setInt(1, id);
			ResultSet rs = conexion.query();
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String documento = rs.getString("documento");
				int numero = rs.getInt("numero");
				int eleccion = rs.getInt("eleccion");
				candidato = new Candidato(id, nombre, apellido, documento, numero, eleccion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return candidato;
	}

}
