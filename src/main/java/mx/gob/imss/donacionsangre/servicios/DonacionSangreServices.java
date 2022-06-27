package mx.gob.imss.donacionsangre.servicios;

import mx.gob.imss.donacionsangre.dto.DonacionSangre;
import org.springframework.stereotype.Service;

@Service
public interface DonacionSangreServices {
    String guardaNuevoVolanteDonacionS(DonacionSangre donacionSangre);
    String findVolantesByFechas(String fechaInicial, String fechaFinal);
}
