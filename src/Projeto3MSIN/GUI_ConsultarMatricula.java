package Projeto3MSIN;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.table.*;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;

import Projeto3MSIN.GUI_Idioma;

public class GUI_ConsultarMatricula extends JInternalFrame {

	private JLabel LRa;
	private JTable table;
	private JTextField Tra;
	private JButton BmAtiva, BmCancelada, Btodos, Blimpar, Bsair, BporRa, BporMatricula;
	private JPanel pnTable;
	private JScrollPane scrollTable;
	TO_Matricula MatriculaMODEL = new TO_Matricula();
	DAO_Matricula MatriculaDAO = new DAO_Matricula();
	String Data, StatusPag, StatusMat;
	int Matricula, CodCurso, Ra;
	float Valor;

	public GUI_ConsultarMatricula() {

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

		painelNorth.setLayout(new GridLayout(1, 2));

		LRa = new JLabel(GUI_Idioma.bn.getString("Menu.Lentrecom"));
		painelNorth.add(LRa);

		Tra = new JTextField();
		painelNorth.add(Tra);

		BporRa = new JButton(GUI_Idioma.bn.getString("Menu.BporRa"));
		BporMatricula = new JButton(GUI_Idioma.bn.getString("Menu.BporMatricula"));
		painelNorth.add(BporRa);
		painelNorth.add(BporMatricula);

		// ADICIONA GRIDS NO BORDER ESPECIFICO

		North.add(painelNorth, BorderLayout.NORTH);

		// -------------------------------------------------------------

		// PainelSouth

		Panel painelSouth = new Panel();

		painelSouth.setLayout(new GridLayout(1, 2));

		// Botão
		BmAtiva = new JButton(GUI_Idioma.bn.getString("Menu.BporMatricula"));
		BmAtiva = new JButton(GUI_Idioma.bn.getString("Menu.Bmatativa"));
		BmCancelada = new JButton(GUI_Idioma.bn.getString("Menu.Bmatcanceladas"));
		Btodos = new JButton(GUI_Idioma.bn.getString("Menu.Blistartodos"));
		Blimpar = new JButton(GUI_Idioma.bn.getString("Menu.Blimpar"));
		Bsair = new JButton(GUI_Idioma.bn.getString("Menu.Bsair"));

		painelSouth.add(BmAtiva);
		painelSouth.add(BmCancelada);
		painelSouth.add(Btodos);
		painelSouth.add(Blimpar);
		painelSouth.add(Bsair);

		// ---------------------------------------------------------------

		add(principal); // adicona borderPrincipal
		principal.setBorder(new TitledBorder(""));
		setTitle(GUI_Idioma.bn.getString("Menu.Tituloconsultarmatricula"));
		setSize(800, 300);// Altura //Largura
		setLocation(300, 800);
		setResizable(false);
		setVisible(true);

		// ----------------------------------------------------------------

		pnTable = new JPanel(new BorderLayout());
		scrollTable = new JScrollPane();

		DefaultTableModel tableModel = new DefaultTableModel(

		new String[] {

				(GUI_Idioma.bn.getString("Menu.Menumatricula")), (GUI_Idioma.bn.getString("Menu.Ldatamatricula")),
				(GUI_Idioma.bn.getString("Menu.Lcodigocurso")), (GUI_Idioma.bn.getString("Menu.Lvalor")),
				(GUI_Idioma.bn.getString("Menu.Lra")), (GUI_Idioma.bn.getString("Menu.Lstatusmat")),
				(GUI_Idioma.bn.getString("Menu.Lstatuspag")), }, 0) {

			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		table = new JTable(tableModel);
		DefaultTableCellRenderer alinhaDireita = new DefaultTableCellRenderer();
		alinhaDireita.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setCellRenderer(alinhaDireita);

		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setCellRenderer(alinhaDireita);

		table.getColumnModel().getColumn(2).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setCellRenderer(alinhaDireita);

		table.getColumnModel().getColumn(3).setPreferredWidth(180);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setCellRenderer(alinhaDireita);

		table.getColumnModel().getColumn(4).setPreferredWidth(220);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setCellRenderer(alinhaDireita);

		table.getColumnModel().getColumn(5).setPreferredWidth(220);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setCellRenderer(alinhaDireita);

		table.getColumnModel().getColumn(6).setPreferredWidth(220);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setCellRenderer(alinhaDireita);

		table.getTableHeader().setReorderingAllowed(false);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		scrollTable.setViewportView(table);

		pnTable.add(scrollTable);

		// Tela Geral

		principal.add(pnTable, BorderLayout.CENTER);
		principal.add(North, BorderLayout.NORTH);
		principal.add(painelSouth, BorderLayout.SOUTH);

		setTitle(GUI_Idioma.bn.getString("Menu.Tituloconsultarmatricula"));

	}

	public void definirEventos() {

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
		BmAtiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (TO_Matricula a : MatriculaDAO.consuAllAtivas()) {
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.addRow(new Object[] { a.getMatricula(), a.getDataMatricula(), a.getCodigoCurso(), a.getValor(),
							a.getRaAluno(), a.getStatusMatricula(), a.getStatusFinanceiro() }

					);
				}

			}
		});

		Btodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (TO_Matricula a : MatriculaDAO.consuAll()) {
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.addRow(new Object[] { a.getMatricula(), a.getDataMatricula(), a.getCodigoCurso(), a.getValor(),
							a.getRaAluno(), a.getStatusMatricula(), a.getStatusFinanceiro() }

					);
				}

			}
		});

		BmCancelada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (TO_Matricula a : MatriculaDAO.consuAllCanceladas()) {
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.addRow(new Object[] { a.getMatricula(), a.getDataMatricula(), a.getCodigoCurso(), a.getValor(),
							a.getRaAluno(), a.getStatusMatricula(), a.getStatusFinanceiro() }

					);
				}

			}
		});

		BporMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				int cod = 0;
				if (Tra.getText().length() == 0) {
					cod = 0;
					JOptionPane.showMessageDialog(null, (GUI_Idioma.bn.getString("Menu.MessagemErro3")),
							(GUI_Idioma.bn.getString("Menu.TituloErro3")), JOptionPane.ERROR_MESSAGE);
				} else {
					cod = Integer.parseInt(Tra.getText());
				}

				MatriculaMODEL = MatriculaDAO.Consultar(cod);

				Matricula = MatriculaMODEL.getMatricula();
				Data = MatriculaMODEL.getDataMatricula();
				CodCurso = MatriculaMODEL.getCodigoCurso();
				Valor = MatriculaMODEL.getValor();
				Ra = MatriculaMODEL.getRaAluno();
				StatusMat = MatriculaMODEL.getStatusMatricula();
				StatusPag = MatriculaMODEL.getStatusFinanceiro();
				dtm.addRow(new Object[] { Matricula, Data, CodCurso, Valor, Ra, StatusMat, StatusPag });

			}
		});

		BporRa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int cod = 0;
				if (Tra.getText().length() == 0) {
					cod = 0;
					JOptionPane.showMessageDialog(null, (GUI_Idioma.bn.getString("Menu.MessagemErro3")),
							(GUI_Idioma.bn.getString("Menu.TituloErro3")), JOptionPane.ERROR_MESSAGE);
				} else {
					cod = Integer.parseInt(Tra.getText());
				}

				for (TO_Matricula a : MatriculaDAO.consuAllRa(cod)) {
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.addRow(new Object[] { a.getMatricula(), a.getDataMatricula(), a.getCodigoCurso(), a.getValor(),
							a.getRaAluno(), a.getStatusMatricula(), a.getStatusFinanceiro() }

					);
				}

			}
		});

	}

	private void Limpar() {
		Tra.setText("");
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setNumRows(0);

	}
}
