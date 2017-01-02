package com.coderscampus;
//POJO para leer el archivo
public class CrimeReportDataRow {
	private String crimeDescription;
	private Integer crimeInstanceNumber;
	private Integer crimeRate;
	private Integer yearlyCrimeRateChange;
	private Integer decadeCrimeRateChange;
	
	public CrimeReportDataRow(String data[]){
		this.setCrimeDescription(data[0]);
		this.setCrimeInstanceNumber(Integer.valueOf(data[1]));
		this.setCrimeRate(Integer.valueOf(data[2]));
		this.setYearlyCrimeRateChange(Integer.valueOf(data[3]));
		this.setDecadeCrimeRateChange(Integer.valueOf(data[4]));
	}
	
	
	public String getCrimeDescription() {
		return crimeDescription;
	}
	public void setCrimeDescription(String crimeDescription) {
		this.crimeDescription = crimeDescription;
	}
	public Integer getCrimeInstanceNumber() {
		return crimeInstanceNumber;
	}
	public void setCrimeInstanceNumber(Integer crimeInstanceNumber) {
		this.crimeInstanceNumber = crimeInstanceNumber;
	}
	public Integer getCrimeRate() {
		return crimeRate;
	}
	public void setCrimeRate(Integer crimeRate) {
		this.crimeRate = crimeRate;
	}
	public Integer getYearlyCrimeRateChange() {
		return yearlyCrimeRateChange;
	}
	public void setYearlyCrimeRateChange(Integer yearlyCrimeRateChange) {
		this.yearlyCrimeRateChange = yearlyCrimeRateChange;
	}
	public Integer getDecadeCrimeRateChange() {
		return decadeCrimeRateChange;
	}
	public void setDecadeCrimeRateChange(Integer decadeCrimeRateChange) {
		this.decadeCrimeRateChange = decadeCrimeRateChange;
	}
	
	
}
