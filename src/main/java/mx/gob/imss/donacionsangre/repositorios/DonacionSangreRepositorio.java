package mx.gob.imss.donacionsangre.repositorios;

import mx.gob.imss.donacionsangre.modelos.MsmdstDonacionSangre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonacionSangreRepositorio extends JpaRepository<MsmdstDonacionSangre,Integer> {
    @Query(value = "select * from msmdst_donacion_sangre mds where mds.FEC_EFEC between ?1 and ?2 and mds.IND_ACTIVO =1", nativeQuery = true)
    List<MsmdstDonacionSangre> findVolantesDSBetwenFechas(String fechaInicial, String fechaFinal);

}
