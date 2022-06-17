package mx.gob.imss.donacionsangre.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CiudadesModel {
    @JsonProperty
    private Integer idCiudad;
    @JsonProperty
    private Integer idEstado;
    @JsonProperty
    private Integer idDelegacionMunicipio;
    @JsonProperty
    private String nomCiudad;
}
