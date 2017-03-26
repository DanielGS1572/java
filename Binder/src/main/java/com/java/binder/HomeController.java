package com.java.binder;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.binder.domain.User;

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
		model.addAttribute("userObject", new User()); // Debe tener el mismo nombre que
												// commandName
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@ModelAttribute("userObject") User user, Locale locale, Model model) {	//@ModelAttribute es para recuperar lo que se le pasa a traves del post cuando le dan Submit (Dentro de lo que esta en form en el jsp)
		model.addAttribute("userObject", user);
		System.out.println("Usuario: " + user.getUsername() + "\nContraseña: " + user.getPassword());
		return "home";
	}
}
