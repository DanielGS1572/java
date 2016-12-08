package com.example.binding;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Tree;
import com.vaadin.ui.Tree.CollapseEvent;
import com.vaadin.ui.Tree.CollapseListener;
import com.vaadin.ui.Tree.ExpandEvent;
import com.vaadin.ui.Tree.ExpandListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte
 * 
 */
@SuppressWarnings("serial")
public class MyFirstTreeUI extends UI {
	@WebServlet(value = "/firsttree/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MyFirstTreeUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Tree familyTree = new Tree();
		// se van agregando todos los elementos al arbol
		familyTree.addItem("Families");
		familyTree.addItem("The Jackson");
		familyTree.addItem("The Simpsons");
		familyTree.addItem("The Rothschilds");
		familyTree.addItem("The Hapsburgs");
		familyTree.addItem("The Addams");
		// Se construye la jerarquía del arbol
		familyTree.setParent("The Jackson", "Families");
		familyTree.setParent("The Simpsons", "Families");
		familyTree.setParent("The Rothschilds", "The Hapsburgs");
		familyTree.setParent("The Hapsburgs", "Families");
		familyTree.setParent("The Addams", "The Hapsburgs");

		familyTree.setChildrenAllowed("The Jackson", true); // si se define como
															// true pero no
															// tiene nada
															// asociado
															// simplemente pone
															// la flecha
		familyTree.setChildrenAllowed("The Simpsons", false);
		familyTree.setChildrenAllowed("The Rothschilds", false);
		familyTree.setChildrenAllowed("The Hapsburgs", true); // si se desean
																// niveles mas
																// bajos se debe
																// definir que
																// tendra hijos
		familyTree.setChildrenAllowed("The Addams", false);

		familyTree.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				Notification.show(event.getItemId() + " clicked.");
			}
		});

		familyTree.addExpandListener(new ExpandListener() {
			@Override
			public void nodeExpand(ExpandEvent event) {
				Notification.show(event.getItemId() + " expanded.");
			}
		});

		familyTree.addCollapseListener(new CollapseListener() {
			@Override
			public void nodeCollapse(CollapseEvent event) {
				Notification.show(event.getItemId() + " collapsed.");
			}
		});

		HierarchicalContainer hContainer = new HierarchicalContainer();
		hContainer.addItem("DAD");
		hContainer.addItem("son");
		hContainer.setParent("son", "DAD"); // ver que la relación del padre va
											// como segundo parametro
		Tree familyTreeContainer = new Tree();
		familyTreeContainer.setContainerDataSource(hContainer); // ver que no se
																// le esta
																// pasando como
																// codigo duro
																// al arbol sino
																// a traves de
																// un container

		layout.addComponent(familyTree);
		layout.addComponent(familyTreeContainer);
	}

}