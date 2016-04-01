package Projeto3MSIN;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import Projeto3MSIN.GUI_Idioma;

public class GUI_CadastrarAluno extends JInternalFrame {

	private JButton Bcadastrar, Bsair, Blimpar;
	private JLabel Lnome, Lendereco, Ltelefone, Lemail, Lrg, Lcpf;
	private JTextField Tnome, Temail,Tendereco;
	private JFormattedTextField Ttelefone, Trg, Tcpf;

	public GUI_CadastrarAluno() {
		inicializarComponentes();
		definirEventos();

	}

	public void inicializarComponentes() {

		// Border Painel principal
		JPanel principal = new JPanel();
		principal.setLayout(new BorderLayout());

		// -----------------------------------------------
		JPanel painelcadastro = new JPanel();
		painelcadastro.setBorder(BorderFactory.createEtchedBorder());
		painelcadastro.setLayout(new BorderLayout());

		Panel painellabelWest = new Panel();
		painellabelWest.setLayout(new GridLayout(6, 1));// Linhas e Coluna

		Lnome = new JLabel(GUI_Idioma.bn.getString("Menu.Lnome"));
		Lendereco = new JLabel(GUI_Idioma.bn.getString("Menu.Lendereco"));
		Ltelefone = new JLabel(GUI_Idioma.bn.getString("Menu.Ltelefone"));
		Lemail = new JLabel(GUI_Idioma.bn.getString("Menu.Lemail"));
		Lrg = new JLabel(GUI_Idioma.bn.getString("Menu.Lrg"));
		Lcpf = new JLabel(GUI_Idioma.bn.getString("Menu.Lcpf"));

		painellabelWest.add(Lnome);
		painellabelWest.add(Lendereco);
		painellabelWest.add(Ltelefone);
		painellabelWest.add(Lemail);
		painellabelWest.add(Lrg);
		painellabelWest.add(Lcpf);

		// ---------
		Panel paineltextcenter = new Panel();
		paineltextcenter.setLayout(new GridLayout(6, 1));

		Tnome = new JTextField("");
		Tendereco = new  JTextField(GUI_Idioma.bn.getString("Menu.Dendereco"));
		Ttelefone = new JFormattedTextField((setMascara("(**)*********")));

		Temail = new JTextField("");
		Trg = new JFormattedTextField((setMascara("**.***.***-*")));
		Tcpf = new JFormattedTextField((setMascara("***.***.***.**")));

		paineltextcenter.add(Tnome);
		paineltextcenter.add(Tendereco);
		paineltextcenter.add(Ttelefone);
		paineltextcenter.add(Temail);
		paineltextcenter.add(Trg);
		paineltextcenter.add(Tcpf);

		painelcadastro.add(painellabelWest, BorderLayout.WEST);
		painelcadastro.add(paineltextcenter, BorderLayout.CENTER);

		// ----------------------------------------------------
		Panel painelBotaoSouth = new Panel();
		painelBotaoSouth.setLayout(new GridLayout(1, 3));

		Bcadastrar = new JButton(GUI_Idioma.bn.getString("Menu.Bcadastrar"));
		Blimpar = new JButton(GUI_Idioma.bn.getString("Menu.Blimpartext"));
		Bsair = new JButton(GUI_Idioma.bn.getString("Menu.Bsair"));

		painelBotaoSouth.add(Bcadastrar);
		painelBotaoSouth.add(Blimpar);
		painelBotaoSouth.add(Bsair);

		// ----------------------------------------------------
		// AdicionaBorder ao painel Principal

		principal.add(painelcadastro, BorderLayout.CENTER);
		principal.add(painelBotaoSouth, BorderLayout.SOUTH);

		add(principal);
		setSize(800, 300);
		setLocation(300, 800);

		// Não permite alterar o tam da tela
		// setResizable(false);
		setVisible(true);
		principal.setBorder(new TitledBorder(""));
		setTitle(GUI_Idioma.bn.getString("Menu.Titulocadastraraluno"));
	}

	public void definirEventos() {
		Bsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
				setVisible(false);
				dispose();
			}
		});

		Bcadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CTRL_Aluno Controle = new CTRL_Aluno();

				Controle.AlunoInsert(0, Tnome.getText(), Tendereco.getText(), Ttelefone.getText(), Temail.getText(),
						Trg.getText(), Tcpf.getText());

				JOptionPane.showMessageDialog(null, GUI_Idioma.bn.getString("Menu.Messagem1"));
				Limpar();

			}
		});

		Blimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Limpar();
			}
		});

	}

	private MaskFormatter setMascara(String mascara) {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter(mascara);
		} catch (java.text.ParseException ex) {
		}
		return mask;
	}

	private void Limpar() {
		Tnome.setText("");
		Tendereco.setText(GUI_Idioma.bn.getString("Menu.Dendereco"));
		Ttelefone.setValue(null);
		Temail.setText("");
		Trg.setValue(null);
		Tcpf.setValue(null);

	}
}
