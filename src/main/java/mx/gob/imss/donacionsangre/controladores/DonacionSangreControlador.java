package mx.gob.imss.donacionsangre.controladores;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.donacionsangre.dto.DonacionSangre;
import mx.gob.imss.donacionsangre.dto.ReporteDonacionSangre;
import mx.gob.imss.donacionsangre.modelos.DonacionSangreResponse;
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
import java.util.List;

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
    public ResponseEntity guardanuevoVolante(@RequestBody DonacionSangre donacionSangre) {
        Gson gson = new Gson();
        System.out.println(gson.toJson(donacionSangre));
        return new ResponseEntity<>(donaSangre.guardaNuevoVolanteDonacionS(donacionSangre), HttpStatus.OK);
    }

    @GetMapping(path = "/findVolantesByFechas/{fechaInicial}/{fechaFinal}", produces = "application/json")
    public ResponseEntity findVolantesByFechas(@PathVariable String fechaInicial, @PathVariable String fechaFinal) {
        return new ResponseEntity<>(donaSangre.findVolantesByFechas(fechaInicial, fechaFinal), HttpStatus.OK);
    }
    
    @PostMapping (path = "/reporteDonacionSangre", consumes = "application/json")
    public ResponseEntity<Resource> download(@RequestBody ReporteDonacionSangre reporte)
            throws JRException, IOException {
    	
    	byte[] filePdf = reporteDonacionSangreServices.imprimeDonacionSangre(reporte);
    	ByteArrayResource resource = new ByteArrayResource(filePdf);
     	return ResponseEntity.ok()
    			.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=Reporte_DonacionSangre.pdf")
    			.contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(filePdf.length).body(resource);

    } 

}

