package mx.gob.imss.donacionsangre.repositorios;

import mx.gob.imss.donacionsangre.modelos.MtstVolanteDonacionSangre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonacionSangreRepositorio extends JpaRepository<MtstVolanteDonacionSangre,Integer> {
    @Query(value = "select * from MTST_VOLANTE_DONACION_SANGRE mds where mds.FEC_EFEC between ?1 and ?2 and mds.IND_ACTIVO =1", nativeQuery = true)
    List<MtstVolanteDonacionSangre> findVolantesDSBetwenFechas(String fechaInicial, String fechaFinal);
    @Query(value = "select * from MTST_VOLANTE_DONACION_SANGRE mds where mds.ID_VOLANTE_DONACION_SANGRE =?1 and mds.IND_ACTIVO =1", nativeQuery = true)
    MtstVolanteDonacionSangre findVolantesDSById(Integer idVolanteDonacion);

    @Query(value = "select * from MTST_VOLANTE_DONACION_SANGRE mds where mds.FEC_EFEC between ?1 and ?2  and mds.DES_TIPO_SANGRE =?3 and mds.IND_ACTIVO =1",nativeQuery = true)
    List<MtstVolanteDonacionSangre> findVolantesByParameters(String fechaInicio, String fechaFin, String tipoSangre);

}
