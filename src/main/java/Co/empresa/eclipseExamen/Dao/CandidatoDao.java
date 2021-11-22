package Co.empresa.eclipseExamen.Dao;

import java.sql.SQLException;
import java.util.List;

import Co.empresa.eclipseExamen.modelo.Candidato;

public interface CandidatoDao {
	public void insertarCandidato(Candidato candidato) throws SQLException;
	public void eliminarCandidato(int id) throws SQLException;
	public void actualizarCandidato(Candidato candidato) throws SQLException;
	public List<Candidato> buscarCandidatos();
	public Candidato buscarCandidatoId(int id);
}
