package Projeto3MSIN;

import java.io.*;

import javax.swing.JOptionPane;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Projeto3MSIN.GUI_Idioma;

public class Gravar_TXT_Financeiro {
	private ResourceBundle bn;

	public void GravarTcFinaceiro(int Matricula, String DataMatricula, int CodigoCurso, float Valor, int RaAluno,
			String StatusMatricula, String StatusFinanceiro) {

		try {

			File file = new File("src/Textos/Sistema_Financeiro.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

			writer.write((GUI_Idioma.bn.getString("Menu.Lmatricula") + ":" + Matricula + "\r|"
					+ GUI_Idioma.bn.getString("Menu.Ldatamatricula") + ":" + DataMatricula + "\r|"
					+ GUI_Idioma.bn.getString("Menu.Lcodigocurso") + ":" + CodigoCurso + "\r|"
					+ GUI_Idioma.bn.getString("Menu.Lvalor") + ":" + Valor + "\r|" + GUI_Idioma.bn.getString("Menu.Lra")
					+ ":" + RaAluno + "\r|" + GUI_Idioma.bn.getString("Menu.Lstatusmat") + ":" + StatusMatricula + "\r|"
					+ GUI_Idioma.bn.getString("Menu.Lstatuspag") + ":" + StatusFinanceiro));

			writer.flush(); // Cria o conteúdo do arquivo.
			writer.newLine();// pula uma linha no arquivoescrever (result);
			writer.close(); // Fechando conexão e escrita do arquivo.

		} catch (IOException e) {

			e.printStackTrace(); // possibilita capturar qualquer erro que o
									// "io" venha ocasionar
			// printStackTrace ---> mostra a descrição do erro
		}
	}

	public String lerTcFinaceiro() {
		String campos = "";

		try {
			File file = new File("Sistema_Financeiro.txt");
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
