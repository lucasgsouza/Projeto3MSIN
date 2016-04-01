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

public class GUI_AlterarCurso extends JInternalFrame {

	private JButton Balterar, Bsair, Bconsultar;
	private JLabel Lnome, Lcodigo, Ldatainicio, Ldatafim, Lhorario, Lnvagas, Lvalor, Llab, Lmateriais, Ldescricao;
	private JCheckBox Cinformatica, Cartes;
	private JComboBox CBHorario;
	private JTextField Tnome, Tcodigo, Tnvagas, Tlab, Tmateriais, Tdescricao;
	private JFormattedTextField Tdatainicio, Tdatafim, Tvalor;

	public GUI_AlterarCurso() {
		inicializarComponentes();
		definirEventos();
		Select();

	}

	public void inicializarComponentes() {

		// Border Painel principal
		JPanel principal = new JPanel();
		principal.setLayout(new BorderLayout());

		// -----------------------------------------------
		JPanel painelalterar = new JPanel();
		painelalterar.setBorder(BorderFactory.createEtchedBorder());
		painelalterar.setLayout(new BorderLayout());

		Panel painellabelWest = new Panel();
		painellabelWest.setLayout(new GridLayout(7, 1));// Linhas e Coluna

		Lcodigo = new JLabel(GUI_Idioma.bn.getString("Menu.Lcodigo"));
		Lnome = new JLabel(GUI_Idioma.bn.getString("Menu.Lnomedocurso"));
		Ldatainicio = new JLabel(GUI_Idioma.bn.getString("Menu.Ldatainicio"));
		Ldatafim = new JLabel(GUI_Idioma.bn.getString("Menu.Ldatafim"));
		Lhorario = new JLabel(GUI_Idioma.bn.getString("Menu.Lhorario"));
		Lnvagas = new JLabel(GUI_Idioma.bn.getString("Menu.Lnvagas"));
		Lvalor = new JLabel(GUI_Idioma.bn.getString("Menu.Lvalor"));

		painellabelWest.add(Lcodigo);
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

		Tcodigo = new JTextField((GUI_Idioma.bn.getString("Menu.Tinsiracodigo")));
		Tnome = new JTextField();
		Tdatainicio = new JFormattedTextField((setMascara("**/**/****")));
		Tdatafim = new JFormattedTextField((setMascara("**/**/****")));
		CBHorario = new JComboBox(Hora);
		Tnvagas = new JTextField(10);
		Tvalor = new JFormattedTextField((setMascara("***.**")));

		paineltextcenter.add(Tcodigo);
		paineltextcenter.add(Tnome);
		paineltextcenter.add(Tdatainicio);
		paineltextcenter.add(Tdatafim);
		paineltextcenter.add(CBHorario);
		paineltextcenter.add(Tnvagas);
		paineltextcenter.add(Tvalor);

		painelalterar.add(painellabelWest, BorderLayout.WEST);
		painelalterar.add(paineltextcenter, BorderLayout.CENTER);

		// -----------------------------------------------
		JPanel alterarcheck1 = new JPanel();
		alterarcheck1.setLayout(new BorderLayout());

		Bconsultar = new JButton(GUI_Idioma.bn.getString("Menu.Bconsultar"));

		alterarcheck1.add(Bconsultar, BorderLayout.NORTH);

		JPanel alterarcheck2 = new JPanel();
		alterarcheck2.setBorder(BorderFactory.createEtchedBorder());
		alterarcheck2.setBorder(new TitledBorder(GUI_Idioma.bn.getString("Menu.Larea")));
		alterarcheck2.setLayout(new BorderLayout());

		Panel painelcheckcenter = new Panel();
		painelcheckcenter.setLayout(new GridLayout(2, 1));

		Cinformatica = new JCheckBox(GUI_Idioma.bn.getString("Menu.Menuinformatica"));
		Cartes = new JCheckBox(GUI_Idioma.bn.getString("Menu.Menuartes"));

		painelcheckcenter.add(Cinformatica);
		painelcheckcenter.add(Cartes);

		alterarcheck2.add(painelcheckcenter, BorderLayout.WEST);

		// ---------
		JPanel alterarlab = new JPanel();
		alterarlab.setBorder(BorderFactory.createEtchedBorder());
		alterarlab.setBorder(new TitledBorder(GUI_Idioma.bn.getString("Menu.Lexclusivo")));
		alterarlab.setLayout(new BorderLayout());

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

		alterarlab.add(painellabcenter, BorderLayout.CENTER);

		alterarcheck1.add(alterarcheck2, BorderLayout.SOUTH);
		alterarcheck1.add(alterarlab, BorderLayout.CENTER);

		// ----------------------------------------------------
		Panel painelBotaoSouth = new Panel();
		painelBotaoSouth.setLayout(new GridLayout(1, 3));

		Balterar = new JButton(GUI_Idioma.bn.getString("Menu.Balterar"));
		Bsair = new JButton(GUI_Idioma.bn.getString("Menu.Bsair"));

		painelBotaoSouth.add(Balterar);
		painelBotaoSouth.add(Bsair);

		// ----------------------------------------------------
		// AdicionaBorder ao painel Principal

		principal.add(painelalterar, BorderLayout.CENTER);
		principal.add(alterarcheck1, BorderLayout.EAST);
		principal.add(painelBotaoSouth, BorderLayout.SOUTH);

		add(principal);
		setSize(800, 300);
		setLocation(300, 800);

		// Não permite alterar o tam da tela
		// setResizable(false);
		setVisible(true);
		setTitle(GUI_Idioma.bn.getString("Menu.Tituloalterarcurso"));
	}

