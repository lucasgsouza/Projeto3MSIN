package Projeto3MSIN;

import javax.swing.*;

import org.apache.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;

public class GUI_Idioma extends JFrame {

	// Componentes da Tela
	private JButton Bentrar, Bsair;
	private JRadioButton Rportugues, Ringles, Respanhol;
	private JLabel jpgBrasil, jpgEUA, jpgEspanha;

	// Classe controle
	CTRL_Inicialização inicialização = new CTRL_Inicialização();
	public static ResourceBundle bn = null;

	public GUI_Idioma() {
		// Classes
		inicializarComponentes();
		definirEventos();
		AcaoJRadioButton();

	}

	public void inicializarComponentes() {

		// Border Painel Principal
		Panel principal = new Panel();
		principal.setLayout(new BorderLayout());

		// ----------------------------------------------------

		// Painel com labels
		Panel painelCenter = new Panel();
		painelCenter.setLayout(new GridLayout(3, 1));// Linhas e Coluna

		Rportugues = new JRadioButton("Português-Portuguese");
		Ringles = new JRadioButton("Inglês-English");
		Respanhol = new JRadioButton("Espanhol-Espanõl");

		// Adiciona labels ao painel
		painelCenter.add(Rportugues);
		painelCenter.add(Ringles);
		painelCenter.add(Respanhol);

		// ----------------------------------------------------

		// Painel com Botões
		Panel painelSouth = new Panel();
		painelSouth.setLayout(new GridLayout(1, 2));

		Bentrar = new JButton("OK");
		Bsair = new JButton("Sair");

		// Adiciona botões ao painel
		painelSouth.add(Bentrar);
		painelSouth.add(Bsair);

		// ----------------------------------------------------

		// Painel com Imagens
		Panel painelEast = new Panel();
		painelEast.setLayout(new GridLayout(3, 1));

		ImageIcon imgbrasil = new ImageIcon(GUI_Idioma.class.getResource("/Imagem/bandeira_Brasil.jpg"));
		jpgBrasil = new JLabel(imgbrasil);

		ImageIcon imgEUA = new ImageIcon(GUI_Idioma.class.getResource("/Imagem/bandeira_EUA.jpg"));
		jpgEUA = new JLabel(imgEUA);

		ImageIcon imgEsp = new ImageIcon(GUI_Idioma.class.getResource("/Imagem/bandeira_Espanha.jpg"));
		jpgEspanha = new JLabel(imgEsp);

		// Adiciona imagens ao painel

		painelEast.add(jpgBrasil);
		painelEast.add(jpgEUA);
		painelEast.add(jpgEspanha);

		// ----------------------------------------------------

		// Organização da Tela de forma Geral

		// Adiciona Border ao painel Principal
		principal.add(painelCenter, BorderLayout.CENTER);
		principal.add(painelSouth, BorderLayout.SOUTH);
		principal.add(painelEast, BorderLayout.EAST);
		add(principal);

		setSize(280, 180);
		setLocation(200, 300);

		// Não permite alterar o tam da tela
		setResizable(false);
		setVisible(true);

	}

	// Selecionar Apenas Um RadioButton
	public void AcaoJRadioButton() {
		Rportugues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Rportugues.isSelected()) {

					Ringles.setEnabled(false);
					Respanhol.setEnabled(false);
					jpgEUA.setEnabled(false);
					jpgEspanha.setEnabled(false);

				}

				else {

					Ringles.setEnabled(true);
					Respanhol.setEnabled(true);
					jpgEUA.setEnabled(true);
					jpgEspanha.setEnabled(true);

				}
			}
		}

		);

		Ringles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Ringles.isSelected()) {

					Rportugues.setEnabled(false);
					Respanhol.setEnabled(false);
					jpgBrasil.setEnabled(false);
					jpgEspanha.setEnabled(false);

				}

				else {

					Rportugues.setEnabled(true);
					Respanhol.setEnabled(true);
					jpgBrasil.setEnabled(true);
					jpgEspanha.setEnabled(true);

				}
			}
		}

		);

		Respanhol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Respanhol.isSelected()) {

					Ringles.setEnabled(false);
					Rportugues.setEnabled(false);
					jpgEUA.setEnabled(false);
					jpgBrasil.setEnabled(false);

				}

				else {

					Ringles.setEnabled(true);
					Rportugues.setEnabled(true);
					jpgEUA.setEnabled(true);
					jpgBrasil.setEnabled(true);

				}
			}
		}

		);

	}

	public void definirEventos() {// Acão dos Botões
		Bentrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Teste somente para "entra" na proxima tela
				// Futuramente implementar internacionalização

				if (Rportugues.isSelected()) {
					bn = ResourceBundle.getBundle("ex1", new Locale("pt", "BR"));
					inicialização.Acao_TelaLogin();
					dispose();

				}

				if (Ringles.isSelected()) {
					bn = ResourceBundle.getBundle("ex1", new Locale("en", "US"));
					inicialização.Acao_TelaLogin();
					dispose();

				}

				if (Respanhol.isSelected()) {
					bn = ResourceBundle.getBundle("ex1", new Locale("es", "ES"));
					inicialização.Acao_TelaLogin();
					dispose();

				}

			}
		});

		Bsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
	}

}
