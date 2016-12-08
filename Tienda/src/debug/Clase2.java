package debug;

import com.vaadin.ui.Table;

public class Clase2 {
	private static Table tablaCliente;

	public static void construyeTabla(String productoComprado, int total, int registro) {

		tablaCliente.addItem(new Object[] { productoComprado, total }, registro);

	}

	public static void inicializaTabla() {
		tablaCliente = new Table();
		tablaCliente.addContainerProperty("Producto", String.class, null);
		tablaCliente.addContainerProperty("Total", Integer.class, null);
	}
}
