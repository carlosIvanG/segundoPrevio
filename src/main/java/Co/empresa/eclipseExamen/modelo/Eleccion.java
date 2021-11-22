package Co.empresa.eclipseExamen.modelo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Data
public class Eleccion implements Serializable {
	private Integer id;
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private String cargo;
	
	
	public Eleccion(int id, String nombre, Date fechaInicio, Date fechaFin, String cargo) {
		this.id= id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cargo = cargo;
	}
	
	public Eleccion(String nombre, Date fechaInicio, Date fechaFin, String cargo) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cargo = cargo;
	}
	
	
}