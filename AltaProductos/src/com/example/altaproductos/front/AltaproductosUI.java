package com.example.altaproductos.front;

import javax.servlet.annotation.WebServlet;

import com.example.altaproductos.datos.HelperClassAltaCombos;
import com.example.altaproductos.datos.HelperClassAltaProductos;
import com.example.altaproductos.datos.HelperClassAltaPromociones;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.DetailsGenerator;
import com.vaadin.ui.Grid.HeaderRow;
import com.vaadin.ui.Grid.RowReference;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("altaproductos")
public class AltaproductosUI extends UI {

	private BeanItemContainer<HelperClassAltaProductos> containerProductos;
	private BeanItemContainer<HelperClassAltaPromociones> containerPromociones;
	private BeanItemContainer<HelperClassAltaCombos> containerCombos;

	private int idProductos = 0;
	private int idPromociones = 0;
	private int idCombos = 0;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = AltaproductosUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		// ##############################################################################
		// #####______________________Alta_de_productos_____________________________#####
		// ##############################################################################
		final VerticalLayout vl = new VerticalLayout();
		vl.setMargin(true);
		setContent(vl);

		final HorizontalLayout hl = new HorizontalLayout();
		hl.setMargin(false);
		
		final VerticalLayout vlProductos = new VerticalLayout();
		vlProductos.setMargin(false);
		
		final VerticalLayout vlPromocion = new VerticalLayout();
		vlPromocion.setMargin(false);
		
		final Label lblProducto = new Label("<b>ALTA DE PRODUCTOS</b>",ContentMode.HTML);
		final Label lblPromocion = new Label("<b>ALTA DE PROMOCIONES</b>",ContentMode.HTML);
		final Label lblCombos = new Label("<b>ALTA DE COMBOS</b>",ContentMode.HTML);
		// +++++++++++++++++ Configuración del boton de nuevo registro
		Grid altaProductos = new Grid();
		Button registroNuevoProducto = new Button("Agregar producto");

			registroNuevoProducto.addClickListener(new Button.ClickListener() {
	
				@Override
				public void buttonClick(ClickEvent event) {
					idProductos++;
					containerProductos.addItem(new HelperClassAltaProductos(idProductos, "", "", 0.0));
	
				}
			});

		vl.addComponent(hl);
		
		hl.addComponent(vlProductos);
		hl.addComponent(vlPromocion);
		hl.setSpacing(true);
		vl.setComponentAlignment(hl, Alignment.MIDDLE_CENTER);
		
		vlProductos.addComponent(lblProducto);
		vlProductos.setComponentAlignment(lblProducto, Alignment.TOP_CENTER);
		
		vlPromocion.addComponent(lblPromocion);
		vlPromocion.setComponentAlignment(lblPromocion, Alignment.TOP_CENTER);
	
		vl.setSpacing(true);

		containerProductos = new BeanItemContainer<HelperClassAltaProductos>(HelperClassAltaProductos.class);

		altaProductos.setContainerDataSource(containerProductos);

		altaProductos.setColumnOrder("id", "categoria", "nombreProducto", "precio");
		altaProductos.getColumn("id").setEditable(false);
		altaProductos.setEditorEnabled(true);

		// +++++++++++++++++ Configuración del boton de borrado
		altaProductos.setDetailsGenerator(new DetailsGenerator() {

			@Override
			public Component getDetails(RowReference rowReference) {
				HelperClassAltaProductos altaProductos = (HelperClassAltaProductos) rowReference.getItemId();
				String detalleMsg = "Deseas eliminar el registro " + altaProductos.getId() + "?";

				Button deleteButton = new Button("Eliminar registro", new Button.ClickListener() {

					@Override
					public void buttonClick(ClickEvent event) {
						Notification.show("Registro " + altaProductos.getId() + " eliminado");
						containerProductos.removeItem(rowReference.getItemId());

					}
				});

				VerticalLayout vlRegistro = new VerticalLayout(new Label(detalleMsg), deleteButton);
				vlRegistro.setMargin(true);
				vlRegistro.setSpacing(true);
				return vlRegistro;
			}

		});
		// +++++++++++++++++ Configuración para poner visible boton de borrado y
		// mensaje
		altaProductos.addItemClickListener(new ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {
				Object itemId = event.getItemId();
				altaProductos.setDetailsVisible(itemId, !altaProductos.isDetailsVisible(itemId));

			}

		});

		// ##############################################################################
		// #####______________________Alta_de_promociones___________________________#####
		// ##############################################################################
		Grid altaPromociones = new Grid();
		vl.addComponent(altaPromociones);

		containerPromociones = new BeanItemContainer<HelperClassAltaPromociones>(HelperClassAltaPromociones.class);
		altaPromociones.setContainerDataSource(containerPromociones);
		altaPromociones.setColumnOrder("idPromocion", "idProducto", "enLaCompraDe", "llevate");

		// +++++++++++++++++ Configuración del boton de nuevo registro
		Button registroNuevaPromocion = new Button("Agregar promoción");

		registroNuevaPromocion.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				idPromociones++;
				containerPromociones.addItem(new HelperClassAltaPromociones(idPromociones, 0, 0, 0));

			}
		});

		vlProductos.addComponent(altaProductos);
		vlProductos.addComponent(registroNuevoProducto);
		vlProductos.setSpacing(true);
		
		vlPromocion.addComponent(altaPromociones);
		vlPromocion.addComponent(registroNuevaPromocion);
		vlPromocion.setSpacing(true);
