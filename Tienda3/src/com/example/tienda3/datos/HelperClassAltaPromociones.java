package com.example.tienda3.datos;

public class HelperClassAltaPromociones {
	private String producto;
	private int idPromocion;
	private int enLaCompraDe;
	private int llevate;

	public HelperClassAltaPromociones(int idPromocion, String producto, int enLaCompraDe, int llevate) {
		this.idPromocion = idPromocion;
		this.producto = producto;
		this.enLaCompraDe = enLaCompraDe;
		this.llevate = llevate;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getIdPromocion() {
		return idPromocion;
	}

	public void setIdPromocion(int idPromocion) {
		this.idPromocion = idPromocion;
	}

	public int getEnLaCompraDe() {
		return enLaCompraDe;
	}

	public void setEnLaCompraDe(int enLaCompraDe) {
		this.enLaCompraDe = enLaCompraDe;
	}

	public int getLlevate() {
		return llevate;
	}

	public void setLlevate(int llevate) {
		this.llevate = llevate;
	}

}
