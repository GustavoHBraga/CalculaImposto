package br.com.patterns.fiap.conf;

import java.io.IOException;
import java.util.Properties;

public class AliquotaSingleton {

	// Atributo privado static pertence � classe e n�o ao objeto, ser�
	// compartilhado por todos os objetos que o acessarem
	private static Properties properties;
	
	private static final String ARQ = "/resources/conf.properties";	
		// O construtor da classe � privado 
	// outros objetos n�o podem instanciar AliquotaSingleton
	private AliquotaSingleton(){}
	
	// A �nica maneira de obter um objeto Properties 
	// � atrav�s do m�todo p�blico e est�tico getInstance()
	// que sempre retornar� uma �nica inst�ncia dessa classe
	
	public static Properties getInstance(){
		
		// Se properties � nulo, instancia um para retornar
		// desta forma instanciamos apenas um properties
		if(properties == null){
			properties = new Properties();
			try{
				properties.load(AliquotaSingleton
                                .class.getResourceAsStream(ARQ));
				System.out.println("Instanciando pela primeira vez");
			} catch(IOException e){
				e.printStackTrace();
			}
		}
		return properties;
	}	
}