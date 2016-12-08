package com.example.binding;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.DateField;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TwinColSelect;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class OptionGroup extends UI implements ValueChangeListener {
	private DateField date = new DateField("Select a date");
//	private InlineDateField date = new InlineDateField("Select a date");
	@WebServlet(value = "/optiongroup/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = OptionGroup.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		// an array with the options
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("Vaadin beans");
		answers.add("Session beans");
		answers.add("Enterprise App for Vaadin beans");
		answers.add("Message-driven beans");

		// our OptionGroup component
		com.vaadin.ui.OptionGroup og = new com.vaadin.ui.OptionGroup("Two kinds of EJBs in Java EE are:", answers);

		og.addValueChangeListener(this);
		og.setImmediate(true);
		// FIXME: og should be multi select!
		og.setMultiSelect(true);

		// our main layout
		VerticalLayout layout = new VerticalLayout();

		setContent(layout);

		TwinColSelect tcs = new TwinColSelect("Two kinds of EJBs in Java EE are:", answers);

		date.setResolution(Resolution.DAY);		// Se puede cambiar la resolución de la fecha
		date.setDateFormat("yy-MM-dd");				// Formato a la fecha
		layout.addComponents(og, tcs, date);
		setContent(layout);
	}

	@Override
	public void valueChange(ValueChangeEvent event) {
		String answer = event.getProperty().getValue().toString();
		Notification.show("Your answer: " + answer);
		System.out.println(date.getValue());	// getValue regresa un objeto del tipo java.util.Date
	}
}