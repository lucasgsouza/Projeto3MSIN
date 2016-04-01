package Projeto3MSIN;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.applet.*;
import java.util.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import Projeto3MSIN.GUI_Idioma;

public class GUI_AlterarMatricula extends JInternalFrame {

	private JButton Balterar, Bsair, Bconsultar, Bconsultarcurso, Balterarcurso;
	private JLabel Lmatricula, Ldata, Lcodcurso, Lvalor, Lra, Lstatusmat, Lstatuspag, Ldefinicaopag, Ldefinicaomat;
	private JTextField Tmatricula, Tvalor, Tcodcurso, Tra;
	private JFormattedTextField Tdata;
	private JComboBox CBstatusmat, CBstatuspag;
	private static final Logger LOGGER = Logger.getLogger(Projeto3MSIN.GUI_AlterarMatricula.class);

	public GUI_AlterarMatricula() {
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
		painellabelWest.setLayout(new GridLayout(5, 1));// Linhas e Coluna

		Lmatricula = new JLabel(GUI_Idioma.bn.getString("Menu.Menumatricula"));
		Ldata = new JLabel(GUI_Idioma.bn.getString("Menu.Ldatamatricula"));
		Lcodcurso = new JLabel(GUI_Idioma.bn.getString("Menu.Lcodigocurso"));
		Lvalor = new JLabel(GUI_Idioma.bn.getString("Menu.Lvalor"));
		Lra = new JLabel(GUI_Idioma.bn.getString("Menu.Lra"));

		painellabelWest.add(Lmatricula);
		painellabelWest.add(Ldata);
		painellabelWest.add(Lcodcurso);
		painellabelWest.add(Lvalor);
		painellabelWest.add(Lra);

		// ---------
		Panel paineltextcenter = new Panel();
		paineltextcenter.setLayout(new GridLayout(5, 1));

		Tmatricula = new JTextField(GUI_Idioma.bn.getString("Menu.Tinsiracodmat"));
		Tdata = new JFormattedTextField((setMascara("**/**/****")));
		Tcodcurso = new JTextField(GUI_Idioma.bn.getString("Menu.Tinsiracodigo"));
		Tvalor = new JTextField();
		Tra = new JTextField("");

		paineltextcenter.add(Tmatricula);
		paineltextcenter.add(Tdata);
		paineltextcenter.add(Tcodcurso);
		paineltextcenter.add(Tvalor);
		paineltextcenter.add(Tra);

		JPanel South = new JPanel();
		South.setBorder(BorderFactory.createEtchedBorder());
		South.setBorder(new TitledBorder(GUI_Idioma.bn.getString("Menu.Lstatus")));
		South.setLayout(new BorderLayout());

		Panel painelsouth = new Panel();
		painelsouth.setLayout(new GridLayout(3, 2));

		String[] Statusmat = { (GUI_Idioma.bn.getString("Menu.CSelecione")), "A", "C" };

		String[] Statuspag = { (GUI_Idioma.bn.getString("Menu.CSelecione")), "P", "PD", "NP" };

		Lstatusmat = new JLabel(GUI_Idioma.bn.getString("Menu.Lstatusmat"));
		Lstatuspag = new JLabel(GUI_Idioma.bn.getString("Menu.Lstatuspag"));
		CBstatusmat = new JComboBox(Statusmat);
		CBstatuspag = new JComboBox(Statuspag);

		Ldefinicaomat = new JLabel(GUI_Idioma.bn.getString("Menu.Ldefinicaomat"));
		Ldefinicaopag = new JLabel(GUI_Idioma.bn.getString("Menu.Ldefinicaopag"));

		painelsouth.add(Lstatusmat);
		painelsouth.add(Lstatuspag);
		painelsouth.add(CBstatusmat);
		painelsouth.add(CBstatuspag);
		painelsouth.add(Ldefinicaomat);
		painelsouth.add(Ldefinicaopag);

		South.add(painelsouth, BorderLayout.CENTER);

		painelcadastro.add(painellabelWest, BorderLayout.WEST);
		painelcadastro.add(paineltextcenter, BorderLayout.CENTER);
		painelcadastro.add(South, BorderLayout.SOUTH);

		// ----------------------------------------------------
		Panel painelBotaoSouth = new Panel();
		painelBotaoSouth.setLayout(new GridLayout(1, 5));

		Balterar = new JButton(GUI_Idioma.bn.getString("Menu.Balterar"));
		Bconsultarcurso = new JButton(GUI_Idioma.bn.getString("Menu.Bconsultarcurso"));
		Balterarcurso = new JButton(GUI_Idioma.bn.getString("Menu.Balterarcurso"));
		Bconsultar = new JButton(GUI_Idioma.bn.getString("Menu.Bconsultar"));
		Bsair = new JButton(GUI_Idioma.bn.getString("Menu.Bsair"));

		painelBotaoSouth.add(Bconsultar);
		painelBotaoSouth.add(Bconsultarcurso);
		painelBotaoSouth.add(Balterarcurso);
		painelBotaoSouth.add(Balterar);
		painelBotaoSouth.add(Bsair);

		// ----------------------------------------------------
		// AdicionaBorder ao painel Principal

		principal.add(painelcadastro, BorderLayout.CENTER);
		principal.add(painelBotaoSouth, BorderLayout.SOUTH);

		add(principal);
		setSize(800, 330);
		setLocation(300, 800);

		// Não permite alterar o tam da tela
		// setResizable(false);
		setVisible(true);
		principal.setBorder(new TitledBorder(""));
		setTitle(GUI_Idioma.bn.getString("Menu.Tituloalterarcurso"));
	}

