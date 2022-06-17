package mx.gob.imss.donacionsangre.servicios.impl;

import com.google.gson.Gson;
import mx.gob.imss.componentes.TransformaObjetos;
import mx.gob.imss.donacionsangre.dto.DonacionSangre;
import mx.gob.imss.donacionsangre.modelos.DonacionSangreResponse;
import mx.gob.imss.donacionsangre.modelos.MsmdstDonacionSangre;
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
            MsmdstDonacionSangre msmdstDonacionSangre = transforma.dtoToDonacionSangreModel(donacionSangre);
            donacionSangreRepositorio.save(msmdstDonacionSangre);
            donacionSangreRepositorio.flush();
            return "Se guardo con exito";
        } catch (Exception ex) {
            return "Error al insertar nuevo Volante donacion de sangre [" + ex.getMessage() + "]";
        }
    }

    @Override
    public String findVolantesByFechas(String fechaInicial, String fechaFinal) {
        List<DonacionSangreResponse> volantesDSList = new ArrayList<>();
        List<MsmdstDonacionSangre> msmdstDonacionSangreList = donacionSangreRepositorio.findVolantesDSBetwenFechas(fechaInicial, fechaFinal);
        for (MsmdstDonacionSangre msmdstDonacionSangre : msmdstDonacionSangreList) {
            volantesDSList.add(transforma.buildResponse(msmdstDonacionSangre));
        }
        Gson jsonArray = new Gson();
        String jsonResponse = jsonArray.toJson(volantesDSList);
        return jsonResponse;
    }
}
