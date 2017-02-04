package com.funwithcontrollers.fun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeControllerTwo {

	private static final Logger logger = LoggerFactory.getLogger(HomeControllerTwo.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET) // a los
																	// metodos
																	// que
																	// tienen la
																	// anotacion
	// de requestMapping puede recibir como parametro varios objetos, entre
	// ellos estan:
	// - Model

	// - ModelMap .- Es usado para pasarle información a la vista (HTML o JSP)

	// - HttpServletRequest .- Se usa para obtener acceso a los datos que se le
	// han pasado a algun formulario
	// de la pagina web y la forma de recuperarlo es String username =
	// (String)request.getParameter("username");

	// - HttpServletResponse .- Es lo que sucede despues que una petición ha
	// sido realizada. Al usar Spring se
	// puede evitar el uso de HttpServletResponse pues para eso esta el
	// modelmap. HttpServletResponse casi no se usa

	// - @RequestParam .- Se puede usar en sustitucion del Request (es una forma
	// mas "moderna" de obtener un
	// parametro dentro de la vista. Usa el metodo RequestMethod.POST
	public String userLoginGet(ModelMap model) {

		return "home"; // si en el view no encuentra la variable no manda error
						// ni nada, simplemente no la pinta
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String userLoginPost(ModelMap model) {
		if (loginAttemptValid()) {
			return "home";
		} else {
			return "login";
		}
	}
	
	
	
	//Falta ver como se hace un POST Y OBTENER LOS DATOS
	
	
	@RequestMapping(value = "loginTwo", method = RequestMethod.GET)
	public String userLoginGetLoginTwo(ModelMap model) {

		return "home";
	}
	@RequestMapping(value = "loginTwo", method = RequestMethod.POST)
	public void userLoginPost(ModelMap model, @RequestParam("username") String username) {
		// now the username variable is populated with the value from the
		// request
		System.out.println("The username is: " + username);
	}

	private boolean loginAttemptValid() {
		return false;
	}

}
