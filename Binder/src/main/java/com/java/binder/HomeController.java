package com.java.binder;

import java.text.DateFormat;
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
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET) // si no
																	// tuviera
																	// el
																	// parametro
																	// de
																	// method,
																	// no es
																	// necesario
																	// poner el
																	// "value="
																	// (pues es
																	// el unico
																	// parametro)
	public String login(Locale locale, Model model) {
		// GET -> cuando un usuario realiza la primer carga de una URL
		// POST -> cuando se envia información de una pagina/url específica
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(Locale locale, Model model) {
		return "home";
	}
}
