package mx.gob.imss.donacionsangre.modelos;

import lombok.Data;

@Data
public class DonacionSangreResponse {

    private Integer idVolanteDonacionSangre;
    private String desUnidadMedicaHospitalaria;
    private String fecEfec;
    private Integer idNombreBancoSangre;
    private String nombreBancoSangre;
    private String timHoraInicialAtencion;
    private String timHoraFinalAtencion;
    private String desCodigoPostal;
    private Integer idEstado;
    private String nombreEstado;
    private Integer idDelegacionMunicipio;
    private String nombreDelegacionMunicipio;
    private Integer idCiudad;
    private String nombreCiudad;
    private String nomColonia;
    private String nomCalle;
    private String numExterior;
    private String numInterior;
    private String nomPaciente;
    private String desNssAgregado;
    private String tipoSangre;
    private String idServicio;
    private String nombreServicio;
    private String fecInternamiento;
    private String fecCirugia;
    private String numTelefonoPaciente;
    private String nomTrabajadorSocial;
    private String desMatriculaTrabajadorSocial;
    private String numTelefonoTrabajadorSocial;
    private String desObservaciones;
}
