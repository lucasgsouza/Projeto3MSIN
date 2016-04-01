package Projeto3MSIN;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.sql.SQLException;

import Projeto3MSIN.GUI_Idioma;

public class GUI_GerarUsuarios extends JFrame {

	// Classes
	CTRL_Inicialização inicializacao = new CTRL_Inicialização();
	GravarTXT_Atendente gravaAt = new GravarTXT_Atendente();
	GravarTXT_Aluno gravaAl = new GravarTXT_Aluno();
	Impressora prn = new Impressora();

	private JButton Bcadastrar, Bcancelar, Bconsultar;
	private JLabel Lusuario, Lsenha, Lnome;
	private static JTextField Tid, Tnome;
	private static JPasswordField Tsenha;
	private static JRadioButton Ratendente, Raluno;

	// Classes

	private ResourceBundle bn;

	public GUI_GerarUsuarios() {
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
		painelWest.setLayout(new GridLayout(3, 1));// Linhas e Coluna

		Lusuario = new JLabel(GUI_Idioma.bn.getString("Menu.Lid"));
		Lnome = new JLabel(GUI_Idioma.bn.getString("Menu.Lnome"));
		Lsenha = new JLabel(GUI_Idioma.bn.getString("Menu.Lnovasenha"));

		painelWest.add(Lusuario);
		painelWest.add(Lnome);
		painelWest.add(Lsenha);
		// -----------------------------------------------

		// Painel Campo de Texto e Senha

		Panel painelCenter = new Panel();
		painelCenter.setLayout(new GridLayout(3, 1));// Linhas e Coluna

		Tid = new JTextField();
		Tnome = new JTextField();
		Tsenha = new JPasswordField();

		painelCenter.add(Tid);
		painelCenter.add(Tnome);
		painelCenter.add(Tsenha);

		Tsenha.setEditable(false);

		// ----------------------------------------------------

		JPanel East = new JPanel();
		East.setBorder(BorderFactory.createEtchedBorder());
		East.setBorder(new TitledBorder(GUI_Idioma.bn.getString("Menu.Tperfil")));
		East.setLayout(new BorderLayout());

		Panel painelEast = new Panel();
		painelEast.setLayout(new GridLayout(2, 1));

		Ratendente = new JRadioButton(GUI_Idioma.bn.getString("Menu.Ratendente"));
		Raluno = new JRadioButton(GUI_Idioma.bn.getString("Menu.Raluno"));

		painelEast.add(Ratendente);
		painelEast.add(Raluno);

		East.add(painelEast);
		// ----------------------------------------------------

		// Painel de Botões
		Panel painelSouth = new Panel();
		painelSouth.setLayout(new GridLayout(1, 2));

		Bconsultar = new JButton(GUI_Idioma.bn.getString("Menu.Bconsultar"));
		Bcadastrar = new JButton(GUI_Idioma.bn.getString("Menu.Bcadastrar"));
		Bcancelar = new JButton(GUI_Idioma.bn.getString("Menu.Bcancelar"));

		painelSouth.add(Bconsultar);
		painelSouth.add(Bcadastrar);
		painelSouth.add(Bcancelar);

		Bcadastrar.setEnabled(false);
		;

		// ----------------------------------------------------
		// Adiciona Border ao painel Principal
		principal.add(painelWest, BorderLayout.WEST);
		principal.add(painelCenter, BorderLayout.CENTER);
		principal.add(painelSouth, BorderLayout.SOUTH);
		principal.add(East, BorderLayout.EAST);

		add(principal);

		setSize(300, 140);
		setLocation(200, 300);

		// Não permite alterar o tam da tela
		setResizable(false);
		setVisible(true);
		setTitle(GUI_Idioma.bn.getString("Menu.Lnovousuario"));

	}

	public void definirEventos() {
		Bcadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Tsenha.getText().length() == 0) {

					JOptionPane.showMessageDialog(null, (GUI_Idioma.bn.getString("Menu.MessagemErro1")),
							(GUI_Idioma.bn.getString("Menu.TituloErro1")), JOptionPane.ERROR_MESSAGE);

				}

