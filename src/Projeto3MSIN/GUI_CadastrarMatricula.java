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

import org.apache.log4j.Logger;

public class GUI_CadastrarMatricula extends JInternalFrame {

	private JButton Bcadastrar, Bsair, Bconsultarcurso, Balterarcurso;
	private JLabel Ldata, Lcodcurso, Lvalor, Lra, Lstatusmat, Lstatuspag, Ldefinicaopag, Ldefinicaomat;
	private JTextField Tvalor, Tcodcurso, Tra;
	private JFormattedTextField Tdata;
	private JComboBox CBstatusmat, CBstatuspag;
	private static final Logger LOGGER = Logger.getLogger(Projeto3MSIN.GUI_CadastrarMatricula.class);

	public GUI_CadastrarMatricula() {
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
		painellabelWest.setLayout(new GridLayout(4, 1));// Linhas e Coluna

		Ldata = new JLabel(GUI_Idioma.bn.getString("Menu.Ldatamatricula"));
		Lcodcurso = new JLabel(GUI_Idioma.bn.getString("Menu.Lcodigocurso"));
		Lvalor = new JLabel(GUI_Idioma.bn.getString("Menu.Lvalor"));
		Lra = new JLabel(GUI_Idioma.bn.getString("Menu.Lra"));

		painellabelWest.add(Ldata);
		painellabelWest.add(Lcodcurso);
		painellabelWest.add(Lvalor);
		painellabelWest.add(Lra);

		// ---------
		Panel paineltextcenter = new Panel();
		paineltextcenter.setLayout(new GridLayout(4, 1));

		Tdata = new JFormattedTextField((setMascara("**/**/****")));
		Tcodcurso = new JTextField(GUI_Idioma.bn.getString("Menu.Tinsiracodigo"));
		Tvalor = new JTextField();
		Tra = new JTextField("");

		paineltextcenter.add(Tdata);
		paineltextcenter.add(Tcodcurso);
		paineltextcenter.add(Tvalor);
		paineltextcenter.add(Tra);

		// ---------
		JPanel South = new JPanel();
		South.setBorder(BorderFactory.createEtchedBorder());
		South.setBorder(new TitledBorder(GUI_Idioma.bn.getString("Menu.Lstatus")));
		South.setLayout(new BorderLayout());

		Panel painelsouth = new Panel();
		painelsouth.setLayout(new GridLayout(3, 2));

		String[] Statusmat = { "A" };

		String[] Statuspag = { (GUI_Idioma.bn.getString("Menu.CSelecione")), "P", "PD", "NP" };

		Lstatusmat = new JLabel(GUI_Idioma.bn.getString("Menu.Lstatusmat"));
		Lstatuspag = new JLabel(GUI_Idioma.bn.getString("Menu.Lstatuspag"));
		CBstatusmat = new JComboBox(Statusmat);
		CBstatuspag = new JComboBox(Statuspag);

		CBstatusmat.setEditable(false);

		Ldefinicaomat = new JLabel(GUI_Idioma.bn.getString("Menu.Ldefinicaomat"));
		Ldefinicaopag = new JLabel(GUI_Idioma.bn.getString("Menu.Ldefinicaopag"));

		painelsouth.add(Lstatusmat);
		painelsouth.add(Lstatuspag);
		painelsouth.add(CBstatusmat);
		painelsouth.add(CBstatuspag);
		painelsouth.add(Ldefinicaomat);
		painelsouth.add(Ldefinicaopag);

		South.add(painelsouth, BorderLayout.CENTER);

		// ---------

		painelcadastro.add(painellabelWest, BorderLayout.WEST);
		painelcadastro.add(paineltextcenter, BorderLayout.CENTER);
		painelcadastro.add(South, BorderLayout.SOUTH);

		// ----------------------------------------------------
		Panel painelBotaoSouth = new Panel();
		painelBotaoSouth.setLayout(new GridLayout(1, 4));

		Bcadastrar = new JButton(GUI_Idioma.bn.getString("Menu.Bcadastrar"));
		Bconsultarcurso = new JButton(GUI_Idioma.bn.getString("Menu.Bconsultarcurso"));
		Balterarcurso = new JButton(GUI_Idioma.bn.getString("Menu.Balterarcurso"));
		Bsair = new JButton(GUI_Idioma.bn.getString("Menu.Bsair"));

		painelBotaoSouth.add(Bconsultarcurso);
		painelBotaoSouth.add(Bcadastrar);
		painelBotaoSouth.add(Balterarcurso);
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
		setTitle(GUI_Idioma.bn.getString("Menu.Titulocadastrarmatricula"));
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

			}

		});

		Bcadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CTRL_Matricula Controle = new CTRL_Matricula();
				TO_Matricula MODELMatricula = new TO_Matricula();

				// Manda pro Controle o conteudo dos TextFilds.getText

				Controle.MatriculaInsert(0, Tdata.getText(), Integer.parseInt(Tcodcurso.getText()),
						Float.parseFloat(Tvalor.getText()), Integer.parseInt(Tra.getText()),
						CBstatusmat.getSelectedItem().toString(), CBstatuspag.getSelectedItem().toString());

				Gravar_TXT_Financeiro gravar = new Gravar_TXT_Financeiro();
				gravar.GravarTcFinaceiro((+1), Tdata.getText(), Integer.parseInt(Tcodcurso.getText()),
						Float.parseFloat(Tvalor.getText()), Integer.parseInt(Tra.getText()),
						CBstatusmat.getSelectedItem().toString(), CBstatuspag.getSelectedItem().toString());
				
				LOGGER.info("Matricula Cadastrada:"+(+1)+
						"\nData:"+Tdata.getText()+"\nCodigo do curso:"+Integer.parseInt(Tcodcurso.getText())+
						"\nValor:"+Float.parseFloat(Tvalor.getText())+"\nRa do Aluno:"+Integer.parseInt(Tra.getText())+
						"\nStatus Matricula:"+CBstatusmat.getSelectedItem().toString()+
						"\nStatus Pagamento:"+CBstatuspag.getSelectedItem().toString());

				JOptionPane.showMessageDialog(null, GUI_Idioma.bn.getString("Menu.Messagem1"));
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
		String[] Statusmat = { "A" };
		String[] Statuspag = { (GUI_Idioma.bn.getString("Menu.CSelecione")), "P", "PD", "NP" };

		Tdata.setValue(null);
		Tcodcurso.setText(GUI_Idioma.bn.getString("Menu.Tinsiracodigo"));
		Tvalor.setText("");
		Tvalor.setEditable(true);
		Tra.setText("");
		CBstatusmat.setSelectedItem(Statusmat);
		CBstatuspag.setSelectedItem(Statuspag);

	}
}
