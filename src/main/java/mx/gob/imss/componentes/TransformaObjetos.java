package mx.gob.imss.componentes;

import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.constantes.DonacionSangreConstantes;
import mx.gob.imss.donacionsangre.dto.DonacionSangre;
import mx.gob.imss.donacionsangre.modelos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Slf4j
@Component
public class TransformaObjetos {
    @Autowired
    AgendaDigitalCliente client;

    public MsmdstDonacionSangre dtoToDonacionSangreModel(DonacionSangre donacionSangre) throws ParseException {
        MsmdstDonacionSangre msmdstDonacionSangre = new MsmdstDonacionSangre();
        SimpleDateFormat format = new SimpleDateFormat(DonacionSangreConstantes.YYYY_MM_DD);
        SimpleDateFormat formatTime = new SimpleDateFormat(DonacionSangreConstantes.HH_MM_SS);
        // llenado de data Transform
        msmdstDonacionSangre.setDesUnidadMedicaHospitalaria(donacionSangre.getUmh());
        //Format DATE
        Date date = format.parse(donacionSangre.getFecha());
        msmdstDonacionSangre.setFecEfec(date);
        msmdstDonacionSangre.setIdNombreBancoSangre(donacionSangre.getIdBancoSangre());
        //format TIME
        long timeInicial = formatTime.parse(donacionSangre.getHoraInicialAtencion()).getTime();
        msmdstDonacionSangre.setTimHoraInicialAtencion(new Time(timeInicial));
        //
        long timeFinal = formatTime.parse(donacionSangre.getHoraFinalAtencion()).getTime();
        msmdstDonacionSangre.setTimHoraFinalAtencion(new Time(timeFinal));

        msmdstDonacionSangre.setDesCodigoPostal(donacionSangre.getCodigoPostal());
        msmdstDonacionSangre.setIdEstado(donacionSangre.getIdEstado());
        msmdstDonacionSangre.setIdDelegacionMunicipio(donacionSangre.getIdDelegacion());
        msmdstDonacionSangre.setIdCiudad(donacionSangre.getIdCiudad());
        msmdstDonacionSangre.setNomColonia(donacionSangre.getColonia());
        msmdstDonacionSangre.setNomCalle(donacionSangre.getCalle());
        msmdstDonacionSangre.setNumExterior(donacionSangre.getNumExterior());
        msmdstDonacionSangre.setNumInterior(donacionSangre.getNumInterior());
        msmdstDonacionSangre.setNomPaciente(donacionSangre.getNombrePaciente());
        msmdstDonacionSangre.setDesNssAgregado(donacionSangre.getDesNSS());
        msmdstDonacionSangre.setIdServicio(donacionSangre.getIdServicio());
        Date dateFecInternamiento = format.parse(donacionSangre.getFechaInternamiento());
        msmdstDonacionSangre.setFecInternamiento(dateFecInternamiento);
        Date dateFecCirugia = format.parse(donacionSangre.getFechaCirugia());
        msmdstDonacionSangre.setFecCirugia(dateFecCirugia);
        msmdstDonacionSangre.setNumTelefonoPaciente(donacionSangre.getNumTelefonoPaciente());
        msmdstDonacionSangre.setNomTrabajadorSocial(donacionSangre.getNombreTrabajadorSocial());
        msmdstDonacionSangre.setDesMatriculaTrabajadorSocial(donacionSangre.getMatriculaTrabajadorSocial());
        msmdstDonacionSangre.setNumTelefonoTrabajadorSocial(donacionSangre.getNumTelefonoTrabajadorSocial());
        msmdstDonacionSangre.setDesObservaciones(donacionSangre.getObservaciones());
        msmdstDonacionSangre.setIndActivo(1);
        return msmdstDonacionSangre;
    }

