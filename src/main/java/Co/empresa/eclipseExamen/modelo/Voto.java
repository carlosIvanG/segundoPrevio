package Co.empresa.eclipseExamen.modelo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
public class Voto implements Serializable {
	private Integer id;
	private Date fechaCreacion;
	private Date fechaVoto;
	private String uuid;
	private String enlace;
	private Integer estamento;
	
		
}
