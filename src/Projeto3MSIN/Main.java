package Projeto3MSIN;

import javax.swing.UIManager;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public class Main {

	public static void main(String[] args) {
		CTRL_Inicialização inicialização = new CTRL_Inicialização();
		inicialização.Acao_TelaIdioma();
		BasicConfigurator.configure();
		setDesign();
		PropertyConfigurator.configure("src/Docs/log4j.properties");
	}

	public final static void setDesign() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {

		}
	}

}