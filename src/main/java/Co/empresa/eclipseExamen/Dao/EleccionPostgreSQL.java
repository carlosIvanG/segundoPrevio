package Co.empresa.eclipseExamen.Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Co.empresa.eclipseExamen.modelo.Eleccion;
import Co.empresa.eclipseExamen.util.ConexionPostgreSQL;

public class EleccionPostgreSQL implements EleccionDao{
	private ConexionPostgreSQL conexion;
	private static final String insertarEleccionSQL = "INSERT INTO candidato(nombre, apellido, eleccion, numero) VALUES (?, ?, ?, ?)";
	private static final String eliminarEleccionSQL = "DELETE FROM candidato WHERE id=?";
	private static final String actualizarEleccionSQL = "UPDATE candidato SET nombre=?, apellido=?, eleccion=?, numero=? WHERE id=?";
	private static final String buscarEleccionId = "SELECT * FROM candidato WHERE id=?";
	private static final String buscarElecciones = "SELECT * FROM candidato";
	@Override
	public void insertarEleccion(Eleccion eleccion) throws SQLException {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(insertarEleccionSQL);
			preparedStatement.setString(1, eleccion.getNombre());
			preparedStatement.setDate(1, (Date) eleccion.getFechaInicio());
			preparedStatement.setDate(1, (Date) eleccion.getFechaFin());
			preparedStatement.setString(1, eleccion.getCargo());
			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminarEleccion(int id) throws SQLException {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(eliminarEleccionSQL);
			preparedStatement.setInt(1, id);
			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizarEleccion(Eleccion eleccion) throws SQLException {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(actualizarEleccionSQL);
			preparedStatement.setString(1, eleccion.getNombre());
			preparedStatement.setDate(2, (Date) eleccion.getFechaInicio());
			preparedStatement.setDate(3, (Date) eleccion.getFechaFin());
			preparedStatement.setString(4, eleccion.getCargo());
			preparedStatement.setInt(6, eleccion.getId());
			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Eleccion> buscarElecciones() {
		List<Eleccion> eleccion= new ArrayList<>();
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(buscarElecciones);
			ResultSet rs = conexion.query();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				Date apellido = rs.getDate("fechaInicio");
				Date documento = rs.getDate("fechaFin");
				String numero = rs.getString("Cargo");
				eleccion.add(new Eleccion(id, nombre, apellido, documento, numero));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eleccion;
	}

	@Override
	public Eleccion buscarEleccionId(int id) {
		Eleccion eleccion = null;
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(buscarEleccionId);

			preparedStatement.setInt(1, id);
			ResultSet rs = conexion.query();
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				Date apellido = rs.getDate("fechaInicio");
				Date documento = rs.getDate("fechaFin");
				String numero = rs.getString("Cargo");
				eleccion=new Eleccion(id, nombre, apellido, documento, numero);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eleccion;
	}

}
