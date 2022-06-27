package mx.gob.imss.donacionsangre.controladores;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.donacionsangre.dto.DonacionSangre;
import mx.gob.imss.donacionsangre.modelos.DonacionSangreResponse;
import mx.gob.imss.donacionsangre.servicios.DonacionSangreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/msmts-donacion-sangre/api")
public class DonacionSangreControlador {
    @Autowired
    DonacionSangreServices donaSangre;

    @PostMapping(value = "/guardaNuevoVolanteDonacionSangre",
            produces = "application/json",
            consumes = "application/json")
    public ResponseEntity guardanuevoVolante(@RequestBody DonacionSangre donacionSangre) {
        try{
        Gson gson = new Gson();
        log.error("Request -> " + gson.toJson(donacionSangre));
        return new ResponseEntity<>(donaSangre.guardaNuevoVolanteDonacionS(donacionSangre), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity("Error al guardar el registro [" + ex.getMessage() + "]",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/findVolantesByFechas/{fechaInicial}/{fechaFinal}",
            produces = "application/json;charset=UTF-8")
    public ResponseEntity findVolantesByFechas(@PathVariable String fechaInicial, @PathVariable String fechaFinal) {
        try{
            return new ResponseEntity<>(donaSangre.findVolantesByFechas(fechaInicial, fechaFinal), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity("Error al consultar [" + ex.getMessage() + "]" , HttpStatus.BAD_REQUEST);
        }
    }

}

