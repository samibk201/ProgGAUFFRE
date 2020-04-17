/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moteur;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author Sami
 */
public class Play {
    
    private int player=0;
    static Play play=null;

    private Play() {
        super();
    }
    
    public static Play getInstance(){
        if(play==null){
            Play.play = new Play();        
        }
        return Play.play; 
        //recuperation de la taille de la gauffre        
    }
    
    public boolean[][] InitTabGauffre(int w, int h){
        boolean [][] gauffre = new boolean[w][h];
        for(int i=0; i<w; i++){
            for(int j=0; j<h; j++){
                gauffre[i][j]=true;
            }
        }
        return gauffre;
    }
    
    public boolean CheckCoord(String x, String y,int w ,int h, boolean[][] gauffre){
        int v1;
        int v2;
        
        try {
            v1 = Integer.parseInt(x);
        }catch(NumberFormatException e) {
            System.out.println("> line input is not a valid integer");
            return false;
        }
        
        try {
            v2 = Integer.parseInt(y);
        }catch(NumberFormatException e) {
            System.out.println("> column input is not a valid integer");
            return false;
        }
        
        
        if ( v1<0 || v2<0 || v1>=w || v2>=h)
            return false;  
        return gauffre[v1][v2];  
    }
    
    @SuppressWarnings("UnusedAssignment")
    public void Jouer(boolean[][] gauffre){
        Affichages affichage = Affichages.getInstance();
        Scanner sc = new Scanner(System.in);
        String x1,y1;
        int x,y;
        while(gauffre[0][0]){
            int gagnant = player;
            boolean b;
            int h=affichage.getHeight(), w=affichage.getWidth(); 
            System.out.println("****************************");
            System.out.println("|   tour du joueur num: "+(player+1)+"  |");
            System.out.println("****************************");
            System.out.println("> please type your coordinates");
            x1 = sc.next();
            y1 = sc.next();
            b=CheckCoord(x1,y1,w,h,gauffre);
            while(!b){
                System.out.println("> please retype valid coordinates");
                x1 = sc.next();
                y1 = sc.next();
                b=CheckCoord(x1,y1,w,h,gauffre);
            }
            x = Integer.parseInt(x1);
            y = Integer.parseInt(y1);
            if(x==0 && y==0){
                
                System.out.println("> partie terminée");
                System.out.println("############################");
                System.out.println("#   GAGNANT : JOUEUR"+((gagnant+1)%2 + 1)+"      #");
                System.out.println("############################");
                exit(0);
            }else{
                gagnant = (gagnant+1)%2;
                Coup(gauffre,x,y);
            }
        }
        
    }
    public void Coup(boolean[][] gauffre, int x, int y){
        
        for(int i=x; i<gauffre.length;i++){
            for(int j=y;j<gauffre[i].length;j++){
                gauffre[i][j]=false;
            }
        }
        player = (player+1)%2;
        //Affichages affichage = Affichages.getInstance();
        //affichage.DrawWaffle(gauffre);
    }

	public int getPlayer() {
		return player;
	}
    
    
}
