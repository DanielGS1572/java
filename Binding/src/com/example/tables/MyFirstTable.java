package com.example.tables;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnHeaderMode;
import com.vaadin.ui.Table.FooterClickEvent;
import com.vaadin.ui.Table.FooterClickListener;
import com.vaadin.ui.Table.HeaderClickEvent;
import com.vaadin.ui.Table.HeaderClickListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Alejandro Duarte.
 */
@SuppressWarnings("serial")
public class MyFirstTable extends UI {

	@WebServlet(value = "/myfirsttable/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MyFirstTable.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		// Cada tabla de vaadin es un container, por lo que se pueden agregar
		// properties y items
		// es respaldado por un indexContainer pero se puede usar
		// setContainerDataSource
		final Table table = new Table();

		// table.addContainerProperty("Column 1", String.class, null);
		// El tercer parametro que se le pasa es para inicializar el addItem(),
		// pero se le puede pasar null como la instrucción anterior
		// para que no ponga nada

		// Ver que las columnas se agregan al container y que al container se
		// agregan items
		// Los items tienen un ID, por lo que tienen un tipo y un valor
		table.addContainerProperty("Column 1", String.class, null);
		table.addContainerProperty("Column 2", Integer.class, 1);
	

		// ##########################################################################################
		Item item3 = table.addItem("item ID 3"); // <--> Agrega un nuevo Item
													// con los datos por default
		item3.getItemProperty("Column 1").setValue("aa");

		Property column2 = item3.getItemProperty("Column 2"); // Ver que para
																// poder cambiar
																// el dato de
																// una celda se
																// necesita
																// obtener la
																// variable del
																// item y el
																// cruce con la
																// columna
		// pero tambien se puede obtener el item del container
		column2.setValue(100);
		Container container = table.getContainerDataSource();
		// table.setColumnHeader("Column 2", "test"); // Cuando se hizo el
		// addContainerProperty se
		// le paso un identificador
		// que es como lo
		// identifica vaadin, pero para que no aparezca el mismo nombre se puede
		// cambiar con setColumnHeader

		table.setColumnHeaders(new String[] { "Header 1", "Header 2" }); // También
																			// se
																			// puede
																			// cambiar
																			// de
																			// nombre
																			// de
																			// un
																			// jalón

		System.out.println(container.getItem("item ID 3").getItemProperty("Column 2").getValue()); // Ver
		// como
		// se
		// hace
		// el
		// cruce
		// de
		// renglon-columna

		table.addItem(); // esto agrega un nuevo registro con los valores por
							// default
		// ##########################################################################################

		String[] columnHeaders = table.getColumnHeaders();

		for (String x : columnHeaders) {

			System.out.println(x);
		}

//		table.setColumnHeaderMode(ColumnHeaderMode.HIDDEN);				//esto hace que se oculten el nombre de los encabezados

		String columnHeader = table.getColumnHeader("Column 1");
		System.out.println(columnHeader); // Obtiene el nombre y no el ID

		// ver como el arreglo es de tipo Object para que se le puedan pasar un
		// arreglo de diferente tipos (que son definidos en
		// addContainerProperty)
		table.addItem(new Object[] { "Hi", 3 }, "item ID 1");
		table.addItem(new Object[] { "Well", 4 }, "item ID 2");

		table.setColumnFooter("Column 1", "Footer x1");
		table.setFooterVisible(true);

		table.addHeaderClickListener(new HeaderClickListener() {		//Listener para el header
			@Override
			public void headerClick(HeaderClickEvent event) {
				Notification.show("Header clicked: " + event.getPropertyId());

			}
		});

		table.addFooterClickListener(new FooterClickListener() {
			@Override
			public void footerClick(FooterClickEvent event) {
				Notification.show("Footer clicked: " + event.getPropertyId());
			}
		});

		layout.addComponent(table);
	}

}