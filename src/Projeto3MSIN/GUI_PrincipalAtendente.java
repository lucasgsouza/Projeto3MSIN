package Projeto3MSIN;

import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

import Projeto3MSIN.GUI_AlterarAluno;
import Projeto3MSIN.GUI_AlterarCurso;
import Projeto3MSIN.GUI_AlterarMatricula;
import Projeto3MSIN.GUI_CadastrarAluno;
import Projeto3MSIN.GUI_CadastrarCurso;
import Projeto3MSIN.GUI_CadastrarMatricula;
import Projeto3MSIN.GUI_ConsultarAluno;
import Projeto3MSIN.GUI_ConsultarCurso;
import Projeto3MSIN.GUI_ConsultarMatricula;
import Projeto3MSIN.GUI_ExcluirAluno;
import Projeto3MSIN.GUI_ExcluirCurso;
import Projeto3MSIN.GUI_Idioma;
import Projeto3MSIN.GUI_RelatorioCancelamentos;
import Projeto3MSIN.GUI_RelatorioMatricula;

public class GUI_PrincipalAtendente extends JFrame {

	// Cria objeto JPane, do tipo JDesktopPane. Ele vai dentro do JFrame
	public JDesktopPane jdesktop = new JDesktopPane();

	// Classes JInternalFrame
	GUI_CadastrarCurso cadastrarcurso = new GUI_CadastrarCurso();
	GUI_AlterarCurso alterarcurso = new GUI_AlterarCurso();
	GUI_ExcluirCurso excluircurso = new GUI_ExcluirCurso();
	GUI_ConsultarCurso consultarcurso = new GUI_ConsultarCurso();

	GUI_CadastrarAluno cadastraraluno = new GUI_CadastrarAluno();
	GUI_AlterarAluno alteraraluno = new GUI_AlterarAluno();
	GUI_ExcluirAluno excluiraluno = new GUI_ExcluirAluno();
	GUI_ConsultarAluno consultaraluno = new GUI_ConsultarAluno();

	GUI_CadastrarMatricula cadastrarmatricula = new GUI_CadastrarMatricula();
	GUI_AlterarMatricula alterarmatricula = new GUI_AlterarMatricula();
	GUI_ConsultarMatricula consultarmatricula = new GUI_ConsultarMatricula();

	GUI_RelatorioMatricula relmatricula = new GUI_RelatorioMatricula();
	GUI_RelatorioCancelamentos relcancelamentos = new GUI_RelatorioCancelamentos();
	GUI_Sobre Sobre = new GUI_Sobre();

