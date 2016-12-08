package com.example.boxwords;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnHeaderMode;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class BoxwordUI extends UI implements ItemClickListener {
	private Game game = new Game(5);
	private Table table = new Table();
	private VerticalLayout messagesLayout = new VerticalLayout();
	private Label currentLetter = new Label("", ContentMode.HTML);

	@WebServlet(value = "/boxword/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = BoxwordUI.class)
	public static class Servlet extends VaadinServlet {
	}

	protected void init(VaadinRequest request) {

		// init main layout
		HorizontalLayout layout = new HorizontalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);
		// init the table
		table.setPageLength(0); // Muestra el numero de renglones, si es cero
								// muestra la tabla completa
		table.setColumnHeaderMode(ColumnHeaderMode.HIDDEN);
		table.addItemClickListener(this); // Esto escucha los clics en la
											// columna de esta clase y reconoce
											// que renglon
		for (int column = 0; column < game.getSize(); column++) {
			table.addContainerProperty(column, String.class, ".");
		}
		for (int row = 0; row < game.getSize(); row++) {
			table.addItem(row);
		}
		layout.addComponent(table);
		// init the components for showing the next letter and results
		// messagesLayout.addComponent(currentLetter);
		// layout.addComponent(messagesLayout);
		nextTurn();
	}

	// Como implementa la interfaz ItemClickListener se debe hacer override al
	// metodo
	public void itemClick(ItemClickEvent event) {

		// con event.getItem() se obtiene el renglon
		System.out.println(event.getPropertyId()); // Obtiene el id de la
													// columna
		System.out.println(event.getItem()); // Obtiene todos los elementos de
												// un registro
		System.out.println(event.getItem().getItemProperty(event.getPropertyId()).getValue()); // Obtiene
																								// el
																								// elemento
																								// donde
																								// se
																								// hizo
																								// clic

		Property property = event.getItem().getItemProperty(event.getPropertyId());
		if (".".equals(property.getValue())) {
			property.setValue(game.getCurrentLetter());
			nextTurn();
		} else {
			Notification.show("You must select an empty cell.");
		}

	}

	private void nextTurn() {
		if (game.over()) {
			gameOver();
		} else {
			currentLetter.setValue("Next letter: " + game.nextLetter());
		}
	}

	private void gameOver() {
		Collection<String> words = getWords();
		currentLetter.setValue("You scored " + game.getScore(words) + "!");
		messagesLayout.addComponent(new Label("Words:"));
		for (String word : words) {
			String link = "http://www.merriam-webster.com/dictionary/" + word.toLowerCase();
			// The following is not a good implementation.
			// Next chapter we will see how to get rid of this ugly
			// HTML.
			String anchor = "<a href='" + link + "' target='_blank' style='margin-left: 10px;'>" + word.toLowerCase()
					+ "</a>";
			messagesLayout.addComponent(new Label(anchor, ContentMode.HTML));
		}
	}

	private Collection<String> getWords() {
		ArrayList<String> words = new ArrayList<String>();
		for (int row = 0; row < game.getSize(); row++) {
			String line = "";
			for (int column = 0; column < game.getSize(); column++) {
				line += table.getItem(row).getItemProperty(column).getValue();
			}
			words.addAll(game.getWords(line));
		}
		for (int column = 0; column < game.getSize(); column++) {
			String line = "";
			for (int row = 0; row < game.getSize(); row++) {
				line += table.getItem(row).getItemProperty(column).getValue();
			}
			words.addAll(game.getWords(line));
		}
		return words;
	}

}
