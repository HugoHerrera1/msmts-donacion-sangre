package mx.gob.imss.donacionsangre.modelos;

import lombok.Data;

@Data
public class ConsultaVolantesDS {
private String status;
private String mensaje;
private DonacionSangreResponse datosVolantesDonacion;
}
