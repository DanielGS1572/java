package timeit.ui;

import java.util.Collection;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import biz.Test;
import biz.TestSet;
import biz.TestSetExecutor;
import biz.test.LongVsInt;
import biz.test.ShortCircuitVsNoShortCircuit;
import biz.test.StringVsStringBuffer;

/**
 * 
 * @author Alejandro Duarte.
 *
 */
@SuppressWarnings("serial")
public class TimeItUI extends UI {
//	########################### inicialización de variables ###########################
	
//	Porque en este caso solo se puede crear un objeto de tipo array?
	private static final TestSet[] testSets = new TestSet[] { //ver que crea un arreglo de objetos de una interfaz... QUE CASO TENDRÍA HACER ESTO?
		new LongVsInt(),
		new StringVsStringBuffer(),
		new ShortCircuitVsNoShortCircuit()
	};
	
//	private static final Test test1 = new Test();			//Esto esta mal
private static final Test[] test2 = new Test[3];			//Esto esta bien
	
	private VerticalLayout layout = new VerticalLayout();
	private ComboBox combo = new ComboBox("Test");				//pone arriba el nombre	
	private final TextField textField = new TextField("Number of iterations", "1000");  //poner arriba el nombre e inicializa
	private CheckBox checkBox = new CheckBox("Keep previous results");
	private Button button = new Button("Time it!");
	private VerticalLayout resultsLayout = new VerticalLayout();
//	########################### inicialización de variables ########################### 
	
	
	
	
	@Override
	protected void init(VaadinRequest request) {
		initCombo();
		initButton();
		initLayout();
	}

	private void initCombo() {
		for(TestSet testSet : testSets) {
//			combo.addItems(testSet,"otro");		//Agrega los objetos como tal y en el combobox pinta la referencia
			combo.addItem(testSet);
			combo.setItemCaption(testSet, testSet.getTitle());     //de cada objeto agregado le pone un Caption definido en cada POJO
		}
		
		combo.addValueChangeListener(new ValueChangeListener() { //cada que se hace un cambio de valor entra al metodo addValueChangeListener y se le pasa como
// parametro un nuevo objeto de tipo ValueChangeListener, que hace que tenga que hacer override al objeto ValueChange...
			
// ver como se le pasa como argumento una interfaz que hace que a fuerza tenga que hacer override al metodo valueChange
			@Override
			public void valueChange(ValueChangeEvent event) {
				TestSet testSet = (TestSet) combo.getValue();	//Ver que getValue regresa un Object para que pueda ser casteado
// por lo que testSet es un arreglo de objetos de 3

				textField.setValue("" + testSet.getDefaultTimes());	//Dependiendo de lo que seleccione cambiara el número de iteraciones
				button.setDescription("<big>" + testSet.getDescription() + "</big>");	//usado para tooltip
			}
		});
		
		combo.setImmediate(true);
	}

	private void initButton() {
		button.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				if(isValid()) {
					runSelectedTest();
				}
			}
		});
	}
	
	private void initLayout() {
		layout.setMargin(true);
		layout.setSpacing(true);
		layout.addComponent(combo);
		layout.addComponent(textField);
		layout.addComponent(checkBox);
		layout.addComponent(button);
		layout.addComponent(resultsLayout);
		
		setContent(layout);
	}

	public boolean isValid() {
		combo.setComponentError(null);
		textField.setComponentError(null);
		
		boolean isValid = true;
		
		if(combo.getValue() == null) {
			combo.setComponentError(new UserError("Select a test from the list."));		//Pone circulo rojo y pone mensaje de error, parece que no aplica para textField
			// se debe de crear un objeto de tipo UserError
			isValid = false;
		}
		
		if(textField.getValue().toString().isEmpty()) {
			
			textField.setComponentError(new UserError("You must introduce the number of iterations to execute"));
			isValid = false;
			
		}
		
		try{
			Integer.parseInt(textField.getValue().toString());
		}catch(NumberFormatException e){
			textField.setComponentError(new UserError("Introduce un valor entero"));
			isValid = false;
		}
		
		System.out.println(textField.getValue().toString());
		
		return isValid;
	}
//!				##################### Entender esta parte --> runSelectedTest
	public void runSelectedTest() {
		Long times = Long.parseLong(textField.getValue());					
		Collection<String> results = TestSetExecutor.execute((TestSet) combo.getValue(), times);
		showResults(results);
	}
	
	private void showResults(Collection<String> results) {
		if(!checkBox.getValue()) {				//obtiene el valor booleano del checkbox
			resultsLayout.removeAllComponents();
			
		} else if(resultsLayout.getComponentCount() > 0) {
			resultsLayout.addComponent(new Label("--"));
		}
		
		for(String result : results) {
			resultsLayout.addComponent(new Label(result));
		}
	}

}