package com.example.binding;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutAction.ModifierKey;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte.
 * 
 */
@SuppressWarnings("serial")
public class ShortcutUI extends UI {

	@WebServlet(value = "/shortcut/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = ShortcutUI.class)
	public static class Servlet extends VaadinServlet {
	}
	
	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);

		final TextField tf = new TextField("Your data:");
		layout.addComponent(tf);

		Button button = new Button("Send data (ENTER)");
		button.setClickShortcut(KeyCode.ENTER, ModifierKey.SHIFT);		//El ModifierKey es para que se combine con el KeyCode
//		 button.setClickShortcut(KeyCode.ENTER);

		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {				//aqui aprovechan el clicklistener para que se le ponga el foco a la celda cada que se le da clic al botón
				
				layout.addComponent(new Label(tf.getValue()));
				tf.setValue("");
				tf.focus();
			}
		});

		layout.addComponent(button);
	}

}
