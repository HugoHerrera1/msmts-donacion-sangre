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
	private String uMedicaH;
	@JsonProperty
    private String fechaSolc;
	@JsonProperty
    private String nombreBancoS;
    @JsonProperty
    private String calleBanco;
    @JsonProperty
    private String noBanco;
    @JsonProperty
    private String colBanco;
    @JsonProperty
    private String cpBanco;
    @JsonProperty
    private String alcaldiaBanco;
    @JsonProperty
    private String hrDesde;
    @JsonProperty
    private String hrHasta;
    @JsonProperty
    private String nss;
    @JsonProperty
    private String agregado;
    @JsonProperty
    private String fechaInter;
    @JsonProperty
    private String fechaCir;
    @JsonProperty
    private String servicio;
    @JsonProperty
    private String telPaciente;
    @JsonProperty
    private String nombreTS;
    @JsonProperty
    private String matricula;
    @JsonProperty
    private String telTS;
    @JsonProperty
    private String observaciones;
    @JsonProperty
    private String nombrePac;
}
