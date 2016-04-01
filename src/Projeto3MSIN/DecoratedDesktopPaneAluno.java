package Projeto3MSIN;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class DecoratedDesktopPaneAluno extends JDesktopPane {
	private Image img;

	public DecoratedDesktopPaneAluno() {
		File imagem = new File("src/Imagem/Fundo_Aluno.jpg");
		try {
			img = javax.imageio.ImageIO.read(imagem);
		} catch (Exception ex) {
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(img != null) {
			g.drawImage(img, 0,0,this.getWidth(),this.getHeight(),this);  
	    
		} else {
			g.drawString("Imagem nao encontrada", 50, 50);
		}
	}}