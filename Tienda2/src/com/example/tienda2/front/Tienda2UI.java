package com.example.tienda2.front;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.annotation.WebServlet;
import com.example.tienda2.datos.HelperClassTienda2;
import com.example.tienda2.servicios.Servicios2;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Field;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("tienda2")
public class Tienda2UI extends UI {
	private DecimalFormat f = new DecimalFormat("##.00");
	private ArrayList<HelperClassTienda2> listaCatalogo;

	private Iterator<HelperClassTienda2> li;
	private double suma = 0;

	private Grid gridCatalogo;
	private Grid gridCliente = new Grid();

	private BeanItemContainer<HelperClassTienda2> containerCatalogo;
	private BeanItemContainer<HelperClassTienda2> containerCliente;

	private Label despliegaSuma;

	@WebServlet(value = { "/myui/*", "/VAADIN/*" }, asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Tienda2UI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {

		// ################## Establece Layout

		final HorizontalLayout hl = new HorizontalLayout();
		hl.setMargin(true);
		setContent(hl);

		final VerticalLayout vlCatalogo = new VerticalLayout();
		vlCatalogo.setMargin(true);

		final VerticalLayout vlCompra = new VerticalLayout();
		vlCompra.setMargin(true);

		final HorizontalLayout hlCalculoResultado = new HorizontalLayout();

		Button button = new Button("Calcular suma");
		despliegaSuma = new Label("");

		gridCatalogo = new Grid();

		hl.addComponent(vlCatalogo);
		hl.addComponent(vlCompra);

		vlCatalogo.addComponent(new Label("Catalogo de productos"));
		vlCatalogo.addComponent(gridCatalogo);
		vlCatalogo.setSpacing(true);

		vlCompra.addComponent(new Label("Compras realizadas"));
		vlCompra.addComponent(gridCliente);

		vlCompra.addComponent(hlCalculoResultado);
		vlCompra.setSpacing(true);

		hlCalculoResultado.setSpacing(true);
		hlCalculoResultado.addComponent(button);
		hlCalculoResultado.addComponent(despliegaSuma);
		hlCalculoResultado.setComponentAlignment(despliegaSuma, Alignment.MIDDLE_CENTER);

		// ################## Crea catalogo de la tienda
		containerCatalogo = new BeanItemContainer<HelperClassTienda2>(HelperClassTienda2.class);

		Servicios2 catalogoTienda = new Servicios2();
		catalogoTienda.creaCatalogo();

		listaCatalogo = catalogoTienda.getCatalogo();

		for (HelperClassTienda2 lC : listaCatalogo) {
			containerCatalogo.addItem(lC);
		}

		gridCatalogo.setContainerDataSource(containerCatalogo);

		// Ajustes en la tabla de grid Catalogo
		gridCatalogo.getColumn("id").setHeaderCaption("ID");
		gridCatalogo.getColumn("nombreProducto").setHeaderCaption("Producto");

		gridCatalogo.setEditorEnabled(true);
		gridCatalogo.getColumn("cantidad").setEditable(true);
		gridCatalogo.getColumn("id").setEditable(false);
		gridCatalogo.getColumn("categoria").setEditable(false);
		gridCatalogo.getColumn("nombreProducto").setEditable(false);
		gridCatalogo.getColumn("precio").setEditable(false);

		gridCatalogo.getColumn("cantidad").setSortable(false);
		gridCatalogo.getColumn("nombreProducto").setSortable(false);
		gridCatalogo.getColumn("precio").setSortable(false);

		// Valida que no existan vacios

		Field<?> customerField = gridCatalogo.getColumn("cantidad").getEditorField();
		customerField.setRequired(true);
		customerField.setRequiredError("Por favor introduce un valor numerico");

		Object[] VISIBLE_CATALOGO_COLUMN_IDS = new String[] { "id", "categoria", "nombreProducto", "precio",
				"cantidad" };
		gridCatalogo.setColumns(VISIBLE_CATALOGO_COLUMN_IDS);

		// ################## Invoca creaciÛn tabla cliente
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				// Notification.show("CLICKED");
				pintaTablaCliente();

				despliegaSuma.setValue("El total es: " + f.format(suma));

			}
		});

	}

	// ################## Crea lista de productos comprados
	public void pintaTablaCliente() {
		suma = 0;
		containerCliente = new BeanItemContainer<HelperClassTienda2>(HelperClassTienda2.class);
		containerCliente.removeAllItems();

		ArrayList<HelperClassTienda2> listaProductosComprados = new ArrayList<HelperClassTienda2>();
		int cantidad = 0;

		for (li = containerCatalogo.getItemIds().iterator(); li.hasNext();) {

			HelperClassTienda2 obj = li.next();
			cantidad = obj.getCantidad();

			if (cantidad != 0) {
				listaProductosComprados
						.add(new HelperClassTienda2(obj.getNombreProducto(), obj.regresaTotalxProducto()));

				suma += obj.regresaTotalxProducto();
			}

		}

		for (HelperClassTienda2 lPC : listaProductosComprados) {
			containerCliente.addItem(lPC);
		}

		gridCliente.setContainerDataSource(containerCliente);

		Object[] VISIBLE_CLIENTE_COLUMN_IDS = new String[] { "nombreProducto", "totalxProducto" };
		gridCliente.setColumns(VISIBLE_CLIENTE_COLUMN_IDS);

		gridCliente.getColumn("nombreProducto").setHeaderCaption("Producto");
		gridCliente.getColumn("totalxProducto").setHeaderCaption("Subtotal");

	}

}

