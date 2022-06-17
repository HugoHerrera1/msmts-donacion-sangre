package mx.gob.imss.donacionsangre.modelos;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "MSMDST_DONACION_SANGRE")
public class MsmdstDonacionSangre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VOLANTE_DONACION_SANGRE", nullable = false)
    private Integer id;

    @Column(name = "DES_UNIDAD_MEDICA_HOSPITALARIA", length = 100)
    private String desUnidadMedicaHospitalaria;

    @Column(name = "FEC_EFEC")
    private Date fecEfec;

    @Column(name = "ID_NOMBRE_BANCO_SANGRE")
    private Integer idNombreBancoSangre;

    @Column(name = "TIM_HORA_INICIAL_ATENCION")
    private Time timHoraInicialAtencion;

    @Column(name = "TIM_HORA_FINAL_ATENCION")
    private Time timHoraFinalAtencion;

    @Column(name = "DES_CODIGO_POSTAL", length = 10)
    private String desCodigoPostal;

    @Column(name = "ID_ESTADO")
    private Integer idEstado;

    @Column(name = "ID_DELEGACION_MUNICIPIO")
    private Integer idDelegacionMunicipio;

    @Column(name = "ID_CIUDAD")
    private Integer idCiudad;

    @Column(name = "NOM_COLONIA", length = 100)
    private String nomColonia;

    @Column(name = "NOM_CALLE", length = 100)
    private String nomCalle;

    @Column(name = "NUM_EXTERIOR")
    private Integer numExterior;

    @Column(name = "NUM_INTERIOR")
    private Integer numInterior;

    @Column(name = "NOM_PACIENTE", length = 100)
    private String nomPaciente;

    @Column(name = "DES_NSS_AGREGADO", length = 15)
    private String desNssAgregado;

    @Column(name = "ID_SERVICIO")
    private Integer idServicio;

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

    @Column(name = "FEC_ACTUALIZACION")
    private Date fecActualizacion;

    @Column(name = "IND_ACTIVO")
    private Integer indActivo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getIdNombreBancoSangre() {
        return idNombreBancoSangre;
    }

    public void setIdNombreBancoSangre(Integer idNombreBancoSangre) {
        this.idNombreBancoSangre = idNombreBancoSangre;
    }

    public Time getTimHoraInicialAtencion() {
        return timHoraInicialAtencion;
    }

    public void setTimHoraInicialAtencion(Time timHoraInicialAtencion) {
        this.timHoraInicialAtencion = timHoraInicialAtencion;
    }

    public Time getTimHoraFinalAtencion() {
        return timHoraFinalAtencion;
    }

    public void setTimHoraFinalAtencion(Time timHoraFinalAtencion) {
        this.timHoraFinalAtencion = timHoraFinalAtencion;
    }

    public String getDesCodigoPostal() {
        return desCodigoPostal;
    }

    public void setDesCodigoPostal(String desCodigoPostal) {
        this.desCodigoPostal = desCodigoPostal;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdDelegacionMunicipio() {
        return idDelegacionMunicipio;
    }

    public void setIdDelegacionMunicipio(Integer idDelegacionMunicipio) {
        this.idDelegacionMunicipio = idDelegacionMunicipio;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
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

    public Integer getNumExterior() {
        return numExterior;
    }

    public void setNumExterior(Integer numExterior) {
        this.numExterior = numExterior;
    }

    public Integer getNumInterior() {
        return numInterior;
    }

    public void setNumInterior(Integer numInterior) {
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

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
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

    public Date getFecActualizacion() {
        return fecActualizacion;
    }

    public void setFecActualizacion(Date fecActualizacion) {
        this.fecActualizacion = fecActualizacion;
    }

    public Integer getIndActivo() {
        return indActivo;
    }

    public void setIndActivo(Integer indActivo) {
        this.indActivo = indActivo;
    }

}