package mx.gob.imss.donacionsangre.servicios.impl;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.componentes.TransformaObjetos;
import mx.gob.imss.donacionsangre.dto.DonacionSangre;
import mx.gob.imss.donacionsangre.modelos.DonacionSangreResponse;
import mx.gob.imss.donacionsangre.modelos.MtstVolanteDonacionSangre;
import mx.gob.imss.donacionsangre.repositorios.DonacionSangreRepositorio;
import mx.gob.imss.donacionsangre.servicios.DonacionSangreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DonacionSangreImpl implements DonacionSangreServices {
    @Autowired
    TransformaObjetos transforma;
    @Autowired
    DonacionSangreRepositorio donacionSangreRepositorio;

    @Override
    public String guardaNuevoVolanteDonacionS(DonacionSangre donacionSangre) {
        try {
            Gson gson  = new Gson();
            MtstVolanteDonacionSangre msmdstDonacionSangre = transforma.dtoToDonacionSangreModel(donacionSangre);
            String jsonResponse = gson.toJson(donacionSangreRepositorio.save(msmdstDonacionSangre));
            log.debug(jsonResponse);
            donacionSangreRepositorio.flush();
            return jsonResponse;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error al insertar nuevo Volante donacion de sangre [" + ex.getMessage() + "]";
        }
    }

    @Override
    public String findVolantesByFechas(String fechaInicial, String fechaFinal) {
        try {
            List<DonacionSangreResponse> volantesDSList = new ArrayList<>();
            List<MtstVolanteDonacionSangre> msmdstDonacionSangreList = donacionSangreRepositorio.findVolantesDSBetwenFechas(fechaInicial, fechaFinal);
            for (MtstVolanteDonacionSangre msmdstDonacionSangre : msmdstDonacionSangreList) {
                volantesDSList.add(transforma.buildResponse(msmdstDonacionSangre));
            }
            Gson jsonArray = new Gson();
            return jsonArray.toJson(volantesDSList);
        }catch (Exception ex){
            ex.printStackTrace();
            return "Error al consultar [" + ex.getMessage() + "]";
        }
    }
}
