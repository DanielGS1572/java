package com.example.liferay.datos;

public class HelperClassCatalogoProductos {

	private int id;
	private String nombreProducto;
	private String categoria;
	private int cantidad;
	private double precio;
	private double totalxProducto;
	
	public HelperClassCatalogoProductos(){
		
	}
	
	public HelperClassCatalogoProductos(int id, String categoria, String nombreProducto, double precio, int cantidad) {
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.categoria = categoria;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	public HelperClassCatalogoProductos(int id, String categoria, String nombreProducto, double precio) {
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.categoria = categoria;
		
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getTotalxProducto() {
		return totalxProducto;
	}

	public void setTotalxProducto(double totalxProducto) {
		this.totalxProducto = totalxProducto;
	}

	
	
}
