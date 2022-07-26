package mx.gob.imss.donacionsangre.dto;




import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReporteDonacionSangre {
	
	private String desUnidadMedicaHospitalaria;

    private String fecEfec;
	
    private String nombreBancoSangre;
   
    private String nomCalle;
 
    private String numExterior;
 
    private String nomColonia;
   
    private String desCodigoPostal;
   
    private String nombreDelegacionMunicipio;
   
    private String timHoraInicialAtencion;
    
    private String timHoraFinalAtencion;
 
    private String nss;
  
    private String desNssAgregado;
   
    private String fecInternamiento;
 
    private String fecCirugia;
  
    private String nombreServicio;
 
    private String numTelefonoPaciente;
  
    private String nomTrabajadorSocial;
 
    private String desMatriculaTrabajadorSocial;
  
    private String numTelefonoTrabajadorSocial;
  
    private String desObservaciones;

    private String nomPaciente;
    
    public ReporteDonacionSangre() {
    	
    }

	public ReporteDonacionSangre(String desUnidadMedicaHospitalaria, String fecEfec, String nombreBancoSangre,
			String nomCalle, String numExterior, String nomColonia, String desCodigoPostal,
			String nombreDelegacionMunicipio, String timHoraInicialAtencion, String timHoraFinalAtencion, String nss,
			String desNssAgregado, String fecInternamiento, String fecCirugia, String nombreServicio,
			String numTelefonoPaciente, String nomTrabajadorSocial, String desMatriculaTrabajadorSocial,
			String numTelefonoTrabajadorSocial, String desObservaciones, String nomPaciente) {
		super();
		this.desUnidadMedicaHospitalaria = desUnidadMedicaHospitalaria;
		this.fecEfec = fecEfec;
		this.nombreBancoSangre = nombreBancoSangre;
		this.nomCalle = nomCalle;
		this.numExterior = numExterior;
		this.nomColonia = nomColonia;
		this.desCodigoPostal = desCodigoPostal;
		this.nombreDelegacionMunicipio = nombreDelegacionMunicipio;
		this.timHoraInicialAtencion = timHoraInicialAtencion;
		this.timHoraFinalAtencion = timHoraFinalAtencion;
		this.nss = nss;
		this.desNssAgregado = desNssAgregado;
		this.fecInternamiento = fecInternamiento;
		this.fecCirugia = fecCirugia;
		this.nombreServicio = nombreServicio;
		this.numTelefonoPaciente = numTelefonoPaciente;
		this.nomTrabajadorSocial = nomTrabajadorSocial;
		this.desMatriculaTrabajadorSocial = desMatriculaTrabajadorSocial;
		this.numTelefonoTrabajadorSocial = numTelefonoTrabajadorSocial;
		this.desObservaciones = desObservaciones;
		this.nomPaciente = nomPaciente;
	}

	public String getDesUnidadMedicaHospitalaria() {
		return desUnidadMedicaHospitalaria;
	}

	public void setDesUnidadMedicaHospitalaria(String desUnidadMedicaHospitalaria) {
		this.desUnidadMedicaHospitalaria = desUnidadMedicaHospitalaria;
	}

	public String getFecEfec() {
		return fecEfec;
	}

	public void setFecEfec(String fecEfec) {
		this.fecEfec = fecEfec;
	}

	public String getNombreBancoSangre() {
		return nombreBancoSangre;
	}

	public void setNombreBancoSangre(String nombreBancoSangre) {
		this.nombreBancoSangre = nombreBancoSangre;
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

	public String getNomColonia() {
		return nomColonia;
	}

	public void setNomColonia(String nomColonia) {
		this.nomColonia = nomColonia;
	}

	public String getDesCodigoPostal() {
		return desCodigoPostal;
	}

	public void setDesCodigoPostal(String desCodigoPostal) {
		this.desCodigoPostal = desCodigoPostal;
	}

	public String getNombreDelegacionMunicipio() {
		return nombreDelegacionMunicipio;
	}

	public void setNombreDelegacionMunicipio(String nombreDelegacionMunicipio) {
		this.nombreDelegacionMunicipio = nombreDelegacionMunicipio;
	}

	public String getTimHoraInicialAtencion() {
		return timHoraInicialAtencion;
	}

	public void setTimHoraInicialAtencion(String timHoraInicialAtencion) {
		this.timHoraInicialAtencion = timHoraInicialAtencion;
	}

	public String getTimHoraFinalAtencion() {
		return timHoraFinalAtencion;
	}

	public void setTimHoraFinalAtencion(String timHoraFinalAtencion) {
		this.timHoraFinalAtencion = timHoraFinalAtencion;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public String getDesNssAgregado() {
		return desNssAgregado;
	}

	public void setDesNssAgregado(String desNssAgregado) {
		this.desNssAgregado = desNssAgregado;
	}

	public String getFecInternamiento() {
		return fecInternamiento;
	}

	public void setFecInternamiento(String fecInternamiento) {
		this.fecInternamiento = fecInternamiento;
	}

	public String getFecCirugia() {
		return fecCirugia;
	}

	public void setFecCirugia(String fecCirugia) {
		this.fecCirugia = fecCirugia;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
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

	public String getNomPaciente() {
		return nomPaciente;
	}

	public void setNomPaciente(String nomPaciente) {
		this.nomPaciente = nomPaciente;
	}
    
    
}
