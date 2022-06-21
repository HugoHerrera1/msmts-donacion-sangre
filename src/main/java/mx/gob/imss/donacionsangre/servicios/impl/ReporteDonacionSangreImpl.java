package mx.gob.imss.donacionsangre.servicios.impl;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.donacionsangre.dto.ReporteDonacionSangre;
import mx.gob.imss.donacionsangre.servicios.ReporteDonacionSangreServices;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;

@Slf4j
@Service
public class ReporteDonacionSangreImpl implements ReporteDonacionSangreServices {
	
	@Autowired
	private MessageSource messageSource;
	
	public byte[] imprimeDonacionSangre (ReporteDonacionSangre reporte) {
		byte [] filePdf= new byte [0];
		
		Map <String, Object> parameters = new HashMap<>();
		   parameters.put("uMedicaH", reporte.getUMedicaH());
	        parameters.put("fechaSolc", reporte.getFechaSolc());
	        parameters.put("nombreBancoS", reporte.getNombreBancoS());
	        parameters.put("calleBanco", reporte.getCalleBanco());
	        parameters.put("noBanco", reporte.getNoBanco());
	        parameters.put("colBanco", reporte.getColBanco());
	        parameters.put("cpBanco", reporte.getCpBanco());
	        parameters.put("alcaldiaBanco", reporte.getAlcaldiaBanco());
	        parameters.put("hrDesde", reporte.getHrDesde());
	        parameters.put("hrHasta", reporte.getHrHasta());
	        parameters.put("nss", reporte.getNss());
	        parameters.put("agregado", reporte.getAgregado());
	        parameters.put("fechaInter", reporte.getFechaInter());
	        parameters.put("fechaCir", reporte.getFechaCir()); 
	        parameters.put("servicio", reporte.getServicio());
	        parameters.put("telPaciente", reporte.getTelPaciente());
	        parameters.put("nombreTS", reporte.getNombreTS());
	        parameters.put("matricula", reporte.getMatricula());
	        parameters.put("telTS", reporte.getTelTS());
	        parameters.put("observaciones", reporte.getObservaciones());
	        parameters.put("nombrePac", reporte.getNombrePac());
	        
	        try {

	            InputStream reportStream = Files.newInputStream(Paths.get("src/main/resources/reports/ReporteVolanteDonacionSangre.jrxml"));

	            JasperReport report = JasperCompileManager.compileReport(reportStream);
	            reportStream.close();

	            filePdf = JasperRunManager.runReportToPdf(report, parameters, new JREmptyDataSource());

	        } catch (Exception e) {

	            log.error(messageSource.getMessage("JASPER_ERROR", new Object[]{e.getMessage()}, Locale.getDefault()));
	            e.printStackTrace();

	        }
		
		
		return filePdf;       
	        
	}

}
