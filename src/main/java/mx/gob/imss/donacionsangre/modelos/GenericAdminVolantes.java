package mx.gob.imss.donacionsangre.modelos;

import lombok.Data;

import java.util.List;

@Data
public class GenericAdminVolantes {
    private String status;
    private String mensaje;
    private List<ConsultaAdminVolanteResponse> datosVolantesDonacion;
}
