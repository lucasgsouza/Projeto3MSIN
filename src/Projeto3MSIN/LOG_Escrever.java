package Projeto3MSIN;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class LOG_Escrever {

	public void LOG_Escrever() {

		Logger logger = Logger.getLogger("MyLog");
		FileHandler fh;

		try {

			fh = new FileHandler("MyLogFile.log", true);

			logger.addHandler(fh);
			logger.setLevel(Level.INFO);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);


		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
