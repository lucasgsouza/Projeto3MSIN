package Projeto3MSIN;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Projeto3MSIN.GUI_GerarUsuarios;
import Projeto3MSIN.GUI_Idioma;
import Projeto3MSIN.GUI_Login;
import Projeto3MSIN.GUI_PrincipalAluno;
import Projeto3MSIN.GUI_PrincipalAtendente;

public class CTRL_Inicialização {
	// GUIS
	private static GUI_Idioma frame_idioma;
	private static GUI_Login frame_login;
	private static GUI_PrincipalAluno frame_principalaluno;
	private static GUI_PrincipalAtendente frame_principalatendente;
	private static GUI_GerarUsuarios frame_gerar;
	
	// "Chamada" de tela
	// (Idioma)
	public void Acao_TelaIdioma() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame_idioma = new GUI_Idioma();
				frame_idioma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Dimension gui_idioma = Toolkit.getDefaultToolkit().getScreenSize();
				frame_idioma.setLocation((gui_idioma.width - frame_idioma.getSize().width) / 2,
						(gui_idioma.height - frame_idioma.getSize().height) / 2);
				frame_idioma.setVisible(true);

			}
		});

	}
	//(Login)
	public void Acao_TelaLogin() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame_login = new GUI_Login();
				frame_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Dimension gui_login = Toolkit.getDefaultToolkit().getScreenSize();
				frame_login.setLocation((gui_login.width - frame_login.getSize().width) / 2,
						(gui_login.height - frame_login.getSize().height) / 2);
				frame_login.setVisible(true);

			}
		});

	}
	
	//Tela Principal Aluno
	public void Acao_TelaPrincipalAluno() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame_principalaluno = new GUI_PrincipalAluno();
				frame_principalaluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Dimension gui_principalaluno = Toolkit.getDefaultToolkit().getScreenSize();
				frame_principalaluno.setLocation((gui_principalaluno.width - frame_principalaluno.getSize().width) / 2,
						(gui_principalaluno.height - frame_principalaluno.getSize().height) / 2);
				frame_principalaluno.setVisible(true);

			}
		});

	}
	//Tela Principal Atendente
		public void Acao_TelaPrincipalAtendente() {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					frame_principalatendente = new GUI_PrincipalAtendente();
					frame_principalatendente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Dimension gui_principalatendente = Toolkit.getDefaultToolkit().getScreenSize();
					frame_principalatendente.setLocation((gui_principalatendente.width - frame_principalatendente.getSize().width) / 2,
							(gui_principalatendente.height - frame_principalatendente.getSize().height) / 2);
					frame_principalatendente.setVisible(true);

				}
			});

		}
		//Tela Gerar Usuários
				public void Acao_GerarUsuarios() {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							frame_gerar = new GUI_GerarUsuarios();
							frame_gerar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							Dimension gui_gerar = Toolkit.getDefaultToolkit().getScreenSize();
							frame_gerar.setLocation((gui_gerar.width - frame_gerar.getSize().width) / 2,
									(gui_gerar.height - frame_gerar.getSize().height) / 2);
							frame_gerar.setVisible(true);

						}
					});

				}

}
