package mx.gob.imss.donacionsangre.servicios.impl;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.componentes.TransformaObjetos;
import mx.gob.imss.constantes.DonacionSangreConstantes;
import mx.gob.imss.donacionsangre.dto.DonacionSangre;
import mx.gob.imss.donacionsangre.modelos.*;
import mx.gob.imss.donacionsangre.repositorios.BancosSangreRepositorio;
import mx.gob.imss.donacionsangre.repositorios.DonacionSangreRepositorio;
import mx.gob.imss.donacionsangre.servicios.DonacionSangreServices;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    BancosSangreRepositorio bancoSangre;

    @Override
    public String guardaNuevoVolanteDonacionS(DonacionSangre donacionSangre) {
        InsertResponse response = new InsertResponse();
        Gson gson  = new Gson();
        try {
            MtstVolanteDonacionSangre msmdstDonacionSangre = transforma.dtoToDonacionSangreModel(donacionSangre);
            response.setStatus("OK");
            response.setIdVolanteDonacionSangre(donacionSangreRepositorio.save(msmdstDonacionSangre).getId().intValue());
            response.setMensaje(DonacionSangreConstantes.MENSAJE_OK);
            donacionSangreRepositorio.flush();
            return gson.toJson(response);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(DonacionSangreConstantes.MENSAJE_ERROR);
            response.setIdVolanteDonacionSangre(null);
            response.setMensaje("Error al insertar nuevo Volante donacion de sangre [" + ex.getMessage() + "]");
            return gson.toJson(response);
        }
    }

    @Override
    public String findVolantesByFechas(String fechaInicial, String fechaFinal) {
        GenericConsultaVolanteDS genericConsultaResponse = new GenericConsultaVolanteDS();
        Gson jsonArray = new Gson();
        try {
            List<ConsultaVolanteDSModelResponse> volantesDSList = new ArrayList<>();
            List<MtstVolanteDonacionSangre> msmdstDonacionSangreList = donacionSangreRepositorio.findVolantesDSBetwenFechas(fechaInicial, fechaFinal);
            for (MtstVolanteDonacionSangre msmdstDonacionSangre : msmdstDonacionSangreList) {
                volantesDSList.add(transforma.buildResponseGeneric(msmdstDonacionSangre));
            }
            genericConsultaResponse.setStatus("OK");
            genericConsultaResponse.setMensaje(DonacionSangreConstantes.MENSAJE_OK);
            genericConsultaResponse.setDatosVolantesDonacion(volantesDSList);
            return jsonArray.toJson(genericConsultaResponse);
        }catch (Exception ex){
            ex.printStackTrace();
            genericConsultaResponse.setStatus(DonacionSangreConstantes.MENSAJE_ERROR);
            genericConsultaResponse.setMensaje(DonacionSangreConstantes.MENSAJE_ERROR + "[" + ex.getMessage() + "]");
            genericConsultaResponse.setDatosVolantesDonacion(new ArrayList<>());
            return jsonArray.toJson(genericConsultaResponse);
        }
    }

    @Override
    public String findVolantesById(Integer idVolanteDonacion) {
        ConsultaVolantesDS genericResponse = new ConsultaVolantesDS();
        Gson jsonArray = new Gson();
        try{
            MtstVolanteDonacionSangre volante = donacionSangreRepositorio.findVolantesDSById(idVolanteDonacion);
            DonacionSangreResponse volantesDSList = transforma.detalle(volante);
            genericResponse.setStatus("OK");
            genericResponse.setMensaje(DonacionSangreConstantes.MENSAJE_OK);
            genericResponse.setDatosVolantesDonacion(volantesDSList);
            return jsonArray.toJson(genericResponse);
        }catch (Exception ex){
            ex.printStackTrace();
            genericResponse.setStatus(DonacionSangreConstantes.MENSAJE_ERROR);
            genericResponse.setMensaje(DonacionSangreConstantes.MENSAJE_ERROR + "[" + ex.getMessage() + "]");
            genericResponse.setDatosVolantesDonacion(new DonacionSangreResponse());
            return jsonArray.toJson(genericResponse);
        }

    }

    @Override
    public String getBancosSangre() {
        Gson jsonBancosSangre = new Gson();
        BancosSangreResponse br = new BancosSangreResponse();
        try{
            List<MtscBancoSangre> mtBancoSangre = bancoSangre.findBancosSangre();
            List<BancosSangre> listBancos = new ArrayList<>();
            for (MtscBancoSangre msmdstBancosSangre : mtBancoSangre) {
                listBancos.add(transforma.getCatalogoBancosSangre(msmdstBancosSangre));
            }
            br.setStatus("OK");
            br.setMensaje(DonacionSangreConstantes.MENSAJE_OK);
            br.setDatosBancosSangre(listBancos);
            return jsonBancosSangre.toJson(br);
        }catch (Exception ex){
ex.printStackTrace();
            br.setStatus(DonacionSangreConstantes.MENSAJE_ERROR);
            br.setMensaje(DonacionSangreConstantes.MENSAJE_ERROR);
            br.setDatosBancosSangre(new ArrayList<>());
            return jsonBancosSangre.toJson(br);
        }
    }
}