//		vl.addComponent(registroNuevaPromocion);

		altaPromociones.getColumn("idPromocion").setEditable(false);
		altaPromociones.setEditorEnabled(true);
		// +++++++++++++++++ Configuración del boton de borrado
		altaPromociones.setDetailsGenerator(new DetailsGenerator() {

			@Override
			public Component getDetails(RowReference rowReference) {
				HelperClassAltaPromociones altaPromociones = (HelperClassAltaPromociones) rowReference.getItemId();
				String detalleMsg = "Deseas eliminar el registro " + altaPromociones.getIdPromocion() + "?";

				Button deleteButton = new Button("Eliminar registro", new Button.ClickListener() {

					@Override
					public void buttonClick(ClickEvent event) {
						Notification.show("Registro eliminado");
						containerPromociones.removeItem(rowReference.getItemId());

					}
				});

				VerticalLayout vlRegistro = new VerticalLayout(new Label(detalleMsg), deleteButton);
				vlRegistro.setMargin(true);
				vlRegistro.setSpacing(true);
				return vlRegistro;
			}

		});
		// +++++++++++++++++ Configuración para poner visible boton de borrado y
		// mensaje
		altaPromociones.addItemClickListener(new ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {
				Object itemId = event.getItemId();
				altaPromociones.setDetailsVisible(itemId, !altaPromociones.isDetailsVisible(itemId));

			}

		});

		// ##############################################################################
		// #####______________________Alta_de_combos________________________________#####
		// ##############################################################################
		Grid altaCombos = new Grid();
		vl.addComponent(lblCombos);
		lblCombos.setWidth("140px");
//		vl.setComponentAlignment(lblCombos, Alignment.MIDDLE_CENTER);
		
		vl.addComponent(altaCombos);

		containerCombos = new BeanItemContainer<HelperClassAltaCombos>(HelperClassAltaCombos.class);
		altaCombos.setContainerDataSource(containerCombos);
		altaCombos.setColumnOrder("idCombo", "cantidadProductoComprado", "idProductoComprado", "cantidadProductoRegalo",
				"idProductoRegalo");

		// +++++++++++++++++ Configuración del boton de nuevo registro
		Button registroNuevoCombo = new Button("Agregar combo");

		registroNuevoCombo.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				idCombos++;
				containerCombos.addItem(new HelperClassAltaCombos(idCombos, 0, 0, 0, 0));

			}
		});

		vl.addComponent(registroNuevoCombo);

		altaCombos.getColumn("idCombo").setEditable(false);
		altaCombos.setEditorEnabled(true);
		// +++++++++++++++++ Configuración del boton de borrado
		altaCombos.setDetailsGenerator(new DetailsGenerator() {

			@Override
			public Component getDetails(RowReference rowReference) {
				HelperClassAltaCombos altaCombos = (HelperClassAltaCombos) rowReference.getItemId();
				String detalleMsg = "Deseas eliminar el registro " + altaCombos.getIdCombo() + "?";

				Button deleteButton = new Button("Eliminar registro", new Button.ClickListener() {

					@Override
					public void buttonClick(ClickEvent event) {
						Notification.show("Registro  eliminado");
						containerCombos.removeItem(rowReference.getItemId());

					}
				});

				VerticalLayout vlRegistro = new VerticalLayout(new Label(detalleMsg), deleteButton);
				vlRegistro.setMargin(true);
				vlRegistro.setSpacing(true);
				return vlRegistro;
			}

		});
		// +++++++++++++++++ Configuración para poner visible boton de borrado y
		// mensaje
		altaCombos.addItemClickListener(new ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {
				Object itemId = event.getItemId();
				altaCombos.setDetailsVisible(itemId, !altaCombos.isDetailsVisible(itemId));

			}

		});
		
		altaCombos.setWidth("100%");
		
		HeaderRow extraHeader = altaCombos.prependHeaderRow();
		extraHeader.join("cantidadProductoComprado","idProductoComprado").setText("En la compra de: ");
		extraHeader.join("cantidadProductoRegalo","idProductoRegalo").setText("Llevate");
	}

}