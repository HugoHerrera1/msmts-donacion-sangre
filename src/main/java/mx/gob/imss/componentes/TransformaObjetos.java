package mx.gob.imss.componentes;

import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.constantes.DonacionSangreConstantes;
import mx.gob.imss.donacionsangre.dto.DonacionSangre;
import mx.gob.imss.donacionsangre.modelos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Slf4j
@Component
public class TransformaObjetos {
    @Autowired
    AgendaDigitalCliente client;

    public MtstVolanteDonacionSangre dtoToDonacionSangreModel(DonacionSangre donacionSangre) throws ParseException {
        MtstVolanteDonacionSangre msmdstDonacionSangre = new MtstVolanteDonacionSangre();
        SimpleDateFormat format = new SimpleDateFormat(DonacionSangreConstantes.YYYY_MM_DD);
        SimpleDateFormat formatTime = new SimpleDateFormat(DonacionSangreConstantes.HH_MM_SS);
        // llenado de data Transform
        msmdstDonacionSangre.setDesUnidadMedicaHospitalaria(donacionSangre.getUmh());
        //Format DATE
        Date date = format.parse(donacionSangre.getFecha());
        msmdstDonacionSangre.setFecEfec(date);
        msmdstDonacionSangre.setIdNombreBancoSangre(Long.parseLong(donacionSangre.getIdBancoSangre().toString()));
        //format TIME
        long timeInicial = formatTime.parse(donacionSangre.getHoraInicialAtencion()).getTime();
        msmdstDonacionSangre.setTimInicialAtencion(new Time(timeInicial));
        //
        long timeFinal = formatTime.parse(donacionSangre.getHoraFinalAtencion()).getTime();
        msmdstDonacionSangre.setTimFinalAtencion(new Time(timeFinal));

        msmdstDonacionSangre.setDesCodigoPostal(donacionSangre.getCodigoPostal());
        msmdstDonacionSangre.setIdEstado(donacionSangre.getIdEstado().toString());
        msmdstDonacionSangre.setIdDelegacionMunicipio(donacionSangre.getIdDelegacion().toString());
        msmdstDonacionSangre.setIdCiudad(donacionSangre.getIdCiudad().toString());
        msmdstDonacionSangre.setNomColonia(donacionSangre.getColonia());
        msmdstDonacionSangre.setNomCalle(donacionSangre.getCalle());
        msmdstDonacionSangre.setNumExterior(donacionSangre.getNumExterior().toString());
        msmdstDonacionSangre.setNumInterior(donacionSangre.getNumInterior().toString());
        msmdstDonacionSangre.setNomPaciente(donacionSangre.getNombrePaciente());
        msmdstDonacionSangre.setDesNssAgregado(donacionSangre.getDesNSS());
        msmdstDonacionSangre.setIdServicio(donacionSangre.getIdServicio().longValue());
        Date dateFecInternamiento = format.parse(donacionSangre.getFechaInternamiento());
        msmdstDonacionSangre.setFecInternamiento(dateFecInternamiento);
        Date dateFecCirugia = format.parse(donacionSangre.getFechaCirugia());
        msmdstDonacionSangre.setFecCirugia(dateFecCirugia);
        msmdstDonacionSangre.setNumTelefonoPaciente(donacionSangre.getNumTelefonoPaciente());
        msmdstDonacionSangre.setNomTrabajadorSocial(donacionSangre.getNombreTrabajadorSocial());
        msmdstDonacionSangre.setDesMatriculaTrabajadorSocial(donacionSangre.getMatriculaTrabajadorSocial());
        msmdstDonacionSangre.setNumTelefonoTrabajadorSocial(donacionSangre.getNumTelefonoTrabajadorSocial());
        msmdstDonacionSangre.setDesObservaciones(donacionSangre.getObservaciones());
        msmdstDonacionSangre.setIndActivo(true);
        return msmdstDonacionSangre;
    }

    public DonacionSangreResponse buildResponse(MtstVolanteDonacionSangre msmdstDonacionSangre) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DonacionSangreResponse dr = new DonacionSangreResponse();
        dr.setIdVolanteDonacionSangre(Integer.parseInt(msmdstDonacionSangre.getId().toString()));
        dr.setDesUnidadMedicaHospitalaria(msmdstDonacionSangre.getDesUnidadMedicaHospitalaria());
        dr.setFecEfec(dateFormat.format(msmdstDonacionSangre.getFecEfec()));
        dr.setIdNombreBancoSangre(msmdstDonacionSangre.getIdNombreBancoSangre().intValue());
        // nombre banco de sangre
        //falta consumo AD
        dr.setNombreBancoSangre("");
        dr.setTimHoraInicialAtencion(msmdstDonacionSangre.getTimInicialAtencion());
        dr.setTimHoraFinalAtencion(msmdstDonacionSangre.getTimFinalAtencion());
        dr.setDesCodigoPostal(msmdstDonacionSangre.getDesCodigoPostal());
        dr.setIdEstado(Integer.valueOf(msmdstDonacionSangre.getIdEstado()));
        //nombre estado
        EstadosModel edos = client.getEstado(Integer.valueOf(msmdstDonacionSangre.getIdEstado()));
        String nombreEdo = Objects.isNull(edos) ? "No se encontro registro" : edos.getNomCompleto();
        dr.setNombreEstado(nombreEdo);
        // fin nombre estado
        dr.setIdDelegacionMunicipio(Integer.valueOf(msmdstDonacionSangre.getIdDelegacionMunicipio()));
        //nombre delegacion
        DelegacionMunicipioModel del = client.getDelegacion(Integer.valueOf(msmdstDonacionSangre.getIdEstado()), Integer.valueOf(msmdstDonacionSangre.getIdDelegacionMunicipio()));
        String nombreDel = Objects.isNull(del) ? "No se encontro registro" : del.getNomMunicipio();
        dr.setNombreDelegacionMunicipio(nombreDel);

        // fin nombre delegacion
        dr.setIdCiudad(Integer.valueOf(msmdstDonacionSangre.getIdCiudad()));
        //nombre ciudad
        CiudadesModel ciudades = client.getCiudad(Integer.valueOf(msmdstDonacionSangre.getIdEstado()), Integer.valueOf(msmdstDonacionSangre.getIdDelegacionMunicipio()), Integer.valueOf(msmdstDonacionSangre.getIdCiudad()));
        String nombreCiudades = Objects.isNull(ciudades) ? "No se encontro registro" : ciudades.getNomCiudad();
        dr.setNombreCiudad(nombreCiudades);
        dr.setNomColonia(msmdstDonacionSangre.getNomColonia());
        dr.setNomCalle(msmdstDonacionSangre.getNomCalle());
        dr.setNumExterior(msmdstDonacionSangre.getNumExterior());
        dr.setNumInterior(msmdstDonacionSangre.getNumInterior());
        dr.setNomPaciente(msmdstDonacionSangre.getNomPaciente());
        dr.setDesNssAgregado(msmdstDonacionSangre.getDesNssAgregado());
        dr.setIdServicio(msmdstDonacionSangre.getIdServicio().intValue());
        // nombre servicio
        List<ServiciosModel> servicios = client.getServicio(msmdstDonacionSangre.getIdServicio().toString());
        String nombreServicio = servicios.isEmpty() ? "No se encontro registro" : servicios.get(0).getNomEspecialidad();
        dr.setNombreServicio(nombreServicio);
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
