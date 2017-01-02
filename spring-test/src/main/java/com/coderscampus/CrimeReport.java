package com.coderscampus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties") // Esta linea puede estar
													// dentro de la clase que
													// contiene al metodo main, a pesar que pudiera estar dentro del metodo main puede leer la propiedad ${} 
@Scope("prototype")
public class CrimeReport {
	private List<CrimeReportDataRow> dataRow = new ArrayList<CrimeReportDataRow>();

	private FileProcessorService fps;

	@Autowired
	@Qualifier("ascReport")
	private CrimeReportResult crimeReportResult;
	
	@Value("${report.filename}") // Aqui se obtiene el property
	private String fileName;

	private FileProcessorService fileProcessorService;

	public void generateReport() {
		this.setDataRow(fileProcessorService.processFile(fileName));
		System.out.println(crimeReportResult.getSorting());
	}

	public List<CrimeReportDataRow> getDataRow() {
		return dataRow;
	}

	public void setDataRow(List<CrimeReportDataRow> dataRow) {
		this.dataRow = dataRow;
	}

	@Autowired // El autowired puede estar en el setter o en la definición de la
				// variable
	public void setFileProcessorService(FileProcessorService fileProcessorService) {
		this.fileProcessorService = fileProcessorService;
	}

//	@Override
//	public String toString() {
//		return "CrimeReport [dataRow=" + dataRow + ", fps=" + fps + ", fileName=" + fileName + ", fileProcessorService="
//				+ fileProcessorService + "]";
//	}

}
