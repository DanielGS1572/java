package com.example.binding;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class Website3 extends UI{
	@WebServlet(value = "/website3/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Website3.class)
	public static class Servlet extends VaadinServlet {
	}
	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		String page = request.getParameter("page");			//Accedido como http://localhost:8080/Binding/website3/?page=1

		page = getPage().getUriFragment();					//Accedido como http://localhost:8080/Binding/website3/#1
		
		if (page == null) {
			layout.addComponent(new Label("Welcome to Simple Web Site"));
			getPage().setTitle("Simple Web Site");			//Para cambiar el titulo de la pagina

		} else if ("1".equals(page)) {
			layout.addComponent(new Label("Oh yeah! You are watching Page 1!"));
			getPage().setTitle("Simple Web Site - Page 1");

		} else if ("2".equals(page)) {
			layout.addComponent(new Label("Yay! This is Page 2!"));
			getPage().setTitle("Simple Web Site - Page 2");

		} else {
			getPage().setTitle("Simple Web Site - 404!");
			layout.addComponent(new Label(
					"You just got 404'd! The requested page doesn't exist."));
		}

	}

}
