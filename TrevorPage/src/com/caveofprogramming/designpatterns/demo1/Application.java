package com.caveofprogramming.designpatterns.demo1;

import javax.swing.SwingUtilities;

import com.caveofprogramming.designpatterns.demo1.controller.Controller;
import com.caveofprogramming.designpatterns.demo1.model.Model;
import com.caveofprogramming.designpatterns.demo1.view.View;

public class Application {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				runApp();
			}
			
		});
	}
	public static void runApp(){
		//el modelo es independiente  del controller y del view
		//el model no debe importar nada de GUIs
		Model model = new Model();
		
		//view debe importar paquetes del modelo para que puedan ser presentados
		//por lo que se le debe pasar la referencia del modelo al view
		View view = new View(model);
		
		//El controller le envia comandos al modelo, le dice al modelo que hacer
		Controller controller = new Controller(view,model);
	}
}
