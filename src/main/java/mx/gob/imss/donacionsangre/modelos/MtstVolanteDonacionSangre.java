package mx.gob.imss.donacionsangre.modelos;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "MTST_VOLANTE_DONACION_SANGRE")
@Data
public class MtstVolanteDonacionSangre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VOLANTE_DONACION_SANGRE", nullable = false)
    private Long id;

    @Column(name = "ID_NOMBRE_BANCO_SANGRE")
    private Long idNombreBancoSangre;

    @Column(name = "ID_ESTADO", length = 45)
    private String idEstado;

    @Column(name = "ID_DELEGACION_MUNICIPIO", length = 45)
    private String idDelegacionMunicipio;

    @Column(name = "ID_CIUDAD", length = 45)
    private String idCiudad;

    @Column(name = "ID_SERVICIO")
    private String idServicio;

    @Column(name = "DES_UNIDAD_MEDICA_HOSPITALARIA", length = 100)
    private String desUnidadMedicaHospitalaria;

    @Column(name = "FEC_EFEC")
    private Date fecEfec;

    @Column(name = "TIM_INICIAL_ATENCION")
    private Time timInicialAtencion;

    @Column(name = "TIM_FINAL_ATENCION")
    private Time timFinalAtencion;

    @Column(name = "DES_CODIGO_POSTAL", length = 10)
    private String desCodigoPostal;

    @Column(name = "NOM_COLONIA", length = 150)
    private String nomColonia;

    @Column(name = "NOM_CALLE", length = 100)
    private String nomCalle;

    @Column(name = "NUM_EXTERIOR", length = 10)
    private String numExterior;

    @Column(name = "NUM_INTERIOR", length = 10)
    private String numInterior;

    @Column(name = "NOM_PACIENTE", length = 100)
    private String nomPaciente;

    @Column(name = "DES_NSS_AGREGADO", length = 15)
    private String desNssAgregado;

    @Column(name = "FEC_INTERNAMIENTO")
    private Date fecInternamiento;

    @Column(name = "FEC_CIRUGIA")
    private Date fecCirugia;

    @Column(name = "NUM_TELEFONO_PACIENTE", length = 10)
    private String numTelefonoPaciente;

    @Column(name = "NOM_TRABAJADOR_SOCIAL", length = 100)
    private String nomTrabajadorSocial;

    @Column(name = "DES_MATRICULA_TRABAJADOR_SOCIAL", length = 40)
    private String desMatriculaTrabajadorSocial;

    @Column(name = "NUM_TELEFONO_TRABAJADOR_SOCIAL", length = 10)
    private String numTelefonoTrabajadorSocial;

    @Column(name = "DES_OBSERVACIONES", length = 100)
    private String desObservaciones;

    @Column(name = "FEC_EXPIRA")
    private Date fecExpira;

    @Column(name = "FEC_ALTA")
    private Instant fecAlta;

    @Column(name = "FEC_ACTUALIZACION")
    private Date fecActualizacion;

    @Column(name = "FEC_BAJA")
    private Date fecBaja;

    @Column(name = "IND_ACTIVO")
    private Boolean indActivo;

    @Column(name = "DES_TIPO_SANGRE")
    private String tipoSangre;

    @Column(name = "DES_AGREGADO_MEDICO")
    private String desAgregadoMedico;

    @Column(name = "DES_NSS_PACIENTE")
    private String nssPaciente;



}