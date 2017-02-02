package com.howtoprogramwithjava.spring;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller // Es importante para que funcione
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); // para
																						// poner
																						// en
																						// el
																						// log

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) // Se usa para
																// mapear una
																// URL a un
																// metodo (en
																// este caso
																// home)
	public String home(Locale locale, Model model) { // ver como el metodo
														// regresa un dato de
														// tipo String que es el
														// nombre del JSP
														// (spring se asoma a la
														// carpeta de views para
														// encontrar el objeto)
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String formattedDate = format.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/home2", method = RequestMethod.GET) // Se usa para
																	// mapear
																	// una URL a
																	// un metodo
																	// (en este
																	// caso
																	// home)
	public String home2(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		model.addAttribute("serverTime", "HOLA!");

		return "home";
	}

}
