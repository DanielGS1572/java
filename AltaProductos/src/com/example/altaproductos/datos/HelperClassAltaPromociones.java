package com.example.altaproductos.datos;

public class HelperClassAltaPromociones {
	private int idProducto;
	private int idPromocion;
	private int enLaCompraDe;
	private int llevate;
	
	public HelperClassAltaPromociones(int idPromocion,int idProducto, int enLaCompraDe, int llevate){
		this.idPromocion = idPromocion;
		this.idProducto = idProducto;
		this.enLaCompraDe = enLaCompraDe;
		this.llevate = llevate;
	}

	public int getIdProducto() {
		return idProducto;
	}



	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
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
