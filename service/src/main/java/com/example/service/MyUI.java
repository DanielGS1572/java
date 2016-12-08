package com.example.service;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.annotation.WebServlet;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("com.example.service.MyAppWidgetset")
public class MyUI extends UI {
	private Button llamarServicio = new Button("Obtener datos");
	private String idProveedor;
	private InputStream getResponse = null;
	private String myString;
	private OptionGroup optionGroup = new OptionGroup();
	private Button insertarServicio = new Button("Crear/Actualizar");
	private Label labelIdProveedor = new Label("6f68b728-ee13-9b45-4a6d-564231cf5779");
	private TextField txtLogistica = new TextField();
	private TextField txtProveedor = new TextField();
	private TextField txtTipoEntrega = new TextField();
	private TextField txtPaisesEntrega = new TextField();
	private TextField txtEstados = new TextField();
	private TextArea txtComentarios = new TextArea("");

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest vaadinRequest) {

		optionGroup.addItems("Actualizar", "Nuevo registro");
		optionGroup.select("Actualizar");

		txtLogistica.setCaption("Id logística entrega:");
		txtProveedor.setCaption("Id proveedor:");
		txtTipoEntrega.setCaption("Tipo entrega:");
		txtPaisesEntrega.setCaption("Países de entrega:");
		txtEstados.setCaption("Estados:");
		txtComentarios.setCaption("Comentarios:");

		txtLogistica.setWidth("40%");
		txtProveedor.setWidth("40%");
		txtTipoEntrega.setWidth("40%");
		txtPaisesEntrega.setWidth("40%");
		txtEstados.setWidth("40%");
		txtComentarios.setSizeFull();
		
		
		txtProveedor.setPropertyDataSource(labelIdProveedor);
		

		optionGroup.addValueChangeListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {

				if (optionGroup.getValue() == "Actualizar") {
					txtLogistica.setEnabled(true);

				} else {

					txtLogistica.setEnabled(false);
				}

			}
		});

		insertarServicio.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				if (isValid(optionGroup.getValue())) {
					JsonObject json = new JsonObject();
					if (optionGroup.getValue() == "Actualizar") {
						json.addProperty("accion", "2");
						json.addProperty("idLogisticaEntrega", txtLogistica.getValue());

					} else {
						json.addProperty("accion", "1");
						json.addProperty("idLogisticaEntrega", "");
					}
					postService(json);
				}
			}
		});

		// ###############################################################################################
		final TextField idTxtFld = new TextField();

		idTxtFld.setPropertyDataSource(labelIdProveedor);

		idTxtFld.setCaption("Introduce el id del proveedor");
		idTxtFld.setWidth("40%");
		Gson gson = new Gson();

		HttpClient httpclient = HttpClientBuilder.create().build();

		Label label1 = new Label("<b>ID Entrega:</b>", ContentMode.HTML);
		Label label2 = new Label("<b>ID Proveedor:</b>", ContentMode.HTML);
		Label label3 = new Label("<b>Tipo entrega:</b>", ContentMode.HTML);
		Label label4 = new Label("<b>Paises entrega:</b>", ContentMode.HTML);
		Label label5 = new Label("<b>Estados:</b>", ContentMode.HTML);
		Label label6 = new Label("<b>Comentarios:</b>", ContentMode.HTML);

		llamarServicio.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

				idProveedor = idTxtFld.getValue();
				
				String url = "http://192.168.20.222:8080/uni2/rest/portal/consultaLogisticaEntrega?idProveedor="
						+ idProveedor;
				HttpGet get = new HttpGet(url);

				try {
					idTxtFld.setComponentError(null);
					HttpResponse response = httpclient.execute(get);
					getResponse = response.getEntity().getContent();
					myString = IOUtils.toString(getResponse, "UTF-8");
					
					if (!myString.equals("{}")) {

						JsonObject obj = gson.fromJson(myString, JsonElement.class).getAsJsonObject();

						label1.setValue("<b>ID Entrega:</b>" + " " + obj.get("idLogisticaEntrega").toString());

						label2.setValue("<b>ID Proveedor:</b>" + " " + obj.get("idProveedor").toString().substring(1,
								(obj.get("idProveedor").toString()).length() - 1));

						label3.setValue("<b>Tipo entrega:</b>" + " " + obj.get("tipoEntrega").toString().substring(1,
								(obj.get("tipoEntrega").toString()).length() - 1));

						label4.setValue("<b>Paises entrega:</b>" + " " + obj.get("paisesEntrega").toString()
								.substring(1, (obj.get("paisesEntrega").toString()).length() - 1));

						label5.setValue("<b>Estados:</b>" + " " + obj.get("estados").toString().substring(1,
								(obj.get("estados").toString()).length() - 1));

						label6.setValue("<b>Comentarios:</b>" + " " + obj.get("comentario").toString().substring(1,
								(obj.get("comentario").toString()).length() - 1));
					} else {

						idTxtFld.setComponentError(new UserError("Verificar el ID del proveedor"));

						label1.setValue("<b>ID Entrega:</b>" + " NA");
						label2.setValue("<b>ID Proveedor:</b> " + "NA");
						label3.setValue("<b>Tipo entrega:</b>" + " NA");
						label4.setValue("<b>Paises entrega:</b>" + " NA");
						label5.setValue("<b>Estados:</b>" + " NA");
						label6.setValue("<b>Comentarios:</b>" + " NA");

						Notification.show("No se ha encontrado el id de proveedor");

					}

				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		HorizontalSplitPanel hL = new HorizontalSplitPanel();
		hL.setSplitPosition(55);
		VerticalLayout getL = new VerticalLayout();
		VerticalLayout putL = new VerticalLayout();

		hL.addComponent(putL);
		hL.addComponent(getL);

//		hL.setMargin(true);
//		hL.setSpacing(true);
		hL.setWidth("100%");

		setContent(hL);
		// setContent(getL);
		// setContent(putL);
		insertarServicio.setDescription("Servicio que <b>Crea/Actualiza</b>");
		putL.addComponents(optionGroup, txtLogistica, txtProveedor, txtTipoEntrega, txtPaisesEntrega, txtEstados,
				txtComentarios, insertarServicio);
		putL.setMargin(true);
		putL.setSpacing(true);

		llamarServicio.setDescription("<b>Servicio</b> que trae información del <i>cliente</i>");
		getL.addComponents(idTxtFld, llamarServicio, label1, label2, label3, label4, label5, label6);
		getL.setMargin(true);
		getL.setSpacing(true);

	}

	public void postService(JsonObject json) {

		String url = "http://192.168.20.222:8080/uni2/rest/portal/agregarActualizarLogisticaEntregaProveedor";
		json.addProperty("idProveedor", txtProveedor.getValue());
		json.addProperty("tipoEntrega", txtTipoEntrega.getValue());
		json.addProperty("paisesEntrega", txtPaisesEntrega.getValue());
		json.addProperty("estados", txtEstados.getValue());
		json.addProperty("comentario", txtComentarios.getValue());

		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		try {
			HttpPost request = new HttpPost(url);
			StringEntity params = new StringEntity(json.toString());
			request.addHeader("Content-Type", "application/json");
			request.setEntity(params);
			httpClient.execute(request);

		} catch (Exception ex) {
			System.out.println("Ha ocurrido una excepción");
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public boolean isValid(Object object) {
		insertarServicio.setComponentError(null);
		boolean isValid = true;
		
		if ((txtLogistica.getValue().isEmpty() | txtProveedor.getValue().isEmpty() | txtTipoEntrega.getValue().isEmpty()
				| txtPaisesEntrega.getValue().isEmpty() | txtEstados.getValue().isEmpty()
				| txtComentarios.getValue().isEmpty()) & object.equals("Actualizar")) 
		{
			
			isValid = false;
			insertarServicio.setComponentError(new UserError("Se deben de llenar todos los campos"));
		
		} 
		
		else if (txtProveedor.getValue().isEmpty() | txtTipoEntrega.getValue().isEmpty()
				| txtPaisesEntrega.getValue().isEmpty() | txtEstados.getValue().isEmpty()
				| txtComentarios.getValue().isEmpty()) 
		{
			
			isValid = false;
			insertarServicio.setComponentError(new UserError("Se deben de llenar todos los campos"));
			
		}

		return isValid;
	}

}
