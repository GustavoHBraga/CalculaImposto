package br.com.patterns.fiap.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.patterns.fiap.model.Imposto;
import br.com.patterns.fiap.view.TelaDeImposto;

// ImpostoController implementa ActionListener para capturar 
// o evento do bot�o da View 
public class ImpostoController implements ActionListener {

	// O Controller possui refer�ncias a Imposto e a Tela
	// � reutiliz�vel para Telas que calculem Impostos
	// Ou seja, classes que implementem estas interfaces
	private Imposto model;
	private TelaDeImposto view;
	
	// O construtor recebe as refer�ncias das demais camadas
	public ImpostoController(Imposto model, TelaDeImposto view) {
		System.out.println("Construtor do Controller chamado");
		this.model = model;
		this.view = view;
	}
		
	// M�todo invocado quando o bot�o da View � invocado
	public void actionPerformed(ActionEvent e) {
		model.calcularImposto(view.getValor());
	}
}