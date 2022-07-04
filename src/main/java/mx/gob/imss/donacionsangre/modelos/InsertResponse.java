package mx.gob.imss.donacionsangre.modelos;

import lombok.Data;

@Data
public class InsertResponse {
    private String status;
    private Integer idVolanteDonacionSangre;
    private String mensaje;
}
