package com.caveofprogramming.designpatterns.demo1.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.caveofprogramming.designpatterns.demo1.model.Model;

//Es la clase que el usuario verá

public class View extends JFrame implements ActionListener {
	// la clase de view debe tener una instancia del modelo pues es la forma en
	// la que se mostrarán los datos
	// El sujeto es helloButton y todo sujeto debe de tener un listener (que
	// implementa una interfaz)
	
	// Al objeto se le pone un addActionListener(this) y se hace override al metodo
	// de la interfaz (el metodo de la clase anonima). Ademas si se quiere que haga una accion
	// ya se pone la clase anonima de la interfaz. Se debe de implementar en la clase la interfaz
	// para poder hacer override (se puede poner this porque recibe como argumento una interfaz, y como 
	// se esta implementando en esta clase no hay problema
	private Model model;
	private JButton helloButton;
	private JButton goodbyeButton;

	public View(Model model) throws HeadlessException {
		super("MVC Demo");
		this.model = model;

		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("good bye");

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 1;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		add(helloButton, gc);

		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		add(goodbyeButton, gc);

		helloButton.addActionListener(this);
		goodbyeButton.addActionListener(this);
		goodbyeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("sorry to see you go");
			}
		});

		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if (source == helloButton) {
			System.out.println("Hello there");
		} else {
			System.out.println("Some other button");
		}
	}

}
