package com.example.binding;


import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author Alejandro Duarte.
 * 
 */
@SuppressWarnings("serial")
public class UploadUI extends UI implements Receiver {			//La interfaz receiver procesa el archivo byte to byte
	
	@WebServlet(value = "/uploadui/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = UploadUI.class)
	public static class Servlet extends VaadinServlet {
	}
	@Override
	protected void init(VaadinRequest request) {
		Upload upload = new Upload(
				"Select a text file and look at the console",
				this);

		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(upload);
		setContent(layout);
	}

	@Override				// Metodo que implementa de Receiver
	public OutputStream receiveUpload(String filename,
			String mimeType) {
		return new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				System.out.print((char) b);
			}
		};
	}

}