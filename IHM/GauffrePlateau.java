import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.io.File;

public class GauffrePlateau extends JPanel implements MouseListener{
	private Image poison, gaufre;
	private int nbLignes , nbColonnes ;
	private int largeurCase = 100;

	public GauffrePlateau(int l, int c) {
		poison = lisImage("poison.jpg");
		gaufre = lisImage("gauffre_2.png");
		this.nbLignes = l;
		this.nbColonnes = c;
	}
	
	

	public int getLargeurCase() {
		return largeurCase;
	}



	public void setLargeurCase(int largeurCase) {
		this.largeurCase = largeurCase;
	}



	public int getNbLignes() {
		return nbLignes;
	}



	public void setNbLignes(int nbLignes) {
		this.nbLignes = nbLignes;
	}



	public int getNbColonnes() {
		return nbColonnes;
	}



	public void setNbColonnes(int nbColonnes) {
		this.nbColonnes = nbColonnes;
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
		
		/*int largeur = getSize().width;
		System.out.println("largeur = " + largeur);
		int hauteur = getSize().height;
		System.out.println("hauteur " + hauteur);
		int largeurCase = largeur / nbLignes;
		System.out.println("largeur case = " + largeurCase);
		int hauteurCase = hauteur / nbLignes;
		System.out.println("hauteur case = " + hauteurCase);


		largeurCase = hauteurCase = Math.min(largeurCase, hauteurCase);
		System.out.println("largeur hauteur case = " + hauteurCase);
		//g2D.clearRect(0, 0, largeur, hauteur);*/

		for (int j = 0; j < this.nbColonnes; j++) {
			for (int i = 0; i < this.nbLignes; i++) {
				int x, y;
				y = j * largeurCase;
				x = i * largeurCase;
				
				if (i == 0 && j == 0) {
					tracer(g2D, poison, x, y, largeurCase, largeurCase);
				} else {
					tracer(g2D, gaufre, x, y, largeurCase, largeurCase);
				}
			}
		}
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
