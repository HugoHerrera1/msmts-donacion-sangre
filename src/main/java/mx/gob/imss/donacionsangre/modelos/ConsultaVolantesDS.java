package mx.gob.imss.donacionsangre.modelos;

import lombok.Data;

import java.util.List;

@Data
public class ConsultaVolantesDS {
private String status;
private String mensaje;
private DonacionSangreResponse datosVolantesDonacion;
}
