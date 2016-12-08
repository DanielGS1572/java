package com.example.liferay.datos;

public class HelperClassAltaCombos {
	private int idCombo;
	private int cantidadProductoComprado;
	private String productoComprado;
	private int cantidadProductoRegalo;
	private String productoRegalo;
	
	public HelperClassAltaCombos(int idCombo,int cantidadProductoComprado,String productoComprado,int cantidadProductoRegalo,String productoRegalo) {
		this.idCombo = idCombo;
		this.cantidadProductoComprado = cantidadProductoComprado;
		this.productoComprado = productoComprado;
		this.cantidadProductoRegalo = cantidadProductoRegalo;
		this.productoRegalo = productoRegalo;
	}

	public int getIdCombo() {
		return idCombo;
	}

	public void setIdCombo(int idCombo) {
		this.idCombo = idCombo;
	}

	public int getCantidadProductoComprado() {
		return cantidadProductoComprado;
	}

	public void setCantidadProductoComprado(int cantidadProductoComprado) {
		this.cantidadProductoComprado = cantidadProductoComprado;
	}



	public String getProductoComprado() {
		return productoComprado;
	}

	public void setProductoComprado(String productoComprado) {
		this.productoComprado = productoComprado;
	}

	public String getProductoRegalo() {
		return productoRegalo;
	}

	public void setProductoRegalo(String productoRegalo) {
		this.productoRegalo = productoRegalo;
	}

	public int getCantidadProductoRegalo() {
		return cantidadProductoRegalo;
	}

	public void setCantidadProductoRegalo(int cantidadProductoRegalo) {
		this.cantidadProductoRegalo = cantidadProductoRegalo;
	}

	
	
	
}
