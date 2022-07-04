package mx.gob.imss.donacionsangre.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteDonacionSangre {
	
	
	@JsonProperty
	private String desUnidadMedicaHospitalaria;
	@JsonProperty
    private String fecEfec;
	@JsonProperty
    private String idNombreBancoSangre;
    @JsonProperty
    private String nomCalle;
    @JsonProperty
    private String numExterior;
    @JsonProperty
    private String nomColonia;
    @JsonProperty
    private String desCodigoPostal;
    @JsonProperty
    private String idDelegacionMunicipio;
    @JsonProperty
    private String timHoraInicialAtencion;
    @JsonProperty
    private String timHoraFinalAtencion;
    @JsonProperty
    private String nss;
    @JsonProperty
    private String desNssAgregado;
    @JsonProperty
    private String fecInternamiento;
    @JsonProperty
    private String fecCirugia;
    @JsonProperty
    private String idServicio;
    @JsonProperty
    private String numTelefonoPaciente;
    @JsonProperty
    private String nomTrabajadorSocial;
    @JsonProperty
    private String desMatriculaTrabajadorSocial;
    @JsonProperty
    private String numTelefonoTrabajadorSocial;
    @JsonProperty
    private String desObservaciones;
    @JsonProperty
    private String nomPaciente;
}
