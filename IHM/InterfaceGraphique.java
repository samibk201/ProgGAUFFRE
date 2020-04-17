import javax.swing.*;

import Moteur.Play;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGraphique extends JFrame implements Runnable{

	JPanel container = new JPanel();
	JPanel boutonsPanel = new JPanel();
	GauffrePlateau gaufP ;

	public InterfaceGraphique() {
		this.setTitle("Gauffres Empoisonnées");
		this.gaufP =  new GauffrePlateau(8, 6);

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
		
		
		
		container.setLayout(new BorderLayout());
		container.add(boutonsPanel, BorderLayout.NORTH);
		container.add(gaufP);
		int lFenetre = gaufP.getLargeurCase() * gaufP.getLargeur();
		int hFenetre = (gaufP.getLargeurCase() * gaufP.getHauteur()) + 65;
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
		
	}
		

}
