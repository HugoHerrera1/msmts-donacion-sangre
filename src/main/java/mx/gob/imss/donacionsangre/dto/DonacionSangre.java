package mx.gob.imss.donacionsangre.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("donacionSangre")
public class DonacionSangre {

    @JsonProperty
    private String umh;
    @JsonProperty
    private String fecha;
    @JsonProperty
    private Integer idBancoSangre;
    @JsonProperty
    private String horaInicialAtencion;
    @JsonProperty
    private String horaFinalAtencion;
    @JsonProperty
    private String codigoPostal;
    @JsonProperty
    private String idEstado;
    @JsonProperty
    private String idDelegacion;
    @JsonProperty
    private Integer idCiudad;
    @JsonProperty
    private String colonia;
    @JsonProperty
    private String calle;
    @JsonProperty
    private String numExterior;
    @JsonProperty
    private String numInterior;
    @JsonProperty
    private String nombrePaciente;
    @JsonProperty
    private String desNSS;
    @JsonProperty
    private String tipoSangre;
    @JsonProperty
    private String idServicio;
    @JsonProperty
    private String fechaInternamiento;
    @JsonProperty
    private String fechaCirugia;
    @JsonProperty
    private String numTelefonoPaciente;
    @JsonProperty
    private String nombreTrabajadorSocial;
    @JsonProperty
    private String matriculaTrabajadorSocial;
    @JsonProperty
    private String numTelefonoTrabajadorSocial;
    @JsonProperty
    private String observaciones;

}
