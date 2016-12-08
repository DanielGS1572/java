package com.example.statictest;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class GettingStatic extends UI {

	@WebServlet(value = { "/GettingStatic/*", "/VAADIN/*" }, asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = GettingStatic.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		
		// TODO Auto-generated method stub
		Notification.show("TEST");

		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		TextField lbl = new TextField();
		layout.addComponent(lbl);
		
		
		
		Button button = new Button("Refresh");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				layout.addComponent(new Label("Valor agregado"));
				lbl.setValue(SettingStatic.value);
			}
		});
		layout.addComponent(button);
	}
}
