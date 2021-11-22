package Co.empresa.eclipseExamen.modelo;

import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Data
public class Candidato implements Serializable {
	private int id;
	private String nombre;
	private String apellido;
	private String documento;
	private int numero; 
	private int eleccion;
	
	
	public Candidato(int id, String nombre, String apellido, String documento, int numero, int eleccion) {
		this.id=id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.numero = numero;
		this.eleccion = eleccion;
	}
	
	public Candidato(String nombre, String apellido, String documento, int numero, int eleccion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.numero = numero;
		this.eleccion = eleccion;
	}
	
	
}