package mx.gob.imss.donacionsangre.modelos;

import lombok.Data;

import java.util.List;

@Data
public class GenericConsultaVolanteDS {
private String status;
private String mensaje;
private List<ConsultaVolanteDSModelResponse> datosVolantesDonacion;
}
