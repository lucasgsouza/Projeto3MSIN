package Projeto3MSIN;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.table.*;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;

import Projeto3MSIN.GUI_Idioma;

public class GUI_ConsultarAluno extends JInternalFrame {

	private JLabel Lra;
	private JTable table;
	private JTextField Tra;
	private JButton Bconsultarra, Btodos, Blimpar, Bsair;
	private JPanel pnTable;
	private JScrollPane scrollTable;
	DAO_Aluno AlunoDAO = new DAO_Aluno();
	TO_Aluno AlunoMODEL = new TO_Aluno();

	public GUI_ConsultarAluno() {

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

		painelNorth.setLayout(new GridLayout(1, 1));

		Lra = new JLabel(GUI_Idioma.bn.getString("Menu.Lra"));
		painelNorth.add(Lra);

		Tra = new JTextField();
		painelNorth.add(Tra);

		Bconsultarra = new JButton(GUI_Idioma.bn.getString("Menu.Bconsultarra"));
		painelNorth.add(Bconsultarra);

		// ADICIONA GRIDS NO BORDER ESPECIFICO

		North.add(painelNorth, BorderLayout.NORTH);

		// -------------------------------------------------------------

		// PainelSouth

		Panel painelSouth = new Panel();

		painelSouth.setLayout(new GridLayout(1, 2));

		// Botão

		Btodos = new JButton(GUI_Idioma.bn.getString("Menu.Bconsultartodos"));
		Blimpar = new JButton(GUI_Idioma.bn.getString("Menu.Blimpar"));
		Bsair = new JButton(GUI_Idioma.bn.getString("Menu.Bsair"));

		painelSouth.add(Btodos);
		painelSouth.add(Blimpar);
		painelSouth.add(Bsair);

		// ---------------------------------------------------------------

		add(principal); // adicona borderPrincipal
		principal.setBorder(new TitledBorder(""));
		setTitle(GUI_Idioma.bn.getString("Menu.Tituloconsultaraluno"));
		setSize(800, 300);// Altura //Largura
		setLocation(300, 800);
		setResizable(false);
		setVisible(true);

		// ----------------------------------------------------------------

		pnTable = new JPanel(new BorderLayout());
		scrollTable = new JScrollPane();

		DefaultTableModel tableModel = new DefaultTableModel(

		new String[] { (GUI_Idioma.bn.getString("Menu.Lra")), (GUI_Idioma.bn.getString("Menu.Lnome")),
				(GUI_Idioma.bn.getString("Menu.Lendereco")), (GUI_Idioma.bn.getString("Menu.Ltelefone")),
				(GUI_Idioma.bn.getString("Menu.Lemail")), (GUI_Idioma.bn.getString("Menu.Lrg")),
				(GUI_Idioma.bn.getString("Menu.Lcpf")) }, 0) {

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

		setTitle(GUI_Idioma.bn.getString("Menu.Tituloconsultaraluno"));

	}

	public void definirEventos() {

		Btodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (TO_Aluno a : AlunoDAO.consuAll()) {
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.addRow(new Object[] { a.getRa(), a.getNome(), a.getEndereco(), a.getTelefone(), a.getEmail(),
							a.getRG(), a.getCPF() }

					);
				}

			}
		});

		Bconsultarra.addActionListener(new ActionListener() {
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

				AlunoMODEL = AlunoDAO.Consultar(cod);

				int Ra;
				String Nome, Endereco, Telefone, Email, RG, CPF;
				Ra = AlunoMODEL.getRa();
				Nome = AlunoMODEL.getNome();
				Endereco = AlunoMODEL.getEndereco();
				Telefone = AlunoMODEL.getTelefone();
				Email = AlunoMODEL.getEmail();
				RG = AlunoMODEL.getRG();
				CPF = AlunoMODEL.getCPF();

				dtm.addRow(new Object[] { Ra, Nome, Endereco, Telefone, Email, RG, CPF });

			}

		});

		Blimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tra.setText("");
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				tableModel.setNumRows(0);

			}

		});
		Bsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tra.setText("");
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				tableModel.setNumRows(0);

				setVisible(false);
				dispose();

			}

		});

	}
}