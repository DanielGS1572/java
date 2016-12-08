package com.example.statictest;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Field.ValueChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.data.Property;

import com.vaadin.ui.*;

@SuppressWarnings("serial")
@Theme("statictest")
public class SettingStatic extends UI {
	public static String value;
	@WebServlet(value = "/SettingStatic/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = SettingStatic.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		TextField tf = new TextField();
		tf.setSizeUndefined();
		layout.addComponent(tf);

		tf.addValueChangeListener(new Property.ValueChangeListener() {

			@Override
			public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
				// TODO Auto-generated method stub
				value = (String) event.getProperty().getValue();

				// Do something with the value
				Notification.show("Value is: " + value);

			}
		});
		
		tf.setImmediate(true);

		
	}
	
}