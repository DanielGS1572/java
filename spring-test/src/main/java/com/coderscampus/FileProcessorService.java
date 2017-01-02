package com.coderscampus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
//@Scope(value = "prototype")
public class FileProcessorService {
	@Autowired
	FileReadingService frs;

	public List<CrimeReportDataRow> processFile(@Value("${report.filename}") String filename) {
		// frs = new FileReadingService();
		List<String> lines = frs.readFile(filename);
		List< CrimeReportDataRow> rows = new ArrayList<CrimeReportDataRow>();
		for (String line : lines) {
			String[] data = line.split(",");
			if(data.length == 0 || StringUtils.isEmpty(data[0])){
				continue;
			}
			rows.add(new CrimeReportDataRow(data));
			System.out.println(line);
		}
		return rows;
	}
}
