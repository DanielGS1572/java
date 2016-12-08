package fieldfactory;

import com.vaadin.data.Container;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.PasswordField;			// Clase que bloquea el texto
import com.vaadin.ui.TableFieldFactory;
import com.vaadin.ui.TextField;

/**
 * 
 * @author Alejandro Duarte
 * 
 */
@SuppressWarnings("serial")
public class UserFieldFactory implements TableFieldFactory {

	@Override
	public Field<?> createField(Container container, Object itemId,
			Object propertyId, Component uiContext) {
		System.out.println(container);
		System.out.println(itemId);
		System.out.println(propertyId);
		System.out.println(uiContext);
		if ("Password".equals(propertyId)) {
			return new PasswordField();
		}

		return new TextField();
	}

}
