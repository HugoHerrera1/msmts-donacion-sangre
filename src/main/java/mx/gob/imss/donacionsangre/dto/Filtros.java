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
public class Filtros {

    @JsonProperty
    private String fechaIni;
    @JsonProperty
    private String fechaFin;
    @JsonProperty
    private String nssPaciente;
    @JsonProperty
    private String agregadoMedico;


}