	public void definirEventos() {
		Bsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Limpar();
			}
		});

		Bconsultarcurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Tcodcurso.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, (GUI_Idioma.bn.getString("Menu.MessagemErro3")),
							(GUI_Idioma.bn.getString("Menu.TituloErro3")), JOptionPane.ERROR_MESSAGE);
				} else {
					TO_Curso CursoMODEL = new TO_Curso();
					DAO_Curso CursoDAO = new DAO_Curso();

					TO_Curso a = CursoDAO.Consultar(Integer.parseInt(Tcodcurso.getText()));

					Tvalor.setText(Float.toString(a.getValor()));
					Tvalor.setEditable(false);
					
					
				}

			}
		});

		Balterarcurso.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Tcodcurso.setText(GUI_Idioma.bn.getString("Menu.Tinsiracodigo"));
				Tvalor.setText("");
				Tvalor.setEditable(true);
				Tcodcurso.setEditable(true);

			}

		});

		Balterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CTRL_Matricula Controle = new CTRL_Matricula();

				Controle.MatriculaUpdate(Integer.parseInt(Tmatricula.getText()), Tdata.getText(),
						Integer.parseInt(Tcodcurso.getText()), Float.parseFloat(Tvalor.getText()),
						Integer.parseInt(Tra.getText()), CBstatusmat.getSelectedItem().toString(),
						CBstatuspag.getSelectedItem().toString());

				Gravar_TXT_Financeiro gravar = new Gravar_TXT_Financeiro();
				gravar.GravarTcFinaceiro(Integer.parseInt(Tmatricula.getText()), Tdata.getText(),
						Integer.parseInt(Tcodcurso.getText()), Float.parseFloat(Tvalor.getText()),
						Integer.parseInt(Tra.getText()), CBstatusmat.getSelectedItem().toString(),
						CBstatuspag.getSelectedItem().toString());

				JOptionPane.showMessageDialog(null, GUI_Idioma.bn.getString("Menu.Messagem2"));
				Limpar();
			LOGGER.info("Matricula Alterada:"+Integer.parseInt(Tmatricula.getText())+
					"\nData:"+Tdata.getText()+"\nCodigo do curso:"+Integer.parseInt(Tcodcurso.getText())+
					"\nValor:"+Float.parseFloat(Tvalor.getText())+"\nRa do Aluno:"+Integer.parseInt(Tra.getText())+
					"\nStatus Matricula:"+CBstatusmat.getSelectedItem().toString()+
					"\nStatus Pagamento:"+CBstatuspag.getSelectedItem().toString());
			}
		});
		Bconsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Tmatricula.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, (GUI_Idioma.bn.getString("Menu.MessagemErro3")),
							(GUI_Idioma.bn.getString("Menu.TituloErro3")), JOptionPane.ERROR_MESSAGE);
				} else {
					TO_Matricula MatriculaMODEL = new TO_Matricula();
					DAO_Matricula MatriculaDAO = new DAO_Matricula();

					TO_Matricula a = MatriculaDAO.Consultar(Integer.parseInt(Tmatricula.getText()));

					Tmatricula.setText(Integer.toString(a.getMatricula()));
					Tdata.setText(a.getDataMatricula());
					Tcodcurso.setText(Integer.toString(a.getCodigoCurso()));
					Tvalor.setText(Float.toString(a.getValor()));
					Tra.setText(Integer.toString(a.getRaAluno()));
					CBstatusmat.setSelectedItem(a.getStatusMatricula());
					CBstatuspag.setSelectedItem(a.getStatusFinanceiro());
					Tvalor.setEditable(false);
					Tra.setEditable(false);
					Tcodcurso.setEditable(false);
					Tdata.setEditable(false);
					Tmatricula.setEditable(false);

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
		String[] Statuspag = { (GUI_Idioma.bn.getString("Menu.CSelecione")), "P", "PD", "NP" };
		String[] Statusmat = { (GUI_Idioma.bn.getString("Menu.CSelecione")), "A", "C" };

		Tmatricula.setText(GUI_Idioma.bn.getString("Menu.Tinsiracodmat"));
		Tdata.setValue(null);
		Tcodcurso.setText(GUI_Idioma.bn.getString("Menu.Tinsiracodigo"));
		Tvalor.setText("");
		Tra.setText("");
		CBstatusmat.setSelectedItem(Statusmat);
		CBstatuspag.setSelectedItem(Statuspag);

		Tmatricula.setEditable(true);
		Tdata.setEditable(true);
		Tcodcurso.setEditable(true);
		Tvalor.setEditable(true);
		Tra.setEditable(true);

	}

}