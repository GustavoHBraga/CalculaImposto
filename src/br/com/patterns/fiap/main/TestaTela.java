package br.com.patterns.fiap.main;

import br.com.patterns.fiap.controller.ImpostoController;
import br.com.patterns.fiap.model.Pis;
import br.com.patterns.fiap.view.CalculaPis;

public class TestaTela {
	public static void main(String[] args) {
	
			
		Pis modelPis = new Pis();
		CalculaPis viewCalculaPis = new CalculaPis();
		
		// Adiciona um observador para o objeto observado Pis
		modelPis.addObserver(viewCalculaPis);
		
		// Instancia um Controller e informa quem ele controlará
		ImpostoController controller = new ImpostoController(modelPis, viewCalculaPis);
		
		// Envia o controller criado para a View 
		viewCalculaPis.addController(controller);
	
	}
}
