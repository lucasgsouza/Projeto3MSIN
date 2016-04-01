package Projeto3MSIN;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;

import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import Projeto3MSIN.GUI_Idioma;

public class GUI_CadastrarCurso extends JInternalFrame {

	private JButton Bcadastrar, Bsair, Blimpar;
	private JLabel Lnome, Ldatainicio, Ldatafim, Lhorario, Lnvagas, Lvalor, Llab, Lmateriais, Ldescricao;
	private JCheckBox Cinformatica, Cartes;
	private JComboBox CBHorario;
	private JTextField Tnome, Tcodigo, Tnvagas, Tlab, Tmateriais, Tdescricao;
	private JFormattedTextField Tdatainicio, Tdatafim, Tvalor;

	public GUI_CadastrarCurso() {
		inicializarComponentes();
		definirEventos();
		Select();

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
		painellabelWest.setLayout(new GridLayout(7, 1));// Linhas e Coluna

		Lnome = new JLabel(GUI_Idioma.bn.getString("Menu.Lnomedocurso"));
		Ldatainicio = new JLabel(GUI_Idioma.bn.getString("Menu.Ldatainicio"));
		Ldatafim = new JLabel(GUI_Idioma.bn.getString("Menu.Ldatafim"));
		Lhorario = new JLabel(GUI_Idioma.bn.getString("Menu.Lhorario"));
		Lnvagas = new JLabel(GUI_Idioma.bn.getString("Menu.Lnvagas"));
		Lvalor = new JLabel(GUI_Idioma.bn.getString("Menu.Lvalor"));

		painellabelWest.add(Lnome);
		painellabelWest.add(Ldatainicio);
		painellabelWest.add(Ldatafim);
		painellabelWest.add(Lhorario);
		painellabelWest.add(Lnvagas);
		painellabelWest.add(Lvalor);

		// ---------
		Panel paineltextcenter = new Panel();
		paineltextcenter.setLayout(new GridLayout(7, 1));

		String[] Hora = { "Selecione", "7:10 até 8:50", "9:10 até 10:50", "13:10 até 14:50", "15:10 até 16:50",
				"17:10 até 18:50" };

		Tnome = new JTextField();
		Tdatainicio = new JFormattedTextField((setMascara("**/**/****")));
		Tdatafim = new JFormattedTextField((setMascara("**/**/****")));
		CBHorario = new JComboBox(Hora);
		CBHorario.setEditable(false);
		Tnvagas = new JTextField(10);
		Tvalor = new JFormattedTextField((setMascara("***.**")));

		paineltextcenter.add(Tnome);
		paineltextcenter.add(Tdatainicio);
		paineltextcenter.add(Tdatafim);
		paineltextcenter.add(CBHorario);
		paineltextcenter.add(Tnvagas);
		paineltextcenter.add(Tvalor);

		painelcadastro.add(painellabelWest, BorderLayout.WEST);
		painelcadastro.add(paineltextcenter, BorderLayout.CENTER);

		// -----------------------------------------------
		JPanel cadastrocheck1 = new JPanel();
		cadastrocheck1.setLayout(new BorderLayout());

		JPanel cadastrocheck2 = new JPanel();
		cadastrocheck2.setBorder(BorderFactory.createEtchedBorder());
		cadastrocheck2.setBorder(new TitledBorder(GUI_Idioma.bn.getString("Menu.Larea")));
		cadastrocheck2.setLayout(new BorderLayout());

		Panel painelcheckcenter = new Panel();
		painelcheckcenter.setLayout(new GridLayout(2, 1));

		Cinformatica = new JCheckBox(GUI_Idioma.bn.getString("Menu.Menuinformatica"));
		Cartes = new JCheckBox(GUI_Idioma.bn.getString("Menu.Menuartes"));

		painelcheckcenter.add(Cinformatica);
		painelcheckcenter.add(Cartes);

		cadastrocheck2.add(painelcheckcenter, BorderLayout.WEST);

		// ---------
		JPanel cadastrolab = new JPanel();
		cadastrolab.setBorder(BorderFactory.createEtchedBorder());
		cadastrolab.setBorder(new TitledBorder("Exclusivo"));
		cadastrolab.setLayout(new BorderLayout());

		Panel painellabcenter = new Panel();
		painellabcenter.setLayout(new GridLayout(3, 1));

		Llab = new JLabel(GUI_Idioma.bn.getString("Menu.Llab"));
		Ldescricao = new JLabel(GUI_Idioma.bn.getString("Menu.Ldescricao"));
		Lmateriais = new JLabel(GUI_Idioma.bn.getString("Menu.Lmateriais"));

		Tlab = new JTextField("");
		Tdescricao = new JTextField("");
		Tmateriais = new JTextField(GUI_Idioma.bn.getString("Menu.Tregistro"));

		painellabcenter.add(Llab);
		painellabcenter.add(Tlab);
		painellabcenter.add(Ldescricao);
		painellabcenter.add(Tdescricao);
		painellabcenter.add(Lmateriais);
		painellabcenter.add(Tmateriais);

		cadastrolab.add(painellabcenter, BorderLayout.CENTER);
		cadastrocheck1.add(cadastrocheck2, BorderLayout.SOUTH);

		cadastrocheck1.add(cadastrolab, BorderLayout.CENTER);
		// ----------------------------------------------------
		Panel painelBotaoSouth = new Panel();
		painelBotaoSouth.setLayout(new GridLayout(1, 3));

		Bcadastrar = new JButton(GUI_Idioma.bn.getString("Menu.Bcadastrar"));
		Bsair = new JButton(GUI_Idioma.bn.getString("Menu.Bsair"));
		Blimpar = new JButton(GUI_Idioma.bn.getString("Menu.Blimpar"));

		painelBotaoSouth.add(Bcadastrar);
		painelBotaoSouth.add(Blimpar);
		painelBotaoSouth.add(Bsair);

		// ----------------------------------------------------
		// AdicionaBorder ao painel Principal

		principal.add(painelcadastro, BorderLayout.CENTER);
		principal.add(cadastrocheck1, BorderLayout.EAST);
		principal.add(painelBotaoSouth, BorderLayout.SOUTH);

		add(principal);
		setSize(800, 300);
		setLocation(300, 800);

		// Não permite alterar o tam da tela
		// setResizable(false);
		setVisible(true);
		principal.setBorder(new TitledBorder(""));
		setTitle(GUI_Idioma.bn.getString("Menu.Titulocadastrarcurso"));
	}

