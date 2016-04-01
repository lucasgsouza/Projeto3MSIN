package Projeto3MSIN;

import java.io.*;

import javax.swing.JOptionPane;

import java.text.ParseException;
import java.util.ResourceBundle;

import Projeto3MSIN.GUI_Idioma;

public class GravarTXT_Atendente {
	private ResourceBundle bn;

	public void GravarTcAtendente(String tcusuario, String tcsenha) {
		try {

			File file = new File("src/Textos/texto_decifrado_Atendente.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write("usuario=" + tcusuario + "\n" + "senha=" + tcsenha);

			writer.flush(); // Cria o conteúdo do arquivo.
			writer.newLine();
			writer.close(); // Fechando conexão e escrita do arquivo.
			JOptionPane.showMessageDialog(null, (GUI_Idioma.bn.getString("Menu.GravadoSucesso")));
		} catch (IOException e) {

			e.printStackTrace(); // possibilita capturar qualquer erro que o
									// "io" venha ocasionar
			// printStackTrace ---> mostra a descrição do erro
		}
	}

	public String lerTCAtendente() {
		String campos = "";
		try {
			File file = new File("src/Textos/texto_decifrado_Atendente.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String dados = null;
			while ((dados = reader.readLine()) != null)// cada volta do looping
														// ele armazena uma
														// linha
			{
				// Na busca ele traz os dados separados, no arquivo salva td
				// junto, agora ele vai salvar separado tbm.
				campos = dados;
			}

			fileReader.close();
			reader.close();

		} catch (IOException erro) {
			erro.printStackTrace();

		}
		return campos;
	}

	public void gravarTCIAtendente(String tciusuario, String tcisenha) {
		try {
			String aux = "";
			File file = new File("src/Textos/texto_cifrado_Atendente.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

			writer.write(tciusuario + tcisenha);

			writer.flush(); // Cria o conteúdo do arquivo.
			writer.close(); // Fechando conexão e escrita do arquivo.
		} catch (IOException e) {

			e.printStackTrace(); // possibilita capturar qualquer erro que o
									// "io" venha ocasionar
			// printStackTrace ---> mostra a descrição do erro
		}
	}

	// Ler Compromisso
	public String lerTCIAtendente() {
		String campos = "";

		try {
			File file = new File("src/Textos/texto_cifrado_Atendente.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String dados = null;
			while ((dados = reader.readLine()) != null)// cada volta do looping
														// ele armazena uma
														// linha
			{
				// Na busca ele traz os dados separados, no arquivo salva td
				// junto, agora ele vai salvar separado tbm.
				campos = dados;
			}

			fileReader.close();
			reader.close();
		} catch (IOException erro) {
			erro.printStackTrace();

		}
		return campos;
	}

}
