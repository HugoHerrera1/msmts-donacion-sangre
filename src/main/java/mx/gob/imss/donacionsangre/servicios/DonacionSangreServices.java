package mx.gob.imss.donacionsangre.servicios;

import mx.gob.imss.donacionsangre.dto.DonacionSangre;
import mx.gob.imss.donacionsangre.dto.Filtros;
import org.springframework.stereotype.Service;

@Service
public interface DonacionSangreServices {
    String guardaNuevoVolanteDonacionS(DonacionSangre donacionSangre);

    String findVolantesByFechas(Filtros filtros);

    String findVolantesById(Integer idVolanteDonacion);
    String getBancosSangre();
    String findVolantesByParrameters(String fechaInicial, String fechaFinal, String tipoSangre);
    String evictAllcaches();

}