	public void definirEventos() {
		Bsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
				setVisible(false);
				dispose();
			}
		});

		Blimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();

			}
		});

		Bcadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String I = "I";
				String A = "A";
				CTRL_Curso Controle = new CTRL_Curso();

				// Manda pro Controle o conteudo dos TextFilds.getText

				if (Cinformatica.isSelected()) {

					Controle.CursoInsert(0, Tnome.getText(), Tdatainicio.getText(), Tdatafim.getText(),
							CBHorario.getSelectedItem().toString(), Integer.parseInt(Tnvagas.getText()),
							Float.parseFloat(Tvalor.getText()), Integer.parseInt(Tnvagas.getText()),
							Tdescricao.getText(), Tmateriais.getText(), I);
					JOptionPane.showMessageDialog(null, GUI_Idioma.bn.getString("Menu.Messagem1"));
					Limpar();

				} else if (Cartes.isSelected()) {
					Controle.CursoInsert(0, Tnome.getText(), Tdatainicio.getText(), Tdatafim.getText(),
							CBHorario.getSelectedItem().toString(), Integer.parseInt(Tnvagas.getText()),
							Float.parseFloat(Tvalor.getText()), Integer.parseInt(Tnvagas.getText()),
							Tdescricao.getText(), Tmateriais.getText(), A);
					JOptionPane.showMessageDialog(null, GUI_Idioma.bn.getString("Menu.Messagem1"));
					Limpar();

				}

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
		String[] Hora = { "Selecione", "7:10 até 8:50", "9:10 até 10:50", "13:10 até 14:50", "15:10 até 16:50",
				"17:10 até 18:50" };
		Tnome.setText("");
		Tdatainicio.setValue(null);
		Tdatafim.setValue(null);
		CBHorario.setSelectedItem(Hora);
		Tnvagas.setText("");
		Tvalor.setValue(null);
		Cinformatica.setSelected(false);
		Cartes.setSelected(false);
		Tlab.setText("");
		Tdescricao.setText("");
		Tmateriais = new JTextField(GUI_Idioma.bn.getString("Menu.Tregistro"));

	}

	private void Select() {
		Cinformatica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Cinformatica.isSelected()) {
					Cartes.setEnabled(false);
				} else {
					Cartes.setEnabled(true);

				}
			}
		}

		);
		Cartes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Cartes.isSelected()) {
					Cinformatica.setEnabled(false);
				} else {
					Cinformatica.setEnabled(true);

				}
			}
		}

		);

	}

}
