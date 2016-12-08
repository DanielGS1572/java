package com.example.liferay.front;


import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import com.example.liferay.datos.HelperClassAltaCombos;
import com.example.liferay.datos.HelperClassAltaProductos;
import com.example.liferay.datos.HelperClassAltaPromociones;
import com.example.liferay.datos.HelperClassCatalogoProductos;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.fieldgroup.FieldGroup.CommitEvent;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.fieldgroup.FieldGroup.CommitHandler;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ComprasClientes extends UI {

	@WebServlet(value = "/comprascliente/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = ComprasClientes.class)
	public static class Servlet extends VaadinServlet {
	}

	private Grid comprasCliente = new Grid();

	private BeanItemContainer<HelperClassCatalogoProductos> containerCompras = new BeanItemContainer<HelperClassCatalogoProductos>(
			HelperClassCatalogoProductos.class);
	private ArrayList<HelperClassCatalogoProductos> arrayCompras;
	private ArrayList<HelperClassAltaPromociones> arrayPromociones;
	private ArrayList<HelperClassAltaCombos> arrayCombos;
	// private ArrayList<HelperClassAltaProductos> arrayCompras;
	private int suma = 0;
	private Label muestraSuma = new Label("");
	private int controlaPrecaucion = 0;

	@Override
	protected void init(VaadinRequest request) {
		// arrayCompras = AltaProductos.getArrayAlta();

		copy();

		// "Same Instance":"Different Instance");
		final VerticalLayout vl = new VerticalLayout();
		setContent(vl);
		vl.addComponent(comprasCliente);
		vl.addComponent(muestraSuma);

		refrescaCatalogo();

		Button actualizaCatalogo = new Button("Actualizar catalogo");
		vl.addComponent(actualizaCatalogo);

		Button terminarCompra = new Button("Terminar compra");
		vl.addComponent(terminarCompra);

		comprasCliente.setContainerDataSource(containerCompras);

		comprasCliente.getColumn("categoria").setEditable(false);
		comprasCliente.getColumn("id").setEditable(false);
		comprasCliente.getColumn("nombreProducto").setEditable(false);
		comprasCliente.getColumn("precio").setEditable(false);
		comprasCliente.getColumn("totalxProducto").setEditable(false);
		comprasCliente.setEditorEnabled(true);
		comprasCliente.setColumnOrder("id", "categoria", "nombreProducto", "precio", "cantidad", "totalxProducto");
		
		comprasCliente.setWidth("100%");

		comprasCliente.getEditorFieldGroup().addCommitHandler(new CommitHandler() {

			@Override
			public void preCommit(CommitEvent commitEvent) throws CommitException {
			}

			@Override
			public void postCommit(CommitEvent commitEvent) throws CommitException {
				controlaPrecaucion++;

				if (controlaPrecaucion == 1) {
					Notification.show(
							"Precaución: Al dar clic en actualizar catalogo se borrará la información introducida");
				}

				vl.removeComponent(muestraSuma);
				muestraSuma = new Label("El total es: " + realizaCalculo());
				vl.addComponent(muestraSuma);

			}
		});

		terminarCompra.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

				logicaPromociones();
				logicaCombos();

				reconstruyeArray();
				llenaContainer();
				vl.removeComponent(muestraSuma);
				muestraSuma = new Label("El total es: " + realizaCalculo());
				vl.addComponent(muestraSuma);

			}
		});
		terminarCompra.setDisableOnClick(true);
		actualizaCatalogo.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show("Catalogo actualizado");
				refrescaCatalogo();
				terminarCompra.setEnabled(true);
			}

		});

	}

	@SuppressWarnings("unused")
	public void logicaCombos() {
		arrayCombos = AltaCombos.getArrayCombos();
		String productoComprado = "";
		int cantidadProductoComprado = 0;
		String productoRegalo = "";
		int cantidadProductoRegalo = 0;

		String categoriaFromAltaProductos = "";
		String nombreProducto = "";
		double precioFromAltaProductos = 0;
		int calculoCombo = 0;

		for (int b = 0; b < arrayCombos.size(); b++) {
			productoComprado = arrayCombos.get(b).getProductoComprado();
			cantidadProductoComprado = arrayCombos.get(b).getCantidadProductoComprado();
			productoRegalo = arrayCombos.get(b).getProductoRegalo();
			cantidadProductoRegalo = arrayCombos.get(b).getCantidadProductoRegalo();

			for (int a = 0; a < arrayCompras.size(); a++) {
				if (arrayCompras.get(a).getNombreProducto().equals(arrayCombos.get(b).getProductoComprado())
						&& (arrayCompras.get(a).getCantidad() / cantidadProductoComprado) >= 1) {
					{

						categoriaFromAltaProductos = getCategoriaFromAltaProductos(productoRegalo);
						nombreProducto = arrayCompras.get(a).getNombreProducto();
						precioFromAltaProductos = getPrecioFromAltaProductos(arrayCompras.get(a).getNombreProducto());
						System.out.println(
								"categoriaFromAltaProductos: " + categoriaFromAltaProductos + "\nnombreProducto: "
										+ nombreProducto + "\nprecioFromAltaProductos: " + precioFromAltaProductos);
						calculoCombo = getCalculoCombo(arrayCompras.get(a).getCantidad(), cantidadProductoComprado,
								cantidadProductoRegalo);

						arrayCompras.add(a + 1,
								new HelperClassCatalogoProductos(a + 2, "(C) " + categoriaFromAltaProductos,
										productoRegalo, precioFromAltaProductos, calculoCombo));
						System.out.println("\n");
						a++;

						arrayCompras.add(a + 1,
								new HelperClassCatalogoProductos(a + 2, "(C) " + categoriaFromAltaProductos,
										productoRegalo, precioFromAltaProductos, -calculoCombo));

						a++;
					}

				}
			}
			containerCompras.removeAllItems();
			for (HelperClassCatalogoProductos cP : arrayCompras) {
				containerCompras.addItem(cP);
			}

			comprasCliente.setContainerDataSource(containerCompras);
			realizaCalculo();
		}
	}

	public int getCalculoCombo(int cantidadComprada, int cantidadCompraCombo, int cantidadProductoRegalo) {
		int val = (cantidadComprada / cantidadCompraCombo) * cantidadProductoRegalo;
		return val;
	}

	// ################################################################################

	public void logicaPromociones() {

		arrayPromociones = AltaPromociones.getArrayPromociones();
		int enLaCompraDe = 0;
		int llevate = 0;

		String productoFromAltaProductos = "";
		String nombreProducto = "";
		double precioFromAltaProductos = 0;
		int calculoPromocion = 0;

		for (int b = 0; b < arrayPromociones.size(); b++) {
			enLaCompraDe = arrayPromociones.get(b).getEnLaCompraDe();
			llevate = arrayPromociones.get(b).getLlevate();

			for (int a = 0; a < arrayCompras.size(); a++) {

				// System.out.println(arrayCompras.size());
				if (arrayCompras.get(a).getNombreProducto().equals(arrayPromociones.get(b).getProducto())
						&& (arrayCompras.get(a).getCantidad() / enLaCompraDe) >= 1) {

					productoFromAltaProductos = getCategoriaFromAltaProductos(arrayCompras.get(a).getNombreProducto());
					System.out.println("productoFromAltaProductos " + productoFromAltaProductos);
					nombreProducto = arrayCompras.get(a).getNombreProducto();
					precioFromAltaProductos = getPrecioFromAltaProductos(arrayCompras.get(a).getNombreProducto());
					calculoPromocion = getCalculoPromocion(arrayCompras.get(a).getCantidad(), enLaCompraDe, llevate);

					arrayCompras.add(a + 1, new HelperClassCatalogoProductos(a + 1, "(P) " + productoFromAltaProductos,
							nombreProducto, precioFromAltaProductos, -calculoPromocion));

					a++;
				}
			}

		}
		containerCompras.removeAllItems();
		for (HelperClassCatalogoProductos cP : arrayCompras) {
			containerCompras.addItem(cP);
		}

		comprasCliente.setContainerDataSource(containerCompras);
		realizaCalculo();
	}

	public int getCalculoPromocion(int cantidadComprada, int enLaCompraDe, int llevate) {
		int val = (int) (cantidadComprada / enLaCompraDe) * (llevate - enLaCompraDe);
		return val;
	}

	public String getCategoriaFromAltaProductos(String elemento) {
		String val = "";
		for (HelperClassCatalogoProductos p : arrayCompras) {
			if (p.getNombreProducto().equals(elemento))
				val = p.getCategoria();
		}
		return val;
	}

	public double getPrecioFromAltaProductos(String elemento) {
		double val = 0;
		for (HelperClassCatalogoProductos p : arrayCompras) {
			if (p.getNombreProducto().equals(elemento))
				val = p.getPrecio();
		}
		return val;
	}

	public int realizaCalculo() {
		suma = 0;
		for (HelperClassCatalogoProductos cC : arrayCompras) {
			cC.setTotalxProducto(cC.getCantidad() * cC.getPrecio());
			suma += cC.getCantidad() * cC.getPrecio();
		}
		return suma;
	}

	public void refrescaCatalogo() {
		// int i = 0;
		arrayCompras = new ArrayList<HelperClassCatalogoProductos>();
		copy();
		containerCompras.removeAllItems();

		for (HelperClassCatalogoProductos aP : arrayCompras) {
			containerCompras.addItem(aP);
		}

		comprasCliente.setContainerDataSource(containerCompras);
	}

	public ArrayList<HelperClassCatalogoProductos> copy() {
		// int i = 0;

		arrayCompras = new ArrayList<HelperClassCatalogoProductos>();
		for (HelperClassAltaProductos cC : AltaProductos.getArrayAlta()) {
			arrayCompras.add(new HelperClassCatalogoProductos(cC.getId(), cC.getCategoria(), cC.getNombreProducto(),
					cC.getPrecio()));
		}

		return arrayCompras;
	}

	public void reconstruyeArray() {

		System.out.println("tamaño1: " + containerCompras.size());
		containerCompras.removeAllItems();

		System.out.println("tamaño2: " + containerCompras.size());

		for (int i = 0; i < arrayCompras.size(); i++) {
			arrayCompras.get(i).setId(i + 1);
		}
	}

	public void llenaContainer() {

		for (HelperClassCatalogoProductos aP : arrayCompras) {
			containerCompras.addItem(aP);
		}

		comprasCliente.setContainerDataSource(containerCompras);
	}
}
