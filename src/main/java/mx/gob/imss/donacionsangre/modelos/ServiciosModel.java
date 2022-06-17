package mx.gob.imss.donacionsangre.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ServiciosModel {
    @JsonProperty
    private String id;
    @JsonProperty
    private String desClaveEspecialidad;
    @JsonProperty
    private String nomEspecialidad;
    @JsonProperty
    private String indCe;
    @JsonProperty
    private String indHospital;
    @JsonProperty
    private String indIq;
    @JsonProperty
    private String indNivel1;
    @JsonProperty
    private String indNivel2;
    @JsonProperty
    private String indNivel3;
    @JsonProperty
    private String indCss;
    @JsonProperty
    private String fecExpira;
    @JsonProperty
    private String fecAlta;
    @JsonProperty
    private String fecActualizacion;
    @JsonProperty
    private String fecBaja;
    @JsonProperty
    private Boolean indActivo;

}
