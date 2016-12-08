package com.example.editabletable;

import java.util.Date;

import javax.servlet.annotation.WebServlet;

import com.example.boxwords.BoxwordUI;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class EditabletableUI extends UI {
	@WebServlet(value = "/editabletable/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = EditabletableUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Table table = new Table();
		table.setPageLength(0);
		table.setEditable(true);

		table.addContainerProperty("String", String.class, "aaa");
		table.addContainerProperty("Boolean", Boolean.class, false);
		table.addContainerProperty("Date", Date.class, null);
		table.addContainerProperty("Item", Item.class, null);

		table.addItem();
		table.addItem();
		table.addItem();			//Agrega tres registro que han sido inicializados con un default, más otro que trae otros valores (A)

		User user = new User();
		user.setLogin("mylogin");			//Usa la API de java reflection para generar las etiquetas
		user.setPassword("mypassword");

		BeanItem<User> item = new BeanItem<User>(user);  //Crea un objeto de tipo user que es agregado a la tabla, ver que es un BeanItem 
		// porque tiene variables de instancia

		table.addItem(new Object[] { "dd", true, new Date(), item },4);  //(A)... Cómo se estan agregando elementos de diferentes tipos
		// por eso se pone un arreglo de tipo Object
		// El 4 es el itemID
		
		System.out.println(table.getItem(4).getItemProperty("String").getValue());  //Un Item (un renglon) si trae los datos como tal,
		//Pero para un item property si se necesita hacer .getValue, si no traerá un objeto
		System.out.println(FontAwesome.COG);

		layout.addComponent(table);
	}

}