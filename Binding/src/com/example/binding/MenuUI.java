package com.example.binding;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class MenuUI extends UI {
	@WebServlet(value = "/menu/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MenuUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		MenuBar menuBar = new MenuBar();

		MenuItem submenu1 = menuBar.addItem("Submenu 1", null);
		MenuItem submenu2 = menuBar.addItem("Submenu 2", null);

		submenu1.addItem("Option 1", null);
		submenu1.addItem("Option 2", null);

		submenu2.addItem("Option 3", null);
		submenu2.addItem("Option 4", new Command() { // En lugar de tener un
														// listener se tiene un
														// comando que
														// implementa una clase
														// interna
			@Override
			public void menuSelected(MenuItem selectedItem) {
				Notification.show("That was option 4");
			}
		});

		layout.addComponent(menuBar);
	}

}
