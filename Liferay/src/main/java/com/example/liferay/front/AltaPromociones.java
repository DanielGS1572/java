package com.example.liferay.front;

import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.annotation.WebServlet;
import com.example.liferay.datos.HelperClassAltaProductos;
import com.example.liferay.datos.HelperClassAltaPromociones;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.ui.Grid.DetailsGenerator;
import com.vaadin.ui.Grid.RowReference;
import com.vaadin.data.fieldgroup.FieldGroup.CommitEvent;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.fieldgroup.FieldGroup.CommitHandler;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class AltaPromociones extends UI {

	private BeanItemContainer<HelperClassAltaPromociones> containerPromociones = new BeanItemContainer<HelperClassAltaPromociones>(
			HelperClassAltaPromociones.class);
	private ArrayList<String> arraySeleccionPromocion = new ArrayList<String>(); 
	private static ArrayList<HelperClassAltaPromociones> arrayPromociones = new ArrayList<HelperClassAltaPromociones>();
	private Grid altaPromociones;

	@WebServlet(value = "/altapromociones/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = AltaPromociones.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		
		final VerticalLayout vl = new VerticalLayout();
		vl.setMargin(true);
		setContent(vl);

		altaPromociones = new Grid();

		Button registroNuevaPromocion = new Button("Agregar promoción");

		altaPromociones.setContainerDataSource(containerPromociones);


		
		vl.addComponent(altaPromociones);
		vl.addComponent(registroNuevaPromocion);
		
		
		inicializaArrayPromociones();
		llenaContainerPromociones();

		altaPromociones.setEditorEnabled(true);
		altaPromociones.getColumn("idPromocion").setEditable(false);
		altaPromociones.setColumnOrder("idPromocion", "enLaCompraDe", "producto", "llevate");
		altaPromociones.getColumn("producto").setEditorField(getComboBox("Introducir valor", arraySeleccionPromocion));

		registroNuevaPromocion.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				

				llenaArrayPromociones();
				arraySeleccionPromocion.clear();
				for (HelperClassAltaProductos hCAP : AltaProductos.getArrayAlta()) {

					arraySeleccionPromocion.add(hCAP.getNombreProducto());

				}
				llenaContainerPromociones();
				altaPromociones.getColumn("producto").setEditorField(getComboBox("Introducir valor", arraySeleccionPromocion));

			}

		});
		// +++++++++++++++++ Configuración del boton de borrado
		altaPromociones.setDetailsGenerator(new DetailsGenerator() {

			@Override
			public Component getDetails(RowReference rowReference) {

				String detalleMsg = "Deseas eliminar el registro?";

				Button deleteButton = new Button("Eliminar registro", new Button.ClickListener() {

					@Override
					public void buttonClick(ClickEvent event) {

						Notification.show("Registro eliminado");
						arrayPromociones.remove(rowReference.getItemId());
						reconstruyeArrayPromociones();
						llenaContainerPromociones();
						

					}

				});

				VerticalLayout vlRegistro = new VerticalLayout(new Label(detalleMsg), deleteButton);
				vlRegistro.setMargin(true);
				vlRegistro.setSpacing(true);

				return vlRegistro;

			}

		});

		altaPromociones.addItemClickListener(new ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {
				Object itemId = event.getItemId();
				altaPromociones.setDetailsVisible(itemId, !altaPromociones.isDetailsVisible(itemId));

			}

		});

		altaPromociones.getEditorFieldGroup().addCommitHandler(new CommitHandler() {

			@Override
			public void preCommit(CommitEvent commitEvent) throws CommitException {
				
				
			}

			@SuppressWarnings("unchecked")
			@Override
			public void postCommit(CommitEvent commitEvent) throws CommitException {
			
				
				if((int)commitEvent.getFieldBinder().getItemDataSource().getItemProperty("enLaCompraDe").getValue() > (int)commitEvent.getFieldBinder().getItemDataSource().getItemProperty("llevate").getValue())
				{
					Notification.show("La columna de LLEVATE debe ser mayor que EN LA COMPRA DE");
					commitEvent.getFieldBinder().getItemDataSource().getItemProperty("llevate").setValue(new Integer(0));
					commitEvent.getFieldBinder().getItemDataSource().getItemProperty("enLaCompraDe").setValue(new Integer(0));
			
				}
			}

		});
	}


	public void llenaContainerPromociones() {
		for (HelperClassAltaPromociones aP : arrayPromociones) {
			containerPromociones.addItem(aP);
		}
		altaPromociones.setContainerDataSource(containerPromociones);
	}

	public void llenaArrayPromociones() {
		arrayPromociones.add(new HelperClassAltaPromociones(containerPromociones.size() + 1, "", 0, 0));
	}

	public void reconstruyeArrayPromociones() {
		containerPromociones.removeAllItems();
		for (int i = 0; i < arrayPromociones.size(); i++) {
			arrayPromociones.get(i).setIdPromocion(i + 1);
		}
	}


	public static ArrayList<HelperClassAltaPromociones> getArrayPromociones() {
		return arrayPromociones;

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
	
	
	public void inicializaArrayPromociones(){
		if(arrayPromociones.size() == 0){
			for(int i = 1; i <2; i++){
				arrayPromociones.add(new HelperClassAltaPromociones(containerPromociones.size() + i, "Nombre 3", 2, 3));
			}
		}
	}
}
