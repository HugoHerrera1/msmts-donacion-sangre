package mx.gob.imss.donacionsangre.modelos;

import javax.persistence.*;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "MTST_VOLANTE_DONACION_SANGRE")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdNombreBancoSangre() {
        return idNombreBancoSangre;
    }

    public void setIdNombreBancoSangre(Long idNombreBancoSangre) {
        this.idNombreBancoSangre = idNombreBancoSangre;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public String getIdDelegacionMunicipio() {
        return idDelegacionMunicipio;
    }

    public void setIdDelegacionMunicipio(String idDelegacionMunicipio) {
        this.idDelegacionMunicipio = idDelegacionMunicipio;
    }

    public String getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(String idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getDesUnidadMedicaHospitalaria() {
        return desUnidadMedicaHospitalaria;
    }

    public void setDesUnidadMedicaHospitalaria(String desUnidadMedicaHospitalaria) {
        this.desUnidadMedicaHospitalaria = desUnidadMedicaHospitalaria;
    }

    public Date getFecEfec() {
        return fecEfec;
    }

    public void setFecEfec(Date fecEfec) {
        this.fecEfec = fecEfec;
    }

    public Time getTimInicialAtencion() {
        return timInicialAtencion;
    }

    public void setTimInicialAtencion(Time timInicialAtencion) {
        this.timInicialAtencion = timInicialAtencion;
    }

    public Time getTimFinalAtencion() {
        return timFinalAtencion;
    }

    public void setTimFinalAtencion(Time timFinalAtencion) {
        this.timFinalAtencion = timFinalAtencion;
    }

    public String getDesCodigoPostal() {
        return desCodigoPostal;
    }

    public void setDesCodigoPostal(String desCodigoPostal) {
        this.desCodigoPostal = desCodigoPostal;
    }

    public String getNomColonia() {
        return nomColonia;
    }

    public void setNomColonia(String nomColonia) {
        this.nomColonia = nomColonia;
    }

    public String getNomCalle() {
        return nomCalle;
    }

    public void setNomCalle(String nomCalle) {
        this.nomCalle = nomCalle;
    }

    public String getNumExterior() {
        return numExterior;
    }

    public void setNumExterior(String numExterior) {
        this.numExterior = numExterior;
    }

    public String getNumInterior() {
        return numInterior;
    }

    public void setNumInterior(String numInterior) {
        this.numInterior = numInterior;
    }

    public String getNomPaciente() {
        return nomPaciente;
    }

    public void setNomPaciente(String nomPaciente) {
        this.nomPaciente = nomPaciente;
    }

    public String getDesNssAgregado() {
        return desNssAgregado;
    }

    public void setDesNssAgregado(String desNssAgregado) {
        this.desNssAgregado = desNssAgregado;
    }

    public Date getFecInternamiento() {
        return fecInternamiento;
    }

    public void setFecInternamiento(Date fecInternamiento) {
        this.fecInternamiento = fecInternamiento;
    }

    public Date getFecCirugia() {
        return fecCirugia;
    }

    public void setFecCirugia(Date fecCirugia) {
        this.fecCirugia = fecCirugia;
    }

    public String getNumTelefonoPaciente() {
        return numTelefonoPaciente;
    }

    public void setNumTelefonoPaciente(String numTelefonoPaciente) {
        this.numTelefonoPaciente = numTelefonoPaciente;
    }

    public String getNomTrabajadorSocial() {
        return nomTrabajadorSocial;
    }

    public void setNomTrabajadorSocial(String nomTrabajadorSocial) {
        this.nomTrabajadorSocial = nomTrabajadorSocial;
    }

    public String getDesMatriculaTrabajadorSocial() {
        return desMatriculaTrabajadorSocial;
    }

    public void setDesMatriculaTrabajadorSocial(String desMatriculaTrabajadorSocial) {
        this.desMatriculaTrabajadorSocial = desMatriculaTrabajadorSocial;
    }

    public String getNumTelefonoTrabajadorSocial() {
        return numTelefonoTrabajadorSocial;
    }

    public void setNumTelefonoTrabajadorSocial(String numTelefonoTrabajadorSocial) {
        this.numTelefonoTrabajadorSocial = numTelefonoTrabajadorSocial;
    }

    public String getDesObservaciones() {
        return desObservaciones;
    }

    public void setDesObservaciones(String desObservaciones) {
        this.desObservaciones = desObservaciones;
    }

    public Date getFecExpira() {
        return fecExpira;
    }

    public void setFecExpira(Date fecExpira) {
        this.fecExpira = fecExpira;
    }

    public Instant getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Instant fecAlta) {
        this.fecAlta = fecAlta;
    }

    public Date getFecActualizacion() {
        return fecActualizacion;
    }

    public void setFecActualizacion(Date fecActualizacion) {
        this.fecActualizacion = fecActualizacion;
    }

    public Date getFecBaja() {
        return fecBaja;
    }

    public void setFecBaja(Date fecBaja) {
        this.fecBaja = fecBaja;
    }

    public Boolean getIndActivo() {
        return indActivo;
    }

    public void setIndActivo(Boolean indActivo) {
        this.indActivo = indActivo;
    }

}