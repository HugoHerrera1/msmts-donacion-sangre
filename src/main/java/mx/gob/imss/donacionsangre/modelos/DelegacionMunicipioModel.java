package mx.gob.imss.donacionsangre.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DelegacionMunicipioModel {
    @JsonProperty
    private Integer idDelegacionMunicipio;
    @JsonProperty
    private Integer idEstado;
    @JsonProperty
    private String nomMunicipio;
}
