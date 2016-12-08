package com.example.altaproductos.datos;

public class HelperClassAltaProductos {

	private int id;
	private String nombreProducto;
	private String categoria;
	private double precio;

	public HelperClassAltaProductos(int id, String categoria, String nombreProducto, double precio) {
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