				if (Tnome.getText().length() > 0 && Tsenha.getText().length() > 0) {
					if (Ratendente.isSelected()) {
						try {
							gravaAt.GravarTcAtendente(Tnome.getText(), Tsenha.getText());
							GravarCifradoAtendente();
							inicializacao.Acao_TelaLogin();
							dispose();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
					if (Raluno.isSelected()) {
						try {
							gravaAl.GravarTcAluno(Tnome.getText(), Tsenha.getText());
							GravarCifradoAluno();
							inicializacao.Acao_TelaLogin();
							dispose();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
			}
		});

		Bcancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				inicializacao.Acao_TelaLogin();
			}
		});

		Bconsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int R = 0, C = 0;
				String N = null, Nt = null;

				DAO_Aluno AlunoDAO = new DAO_Aluno();
				TO_Aluno AlunoMODEL = new TO_Aluno();
				DAO_Atendente AtendenteDAO = new DAO_Atendente();
				TO_Atendente AtendenteMODEL = new TO_Atendente();

				int cod = 0;
				String name = null;

				if (Tid.getText().length() == 0 || Tnome.getText().length() == 0) {

					JOptionPane.showMessageDialog(null, (GUI_Idioma.bn.getString("Menu.MessagemErro1")),
							(GUI_Idioma.bn.getString("Menu.TituloErro1")), JOptionPane.ERROR_MESSAGE);

				} else {
					cod = Integer.parseInt(Tid.getText());
					name = Tnome.getText();
					AlunoMODEL = AlunoDAO.Consultar(cod);
					AtendenteMODEL = AtendenteDAO.Consultar(cod);

					R = AlunoMODEL.getRa();
					N = AlunoMODEL.getNome();
					C = AtendenteMODEL.getCodigo();
					Nt = AtendenteMODEL.getNome();
				}

				if (cod == R && name.equals(N)) {

					Bcadastrar.setEnabled(true);
					Raluno.setSelected(true);
					Ratendente.setSelected(false);
					Ratendente.setEnabled(false);
					Tsenha.setEditable(true);
					Bconsultar.setEnabled(false);
					Tnome.setEditable(false);
					Tid.setEditable(false);

				} else if (cod == C && name.equals(Nt)) {

					Bcadastrar.setEnabled(true);
					Raluno.setSelected(false);
					Ratendente.setSelected(true);
					Raluno.setEnabled(false);
					Tsenha.setEditable(true);
					Bconsultar.setEnabled(false);
					Tnome.setEditable(false);
					Tid.setEditable(false);
				}

			}

		});

	}

	public void GravarCifradoAtendente() throws IOException, Exception {
		String sMsgClara = gravaAt.lerTCAtendente();

		String sMsgCifrada = null;
		String sMsgDecifrada = null;
		byte[] bMsgClara = null;
		byte[] bMsgCifrada = null;
		byte[] bMsgDecifrada = null;

		Impressora prn = new Impressora();

		// Converte o texto String dado no equivalente byte[]
		bMsgClara = sMsgClara.getBytes("ISO-8859-1");

		/*
		 * Criptografia Dummy
		 * ------------------------------------------------------------
		 */

		// Instancia um objeto da classe CryptoDummy
		CryptoDummy cdummy = new CryptoDummy();
		// Gera a chave criptografica Dummy simetrica e nome do arquivo onde
		// sera armazenada
		cdummy.geraChave(new File("chave1.dummy"));
		// Gera a cifra Dummy da mensagem dada, com a chave Dummy simetrica dada
		cdummy.geraCifra(bMsgClara, new File("chave1.dummy"));
		// Recebe o texto cifrado
		bMsgCifrada = cdummy.getTextoCifrado();
		// Converte o texto byte[] no equivalente String
		sMsgCifrada = (new String(bMsgCifrada, "ISO-8859-1"));

		// Grava TXT Mensagem Cifrada
		String gravar_DummyU = "Cifrado Dummy";
		String gravar_DummyS = "Cifrado Dummy";
		gravaAt.gravarTCIAtendente(gravar_DummyU, gravar_DummyS);
		gravaAt.gravarTCIAtendente(prn.hexBytesToString(bMsgCifrada), prn.hexBytesToString(bMsgCifrada));

		// Gera a decifra Dummy da mensagem dada, segundo a chave Dummy
		// simetrica gerada
		cdummy.geraDecifra(bMsgCifrada, new File("chave1.dummy"));
		// recebe o texto decifrado
		bMsgDecifrada = cdummy.getTextoDecifrado();
		// Converte o texto byte[] no equivalente String
		sMsgDecifrada = (new String(bMsgDecifrada, "ISO-8859-1"));
	}

	public void GravarCifradoAluno() throws IOException, Exception {
		String sMsgClara = gravaAl.lerTCAluno();

		String sMsgCifrada = null;
		String sMsgDecifrada = null;
		byte[] bMsgClara = null;
		byte[] bMsgCifrada = null;
		byte[] bMsgDecifrada = null;

		Impressora prn = new Impressora();

		// Converte o texto String dado no equivalente byte[]
		bMsgClara = sMsgClara.getBytes("ISO-8859-1");

		/*
		 * Criptografia Dummy
		 * ------------------------------------------------------------
		 */

		// Instancia um objeto da classe CryptoDummy
		CryptoDummy cdummy = new CryptoDummy();
		// Gera a chave criptografica Dummy simetrica e nome do arquivo onde
		// sera armazenada
		cdummy.geraChave(new File("chave1.dummy"));
		// Gera a cifra Dummy da mensagem dada, com a chave Dummy simetrica dada
		cdummy.geraCifra(bMsgClara, new File("chave1.dummy"));
		// Recebe o texto cifrado
		bMsgCifrada = cdummy.getTextoCifrado();
		// Converte o texto byte[] no equivalente String
		sMsgCifrada = (new String(bMsgCifrada, "ISO-8859-1"));

		// Grava TXT Mensagem Cifrada
		String gravar_DummyU = "Cifrado Dummy";
		String gravar_DummyS = "Cifrado Dummy";
		gravaAl.gravarTCIAluno(gravar_DummyU, gravar_DummyS);
		gravaAl.gravarTCIAluno(prn.hexBytesToString(bMsgCifrada), prn.hexBytesToString(bMsgCifrada));

		// Gera a decifra Dummy da mensagem dada, segundo a chave Dummy
		// simetrica gerada
		cdummy.geraDecifra(bMsgCifrada, new File("chave1.dummy"));
		// recebe o texto decifrado
		bMsgDecifrada = cdummy.getTextoDecifrado();
		// Converte o texto byte[] no equivalente String
		sMsgDecifrada = (new String(bMsgDecifrada, "ISO-8859-1"));
	}

}
