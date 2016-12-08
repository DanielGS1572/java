package fieldfactory;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class FieldfactoryUI extends UI {
	@WebServlet(value = "/fieldfactory/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = FieldfactoryUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Table table = new Table("Users");
		table.setPageLength(0);
		table.setEditable(true);
		 table.addContainerProperty("Login", String.class, "");
		 table.addContainerProperty("Password", String.class, "");
		table.addContainerProperty("Text fields", TextField.class, "test");
		table.addContainerProperty("Check boxes", CheckBox.class, null);

		table.addItem();
		table.addItem();
		table.addItem();

		table.addItem(new Object[] { new String(), new String(), new TextField(), new CheckBox() }, 4);

		layout.addComponent(table);

		 table.setTableFieldFactory(new UserFieldFactory());
		// al crear el objeto UserFieldFactory se le pasan los parametros que
		// setTableFieldFactory requiere
		// Como que la clase UserFieldFactory cuando usa <?>
	}

}