	public void definirEventos() {
		Bsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
				setVisible(false);
				dispose();
			}
		});

		Bconsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Tcodigo.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, (GUI_Idioma.bn.getString("Menu.MessagemErro3")),
							(GUI_Idioma.bn.getString("Menu.TituloErro3")), JOptionPane.ERROR_MESSAGE);
				} else {
					TO_Curso CursoMODEL = new TO_Curso();
					DAO_Curso CursoDAO = new DAO_Curso();

					TO_Curso a = CursoDAO.Consultar(Integer.parseInt(Tcodigo.getText()));

					Tnome.setText(a.getNomeCurso());
					Tdatainicio.setText(a.getDataInicio());
					Tdatafim.setText(a.getDataFim());
					CBHorario.setSelectedItem(a.getHorario());
					Tnvagas.setText(Integer.toString(a.getNumeroVagas()));
					Tvalor.setText(Float.toString(a.getValor()));
					if (a.getArea().equals("I")) {
						Cinformatica.setSelected(true);

					} else if (a.getArea().equals("A")) {
						Cartes.setSelected(true);

					}

					Tlab.setText(Integer.toString(a.getLabSala()));
					Tdescricao.setText(a.getDescricao());
					Tmateriais.setText(a.getMatSoftwares());
					Tcodigo.setEditable(false);
				}

			}
		});

		Balterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String I = "I";
				String A = "A";
				CTRL_Curso Controle = new CTRL_Curso();

				// Manda pro Controle o conteudo dos TextFilds.getText

				if (Cinformatica.isSelected()) {

					Controle.CursoUpdate(Integer.parseInt(Tcodigo.getText()), Tnome.getText(), Tdatainicio.getText(),
							Tdatafim.getText(), CBHorario.getSelectedItem().toString(),
							Integer.parseInt(Tnvagas.getText()), Float.parseFloat(Tvalor.getText()),
							Integer.parseInt(Tnvagas.getText()), Tdescricao.getText(), Tmateriais.getText(), I);
					JOptionPane.showMessageDialog(null, GUI_Idioma.bn.getString("Menu.Messagem2"));
					Limpar();

				} else if (Cartes.isSelected()) {
					Controle.CursoInsert(Integer.parseInt(Tcodigo.getText()), Tnome.getText(), Tdatainicio.getText(),
							Tdatafim.getText(), CBHorario.getSelectedItem().toString(),
							Integer.parseInt(Tnvagas.getText()), Float.parseFloat(Tvalor.getText()),
							Integer.parseInt(Tnvagas.getText()), Tdescricao.getText(), Tmateriais.getText(), A);
					JOptionPane.showMessageDialog(null, GUI_Idioma.bn.getString("Menu.Messagem2"));
					Limpar();

				}

			}
		});

		Bsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
				setVisible(false);
				dispose();
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
