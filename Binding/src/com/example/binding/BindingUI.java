package com.example.binding;

import javax.servlet.annotation.WebServlet;

import com.google.gwt.layout.client.Layout;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("binding")
public class BindingUI extends UI {

//	http://localhost:8080/Binding/bindingTest
	@WebServlet(value = { "/bindingTest/*", "/VAADIN/*" }, asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = BindingUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		
		TextField textField = new TextField("Daxta");
		textField.setImmediate(true);		
		Label label = new Label();
		
		
		layout.addComponent(textField);
		layout.addComponent(label);
		
		ObjectProperty<String> property = new ObjectProperty<String>("the value");
		
		textField.setPropertyDataSource(property);
		label.setPropertyDataSource(property);
	}

}