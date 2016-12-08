//Esta clase esta relacionada con LayoutFramework

package com.example.layout;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class MainLayout extends VerticalLayout { // Parece que extiende de
													// VerticalLayout en lugar
													// de UI pues contiene los
													// metodos
	// para la parte grafica y no se pone UI pues sería la clase principal

	private VerticalLayout upperSection = new VerticalLayout();
	private HorizontalSplitPanel lowerSection = new HorizontalSplitPanel(); // Esto
																			// hace
																			// que
																			// se
																			// pueda
																			// recorrer,
	// no sirve lowerSection.setMargin
	// private HorizontalLayout lowerSection = new HorizontalLayout();
	private VerticalLayout menuLayout = new VerticalLayout();
	private VerticalLayout contentLayout = new VerticalLayout();

	public MainLayout() { // Metodo en el que construye el Layout y no tiene
							// nada de negocio
		 lowerSection.setSizeFull();
		 contentLayout.setSizeFull();		//Si no se ponen estas dos instrucciones no pintará nada en algunos casos
//		 menuLayout.setSizeFull();			//Se comenta porque todos los botones lo reparte

		upperSection.addComponent(new Label("Header"));
		menuLayout.addComponent(new Label("Menu"));
		contentLayout.addComponent(new Label("Content"));

		// lowerSection.setSplitPosition(30);
		lowerSection.addComponent(menuLayout);
		lowerSection.addComponent(contentLayout);
		lowerSection.setSplitPosition(20); // Define donde poner el split (al 20% de la pantalla)

		addComponent(upperSection);
		addComponent(lowerSection);
		setExpandRatio(lowerSection, 1);

//		showBorders();
		this.setSizeFull(); // lo mismo que setSizeFull().....
		// Hace que todos los componentes ocupen la fracción de verticallayouts
		// que existan, en lugar que ocupen lo minimo
		setExpandRatio(lowerSection, 1); // Hace que se ocupen los espacios
											// vacios que estan intermedios en
											// la pagina.
		// Al poner dos verticallayouts ocuparan fifty-fifty
	}

	@SuppressWarnings("unused")
	private void showBorders() {
		String style = "v-ddwrapper-over"; // clase CSS que viene por default en
											// Vaadin
		setStyleName(style);
		upperSection.setStyleName(style);
		lowerSection.setStyleName(style);
		menuLayout.setStyleName(style);
		contentLayout.setStyleName(style);
	}

	public void addMenuOption(String caption, final Component component) {
		Button button = new Button(caption);
		menuLayout.addComponent(button);

		button.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				contentLayout.removeAllComponents();
				contentLayout.addComponent(component);
			}
		});

	}
	
	public void addUpperSection(String caption, final Component component){
		Button button = new Button(caption);
		menuLayout.addComponent(button);
		button.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				upperSection.removeAllComponents();
				upperSection.addComponent(component);
				
			}
		});
	}
}
