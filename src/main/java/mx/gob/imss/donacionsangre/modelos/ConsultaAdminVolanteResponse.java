package mx.gob.imss.donacionsangre.modelos;

import lombok.Data;

@Data
public class ConsultaAdminVolanteResponse {
    private Integer idVolanteDonacionSangre;
    private String nss;
    private String nombrePaciente;
    private String tipoSangre;
    private String nombreTrabajadorSocial;
    private String matriculaTrabajadorSocial;
    private String numTelefonoTrabajadorSocial;
    private String fechaInternamiento;
    private String fechaCirugia;
    private String fecEfec;
}
