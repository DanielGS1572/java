package Capitulo7;

public enum Libro {
	JHTP6("JAVA how to program","2005"),
	CHTP4( "C How to Program 4e", "2004" ),
	W3HTP3( "Internet & World Wide Web How to Program 3e", "2004" ),
	CPPHTP4( "C++ How to Program 4e", "2003" ),
	VBHTP2( "Visual Basic .NET How to Program 2e", "2002" ),
	CSHARPHTP( "C# How to Program", "2002" );
	
	private String titulo;
	private String anio;
	
	private Libro(String titulo, String anio){
		this.titulo = titulo;
		this.anio = anio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}
	
	
}
