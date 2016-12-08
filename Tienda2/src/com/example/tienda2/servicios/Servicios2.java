package com.example.tienda2.servicios;

import java.text.DecimalFormat;
import java.util.ArrayList;

import com.example.tienda2.datos.HelperClassTienda2;

public class Servicios2 {
	
	private DecimalFormat f = new DecimalFormat("##.00");
	private ArrayList<HelperClassTienda2> catalogo = new ArrayList<HelperClassTienda2>();
	
	
	
	public void creaCatalogo(){
		
		for(int i=1; i<=20; i++){
			if(i <= 10)
				
				catalogo.add(new HelperClassTienda2(i, "Categoria " + 1, "Producto " + i, 0,Double.parseDouble(f.format(Math.random()*10))));
			else
				catalogo.add(new HelperClassTienda2(i, "Categoria " + 2, "Producto " + i, 0,Double.parseDouble(f.format(Math.random()*10))));
		}
	}
	
	

	public ArrayList<HelperClassTienda2> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(ArrayList<HelperClassTienda2> catalogo) {
		this.catalogo = catalogo;
	}

	
}



