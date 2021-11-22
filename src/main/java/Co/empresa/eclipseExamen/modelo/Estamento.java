package Co.empresa.eclipseExamen.modelo;

import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Data
public class Estamento implements Serializable {
	private Integer id;
	private Integer eleccion;
	private String descripcion;
}
