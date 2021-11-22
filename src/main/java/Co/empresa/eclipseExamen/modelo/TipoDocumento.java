package Co.empresa.eclipseExamen.modelo;

import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Data
public class TipoDocumento implements Serializable {
	private Integer id;
	private String descripcion;

}
