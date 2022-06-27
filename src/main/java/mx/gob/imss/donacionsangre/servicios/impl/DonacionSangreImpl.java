package mx.gob.imss.donacionsangre.servicios.impl;

import com.google.gson.Gson;
import mx.gob.imss.componentes.TransformaObjetos;
import mx.gob.imss.donacionsangre.dto.DonacionSangre;
import mx.gob.imss.donacionsangre.modelos.DonacionSangreResponse;
import mx.gob.imss.donacionsangre.modelos.MsmdstDonacionSangre;
import mx.gob.imss.donacionsangre.modelos.MtstVolanteDonacionSangre;
import mx.gob.imss.donacionsangre.repositorios.DonacionSangreRepositorio;
import mx.gob.imss.donacionsangre.servicios.DonacionSangreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            System.out.println(jsonResponse);
            donacionSangreRepositorio.flush();
            return jsonResponse;
        } catch (Exception ex) {
            return "Error al insertar nuevo Volante donacion de sangre [" + ex.getMessage() + "]";
        }
    }

    @Override
    public String findVolantesByFechas(String fechaInicial, String fechaFinal) {
        List<DonacionSangreResponse> volantesDSList = new ArrayList<>();
        List<MtstVolanteDonacionSangre> msmdstDonacionSangreList = donacionSangreRepositorio.findVolantesDSBetwenFechas(fechaInicial, fechaFinal);
        for (MtstVolanteDonacionSangre msmdstDonacionSangre : msmdstDonacionSangreList) {
            volantesDSList.add(transforma.buildResponse(msmdstDonacionSangre));
        }
        Gson jsonArray = new Gson();
        String jsonResponse = jsonArray.toJson(volantesDSList);
        return jsonResponse;
    }
}
