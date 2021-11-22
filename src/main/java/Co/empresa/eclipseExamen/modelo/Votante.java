package Co.empresa.eclipseExamen.modelo;

import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Data
public class Votante implements Serializable {
	private Integer id;
	private String nombre;
	private String email;
	private String documento;
	private Integer tipoDocumento;
	private Integer eleccion;

}
