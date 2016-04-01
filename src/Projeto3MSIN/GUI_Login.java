package Projeto3MSIN;

import javax.swing.*;
import javax.xml.soap.SOAPHeader;

import org.apache.log4j.Logger;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

import Projeto3MSIN.GUI_Idioma;

public class GUI_Login extends JFrame {

	private JButton Bentrar, Bsair;
	private JLabel Lusuario, Lsenha;
	private static JTextField Tusuario;
	private static JPasswordField Tsenha;
	private String tuser, tpassword, tdecifrado;
	byte[] tcifrado;
	boolean ler;

	// Classes
	CTRL_Inicialização inicializacao = new CTRL_Inicialização();

	private ResourceBundle bn;

	public GUI_Login() {
		inicializarComponentes();
		definirEventos();

	}

	public void inicializarComponentes() {

		// Border Painel principal
		Panel principal = new Panel();
		principal.setLayout(new BorderLayout());
		// -----------------------------------------------

		// Painel Labels
		Panel painelWest = new Panel();
		painelWest.setLayout(new GridLayout(2, 1));// Linhas e Coluna

		Lusuario = new JLabel(GUI_Idioma.bn.getString("Menu.Lusuario"));
		Lsenha = new JLabel(GUI_Idioma.bn.getString("Menu.Lsenha"));

		painelWest.add(Lusuario);
		painelWest.add(Lsenha);
		// -----------------------------------------------

		// Painel Campo de Texto e Senha

		Panel painelCenter = new Panel();
		painelCenter.setLayout(new GridLayout(2, 1));// Linhas e Coluna

		Tusuario = new JTextField();
		Tsenha = new JPasswordField(10);

		painelCenter.add(Tusuario);
		painelCenter.add(Tsenha);

		// ----------------------------------------------------

		// Painel de Botões
		Panel painelSouth = new Panel();
		painelSouth.setLayout(new GridLayout(1, 2));

		Bentrar = new JButton(GUI_Idioma.bn.getString("Menu.Bentrar"));
		Bsair = new JButton(GUI_Idioma.bn.getString("Menu.Bsair"));
		painelSouth.add(Bentrar);
		painelSouth.add(Bsair);

		// ----------------------------------------------------
		// Adiciona Border ao painel Principal
		principal.add(painelWest, BorderLayout.WEST);
		principal.add(painelCenter, BorderLayout.CENTER);
		principal.add(painelSouth, BorderLayout.SOUTH);
		add(principal);

		setSize(250, 120);
		setLocation(200, 300);

		// Não permite alterar o tam da tela
		setResizable(false);
		setVisible(true);
		setTitle(GUI_Idioma.bn.getString("Menu.TituloTelalogin"));
	}

	public void definirEventos() {
		Bentrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Tusuario.getText().length() == 0 && Tsenha.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, (GUI_Idioma.bn.getString("Menu.MessagemErro1")),
							(GUI_Idioma.bn.getString("Menu.TituloErro1")), JOptionPane.ERROR_MESSAGE);
					int escolha = JOptionPane.showConfirmDialog(null, "Deseja Criar um novo Usuario ? ");
					if (escolha == JOptionPane.YES_OPTION) {
						inicializacao.Acao_GerarUsuarios();
						dispose();
					} else if (escolha == JOptionPane.NO_OPTION) {
						Tusuario.setText("");
						Tsenha.setText("");
						setVisible(true);
					} else if (escolha == JOptionPane.CANCEL_OPTION) {
						Tusuario.setText("");
						Tsenha.setText("");
						setVisible(true);
					}

				}

				if (Tusuario.getText().length() > 0 && Tsenha.getText().length() > 0) {

					try {
						Entrar();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}

		});

		Bsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CTRL_Inicialização inicialização = new CTRL_Inicialização();
				inicialização.Acao_TelaIdioma();
			}

		});

	}

	public void Entrar() throws Exception {

		String usuario = null, senha = null;
		if (ConfereAluno(usuario, senha, new File("src/Textos/texto_decifrado_Aluno.txt"))) {
			inicializacao.Acao_TelaPrincipalAluno();
			setVisible(false);
			dispose(); // dispensa janela

		} else if (ConfereAtendente(usuario, senha, new File("src/Textos/texto_decifrado_Atendente.txt"))) {
			inicializacao.Acao_TelaPrincipalAtendente();
			setVisible(false);
			dispose(); // dispensa janela
		} else {
			JOptionPane.showMessageDialog(null, (GUI_Idioma.bn.getString("Menu.MessagemErro2")),
					(GUI_Idioma.bn.getString("Menu.TituloErro2")), JOptionPane.ERROR_MESSAGE);
			int escolha = JOptionPane.showConfirmDialog(null, "Deseja Criar um novo Usuario ? ");
			if (escolha == JOptionPane.YES_OPTION) {
				inicializacao.Acao_GerarUsuarios();
				dispose();
			} else if (escolha == JOptionPane.NO_OPTION) {
				Tusuario.setText("");
				Tsenha.setText("");
				setVisible(true);
			} else if (escolha == JOptionPane.CANCEL_OPTION) {
				Tusuario.setText("");
				Tsenha.setText("");
				setVisible(true);
			}
		}
	}

	public static boolean ConfereAluno(String usuario, String senha, File texto_decifrado_Aluno) throws IOException {
		String usuarioLido = null, senhaLida = null;

		Properties p = new Properties();
		p.load(new FileInputStream(texto_decifrado_Aluno));
		usuarioLido = p.getProperty("usuario");
		senhaLida = p.getProperty("senha");
		return usuarioLido.equals(Tusuario.getText()) && senhaLida.equals(Tsenha.getText());

	}

	public static boolean ConfereAtendente(String usuario, String senha, File texto_decifrado_Atendente)

	throws IOException {

		Properties p = new Properties();
		p.load(new FileInputStream(texto_decifrado_Atendente));
		String usuarioLido = p.getProperty("usuario");
		String senhaLida = p.getProperty("senha");
		return usuarioLido.equals(Tusuario.getText()) && senhaLida.equals(Tsenha.getText());

	}

}
