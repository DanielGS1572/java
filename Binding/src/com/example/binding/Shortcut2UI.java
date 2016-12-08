package com.example.binding;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutAction.ModifierKey;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;

/**
 * 
 * @author Alejandro Duarte.
 * 
 */
// Shortcuts genericos para Window y Panel
@SuppressWarnings("serial")
public class Shortcut2UI extends UI {
	
	@WebServlet(value = "/shortcut2/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Shortcut2UI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		Panel panel = new Panel();
		panel.setSizeFull();
		setContent(panel);
		
		

		Handler handler = new Handler() { // Se debe hacer uso de Handler para
											// tener shortcuts genericos

			@Override
			public Action[] getActions(Object target, Object sender) {
				return new Action[] { new ShortcutAction("Enter", KeyCode.ENTER, null),
						new ShortcutAction("Shift + U", KeyCode.U, new int[] { ModifierKey.SHIFT }) };	//
			}

			@Override
			public void handleAction(Action action, Object sender, Object target) {
				Notification.show(action.getCaption());
			}

		};

		panel.addActionHandler(handler);

	}

}
