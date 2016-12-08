package com.example.tienda2.datos;

public class HelperClassTienda2 {

	private int id;
	private String nombreProducto;
	private String categoria;
	private int cantidad;
	private double precio;
	private double totalxProducto;

	public HelperClassTienda2(String nombreProducto, double totalxProducto) {
		this.nombreProducto = nombreProducto;
		this.totalxProducto = totalxProducto;
	}

	public HelperClassTienda2(int id, String categoria, String nombreProducto, int cantidad, double precio) {
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.categoria = categoria;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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

	public double regresaTotalxProducto() {
		this.totalxProducto = this.cantidad * this.precio;
		return totalxProducto;
	}

	public double getTotalxProducto() {
		return totalxProducto;
	}

	public void setTotalxProducto(int totalxProducto) {
		this.totalxProducto = totalxProducto;
	}

	@Override
	public String toString() {
		return "HelperClassTienda2 [id=" + id + ", nombreProducto=" + nombreProducto + ", categoria=" + categoria
				+ ", cantidad=" + cantidad + ", precio=" + precio + ", totalxProducto=" + totalxProducto + "]";
	}

}
