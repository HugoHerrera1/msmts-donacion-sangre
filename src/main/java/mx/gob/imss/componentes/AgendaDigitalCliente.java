package mx.gob.imss.componentes;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.constantes.DonacionSangreConstantes;
import mx.gob.imss.donacionsangre.modelos.CiudadesModel;
import mx.gob.imss.donacionsangre.modelos.DelegacionMunicipioModel;
import mx.gob.imss.donacionsangre.modelos.EstadosModel;
import mx.gob.imss.donacionsangre.modelos.ServiciosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
@Component
public class AgendaDigitalCliente {

    @Value("${app.agenda.digital.url}")
    private String agendaDigitalUrl;

    @Autowired
    private MessageSource messageSource;

    public ServiciosModel getServicio(String idServicio) {
        Gson gson = new Gson();
        try {
            URL url = new URL(agendaDigitalUrl + DonacionSangreConstantes.GET_SERVICIOS_PATH + "/" + idServicio);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Accept", "application/json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            String newJson = responseBuilder.substring(1,responseBuilder.length() - 1);
            ServiciosModel servicios = gson.fromJson(String.valueOf(newJson), ServiciosModel.class);
            return servicios;
        } catch (Exception ex) {
            System.out.println("Exception servicios [" + ex.getMessage() + "]");
            ServiciosModel servicios = new ServiciosModel();
            servicios = null;
            return servicios;
        }
    }

    public EstadosModel getEstado(Integer idEstado) {
        Gson gson = new Gson();
        try {
            URL url = new URL(agendaDigitalUrl + DonacionSangreConstantes.GET_ESTADO_PATH + "/" + idEstado);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Accept", "application/json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            EstadosModel cat = gson.fromJson(String.valueOf(responseBuilder), EstadosModel.class);
            return cat;
        } catch (Exception e) {
            e.printStackTrace();
            return new EstadosModel();
        }

    }

    public DelegacionMunicipioModel getDelegacion(Integer idEstado, Integer idDelegacion) {
        Gson gson = new Gson();
        try {
            URL url = new URL(agendaDigitalUrl + DonacionSangreConstantes.GET_DELEGACION_PATH + "/" + idEstado + "/" + idDelegacion);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Accept", "application/json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            DelegacionMunicipioModel cat = gson.fromJson(String.valueOf(responseBuilder), DelegacionMunicipioModel.class);
            return cat;
        } catch (Exception e) {
            e.printStackTrace();
            return new DelegacionMunicipioModel();
        }

    }

    public CiudadesModel getCiudad(Integer idEstado, Integer idDelegacion, Integer idCiudad) {
        Gson gson = new Gson();
        try {
            URL url = new URL(agendaDigitalUrl + DonacionSangreConstantes.GET_CIUDAD_PATH + "/" + idEstado + "/" + idDelegacion + "/" + idCiudad);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Accept", "application/json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            CiudadesModel cat = gson.fromJson(String.valueOf(responseBuilder), CiudadesModel.class);
            return cat;
        } catch (Exception e) {
            e.printStackTrace();
            CiudadesModel cd = new CiudadesModel();
            cd.setIdCiudad(idCiudad);
            cd.setIdEstado(idEstado);
            cd.setIdDelegacionMunicipio(idDelegacion);
            cd.setNomCiudad("");
            return cd;
        }
    }
}
