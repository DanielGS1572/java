package com.coderscampus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
@Configuration		//Necesario para no tener un archivo xml
@ComponentScan		//Para que escanee los @Component

public class FileReadingConfiguration {
	
	@Bean
	static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer(); 
	}
	
	@Bean 
	@Qualifier("ascReport")
	static CrimeReportResult crimeReportResultAsc(){
		return new CrimeReportResult("Asc");
	}
	
	@Bean
	@Qualifier("descReport")
	static CrimeReportResult crimeReportResultDesc(){
		return new CrimeReportResult("Desc");
	}
	
	public static void main(String args[])
	{
		
		ApplicationContext context = new AnnotationConfigApplicationContext(FileReadingConfiguration.class);
		
		List<CrimeReport> report = new ArrayList<CrimeReport>();
		
//		CrimeReport crimeReport = (CrimeReport) context.getBean("crimeReport");
		report.add((CrimeReport) context.getBean("crimeReport"));
		report.add((CrimeReport) context.getBean("crimeReport"));
		report.add((CrimeReport) context.getBean("crimeReport"));
		
		for(CrimeReport rep: report){
			System.out.println(rep);
			rep.generateReport();
		}
		
//		for(CrimeReportDataRow crimeReport2:crimeReport.getDataRow()){
//			System.out.println(crimeReport2);
//			
//		}
	}
}
