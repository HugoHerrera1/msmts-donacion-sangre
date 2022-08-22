package mx.gob.imss.donacionsangre.controladores;

import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.donacionsangre.dto.DonacionSangre;
import mx.gob.imss.donacionsangre.dto.Filtros;
import mx.gob.imss.donacionsangre.dto.ReporteDonacionSangre;
import mx.gob.imss.donacionsangre.servicios.DonacionSangreServices;
import mx.gob.imss.donacionsangre.servicios.ReporteDonacionSangreServices;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/msmts-donacion-sangre/api")
public class DonacionSangreControlador {
    @Autowired
    DonacionSangreServices donaSangre;


    @Autowired
    private ReporteDonacionSangreServices reporteDonacionSangreServices;

    @PostMapping(value = "/guardaNuevoVolanteDonacionSangre",
            produces = "application/json",
            consumes = "application/json")
    //  @CacheEvict(value = {"volanteDonacionByFechas", "volanteDonacionById", "volanteDonacionParameters"}, allEntries = true)
    public ResponseEntity guardanuevoVolante(@RequestBody DonacionSangre donacionSangre) {
        try {
            return new ResponseEntity(donaSangre.guardaNuevoVolanteDonacionS(donacionSangre), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/findVolantesByFechas", produces = "application/json")
    public ResponseEntity findVolantesByFechas(@RequestBody Filtros filtros) {
        try {
            return new ResponseEntity(donaSangre.findVolantesByFechas(filtros), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/reporteDonacionSangre", consumes = "application/json")
    public ResponseEntity<Resource> download(@RequestBody ReporteDonacionSangre reporte)
            throws JRException, IOException {
        byte[] filePdf = reporteDonacionSangreServices.imprimeDonacionSangre(reporte);
        ByteArrayResource resource = new ByteArrayResource(filePdf);
        try {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=Reporte_DonacionSangre.pdf")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(filePdf.length).body(resource);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            return ResponseEntity.badRequest().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=Reporte_DonacionSangre.pdf")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(0).body(resource);
        }


    }

    @GetMapping(path = "/findVolantesById/{idVolanteDonacion}", produces = "application/json")
    public ResponseEntity findVolantesByID(@PathVariable Integer idVolanteDonacion) {
        try {
            return new ResponseEntity(donaSangre.findVolantesById(idVolanteDonacion), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/findVolantesAdministracion/{fechaInicial}/{fechaFinal}/{tipoSangre}",
            produces = "application/json")
    public ResponseEntity findVolantesByParameters(@PathVariable String fechaInicial, @PathVariable String fechaFinal, @PathVariable String tipoSangre) {
        try {
            return new ResponseEntity(donaSangre.findVolantesByParrameters(fechaInicial, fechaFinal, tipoSangre), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/getBancosSangre", produces = "application/json")
    public ResponseEntity getBancosSangre() {
        try {
            return new ResponseEntity(donaSangre.getBancosSangre(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/evictallcaches", produces = "application/json")
    public ResponseEntity<String> evictAllcaches() {

        return new ResponseEntity<>(donaSangre.evictAllcaches(), HttpStatus.OK);

    }

}

