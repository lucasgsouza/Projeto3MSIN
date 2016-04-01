package Projeto3MSIN;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.table.*;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;

import Projeto3MSIN.GUI_Idioma;

public class GUI_ExcluirCurso extends JInternalFrame {

	private JLabel Lcodigo;
	private JTable table;
	private JTextField Tcodigo;
	private JButton Bconsultar, Bexcluir, Blimpar, Bsair;
	private JPanel pnTable;
	private JScrollPane scrollTable;

	public GUI_ExcluirCurso() {

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

		Lcodigo = new JLabel(GUI_Idioma.bn.getString("Menu.Lcodigo"));
		painelNorth.add(Lcodigo);

		Tcodigo = new JTextField();
		painelNorth.add(Tcodigo);

		Bconsultar = new JButton(GUI_Idioma.bn.getString("Menu.Bconsultarcodcurso"));
		painelNorth.add(Bconsultar);

		// ADICIONA GRIDS NO BORDER ESPECIFICO
		North.add(painelNorth, BorderLayout.NORTH);

		// -------------------------------------------------------------

		// PainelSouth

		Panel painelSouth = new Panel();
		painelSouth.setLayout(new GridLayout(1, 2));

		// Botão

		Bexcluir = new JButton(GUI_Idioma.bn.getString("Menu.Bexcluir"));
		Blimpar = new JButton(GUI_Idioma.bn.getString("Menu.Blimpar"));
		Bsair = new JButton(GUI_Idioma.bn.getString("Menu.Bsair"));

		painelSouth.add(Bexcluir);
		painelSouth.add(Blimpar);
		painelSouth.add(Bsair);

		// ---------------------------------------------------------------

		add(principal); // adicona borderPrincipal
		principal.setBorder(new TitledBorder(""));
		setTitle(GUI_Idioma.bn.getString("Menu.Tituloexcluircurso"));
		setSize(800, 300);// Altura //Largura
		setLocation(300, 800);
		setResizable(false);
		setVisible(true);

		// ----------------------------------------------------------------

		pnTable = new JPanel(new BorderLayout());
		scrollTable = new JScrollPane();

		DefaultTableModel tableModel = new DefaultTableModel(

		new String[] { (GUI_Idioma.bn.getString("Menu.Lcodigo")), (GUI_Idioma.bn.getString("Menu.Lnomedocurso")),
				(GUI_Idioma.bn.getString("Menu.Ldatainicio")), (GUI_Idioma.bn.getString("Menu.Ldatafim")),
				(GUI_Idioma.bn.getString("Menu.Lhorario")), (GUI_Idioma.bn.getString("Menu.Lnvagas")),
				(GUI_Idioma.bn.getString("Menu.Lvalor")), (GUI_Idioma.bn.getString("Menu.Larea")),
				(GUI_Idioma.bn.getString("Menu.Llab")), (GUI_Idioma.bn.getString("Menu.Ldescricao")),
				(GUI_Idioma.bn.getString("Menu.Lmateriais")) }, 0) {

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

		table.getColumnModel().getColumn(7).setPreferredWidth(220);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setCellRenderer(alinhaDireita);

		table.getColumnModel().getColumn(8).setPreferredWidth(220);
		table.getColumnModel().getColumn(8).setResizable(false);
		table.getColumnModel().getColumn(8).setCellRenderer(alinhaDireita);

		table.getColumnModel().getColumn(9).setPreferredWidth(220);
		table.getColumnModel().getColumn(9).setResizable(false);
		table.getColumnModel().getColumn(9).setCellRenderer(alinhaDireita);

		table.getColumnModel().getColumn(10).setPreferredWidth(220);
		table.getColumnModel().getColumn(10).setResizable(false);
		table.getColumnModel().getColumn(10).setCellRenderer(alinhaDireita);

		table.getTableHeader().setReorderingAllowed(false);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		scrollTable.setViewportView(table);

		pnTable.add(scrollTable);

		// Tela Geral

		principal.add(pnTable, BorderLayout.CENTER);
		principal.add(North, BorderLayout.NORTH);
		principal.add(painelSouth, BorderLayout.SOUTH);

		setTitle(GUI_Idioma.bn.getString("Menu.Tituloexcluircurso"));

	}

	public void definirEventos() {

		Bsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();

			}
		});

	}

}