    public DonacionSangreResponse buildResponse(MsmdstDonacionSangre msmdstDonacionSangre) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DonacionSangreResponse dr = new DonacionSangreResponse();
        dr.setIdVolanteDonacionSangre(msmdstDonacionSangre.getId());
        dr.setDesUnidadMedicaHospitalaria(msmdstDonacionSangre.getDesUnidadMedicaHospitalaria());
        dr.setFecEfec(dateFormat.format(msmdstDonacionSangre.getFecEfec()));
        dr.setIdNombreBancoSangre(msmdstDonacionSangre.getIdNombreBancoSangre());
        // nombre banco de sangre
        //falta consumo AD
        dr.setNombreBancoSangre("");
        dr.setTimHoraInicialAtencion(msmdstDonacionSangre.getTimHoraInicialAtencion());
        dr.setTimHoraFinalAtencion(msmdstDonacionSangre.getTimHoraFinalAtencion());
        dr.setDesCodigoPostal(msmdstDonacionSangre.getDesCodigoPostal());
        dr.setIdEstado(msmdstDonacionSangre.getIdEstado());
        //nombre estado
        EstadosModel edos = client.getEstado(msmdstDonacionSangre.getIdEstado());
        String nombreEdo = edos.getNomCompleto();
        if (nombreEdo != null || nombreEdo != "") {
            dr.setNombreEstado(nombreEdo);
        } else {
            dr.setNombreEstado("");
        }
        // fin nombre estado
        dr.setIdDelegacionMunicipio(msmdstDonacionSangre.getIdDelegacionMunicipio());
        //nombre delegacion
        DelegacionMunicipioModel del = client.getDelegacion(msmdstDonacionSangre.getIdEstado(), msmdstDonacionSangre.getIdDelegacionMunicipio());
        String nombreDel = del.getNomMunicipio();
        if (nombreDel != null || nombreDel != "") {
            dr.setNombreDelegacionMunicipio(nombreDel);
        } else {
            dr.setNombreDelegacionMunicipio("");
        }
        // fin nombre delegacion
        dr.setIdCiudad(msmdstDonacionSangre.getIdCiudad());
        //nombre ciudad
        CiudadesModel ciudades = client.getCiudad(msmdstDonacionSangre.getIdEstado(), msmdstDonacionSangre.getIdDelegacionMunicipio(), msmdstDonacionSangre.getIdCiudad());
        String nombreCiudades = ciudades.getNomCiudad();
        if (nombreCiudades != null || nombreCiudades != "") {
            dr.setNombreCiudad(nombreCiudades);
        } else {
            dr.setNombreCiudad("");
        }
        dr.setNomColonia(msmdstDonacionSangre.getNomColonia());
        dr.setNomCalle(msmdstDonacionSangre.getNomCalle());
        dr.setNumExterior(msmdstDonacionSangre.getNumExterior());
        dr.setNumInterior(msmdstDonacionSangre.getNumInterior());
        dr.setNomPaciente(msmdstDonacionSangre.getNomPaciente());
        dr.setDesNssAgregado(msmdstDonacionSangre.getDesNssAgregado());
        dr.setIdServicio(msmdstDonacionSangre.getIdServicio());
        // nombre servicio
        ServiciosModel servicios = client.getServicio(msmdstDonacionSangre.getIdServicio().toString());
        if (servicios.getNomEspecialidad() != null || servicios.getNomEspecialidad() != "") {
            dr.setNombreServicio(servicios.getNomEspecialidad());
        } else {
            dr.setNombreServicio("");
        }
        dr.setFecInternamiento(dateFormat.format(msmdstDonacionSangre.getFecInternamiento()));
        dr.setFecCirugia(dateFormat.format(msmdstDonacionSangre.getFecCirugia()));
        dr.setNumTelefonoPaciente(msmdstDonacionSangre.getNumTelefonoPaciente());
        dr.setNomTrabajadorSocial(msmdstDonacionSangre.getNomTrabajadorSocial());
        dr.setDesMatriculaTrabajadorSocial(msmdstDonacionSangre.getDesMatriculaTrabajadorSocial());
        dr.setNumTelefonoTrabajadorSocial(msmdstDonacionSangre.getNumTelefonoTrabajadorSocial());
        dr.setDesObservaciones(msmdstDonacionSangre.getDesObservaciones());
        return dr;
    }

}
