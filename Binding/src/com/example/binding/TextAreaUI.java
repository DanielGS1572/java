package com.example.binding;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class TextAreaUI extends UI implements ValueChangeListener {
	// http://localhost:8080/Binding/textarea
	@WebServlet(value = "/textarea/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = TextAreaUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		// our TextArea component
		TextArea textArea = new TextArea("Enter some multi-lined text and press TAB:");
		textArea.addValueChangeListener(this);
		textArea.setImmediate(true);
		
		// textArea.removeValueChangeListener(this);
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(textArea);
		setContent(layout);
	}

	@Override
	public void valueChange(ValueChangeEvent event) {
		String userText = event.getProperty().getValue().toString();
		Notification.show("This is it: " + userText);
	}
}
