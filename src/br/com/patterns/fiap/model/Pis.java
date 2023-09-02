package br.com.patterns.fiap.model;

import java.util.Observable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.patterns.fiap.conf.AliquotaSingleton;

// O Model é um Observable
// A Classe Pis da camada Model não possui referência a View ou ao Controller
// Ao implementar Imposto, teremos maior flexibilidade no Controller
public class Pis extends Observable implements Imposto{
	
	final float ALIQUOTA = Float.parseFloat(AliquotaSingleton.getInstance().getProperty("aliquotaPis"));
	
	float valorDoPis = 0;
	
	private static final Logger LOGGER = LogManager.getLogger(Pis.class.getName());
	
	public Pis() {
		System.out.println("Construtor do Model chamado");
	}

	public float getALIQUOTA() {
		return ALIQUOTA;
	}
	
	public float getValorDoPis() {
		return valorDoPis;
	}
	
	public void calcularImposto(float valor) {
		valorDoPis = valor * ALIQUOTA;
		setChanged();
		
		LOGGER.info("Valor: " + valor
				   +"Alíquota:  " + ALIQUOTA
				   +"Valor do Pis: " + valorDoPis
				);
		
		notifyObservers(valorDoPis);
	}

	@Override
	public String toString() {
		return "Pis [ALIQUOTA=" + ALIQUOTA 
                                    + ", valorDoPis=" + valorDoPis + "]";
      }

}
