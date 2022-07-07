package mx.gob.imss.donacionsangre.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CiudadesModel {
    @JsonProperty
    private String cve_ciudad;
    @JsonProperty
    private String cve_estado;
    @JsonProperty
    private String cve_delegacion_municipio;
    @JsonProperty
    private String des_ciudad;
    @JsonProperty
    private String fec_alta;
    @JsonProperty
    private String fec_actualizacion;
    @JsonProperty
    private String fec_baja;
    @JsonProperty
    private String ind_activo;
}
