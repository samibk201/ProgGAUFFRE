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
    
    public boolean[][] InitTabGauffre(int h, int w){
        boolean [][] gauffre = new boolean[h][w];
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                gauffre[i][j]=true;
            }
        }
        return gauffre;
    }
    
    public boolean CheckCoord(int x, int y,int h, int w, boolean[][] gauffre){
        if ( x<0 || y<0 || x>=h || y>=w)
            return false;  
        return gauffre[x][y];  
    }
    
    public void Jouer(boolean[][] gauffre){
        Affichages affichage = Affichages.getInstance();
        Scanner sc = new Scanner(System.in);
        int x,y;
        while(gauffre[0][0]){
            //int x=-1,y=-1;
            int gagnant = player;
            boolean b;
            int h=affichage.getHeight(), w=affichage.getWidth(); 
            System.out.println("****************************");
            System.out.println("*   tour du joueur num: "+(player+1)+"  *");
            System.out.println("****************************");
            System.out.println("> please type your coordinates");
            x = sc.nextInt();
            y = sc.nextInt();
            b=CheckCoord(x,y,h,w,gauffre);
            while(!b){
                System.out.println("> please retype correct coordinates");
                x = sc.nextInt();
                y = sc.nextInt();
                b=CheckCoord(x,y,h,w,gauffre);
            }
            if(x==0 && y==0){
                
                System.out.println("> partie terminée");
                System.out.println("/**************************\\");
                System.out.println("*   GAGNANT : JOUEUR"+((gagnant+1)%2 + 1)+"       *");
                System.out.println("\\**************************/");
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
        Affichages affichage = Affichages.getInstance();
        affichage.DrawWaffle(gauffre);
    } 
    
}
