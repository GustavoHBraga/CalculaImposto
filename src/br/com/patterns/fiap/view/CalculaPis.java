package br.com.patterns.fiap.view;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

public class CalculaPis implements Observer, TelaDeImposto {
	
	private TextField txtValorFaturado;
	private Button btnCalcular; 
	
	// Construtor que comp�e a tela
	public CalculaPis() {
		System.out.println("Construtor da View chamado");

		// O Frame � uma subclasse de Window que estende Container
		// Essa hierarquia de classes utiliza o padr�o Composite
		// para compor a tela, veja os m�todos .add
		Frame frame = 
                new Frame("C�lculo do PIS MVC e Design Patterns");
		frame.add("North", new Label("Valor Faturado"));

		txtValorFaturado = new TextField();
		frame.add("Center", txtValorFaturado);

		Panel panel = new Panel();
		btnCalcular = new Button("Calcular PIS");
		panel.add(btnCalcular);
		frame.add("South", panel);

		frame.addWindowListener(new CloseListener());
		frame.setSize(200, 150);
		frame.setLocation(100, 100);
		frame.setVisible(true);
	}
	
     // M�todo que retorna o valor para c�lculo de imposto
	public float getValor() {
		return Float.parseFloat(txtValorFaturado.getText());
	}
	
	// M�todo que possibilita a View enviar a a��o de calcular 
	// para o Controller chamar o Model
	public void addController(ActionListener controller){
		System.out.println("A View adicionou o Controller");
		btnCalcular.addActionListener(controller);	 
	} 
	
	/* update exibe uma mensagem na View contendo: 
	 * A classe Model 
	 * O toString sobrescrito 
	 * O valor do estado, atributo valorDoPis da classe Pis
	*/
	
	// O m�todo update ser� chamado pelo Model por notifyObservers()
	public void update(Observable objModel, Object estadoDoModel)   
     {
		String msg = objModel.getClass() + " " + objModel.toString() + " " + ((Float)estadoDoModel).floatValue();
		JOptionPane.showMessageDialog(null, msg);	
      }

	
      // Encerra o programa
	public static class CloseListener extends WindowAdapter {
		
            public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		}
	} 

}