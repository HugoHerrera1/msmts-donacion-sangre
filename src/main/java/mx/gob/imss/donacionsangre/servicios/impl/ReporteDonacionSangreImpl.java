package mx.gob.imss.donacionsangre.servicios.impl;

import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.donacionsangre.dto.ReporteDonacionSangre;
import mx.gob.imss.donacionsangre.servicios.ReporteDonacionSangreServices;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class ReporteDonacionSangreImpl implements ReporteDonacionSangreServices {
	
	
	  @SuppressWarnings("finally")
	public byte[] imprimeDonacionSangre (ReporteDonacionSangre reporte) {
		log.error("Estoy en Impl reporte");
		  Map <String, Object> parameters = new HashMap<>();
		byte [] filePdf= new byte [0];
		
		
		   parameters.put("desUnidadMedicaHospitalaria", reporte.getDesUnidadMedicaHospitalaria());
	        parameters.put("fecEfec", reporte.getFecEfec());
	        parameters.put("nombreBancoSangre", reporte.getNombreBancoSangre());
	        parameters.put("nomCalle", reporte.getNomCalle());
	        parameters.put("numExterior", reporte.getNumExterior());
	        parameters.put("nomColonia", reporte.getNomColonia());
	        parameters.put("desCodigoPostal", reporte.getDesCodigoPostal());
	        parameters.put("nombreDelegacionMunicipio", reporte.getNombreDelegacionMunicipio());
	        parameters.put("timHoraInicialAtencion", reporte.getTimHoraInicialAtencion());
	        parameters.put("timHoraFinalAtencion", reporte.getTimHoraFinalAtencion());
	        parameters.put("nss", reporte.getNss());
	        parameters.put("nssCompleto", reporte.getNssCompleto());
	        parameters.put("fecInternamiento", reporte.getFecInternamiento());
	        parameters.put("fecCirugia", reporte.getFecCirugia()); 
	        parameters.put("nombreServicio", reporte.getNombreServicio());
	        parameters.put("numTelefonoPaciente", reporte.getNumTelefonoPaciente());
	        parameters.put("nomTrabajadorSocial", reporte.getNomTrabajadorSocial());
	        parameters.put("desMatriculaTrabajadorSocial", reporte.getDesMatriculaTrabajadorSocial());
	        parameters.put("numTelefonoTrabajadorSocial", reporte.getNumTelefonoTrabajadorSocial());
	        parameters.put("desObservaciones", reporte.getDesObservaciones());
	        parameters.put("nomPaciente", reporte.getNomPaciente());
	        try {
	            InputStream reportStream = new ClassPathResource("reports/ReporteVolanteDonacionSangre.jrxml").getInputStream();

	            JasperReport report = JasperCompileManager.compileReport(reportStream);
	            reportStream.close();

	            filePdf = JasperRunManager.runReportToPdf(report, parameters, new JREmptyDataSource());

	        } catch (Exception e) {
				log.error("Error al generar Reporte [" + e.getMessage() + "]");
	        	 e.printStackTrace();

	        }
	        	return filePdf; 
	        }
	}


