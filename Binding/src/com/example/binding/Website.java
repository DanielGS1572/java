package com.example.binding;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class Website extends UI {
	@WebServlet(value = "/website/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Website.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) { // request le realiza una
													// petición a Vaadin y
													// siempre se le pasa al
													// metodo init
// VaadinRequest encapsula una petición del browser al server

		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		String page = request.getPathInfo();	//Obtiene la ultima parte introducida después de website

		System.out.println(page);

		if (page == null || page.isEmpty() || "/".equals(page)) {
			layout.addComponent(new Label("Welcome to Simple WebSite"));
			getPage().setTitle("Simple Web Site");
		} else if ("/page1".equals(page)) {
			layout.addComponent(new Label("Oh yeah! You are watching Page 1!"));
			getPage().setTitle("Simple Web Site – Page 1");
		} else if ("/page2".equals(page)) {
			layout.addComponent(new Label("Yay! This is Page 2!"));
			getPage().setTitle("Simple Web Site – Page 2");
		} else {
			layout.addComponent(new Label("You just got 404'd! The requested page doesn't exist."));
			getPage().setTitle("Simple Web Site – 404!");
		}

	}

}
