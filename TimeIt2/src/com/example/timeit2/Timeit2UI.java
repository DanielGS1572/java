package com.example.timeit2;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.annotation.WebServlet;

import com.example.timeit2.ShortCircuitVsNoShortCircuit.NoShortCircuitTest;
import com.example.timeit2.ShortCircuitVsNoShortCircuit.ShortCircuitTest;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("timeit2")
public class Timeit2UI extends UI {

	private static final TestSet[] testSets = new TestSet[] { new LongVsInt(), new StringVsStringBuffer(),
			new ShortCircuitVsNoShortCircuit() };
	private VerticalLayout layout = new VerticalLayout();
	private ComboBox combo = new ComboBox("Test");
	private final TextField textField = new TextField("Number of iterations", "10");
	private CheckBox checkBox = new CheckBox("Keep previous results");
	private Button button = new Button("Time it!");
	private VerticalLayout resultsLayout = new VerticalLayout();

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Timeit2UI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override

	protected void init(VaadinRequest request) {

		layout.setMargin(true);
		setContent(layout);
		initLayout();
		initCombo();
		initButton();

	}

	private void initButton() {
		button.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				if (isValid()) {
					runSelectedTest();
				}
			}
		});
	}

	public boolean isValid() {
		combo.setComponentError(null);
		textField.setComponentError(null);
		boolean isValid = true;
		if (combo.getValue() == null) {
			combo.setComponentError(new UserError("Select a test from the list."));
			isValid = false;
		}
		if (textField.getValue().toString().isEmpty()) {
			textField.setComponentError(new UserError("You must introduce the number of iterations to execute"));
			isValid = false;
		}
		return isValid;
	}

	public void runSelectedTest() {
		Long times = Long.parseLong(textField.getValue());
		Collection<String> results = TestSetExecutor.execute((TestSet) combo.getValue(), times);
		showResults(results);
	}

	private void showResults(Collection<String> results) {
		if (!checkBox.getValue()) {

			resultsLayout.removeAllComponents();
		} else if (resultsLayout.getComponentCount() > 0) {
			resultsLayout.addComponent(new Label("--"));
		}
		for (String result : results) {
			resultsLayout.addComponent(new Label(result));
		}
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

	private void initCombo() {
		ComboBox combo = new ComboBox("Select an option");

		for (TestSet testSet : testSets) {
			combo.addItem(testSet);
			combo.setItemCaption(testSet, testSet.getTitle());
		}
		combo.addValueChangeListener(new ValueChangeListener() {

			public void valueChange(ValueChangeEvent event) {
				TestSet testSet = (TestSet) combo.getValue();
				textField.setValue("" + testSet.getDefaultTimes());
				button.setDescription(testSet.getDescription());

			}
		});
		combo.setImmediate(true);
	}

}

// ########################## TestSetExecutor
class TestSetExecutor {

	public static Collection<String> execute(TestSet testSet, long times) {
		ArrayList<String> results = new ArrayList<String>();

		testSet.init();

		for (Test test : testSet.getTests()) {
			long time = execute(test, times);
			results.add(test.getName() + ": " + time + " ms.");
		}

		return results;
	}

	public static long execute(Test test, long times) {
		long startTime = System.nanoTime();

		for (long i = 0; i < times; i++) {
			test.execute();
		}

		long endTime = System.nanoTime();

		return (endTime - startTime) / 1000000;
	}

}

// ########################## Test
interface Test {

	String getName();

	void execute();

}

// ########################## TestSet
interface TestSet {

	Test[] getTests();

	void init();

	long getDefaultTimes();

	String getTitle();

	String getDescription();

}

// ###################StringVsStringBuffer

class StringVsStringBuffer implements TestSet {

	private static final String ADD_THIS = "a";

	@SuppressWarnings("unused")
	private String s;
	private StringBuffer sb;

	public class StringTest implements Test {

		@Override
		public String getName() {
			return "String";
		}

		@Override
		public void execute() {
			s += "a";
		}
	}

	public class StringBufferTest implements Test {

		@Override
		public String getName() {
			return "StringBuffer";
		}

		@Override
		public void execute() {
			sb.append(ADD_THIS);
		}
	}

	@Override
	public Test[] getTests() {
		return new Test[] { new StringTest(), new StringBufferTest() };
	}

	@Override
	public void init() {
		s = "";
		sb = new StringBuffer();
	}

	@Override
	public long getDefaultTimes() {
		return 100000;
	}

	@Override
	public String getTitle() {
		return "String vs StringBuffer";
	}

	@Override
	public String getDescription() {
		return "How much do we gain by using StringBuffer instead of String when dealing with strings?";
	}

}

// #######################ShortCircuitVsNoShortCircuit
class ShortCircuitVsNoShortCircuit implements TestSet {

	private double i;

	public class ShortCircuitTest implements Test {
		@Override
		public String getName() {
			return "if(i < 100 && i > 50)";
		}

		@Override
		public void execute() {
			if (i < 100 && i > 50) {
				i++;
				System.out.println(i);
			}
		}
	}

	public class NoShortCircuitTest implements Test {
		@Override
		public String getName() {
			return "if(i < 100 & i > 50)";
		}

		@Override
		public void execute() {
			if (i < 100 & i > 50) {
				i++;
				System.out.println(i);
			}
		}
	}

	@Override
	public Test[] getTests() {
		return new Test[] { new ShortCircuitTest(), new NoShortCircuitTest() };
	}

	@Override
	public void init() {
		i = 0;
	}

	@Override
	public long getDefaultTimes() {
		return 200000000;
	}

	@Override
	public String getTitle() {
		return "&& vs &";
	}

	@Override
	public String getDescription() {
		return "This will test the difference between short-circuiting && and not short-circuiting &.";
	}

}

// ########################## LongVsInt
class LongVsInt implements TestSet {

	private int iterations;

	public class LongTest implements Test {
		long i;

		@Override
		public String getName() {
			return "for(long i...";
		}

		@Override
		public void execute() {
			for (i = 0; i < iterations; i++)
				;
		}
	}

	public class IntTest implements Test {
		int i;

		@Override
		public String getName() {
			return "for(int i...";
		}

		@Override
		public void execute() {
			for (i = 0; i < iterations; i++)
				;
		}
	}

	@Override
	public Test[] getTests() {
		return new Test[] { new LongTest(), new IntTest() };
	}

	@Override
	public void init() {
		iterations = 100000;
	}

	@Override
	public long getDefaultTimes() {
		return 10000;
	}

	@Override
	public String getTitle() {
		return "long vs int loop";
	}

	@Override
	public String getDescription() {
		return "One could think a loop controlled by an int is faster than one controlled by a long. Let's check how much the difference is.";
	}
}
