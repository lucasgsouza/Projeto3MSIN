package Projeto3MSIN;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

import Projeto3MSIN.GUI_ConsultarCurso;
import Projeto3MSIN.GUI_ConsultarMatricula;
import Projeto3MSIN.GUI_Idioma;

public class GUI_PrincipalAluno extends JFrame {

	// Cria objeto JPane, do tipo JDesktopPane. Ele vai dentro do JFrame
	public JDesktopPane jdesktop = new JDesktopPane();

	// Classes JInternalFrame
	GUI_ConsultarCurso consultarcurso = new GUI_ConsultarCurso();
	GUI_ConsultarMatricula consultarmatricula = new GUI_ConsultarMatricula();
	GUI_Sobre Sobre = new GUI_Sobre();

	public GUI_PrincipalAluno() {

		jdesktop = new DecoratedDesktopPaneAluno();

		// Cria uma barra de menu para o JFrame
		JMenuBar menuBar = new JMenuBar();

		// Adiciona a barra de menu ao frame
		setJMenuBar(menuBar);

		// Adiciona o jDesktopPane ao JFrame(Tela Principal)
		getContentPane().add(jdesktop);

		// -------------------------------------------------------
		// Define e adiciona dois menus drop down na barra de menus
		JMenu Mconsultar = new JMenu(GUI_Idioma.bn.getString("Menu.Menuconsultar"));
		JMenu Mopcoes = new JMenu(GUI_Idioma.bn.getString("Menu.Menuopcoes"));

		// Adiciona A Tela
		menuBar.add(Mconsultar);
		menuBar.add(Mopcoes);

		// -------------------------------------------------------
		// Cria e adiciona um item simples para o menu

		JMenuItem Mcursos = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menucurso"));
		JMenuItem Mmatricula = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menumatricula"));

		// Para Opcoes
		JMenuItem Mlogoff = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menulogoff"));
		JMenuItem Msobre = new JMenuItem(GUI_Idioma.bn.getString("Menu.Menusobre"));

		// -------------------------------------------------------
		// Adiciona A Abas
		// Cursos
		Mconsultar.add(Mcursos);
		Mconsultar.addSeparator();
		Mconsultar.add(Mmatricula);

		// Opções
		Mopcoes.add(Mlogoff);
		Mopcoes.addSeparator();
		Mopcoes.add(Msobre);

		// -------------------------------------------------------
		// Configurações gerais
		// Tela

		setTitle(GUI_Idioma.bn.getString("Menu.Titulo"));
		setSize(900, 700);// Largura //Altura
		setLocation(200, 300);
		setVisible(true);
		setResizable(false);
		setVisible(true);

		// -------------------------------------------------------
		// Acões das abas/itens

		Mcursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jdesktop.add(consultarcurso); // add Tela no JDesktop
				jdesktop.moveToFront(consultarcurso); // Traz a tela a
														// frente do
														// JDesktop
				consultarcurso.setVisible(true);
				CentralizarConsultarCurso(consultarcurso);

			}
		});

		Mmatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jdesktop.add(consultarmatricula); // add Tela no JDesktop
				jdesktop.moveToFront(consultarmatricula); // Traz a tela a
															// frente do
															// JDesktop
				consultarmatricula.setVisible(true);
				CentralizarConsultarMatricula(consultarmatricula);

			}
		});

		Mlogoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				CTRL_Inicialização inicialização = new CTRL_Inicialização();
				inicialização.Acao_TelaIdioma();

			}
		});
		Msobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jdesktop.add(Sobre);
				jdesktop.moveToFront(Sobre);
				Sobre.setVisible(true);
				CentralizarSobre(Sobre);

			}
		});
	}

	// ------------------------------------------------------- //
	// Centralizar JInternalFrame // Passagem private void

	private void CentralizarConsultarCurso(JInternalFrame consultarcurso) {
		Dimension desktopSize = jdesktop.getSize();
		Dimension jInternalFrameSize = consultarcurso.getSize();
		consultarcurso.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
	}

	private void CentralizarConsultarMatricula(JInternalFrame consultarmatricula) {
		Dimension desktopSize = jdesktop.getSize();
		Dimension jInternalFrameSize = consultarmatricula.getSize();
		consultarmatricula.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
	}

	private void CentralizarSobre(JInternalFrame Sobre) {
		Dimension desktopSize = jdesktop.getSize();
		Dimension jInternalFrameSize = Sobre.getSize();
		Sobre.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
	}

}
