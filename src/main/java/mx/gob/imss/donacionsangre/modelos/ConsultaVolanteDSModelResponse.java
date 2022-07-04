package mx.gob.imss.donacionsangre.modelos;

import lombok.Data;

@Data
public class ConsultaVolanteDSModelResponse {

    private Integer idVolanteDonacionSangre;
    private String nombreTrabajadorSocial;
    private String matriculaTrabajadorSocial;
    private String numTelefonoTrabajadorSocial;
    private String fechaInternamiento;
    private String fechaCirugia;
    private String fecEfec;

}
