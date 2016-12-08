package debug;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class Tienda extends UI  {
	static VerticalLayout vL = new VerticalLayout();

	@Override
	protected void init(VaadinRequest request) {
		
		// TODO Auto-generated method stub
		vL.setMargin(true);
		setContent(vL);
		
	}

	
}
