import javax.swing.*;
import java.awt.*;

public class InterfaceGraphique extends JFrame implements Runnable {

	JPanel container = new JPanel();
	JPanel boutonsPanel = new JPanel();
	GauffrePlateau gaufP = new GauffrePlateau(8, 6);

	public InterfaceGraphique() {
		this.setTitle("Gauffres Empoisonnées");

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
		int lFenetre = gaufP.getLargeurCase() * gaufP.getNbLignes();
		System.out.println("lfenetre " + lFenetre);
		int hFenetre = (gaufP.getLargeurCase() * gaufP.getNbColonnes()) + 65;
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
