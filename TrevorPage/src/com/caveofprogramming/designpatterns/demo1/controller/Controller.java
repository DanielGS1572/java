package com.caveofprogramming.designpatterns.demo1.controller;

import com.caveofprogramming.designpatterns.demo1.model.Model;
import com.caveofprogramming.designpatterns.demo1.view.View;

//Maneja la logica de negocio
public class Controller {
	private View view;
	private Model model;
	public Controller(View view, Model model) {
		super();
		this.view = view;
		this.model = model;
	}
	
	
}
