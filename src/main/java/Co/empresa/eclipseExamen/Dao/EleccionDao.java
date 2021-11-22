package Co.empresa.eclipseExamen.Dao;

import java.sql.SQLException;
import java.util.List;

import Co.empresa.eclipseExamen.modelo.Eleccion;

public interface EleccionDao {
	public void insertarEleccion(Eleccion eleccion) throws SQLException;
	public void eliminarEleccion(int id) throws SQLException;
	public void actualizarEleccion(Eleccion eleccion) throws SQLException;
	public List<Eleccion> buscarElecciones();
	public Eleccion buscarEleccionId(int id);
}
