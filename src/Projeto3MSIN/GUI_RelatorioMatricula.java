package Projeto3MSIN;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class GUI_RelatorioMatricula extends JInternalFrame {

	private JButton Bsair, Bgerar, Blimpar;
	private JLabel Ldata;
	private JFormattedTextField Tdata;
	private TextArea textarea;
	private JScrollPane scroll;
	TO_Matricula MatriculaMODEL = new TO_Matricula();
	DAO_Matricula MatriculaDAO = new DAO_Matricula();
	String Data, StatusPag, StatusMat;
	int Matricula, CodCurso, Ra;
	float Valor;

	// Classes
	CTRL_Inicialização inicializacao = new CTRL_Inicialização();
	private ResourceBundle bn;

	public GUI_RelatorioMatricula() {
		inicializarComponentes();
		definirEventos();

	}

	public void inicializarComponentes() {
		// BorderPrincipal BorderLayout
		JPanel principal = new JPanel();
		principal.setLayout(new BorderLayout());

		// ---------------------------------------------------------
		// BorderNorth

		Panel North = new Panel();
		North.setLayout(new BorderLayout());

		// PainelNorth

		Panel painelNorth = new Panel();

		painelNorth.setLayout(new GridLayout(1, 3));

		Ldata = new JLabel(GUI_Idioma.bn.getString("Menu.Ldata"));
		painelNorth.add(Ldata);

		Tdata = new JFormattedTextField((setMascara("**/**/****")));
		painelNorth.add(Tdata);

		Bgerar = new JButton(GUI_Idioma.bn.getString("Menu.Bgerar"));
		painelNorth.add(Bgerar);

		// ADICIONA GRIDS NO BORDER ESPECIFICO

		North.add(painelNorth, BorderLayout.NORTH);

		// -------------------------------------------------------------

		// PainelSouth

		Panel painelSouth = new Panel();

		painelSouth.setLayout(new GridLayout(1, 2));

		// Botão

		Blimpar = new JButton(GUI_Idioma.bn.getString("Menu.Blimpartext"));
		Bsair = new JButton(GUI_Idioma.bn.getString("Menu.Bsair"));

		painelSouth.add(Blimpar);
		painelSouth.add(Bsair);

		// ---------------------------------------------------------------
		Panel painelCenter = new Panel();
		painelCenter.setLayout(new GridLayout(1, 1));

		textarea = new TextArea();
		textarea.setEditable(false);
		textarea.setColumns(72);
		textarea.setRows(3);
		scroll = new JScrollPane(textarea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		textarea.setBackground(Color.WHITE); // Define a cor de fundo
		painelCenter.add(textarea);

		// Tela Geral

		principal.add(North, BorderLayout.NORTH);
		principal.add(painelCenter, BorderLayout.CENTER);
		principal.add(painelSouth, BorderLayout.SOUTH);

		add(principal); // adicona borderPrincipal
		setTitle(GUI_Idioma.bn.getString("Menu.TituloRelatorioM"));
		setSize(800, 300);// Altura //Largura
		setLocation(300, 800);
		setResizable(false);
		setVisible(true);

	}

	public void definirEventos() {
		Bgerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String data = null;
				if (Tdata.getText().length() == 0) {
					data = null;
					JOptionPane.showMessageDialog(null, (GUI_Idioma.bn.getString("Menu.MessagemErro3")),
							(GUI_Idioma.bn.getString("Menu.TituloErro3")), JOptionPane.ERROR_MESSAGE);
				} else {
					data = Tdata.getText();
				}

				String Dados1 = "================================" + "Matricula Ativas "
						+ "================================";
				textarea.append(Dados1);

				for (TO_Matricula a : MatriculaDAO.consultarDataA(data)) {

					String Dados2 = "\n\nMatricula: " + a.getMatricula() + "\n\nData Matricula:" + a.getDataMatricula()
							+ "\n\nCodigo Curso: " + a.getCodigoCurso() + "\n\nValor: " + a.getValor()
							+ "\n\nRa do Aluno: " + a.getRaAluno() + "\n\n Status Matricula: " + a.getStatusMatricula()
							+ "\n\nStatus Pagamento: " + a.getStatusFinanceiro();

					textarea.append("\n" + Dados2 + "\n");

				}

			}
		});

		Bsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
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
		textarea.setText("");
	}
}
