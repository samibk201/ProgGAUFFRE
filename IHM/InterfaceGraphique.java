import javax.swing.*;
import java.awt.*;

public class InterfaceGraphique implements Runnable {
	JFrame frame;
	JPanel container = new JPanel ();
	GauffrePlateau gaufP;
	public InterfaceGraphique () {
	}
	public void demarrer () {
		SwingUtilities.invokeLater(new InterfaceGraphique());
	}
	public void run () {
		frame = new JFrame ("Gauffres Empoisonnées");
		gaufP = new GauffrePlateau ();
		Box boiteTexte = Box.createVerticalBox ();
		
		
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setSize (750,540);
		frame.setLocationRelativeTo (null);
		 
		JButton IA = new JButton ("IA");
		JButton suivant = new JButton (">");
		JButton precedent = new JButton ("<");
		JButton hist = new JButton ("historique");
		JButton sauv = new JButton ("save");
		JButton annuler = new JButton ("reset");
		JLabel label = new JLabel ("Gaufre Empoisonnée");
		
		
		
		Box s_r = Box.createHorizontalBox ();
		s_r.add (sauv);
		s_r.add (annuler);
		Box n_p = Box.createHorizontalBox ();
		n_p.add (precedent);
		n_p.add (suivant);
		
		label.setAlignmentX (Component.CENTER_ALIGNMENT);
		boiteTexte.add (label);
		//boiteTexte.add (Box.createGlue ());
		IA.setAlignmentX (Component.CENTER_ALIGNMENT);
		boiteTexte.add (IA);
		hist.setAlignmentX (Component.CENTER_ALIGNMENT);
		boiteTexte.add (hist);
		s_r.setAlignmentX (Component.CENTER_ALIGNMENT);
		boiteTexte.add (s_r);
		n_p.setAlignmentX (Component.CENTER_ALIGNMENT);
		boiteTexte.add (n_p);
		
		frame.add (boiteTexte,BorderLayout.EAST);
		frame.add (gaufP);
		frame.setVisible (true);
	}
}
