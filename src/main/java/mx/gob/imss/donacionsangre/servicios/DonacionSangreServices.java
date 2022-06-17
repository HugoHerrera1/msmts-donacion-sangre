package mx.gob.imss.donacionsangre.servicios;

import mx.gob.imss.donacionsangre.dto.DonacionSangre;
import mx.gob.imss.donacionsangre.modelos.DonacionSangreResponse;
import mx.gob.imss.donacionsangre.modelos.MsmdstDonacionSangre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonacionSangreServices {
    String guardaNuevoVolanteDonacionS(DonacionSangre donacionSangre);
    String findVolantesByFechas(String fechaInicial, String fechaFinal);
}
