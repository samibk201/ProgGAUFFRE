import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;

import Moteur.Play;

import java.io.IOException;
import java.io.File;

public class GauffrePlateau extends JPanel implements MouseListener{
	private Image poison, gaufre, vide;
	private boolean [][] tabGauffre; 
	private int largeur , hauteur ;
	private int largeurCase = 100;
	private int clicX, clicY;

	public GauffrePlateau(int l, int h) {
		poison = lisImage("poison.png");
		gaufre = lisImage("gauffre_2.png");
		this.largeur = l;
		this.hauteur = h;
		Play play = Play.getInstance();
		this.tabGauffre = play.InitTabGauffre(this.largeur, this.hauteur);
		
		this.addMouseListener(this);
	}
	
	

	public int getLargeurCase() {
		return largeurCase;
	}



	public void setLargeurCase(int largeurCase) {
		this.largeurCase = largeurCase;
	}



	public int getLargeur() {
		return largeur;
	}
	



	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}



	public int getHauteur() {
		return hauteur;
	}



	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	
	
	
	
	

	public int getClicX() {
		return clicX;
	}



	public int getClicY() {
		return clicY;
	}



	public boolean[][] getTabGauffre() {
		return tabGauffre;
	}


	private Image lisImage(String nom) {
		Image img = null;
		try {
			img = ImageIO.read(new File("IHM/Images/" + nom));
		} catch (IOException io) {
			System.out.println("Chargment de l'image " + nom + " Impossible");
			System.exit(1);
		}
		return img;
	}

	private void tracer(Graphics2D g2D, Image i, int x, int y, int l, int h) {
		g2D.drawImage(i, x, y, l, h, this);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		for (int i = 0; i < this.largeur; i++) {
			for (int j = 0; j < this.hauteur; j++) {
				//System.out.println();
				int x, y;
				y = j * largeurCase;
				x = i * largeurCase;
				if(Play.getInstance().CheckCoord(String.valueOf(i), String.valueOf(j), largeur, hauteur, tabGauffre) == true){
					if (i == 0 && j == 0) {
						tracer(g2D, poison, x, y, largeurCase, largeurCase);
					} else {
						tracer(g2D, gaufre, x, y, largeurCase, largeurCase);
					}
				}else {
					if (i == 0 && j == 0) {
						tracer(g2D, poison, x, y, largeurCase, largeurCase);
					} else {
						tracer(g2D, vide, x, y, largeurCase, largeurCase);
					}
				}
			}
		}
	}



	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
			vide = lisImage("vide.png");
			clicX = event.getX()/ largeurCase;
			clicY = event.getY()/ largeurCase;
			
			Play.getInstance().Coup(tabGauffre, clicX, clicY);
			this.repaint();
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
		
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