	public GUI_PrincipalAtendente() {

		jdesktop = new DecoratedDesktopPaneAtendente();

		// Cria uma barra de menu para o JFrame
		JMenuBar menuBar = new JMenuBar();

		// Adiciona a barra de menu ao frame
		setJMenuBar(menuBar);

		// Adiciona o jDesktopPane ao JFrame(Tela Principal)
		getContentPane().add(jdesktop);

		// -------------------------------------------------------
		// Define e adiciona dois menus drop down na barra de menus
		JMenu Mcurso = new JMenu(GUI_Idioma.bn.getString("Menu.Menucurso"));
		JMenu Maluno = new JMenu(GUI_Idioma.bn.getString("Menu.Menualuno"));
		JMenu Mmatricula = new JMenu(GUI_Idioma.bn.getString("Menu.Menumatricula"));
		JMenu Mopcoes = new JMenu(GUI_Idioma.bn.getString("Menu.Menuopcoes"));

		// Adiciona A Tela
		menuBar.add(Mcurso);
		menuBar.add(Maluno);
		menuBar.add(Mmatricula);
		menuBar.add(Mopcoes);

		// -------------------------------------------------------
		// Cria e adiciona um item simples para o menu --Cursos

		// Opçoes
		JMenu Mrelatorios = new JMenu(GUI_Idioma.bn.getString("Menu.Menurelatorios"));

		// Adiciona opções --Cursos
		JMenuItem Ccadastrar = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menucadastrar"));
		JMenuItem Calterar = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menualterar"));
		JMenuItem Cexcluir = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menuexcluir"));
		JMenuItem Cconsultar = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menuconsultar"));

		// Aluno
		JMenuItem Alcadastrar = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menucadastrar"));
		JMenuItem Alalterar = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menualterar"));
		JMenuItem Alexcluir = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menuexcluir"));
		JMenuItem Alconsultar = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menuconsultar"));

		// Matricula
		JMenuItem Mcadastrar = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menucadastrar"));
		JMenuItem Malterar = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menualterar"));
		JMenuItem Mconsultar = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menuconsultar"));

		// Opcoes
		JMenuItem Ologoff = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menulogoff"));
		JMenuItem Osobre = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menusobre"));
		JMenuItem RMatriculas = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menumatriculaativa"));
		JMenuItem RCancelamentos = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menumatriculacancelada"));
		// -------------------------------------------------------

		// Adiciona sub itens a curso --Informatica
		Mcurso.add(Ccadastrar);
		Mcurso.addSeparator();
		Mcurso.add(Calterar);
		Mcurso.addSeparator();
		Mcurso.add(Cexcluir);
		Mcurso.addSeparator();
		Mcurso.add(Cconsultar);

		// Aluno
		Maluno.add(Alcadastrar);
		Maluno.addSeparator();
		Maluno.add(Alalterar);
		Maluno.addSeparator();
		Maluno.add(Alexcluir);
		Maluno.addSeparator();
		Maluno.add(Alconsultar);

		// Matricula
		Mmatricula.add(Mcadastrar);
		Mmatricula.addSeparator();
		Mmatricula.add(Malterar);
		Mmatricula.addSeparator();
		Mmatricula.add(Mconsultar);

		// Opções
		Mopcoes.add(Ologoff);
		Mopcoes.addSeparator();
		Mopcoes.add(Osobre);
		Mopcoes.add(Mrelatorios);

		// sub Itens de Opçoes
		Mrelatorios.add(RMatriculas);
		Mrelatorios.addSeparator();
		Mrelatorios.add(RCancelamentos);
		// -------------------------------------------------------
		// Configurações gerais -Tela

		setTitle(GUI_Idioma.bn.getString("Menu.Titulo"));
		setSize(900, 700);// Largura //Altura
		setLocation(200, 300);
		setVisible(true);
		setResizable(false);
		setVisible(true);

		// -------------------------------------------------------
		// Acões das abas/itens --Cursos --Informatica
		Ccadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jdesktop.add(cadastrarcurso);// add Tela no JDesktop
				jdesktop.moveToFront(cadastrarcurso); // Move tela a frente
														// do JDesktop
				cadastrarcurso.setVisible(true);
				CentralizarCadastrarCurso(cadastrarcurso);

			}
		});
		Calterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jdesktop.add(alterarcurso);// add Tela no JDesktop
				jdesktop.moveToFront(alterarcurso); // Move tela a frente
													// do JDesktop
				alterarcurso.setVisible(true);
				CentralizarAlterarCurso(alterarcurso);

			}
		});
		Cexcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jdesktop.add(excluircurso);// add Tela no JDesktop
				jdesktop.moveToFront(excluircurso); // Move tela a frente
													// do JDesktop
				alterarcurso.setVisible(true);
				CentralizarExcluirCurso(excluircurso);

			}
		});

		Cconsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jdesktop.add(consultarcurso);
				jdesktop.moveToFront(consultarcurso);
				consultarcurso.setVisible(true);
				CentralizarConsultarCurso(consultarcurso);

			}
		});

		Alcadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jdesktop.add(cadastraraluno);
				jdesktop.moveToFront(cadastraraluno);

				cadastrarcurso.setVisible(true);
				CentralizarCadastrarAluno(cadastraraluno);

			}
		});

		Alalterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jdesktop.add(alteraraluno);
				jdesktop.moveToFront(alteraraluno);
				alteraraluno.setVisible(true);
				CentralizarAlterarAluno(alteraraluno);

			}
		});

		Alconsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jdesktop.add(consultaraluno);
				jdesktop.moveToFront(consultaraluno);
				consultaraluno.setVisible(true);
				CentralizarConsultarAluno(consultaraluno);

			}
		});

		Alexcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jdesktop.add(excluiraluno);
				jdesktop.moveToFront(excluiraluno);
				excluiraluno.setVisible(true);
				CentralizarAlterarAluno(excluiraluno);

			}
		});

		Mcadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jdesktop.add(cadastrarmatricula);
				jdesktop.moveToFront(cadastrarmatricula);
				cadastrarmatricula.setVisible(true);
				CentralizarCadastrarMatricula(cadastrarmatricula);

			}
		});

		Malterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jdesktop.add(alterarmatricula);
				jdesktop.moveToFront(alterarmatricula);
				alterarmatricula.setVisible(true);
				CentralizarCadastrarMatricula(alterarmatricula);

			}
		});

		Mconsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jdesktop.add(consultarmatricula);
				jdesktop.moveToFront(consultarmatricula);
				consultarmatricula.setVisible(true);
				CentralizarConsultarMatricula(consultarmatricula);

			}
		});

		RMatriculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jdesktop.add(relmatricula);
				jdesktop.moveToFront(relmatricula);
				relmatricula.setVisible(true);
				CentralizarRelatorioMatricula(relmatricula);

			}
		});
		RCancelamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jdesktop.add(relcancelamentos);
				jdesktop.moveToFront(relcancelamentos);
				relcancelamentos.setVisible(true);
				CentralizarRelatorioCancelamentos(relcancelamentos);

			}
		});

		Ologoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				CTRL_Inicialização inicialização = new CTRL_Inicialização();
				inicialização.Acao_TelaIdioma();

			}
		});

		Osobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jdesktop.add(Sobre);
				jdesktop.moveToFront(Sobre);
				Sobre.setVisible(true);
				CentralizarSobre(Sobre);

			}
		});
	}

	// -------------------------------------------------------
	// Centralizar JInternalFrame

	private void CentralizarCadastrarCurso(JInternalFrame cadastrarcurso) {
		Dimension desktopSize = jdesktop.getSize();
		Dimension jInternalFrameSize = cadastrarcurso.getSize();
		cadastrarcurso.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
	}

	private void CentralizarAlterarCurso(JInternalFrame alterarcurso) {
		Dimension desktopSize = jdesktop.getSize();
		Dimension jInternalFrameSize = alterarcurso.getSize();
		alterarcurso.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
	}

	private void CentralizarExcluirCurso(JInternalFrame excluircurso) {
		Dimension desktopSize = jdesktop.getSize();
		Dimension jInternalFrameSize = excluircurso.getSize();
		excluircurso.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
	}

	private void CentralizarConsultarCurso(JInternalFrame consultarcurso) {
		Dimension desktopSize = jdesktop.getSize();
		Dimension jInternalFrameSize = consultarcurso.getSize();
		consultarcurso.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
	}

	private void CentralizarCadastrarAluno(JInternalFrame cadastraraluno) {
		Dimension desktopSize = jdesktop.getSize();
		Dimension jInternalFrameSize = cadastraraluno.getSize();
		cadastraraluno.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
	}

	private void CentralizarAlterarAluno(JInternalFrame alteraraluno) {
		Dimension desktopSize = jdesktop.getSize();
		Dimension jInternalFrameSize = alteraraluno.getSize();
		alteraraluno.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
	}

	private void CentralizarConsultarAluno(JInternalFrame consultaraluno) {
		Dimension desktopSize = jdesktop.getSize();
		Dimension jInternalFrameSize = consultaraluno.getSize();
		consultaraluno.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
	}

	private void CentralizarExcluirAluno(JInternalFrame excluiraluno) {
		Dimension desktopSize = jdesktop.getSize();
		Dimension jInternalFrameSize = excluiraluno.getSize();
		excluiraluno.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
	}

	private void CentralizarCadastrarMatricula(JInternalFrame cadastrarmatricula) {
		Dimension desktopSize = jdesktop.getSize();
		Dimension jInternalFrameSize = cadastrarmatricula.getSize();
		cadastrarmatricula.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
	}

	private void CentralizarAlterarMatricula(JInternalFrame alterarmatricula) {
		Dimension desktopSize = jdesktop.getSize();
		Dimension jInternalFrameSize = alterarmatricula.getSize();
		alterarmatricula.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
	}

	private void CentralizarExcluirMatricula(JInternalFrame excluiramatricula) {
		Dimension desktopSize = jdesktop.getSize();
		Dimension jInternalFrameSize = excluiramatricula.getSize();
		excluiramatricula.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
	}

	private void CentralizarConsultarMatricula(JInternalFrame consultarmatricula) {
		Dimension desktopSize = jdesktop.getSize();
		Dimension jInternalFrameSize = consultarmatricula.getSize();
		consultarmatricula.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
	}

	private void CentralizarRelatorioMatricula(JInternalFrame relmatricula) {
		Dimension desktopSize = jdesktop.getSize();
		Dimension jInternalFrameSize = relmatricula.getSize();
		relmatricula.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
	}

	private void CentralizarRelatorioCancelamentos(JInternalFrame relcancelamentos) {
		Dimension desktopSize = jdesktop.getSize();
		Dimension jInternalFrameSize = relcancelamentos.getSize();
		relcancelamentos.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
	}

	private void CentralizarSobre(JInternalFrame Sobre) {
		Dimension desktopSize = jdesktop.getSize();
		Dimension jInternalFrameSize = Sobre.getSize();
		Sobre.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
	}

}
