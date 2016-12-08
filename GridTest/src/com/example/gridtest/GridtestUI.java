package com.example.gridtest;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;

import com.vaadin.server.Resource;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.client.renderers.ImageRenderer;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FileResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Image;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.Renderer;

@SuppressWarnings("serial")
@Theme("gridtest")
public class GridtestUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = GridtestUI.class)
	public static class Servlet extends VaadinServlet {
	}

	
	private BeanItemContainer<HelperClass> container = new BeanItemContainer<HelperClass>(HelperClass.class);
	private ArrayList<HelperClass> array = new ArrayList<HelperClass>();
private Grid grid = new Grid();
	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		layout.addComponent(grid);
//		grid.addColumn("txt",String.class);
//		grid.addColumn("txt2",String.class);
		grid.addColumn("im",Resource.class).setRenderer((Renderer<?>) new ImageRenderer());
		grid.addRow(new ThemeResource("img/circle.png"));
//		grid.getColumn("im").setRenderer((Renderer<?>) new ImageRenderer());
		
		
		//
		// for (int a = 0; a < 5; a++) {
		// array.add(new HelperClass(a, a + 1, a + 2));
		// }
		//
		// for(HelperClass t: array){
		// container.addItem(t);
		// }
		// grid.addColumn("test",Resource.class).setRenderer(new
		// ImageRenderer());
		// grid.setContainerDataSource(container);

//		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
//		System.out.println(basepath);
//		FileResource resource = new FileResource(new File(basepath + "/WEB-INF/img/circle.png"));

		// Show the image in the application
		
//		Image image = new Image(null, resource);
//		grid.addRow("test","s", image);
//		ExternalResource image = new ExternalResource("data:image/png;base64,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");
//		array.add(new HelperClass(image,1, 2, 3));
		
		
//		container.addItem(array.get(0));
//		Grid.Column imCol = grid.getColumn("im");
		
		
//		grid.addColumn("im",Resource.class);
//		imCol.setRenderer((Renderer<?>) new ImageRenderer());
//		imCol.setRenderer((Renderer<?>) new ImageRenderer());
//		grid.getColumn("im").setRenderer((Renderer<?>) new ImageRenderer());
		
		
//		grid.setContainerDataSource(container);
//		layout.addComponent(image);
		
		
		// grid.addRow("test",Boolean.class);
	}

}