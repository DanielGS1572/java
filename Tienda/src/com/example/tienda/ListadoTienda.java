package com.example.tienda;

import java.util.Iterator;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;

public class ListadoTienda {

	// Inicializa tabla Cliente

	private static BeanItemContainer<HelperClassTienda> container = new BeanItemContainer<HelperClassTienda>(
			HelperClassTienda.class);

	private static int cantidadElementosComprados = 0;
	private static int suma = 0;

	private static Iterator<HelperClassTienda> item;
	private static Table tablaCliente;

	public static void reset() {
		suma = 0;

		cantidadElementosComprados = 0;
		tablaCliente = null;
		item = null;
	}

	public static BeanItemContainer<HelperClassTienda> createContainer() {

		// Inicializa la tabla del cliente

		for (int i = 1; i <= 20; i++) {
			container.addItem(new HelperClassTienda(i, "categoria " + i, "nombreProducto " + i, i, 20));
		}

		return container;
	}

	public static Table getDetalle() {
		reset();
		inicializaTabla();
		int a = 0;

		for (item = container.getItemIds().iterator(); item.hasNext();) {

			HelperClassTienda obj = item.next();

			int cantidad = obj.getCantidad();
			if (cantidad != 0) {

				a++;

				int precio = obj.getPrecio();
				String productoComprado = obj.getNombreProducto();

				construyeTabla(productoComprado, cantidad * precio, a);
				suma += cantidad * precio;

			}

		}

		System.out.println(obtieneSuma());

		return tablaCliente;
	}

	public static int obtieneSuma() {

		return suma;
	}

	public static void construyeTabla(String productoComprado, int total, int registro) {

		tablaCliente.addItem(new Object[] { productoComprado, total }, registro);
		tablaCliente
	}

	// public static void updateTable() {
	// tablaCliente.removeContainerProperty("Total");
	// tablaCliente.addContainerProperty("Total", Integer.class, null);
	// }

	public static void inicializaTabla() {
		tablaCliente = new Table();

		tablaCliente.addContainerProperty("Producto", String.class, null);
		tablaCliente.addContainerProperty("Total", Integer.class, null);
	}

	public static int getElementosComprados() {
		for (item = container.getItemIds().iterator(); item.hasNext();) {

			if (item.next().getCantidad() != 0) {

				cantidadElementosComprados++;

			}

		}
		return cantidadElementosComprados;
	}

}
