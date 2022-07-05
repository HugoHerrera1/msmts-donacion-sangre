package mx.gob.imss.componentes;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.constantes.DonacionSangreConstantes;
import mx.gob.imss.donacionsangre.modelos.CiudadesModel;
import mx.gob.imss.donacionsangre.modelos.DelegacionMunicipioModel;
import mx.gob.imss.donacionsangre.modelos.EstadosModel;
import mx.gob.imss.donacionsangre.modelos.ServiciosModel;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Slf4j
@Component
public class AgendaDigitalCliente {

    @Value("${app.agenda.digital.url}")
    private String agendaDigitalUrl;

    @Autowired
    private MessageSource messageSource;

    @Cacheable(cacheNames = "servicios")
    public List<ServiciosModel> getServicio(String idServicio) {
        log.error("Se hace la consulta servicios por medio del cliente - no caching- ");
        try {
            Client client = ClientBuilder.newClient().register(new JacksonFeature());
            return client.target(agendaDigitalUrl + DonacionSangreConstantes.GET_SERVICIOS_PATH + "/" + idServicio)
                    .request(MediaType.APPLICATION_JSON).get(new GenericType<List<ServiciosModel>>() {
                    });
        } catch (Exception e) {
            log.error(messageSource.getMessage("SERVICIO_NO_ENCONTRADO", new Object[]{"SERVICIOS [" + idServicio + "]", e.getMessage()}, Locale.getDefault()));
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Cacheable(cacheNames = "edos")
    public EstadosModel getEstado(Integer idEstado) {
        log.error("Se hace la consulta estados por medio del cliente - no caching- ");
        try {
            Client client = ClientBuilder.newClient().register(new JacksonFeature());
            return client.target(agendaDigitalUrl + DonacionSangreConstantes.GET_ESTADO_PATH + "/" + idEstado)
                    .request(MediaType.APPLICATION_JSON).get(new GenericType<EstadosModel>() {
                    });
        } catch (Exception e) {
            log.error(messageSource.getMessage("ESTADO_NO_ENCONTRADO", new Object[]{"ESTADO [" + idEstado + "]", e.getMessage()}, Locale.getDefault()));
            e.printStackTrace();
            return new EstadosModel();
        }
    }


    @Cacheable(cacheNames = "delegacion")
    public DelegacionMunicipioModel getDelegacion(Integer idEstado, Integer idDelegacion) {
        log.error("Se hace la consulta delegacion por medio del cliente - no caching- ");
        try {
            Client cliente = ClientBuilder.newClient().register(new JacksonFeature());
            return cliente.target(agendaDigitalUrl + DonacionSangreConstantes.GET_DELEGACION_PATH + "/" + idEstado + "/" + idDelegacion)
                    .request(MediaType.APPLICATION_JSON).get(new GenericType<DelegacionMunicipioModel>() {
                    });
        } catch (Exception ex) {
            log.error(messageSource.getMessage("DELEGACION_NO_ENCONTRADO", new Object[]{"DELEGACION [" + idDelegacion + "] : ESTADO [" + idEstado + "]", ex.getMessage()}, Locale.getDefault()));
            ex.printStackTrace();
            return new DelegacionMunicipioModel();
        }
    }

    @Cacheable(cacheNames = "ciudad")

    public CiudadesModel getCiudad(Integer idEstado, Integer idDelegacion, Integer idCiudad) {
        log.error("Se hace la consulta ciudades por medio del cliente - no caching- ");
        try {
            Client cliente = ClientBuilder.newClient().register(new JacksonFeature());
            return cliente.target(agendaDigitalUrl + DonacionSangreConstantes.GET_CIUDAD_PATH + "/" + idEstado + "/" + idDelegacion + "/" + idCiudad)
                    .request(MediaType.APPLICATION_JSON).get(new GenericType<CiudadesModel>() {
                    });
        } catch (Exception ex) {
            log.error(messageSource.getMessage("CIUDAD_NO_ENCONTRADO", new Object[]{"CIUDAD [" + idDelegacion + "] : ESTADO [" + idEstado + "]", ex.getMessage()}, Locale.getDefault()));
            ex.printStackTrace();
            return new CiudadesModel();
        }
    }
}
