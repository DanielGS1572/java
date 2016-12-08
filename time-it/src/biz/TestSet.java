package biz;

/**
 * 
 * @author Alejandro Duarte.
 *
 */
public interface TestSet {
	
	Test[] getTests();
	
	void init();
	
	long getDefaultTimes();
	
	String getTitle();

	String getDescription();
	
}


// Como es que ponen en bold el nombre del boton en un eventAction al princip
// Como getDescription obtiene la descripcion? Donde la implementa en la interfaz