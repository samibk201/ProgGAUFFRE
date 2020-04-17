/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Gauffre {
	
	public static void main (String [] args) {
		InterfaceGraphique ig = new InterfaceGraphique ();
		ig.run();
	}
}







//////////////////////////////////////////////
///         TO RUN WITHOUT GRAPHIC         ///
//////////////////////////////////////////////
/*
import Moteur.Affichages;
import Moteur.Play;
import java.util.Scanner;


public class Gauffres {
    
    public static void main(String[] args) {
       
        Affichages affichage = Affichages.getInstance();
        Play play = Play.getInstance();
        //afficher la gauffre
        int height=affichage.getHeight();
        int width=affichage.getWidth();
        boolean[][] gauffre = play.InitTabGauffre(height, width);
        affichage.DrawWaffle(gauffre);
        play.Jouer(gauffre);
        
    }
    
}
*/
