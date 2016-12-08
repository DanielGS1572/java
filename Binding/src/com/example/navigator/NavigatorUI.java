package com.example.navigator;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

/**
 * 
 * @author Alejandro Duarte.
 * 
 */
@SuppressWarnings("serial")
public class NavigatorUI extends UI {
	@WebServlet(value = "/navigator/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = NavigatorUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		Navigator navigator = new Navigator(this, this);

		// Para acceder a navigator se debe usar # al final
		// http://localhost:8080/Binding/navigator#
		navigator.addView("", new Welcome()); // Cualquier página que implemente
												// la interfaz view puede ser
												// agregado al navigator

		// Para acceder a una página
		// http://localhost:8080/Binding/navigator#!page1
		navigator.addView("page1", new Page1()); // El primer elemento es el
													// fragmento de la url (que
													// va despues de #) y se usa
													// para acceder a la pagina
		//En lugar de usar ?page=1, que se le pasa como parametro
		navigator.addView("page2", new Page2());
	}

}
