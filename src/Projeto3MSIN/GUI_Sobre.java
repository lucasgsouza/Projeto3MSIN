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

public class GUI_Sobre extends JInternalFrame {

	private JButton Bsair;

	public GUI_Sobre() {
		inicializarComponentes();
		definirEventos();

	}

	public void inicializarComponentes() {

		// Border Painel principal
		JPanel principal = new JPanel();
		principal.setLayout(new BorderLayout());

		principal = (JPanel) new DecoratedDesktopPaneSobre();

		Bsair = new JButton(GUI_Idioma.bn.getString("Menu.Bsair"));

		principal.add(Bsair, BorderLayout.SOUTH);

		add(principal);
		setSize(800, 300);
		setLocation(300, 800);

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
