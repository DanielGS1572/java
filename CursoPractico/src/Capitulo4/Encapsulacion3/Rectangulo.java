package Capitulo4.Encapsulacion3;

//Una clase puede ser solamente public y default, No puede ser private ni protected
//una variable local no puede tener ninguno de los 4 modificadores de acceso
//los metodos y los atributos pueden tener todos los modificadores

//La idea de la encapsulación es mantener los atributos de los objetos como privados
//y proporcionar acceso de los mismos a traves de metodos publicos

// Hay dos formas de acceder a los campos privados de una clase:
// - A través de su constructor
// - A través de los getters/setters
class Rectangulo {
	private int alto, ancho;
	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		if (alto > 0)
			this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		if (ancho > 0)
			this.ancho = ancho;
	}
	public int muestraSuma(){
		return this.ancho + this.alto;
	}
}
