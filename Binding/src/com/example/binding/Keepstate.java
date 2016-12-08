package com.example.binding;

import javax.servlet.annotation.WebServlet;

import com.example.navigator.NavigatorUI;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte.
 * 
 */
@SuppressWarnings("serial")
 @PreserveOnRefresh
public class Keepstate extends UI {

	@WebServlet(value = "/keepstate/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Keepstate.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		TextField tf = new TextField("Type, press ENTER, and refresh the browser");
		tf.setImmediate(true);

		tf.addValueChangeListener(new ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				Notification.show("Value: " + event.getProperty().getValue());
			}
		});

		layout.addComponent(tf);
	}

}
