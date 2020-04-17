import javax.swing.*;

import Moteur.Play;

import static java.lang.System.exit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGraphique extends JFrame implements Runnable {

	JPanel container = new JPanel();
	JPanel boutonsPanel = new JPanel();
	JPanel labelPanel = new JPanel();
	Label labelPartie;
	GauffrePlateau gaufP;

	public InterfaceGraphique() {
		this.setTitle("Gauffres Empoisonnées");
		this.gaufP = new GauffrePlateau(8, 6);

		JButton IA = new JButton("IA");
		JButton suivant = new JButton(">");
		JButton precedent = new JButton("<");
		JButton hist = new JButton("historique");
		JButton sauv = new JButton("save");
		JButton annuler = new JButton("reset");

		boutonsPanel.setLayout(new FlowLayout());
		boutonsPanel.add(annuler);
		boutonsPanel.add(sauv);
		boutonsPanel.add(precedent);
		boutonsPanel.add(suivant);
		boutonsPanel.add(hist);
		boutonsPanel.add(IA);

		labelPartie = new Label("Début de la partie");
		// Définition d'une police d'écriture
		Font police = new Font("Tahoma", Font.BOLD, 16);
		// On l'applique au JLabel
		labelPartie.setFont(police);
		// Changement de la couleur du texte
		labelPartie.setForeground(Color.blue);
		// On modifie l'alignement du texte grâce aux attributs statiques
		// labelPartie la classe JLabel
		labelPartie.setPreferredSize(new Dimension(750,20));
		labelPartie.setAlignment(JLabel.CENTER);
		labelPanel.setLayout(new BorderLayout());
		labelPanel.add(labelPartie, BorderLayout.WEST);

		container.setLayout(new BorderLayout());
		container.add(boutonsPanel, BorderLayout.NORTH);
		container.add(labelPanel, BorderLayout.SOUTH);
		container.add(gaufP);
		int lFenetre = gaufP.getLargeurCase() * gaufP.getLargeur();
		int hFenetre = (gaufP.getLargeurCase() * gaufP.getHauteur()) + 105;
		this.setSize(lFenetre, hFenetre);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(container);
		this.setVisible(true);
		run();
	}

	public void demarrer() {
		SwingUtilities.invokeLater(new InterfaceGraphique());
	}

	public void run() {
		Play play = Play.getInstance();
		int gagnant= play.getPlayer();
		boolean[][] g = gaufP.getTabGauffre();
		int x = gaufP.getClicX(), y=gaufP.getClicY();
		while (g[0][0]) {
			gagnant = Play.getInstance().getPlayer();
			if (x == 0 && y == 0) {
				gagnant = gagnant + 1;
				this.labelPartie.setText("AU JOUEUR " +  gagnant + "");
			
			} else {
				gagnant = (gagnant + 1) % 2;
				
			}
		}
		gagnant = gagnant + 1;
		
		this.labelPartie.setText("Partie terminée : JOUEUR " + gagnant + " VAINQUEUR ");
	}

}
