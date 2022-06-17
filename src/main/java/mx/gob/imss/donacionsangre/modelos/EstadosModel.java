package mx.gob.imss.donacionsangre.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EstadosModel {

    @JsonProperty
    private Integer idEstado;

    @JsonProperty
    private String nomCompleto;

    @JsonProperty
    private String nomAbreviado;
}
