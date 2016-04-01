package Projeto3MSIN;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DecoratedDesktopPaneSobre extends JPanel {
	private Image img;

	public DecoratedDesktopPaneSobre() {
		File imagem = new File("src/Imagem/tela-preta.png");
		try {
			img = javax.imageio.ImageIO.read(imagem);
		} catch (Exception ex) {
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(img != null) {
			g.drawImage(img, 0, 0, (ImageObserver) this);  ;  
	    
		} else {
			g.drawString("Imagem nao encontrada", 50, 50);
		}
	}}