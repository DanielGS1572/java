package com.example.tienda;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Field;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("tienda")
public class TiendaUI extends UI {
	static VerticalLayout verticalLayout;
	
	static Grid catchGrid;
	static Button boton; 
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = TiendaUI.class)
	public static class Servlet extends VaadinServlet {
	}

	public void render(){
		
		verticalLayout = new VerticalLayout();
		verticalLayout.setMargin(true);
		setContent(verticalLayout);
		
		boton = new Button("Calcular suma");
		verticalLayout.addComponent(boton);
		verticalLayout.setComponentAlignment(boton, Alignment.MIDDLE_CENTER);
		// ################################ Lista de productos
				// ################################
				Grid grid = new Grid();
				verticalLayout.addComponent(grid);
				// verticalLayout.setComponentAlignment(grid,Alignment.TOP_RIGHT);

				// initializeGrid(grid);
				grid.setContainerDataSource(ListadoTienda.createContainer());
				grid.setColumnOrder("id", "categoria", "nombreProducto");

				// Cambia los nombre de las columnas
				grid.getColumn("id").setHeaderCaption("ID");
				grid.getColumn("nombreProducto").setHeaderCaption("Producto");

				// Modifica el ancho de cada columna (las demás quedan con un ancho por
				// default)
				grid.getColumn("id").setMaximumWidth(70);

				// Definir los campos editables
				grid.setEditorEnabled(true);
				grid.getColumn("id").setEditable(false);
				grid.getColumn("categoria").setEditable(false);
				grid.getColumn("nombreProducto").setEditable(false);
				grid.getColumn("precio").setEditable(false);
				grid.getColumn("cantidad").setEditable(true);

				// Establece validación
				Field<?> customerField = grid.getColumn("cantidad").getEditorField();
				customerField.setRequired(true);
				customerField.setRequiredError("Por favor introduce un valor númerico");
				
				catchGrid = grid;
				
				
				Table tablaCliente = ListadoTienda.getDetalle();
				verticalLayout.addComponent(tablaCliente);
				verticalLayout.setComponentAlignment(tablaCliente, Alignment.TOP_RIGHT);
	}
	
	public void renderAfterClicked(){
		verticalLayout = new VerticalLayout();
		verticalLayout.setMargin(true);
		setContent(verticalLayout);
	
		boton = new Button("Calcular suma");
		verticalLayout.addComponent(boton);
		verticalLayout.setComponentAlignment(boton, Alignment.MIDDLE_CENTER);
		
		verticalLayout.addComponent(catchGrid);
//		setContainerDataSource(ListadoTienda.createContainer());
		Table tablaCliente = ListadoTienda.getDetalle();
		verticalLayout.addComponent(tablaCliente);
		verticalLayout.setComponentAlignment(tablaCliente, Alignment.TOP_RIGHT);
	}
	@Override
	protected void init(VaadinRequest request) {
		Notification.show(" Inicia aplicación ");
		render();
		

		
		
		boton.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				
				renderAfterClicked();
				
				// TODO Auto-generated method stub
				Notification.show("CLICKED");
				
				verticalLayout.addComponent(new Label("La suma es: " + ListadoTienda.obtieneSuma()));

			}

		});
		

		

	}

}