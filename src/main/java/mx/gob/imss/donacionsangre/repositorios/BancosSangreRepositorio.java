package mx.gob.imss.donacionsangre.repositorios;

import mx.gob.imss.donacionsangre.modelos.MtscBancoSangre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BancosSangreRepositorio extends JpaRepository<MtscBancoSangre, Long> {

    @Query(value = "select * from MTSC_BANCO_SANGRE mbs where mbs.ID_BANCO_SANGRE = ?1 and mbs.IND_ACTIVO =1", nativeQuery = true)
    MtscBancoSangre findNameBancobyId(Integer idBanco);

    @Query(value = "select * from MTSC_BANCO_SANGRE mbs where mbs.IND_ACTIVO =1", nativeQuery = true)
    List<MtscBancoSangre> findBancosSangre();
}
