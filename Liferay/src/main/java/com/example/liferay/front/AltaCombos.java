package com.example.liferay.front;

import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.annotation.WebServlet;
import com.example.liferay.datos.HelperClassAltaCombos;
import com.example.liferay.datos.HelperClassAltaProductos;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
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
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid.DetailsGenerator;
import com.vaadin.ui.Grid.RowReference;

//@Theme("mytheme")
@SuppressWarnings("serial")
public class AltaCombos extends UI {
	private BeanItemContainer<HelperClassAltaCombos> containerCombos;
	private Grid altaCombos = new Grid();
	private VerticalLayout vl = new VerticalLayout();
	private static ArrayList<HelperClassAltaCombos> arrayCombos = new ArrayList<HelperClassAltaCombos>();
	private Button registroNuevoCombo = new Button("Agregar combo");
	private ArrayList<String> arraySeleccionCombo = new ArrayList<String>();

	@WebServlet(value = "/altacombos/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = AltaCombos.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		// TODO Auto-generated method stub

		setContent(vl);
		vl.addComponent(altaCombos);
		vl.addComponent(registroNuevoCombo);
		containerCombos = new BeanItemContainer<HelperClassAltaCombos>(HelperClassAltaCombos.class);
		altaCombos.setContainerDataSource(containerCombos);
		altaCombos.setWidth("100%");
		
		altaCombos.setColumnOrder("idCombo","productoComprado","cantidadProductoComprado","productoRegalo","cantidadProductoRegalo");
		
		altaCombos.setEditorEnabled(true);
		
		altaCombos.getColumn("productoComprado").setEditable(true);
		altaCombos.getColumn("cantidadProductoComprado").setEditable(true);
		altaCombos.getColumn("productoRegalo").setEditable(true);
		altaCombos.getColumn("cantidadProductoRegalo").setEditable(true);
		
		
		altaCombos.getColumn("productoComprado").setEditorField(getComboBox("Introducir valor", arraySeleccionCombo));
		altaCombos.getColumn("productoRegalo").setEditorField(getComboBox("Introducir valor", arraySeleccionCombo));
		
		registroNuevoCombo.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				llenaArray();
				arraySeleccionCombo.clear();
				for (HelperClassAltaProductos hCAP : AltaProductos.getArrayAlta()) {

					arraySeleccionCombo.add(hCAP.getNombreProducto());

				}
				llenaContainterCombos();
				altaCombos.getColumn("productoComprado").setEditorField(getComboBox("Introducir valor", arraySeleccionCombo));
				altaCombos.getColumn("productoRegalo").setEditorField(getComboBox("Introducir valor", arraySeleccionCombo));
				
				
			}
		});
		//##################
		altaCombos.getEditorFieldGroup().addCommitHandler(new CommitHandler() {

			@Override
			public void preCommit(CommitEvent commitEvent) throws CommitException {
				// TODO Auto-generated method stub
//				commitEvent.getFieldBinder();
				
			}

			@SuppressWarnings("unchecked")
			@Override
			public void postCommit(CommitEvent commitEvent) throws CommitException {
				// TODO Auto-generated method stub
				
				if((int)commitEvent.getFieldBinder().getItemDataSource().getItemProperty("cantidadProductoComprado").getValue() < (int)commitEvent.getFieldBinder().getItemDataSource().getItemProperty("cantidadProductoRegalo").getValue())
				{
					Notification.show("La columna de CANTIDAD PRODUCTO COMPRADO debe ser mayor que CANTIDAD PRODUCTO REGALO");
					commitEvent.getFieldBinder().getItemDataSource().getItemProperty("cantidadProductoComprado").setValue(new Integer(0));
					commitEvent.getFieldBinder().getItemDataSource().getItemProperty("cantidadProductoRegalo").setValue(new Integer(0));
					
				}
			}

		});
		//##################
		altaCombos.setDetailsGenerator(new DetailsGenerator() {

			@Override
			public Component getDetails(RowReference rowReference) {
				

				String detalleMsg = "Deseas eliminar el registro?";

				Button deleteButton = new Button("Eliminar registro", new Button.ClickListener() {

					@Override
					public void buttonClick(ClickEvent event) {

						Notification.show("Registro eliminado");
						arrayCombos.remove(rowReference.getItemId());
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
		
		altaCombos.addItemClickListener(new ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {
				Object itemId = event.getItemId();
				altaCombos.setDetailsVisible(itemId, !altaCombos.isDetailsVisible(itemId));

			}

		});
		
		
	}
	public void llenaArray(){
		arrayCombos.add(new HelperClassAltaCombos(containerCombos.size() + 1, 0, "", 0, ""));
	}
	
	public void llenaContainterCombos(){
		for(HelperClassAltaCombos aC: arrayCombos){
			containerCombos.addItem(aC);
		}
		altaCombos.setContainerDataSource(containerCombos);
	}
	public static ArrayList<HelperClassAltaCombos> getArrayCombos(){
		return arrayCombos;
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
	public void reconstruyeArray() {

		
		containerCombos.removeAllItems();

		

		for (int i = 0; i < arrayCombos.size(); i++) {
			arrayCombos.get(i).setIdCombo(i + 1);
		}
	}
	public void llenaContainer() {

		for (HelperClassAltaCombos aP : arrayCombos) {
			containerCombos.addItem(aP);
		}

		altaCombos.setContainerDataSource(containerCombos);
	}
	
}
