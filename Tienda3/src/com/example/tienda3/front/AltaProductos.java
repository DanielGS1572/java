package com.example.tienda3.front;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.example.tienda3.datos.HelperClassAltaProductos;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.DetailsGenerator;
import com.vaadin.ui.Grid.RowReference;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings("serial")
public class AltaProductos extends UI {
	private BeanItemContainer<HelperClassAltaProductos> containerProductos = new BeanItemContainer<HelperClassAltaProductos>(
			HelperClassAltaProductos.class);
	private static ArrayList<HelperClassAltaProductos> arrayProductos = new ArrayList<HelperClassAltaProductos>();
	private Button registroNuevoProducto;
	private Grid altaProductos;


	@SuppressWarnings("rawtypes")
	private List catList = new ArrayList();

	@WebServlet(value = "/altaproductos/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = AltaProductos.class)
	public static class Servlet extends VaadinServlet {
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	protected void init(VaadinRequest request) {
		catList.add("Carnes");
		catList.add("Electrodomésticos");
		VerticalLayout vl = new VerticalLayout();
		setContent(vl);

		altaProductos = new Grid();
		registroNuevoProducto = new Button("Agregar producto");

		vl.addComponent(altaProductos);
		vl.addComponent(registroNuevoProducto);



		inicializaArray();
		llenaContainer();



		altaProductos.setColumnOrder("id", "categoria", "nombreProducto", "precio");
		altaProductos.setEditorEnabled(true);
		altaProductos.getColumn("id").setEditable(false);
		


		altaProductos.getColumn("categoria").setEditorField(getComboBox("Introducir valor", catList));



		Object[] VISIBLE_ALTA_COLUMN_IDS = new String[] { "id", "categoria", "nombreProducto", "precio" };
		altaProductos.setColumns(VISIBLE_ALTA_COLUMN_IDS);

		registroNuevoProducto.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				llenaArray();
				llenaContainer();
			}

		});

		// +++++++++++++++++ Configuración del boton de borrado
		altaProductos.setDetailsGenerator(new DetailsGenerator() {

			@Override
			public Component getDetails(RowReference rowReference) {
				System.out.println(rowReference);

				String detalleMsg = "Deseas eliminar el registro?";

				Button deleteButton = new Button("Eliminar registro", new Button.ClickListener() {

					@Override
					public void buttonClick(ClickEvent event) {

						Notification.show("Registro eliminado");
						arrayProductos.remove(rowReference.getItemId());
						reconstruyeArray();
						llenaContainer();

					}

				});

				VerticalLayout vlRegistro = new VerticalLayout(new Label(detalleMsg), deleteButton);
				vlRegistro.setMargin(true);
				vlRegistro.setSpacing(true);

				return vlRegistro;

			}

		});

		altaProductos.addItemClickListener(new ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {
				Object itemId = event.getItemId();
				altaProductos.setDetailsVisible(itemId, !altaProductos.isDetailsVisible(itemId));

			}

		});

	}

	public void inicializaArray() {

		if (arrayProductos.size() == 0) {
			for (int i = 1; i <= 5; i++) {
				arrayProductos.add(new HelperClassAltaProductos(containerProductos.size() + i, "Electrodomésticos",
						"Nombre " + i, 10));
			}
		}
	}

	public void llenaContainer() {

		for (HelperClassAltaProductos aP : arrayProductos) {
			containerProductos.addItem(aP);
		}

		altaProductos.setContainerDataSource(containerProductos);
	}

	public void llenaArray() {

		arrayProductos.add(new HelperClassAltaProductos(containerProductos.size() + 1, "", "", 0));

	}

	public void reconstruyeArray() {

		System.out.println("tamaño1: " + containerProductos.size());
		containerProductos.removeAllItems();

		System.out.println("tamaño2: " + containerProductos.size());

		for (int i = 0; i < arrayProductos.size(); i++) {
			arrayProductos.get(i).setId(i + 1);
		}
	}

	public void despliegaArray() {
		System.out.println("tamaño: " + arrayProductos.size());

		for (int i = 0; i < arrayProductos.size(); i++) {
			System.out.println("Nombre: " + arrayProductos.get(i).getNombreProducto());
		}
	}

	public static ArrayList<HelperClassAltaProductos> getArrayAlta() {
		return arrayProductos;
	}

	private Field<?> getComboBox(String requiredErrorMsg, Collection<?> items) {
		ComboBox comboBox = new ComboBox();
		comboBox.setNullSelectionAllowed(true);
		IndexedContainer container = new IndexedContainer(items);
		comboBox.setContainerDataSource(container);
		comboBox.setRequired(true);
		comboBox.setRequiredError(requiredErrorMsg);
		return comboBox;

	}

}
