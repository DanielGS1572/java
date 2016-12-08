package com.example.welcome;

import javax.servlet.annotation.WebServlet;

import com.google.gwt.i18n.client.Messages.Select;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("welcome")
public class WelcomeUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = WelcomeUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
//
//		final TextField name1 = new TextField("First name");
//		final TextField name2 = new TextField("Second name");
//
//		layout.addComponent(name1);
//		layout.addComponent(name2);
//		
//		layout.setComponentAlignment(name2, Alignment.TOP_RIGHT);
//
//		Button button = new Button("Click Mesddase");
//
//		button.addClickListener(new Button.ClickListener() {
//			public void buttonClick(ClickEvent event) {
//				if (name1.getValue() != "" && name2.getValue() != "") {
//					String phrase = getFunnyPhrase(name1.getValue(), name2.getValue());
//					layout.addComponent(new Label(phrase));
//				} else {
//					Notification.show("Introduce valores en los campos");
//				}
//			}
//
//			// {
//			// Label etiqueta = new Label("<b>Bold</b>, not bold");
//			// etiqueta.setContentMode(com.vaadin.shared.ui.label.ContentMode.HTML);
//			//
//			// layout.addComponent(etiqueta);
//			// }
//		});
//
//		layout.addComponent(button);
		
		
		Table tabla = new Table();
		
		tabla.addContainerProperty("Producto", String.class, null);
		tabla.addContainerProperty("Precio", Integer.class, null);
		for(int i = 1; i < 10; i++){
			tabla.addItem(new Object[]{"Producto", 1},i);
							
		}
		
		tabla.setPageLength(tabla.size());
		layout.addComponent(tabla);
		
		layout.setComponentAlignment(tabla, Alignment.TOP_RIGHT);
	}

//	public String getFunnyPhrase(String name1, String name2) {
//		String[] verbs = new String[] { "eats", "melts", "breaks", "washes", "sells" };
//		String[] bodyParts = new String[] { "head", "hands", "waist", "eyes", "elbows" };
//		return name1 + " " + verbs[(int) (Math.random() * 100 % verbs.length)] + " " + name2 + "'s "
//				+ bodyParts[(int) (Math.random() * 100 % verbs.length)];
//	}

}