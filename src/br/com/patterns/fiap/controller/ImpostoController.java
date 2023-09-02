package br.com.patterns.fiap.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.patterns.fiap.model.Imposto;
import br.com.patterns.fiap.view.TelaDeImposto;

// ImpostoController implementa ActionListener para capturar 
// o evento do botão da View 
public class ImpostoController implements ActionListener {

	// O Controller possui referências a Imposto e a Tela
	// É reutilizável para Telas que calculem Impostos
	// Ou seja, classes que implementem estas interfaces
	private Imposto model;
	private TelaDeImposto view;
	
	// O construtor recebe as referências das demais camadas
	public ImpostoController(Imposto model, TelaDeImposto view) {
		System.out.println("Construtor do Controller chamado");
		this.model = model;
		this.view = view;
	}
		
	// Método invocado quando o botão da View é invocado
	public void actionPerformed(ActionEvent e) {
		model.calcularImposto(view.getValor());
	}
}