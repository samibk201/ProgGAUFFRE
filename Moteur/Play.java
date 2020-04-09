/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moteur;

/**
 *
 * @author Sami
 */
public class Play {
    
    public static boolean[][] InitTabGauffre(int h, int w){
        boolean [][] gauffre = new boolean[h][w];
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                gauffre[i][j]=true;
            }
        }
        return gauffre;
    }
    
    //Check coord
    //Jouer
    //Affichage -> afficher joueur
    //gagnant
    
    
}
