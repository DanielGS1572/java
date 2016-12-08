

public class HelperClas {

	private int id;
	private String nombreProducto;
	private String categoria;
	private int cantidad;
	private int precio;

	public HelperClas(int id, String categoria, String nombreProducto, int cantidad, int precio) {
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.categoria = categoria;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getPrecio() {
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

}
