package mx.gob.imss.componentes;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.constantes.DonacionSangreConstantes;
import mx.gob.imss.donacionsangre.modelos.CiudadesModel;
import mx.gob.imss.donacionsangre.modelos.DelegacionMunicipioModel;
import mx.gob.imss.donacionsangre.modelos.EstadosModel;
import mx.gob.imss.donacionsangre.modelos.ServiciosModel;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

@Slf4j
@Component
public class AgendaDigitalCliente {

    @Value("${app.agenda.digital.url}")
    private String agendaDigitalUrl;

    @Autowired
    private MessageSource messageSource;

    @Cacheable(cacheNames = "servicios")
    public ServiciosModel getServicio(String idServicio) {
        Gson gson = new Gson();
        log.error("Se hace la consulta servicios por medio del cliente - no caching- ");
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
            log.error("Exception servicios [" + ex.getMessage() + "]");
            ServiciosModel servicios = new ServiciosModel();
            servicios = null;
            return servicios;
        }
    }

    @Cacheable(cacheNames = "edos")
    public EstadosModel getEstado(Integer idEstado) {
        Gson gson = new Gson();
        log.error("Se hace la consulta estados por medio del cliente - no caching- ");
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


    @Cacheable(cacheNames = "delegacion")
    public DelegacionMunicipioModel getDelegacion(Integer idEstado, Integer idDelegacion) {
        Gson gson = new Gson();
        log.error("Se hace la consulta delegacion por medio del cliente - no caching- ");
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
    @Cacheable(cacheNames = "ciudad")

    public CiudadesModel getCiudad(Integer idEstado, Integer idDelegacion, Integer idCiudad) {
        Gson gson = new Gson();
        log.error("Se hace la consulta ciudades por medio del cliente - no caching- ");
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
