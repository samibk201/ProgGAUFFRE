import java.awt.*;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.io.File;

public class GauffrePlateau extends JComponent {
	private Image poison,gaufre;
	
	public GauffrePlateau () {
			poison = lisImage ("poison.jpg");
			gaufre = lisImage ("gauffre_2.png");
	}
	private Image lisImage (String nom) {
		Image img = null;
		try {
			img = ImageIO.read(new File("Images/"+nom));
		} catch (IOException io) {
			System.out.println ("Chargment de l'image "+nom+" Impossible");
			System.exit (1);
		}
		return img;
	}
	private void tracer(Graphics2D g2D, Image i, int x, int y, int l, int h) {
		g2D.drawImage(i, x, y, l, h, null);
	}
	public void paintComponent (Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		int l = 10,c = 10;
		int largeur = getSize ().width;
		int hauteur = getSize ().height;
		int largeurCase = largeur / c;
		int hauteurCase = hauteur / l;
		
		largeurCase = hauteurCase =  Math.min (largeurCase,hauteurCase);
		g2D.clearRect (0,0,largeur,hauteur);
		
		for (int i = 0; i < l; i ++) {
			for (int j = 0; j < c; j ++) {
				int x,y;
				x = j * largeurCase;
				y = i * hauteurCase;
				if (i == 0 && j == 0) {
					tracer (g2D,poison,x,y,largeurCase,hauteurCase);
				} else {
					tracer (g2D,gaufre,x,y,largeurCase,hauteurCase);
				}
			}
		}
	}
}
