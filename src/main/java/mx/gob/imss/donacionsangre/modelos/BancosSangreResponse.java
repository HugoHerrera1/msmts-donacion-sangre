package mx.gob.imss.donacionsangre.modelos;

import lombok.Data;

import java.util.List;

@Data
public class BancosSangreResponse {
    private String status;
    private String mensaje;
    private List<BancosSangre> datosBancosSangre;
}
