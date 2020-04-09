package Moteur;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author Sami
 */
public class Affichages {
    
    private int height;
    private int width;
    static Affichages affichages=null;

    private Affichages() {
        super();
    }
    
    public static Affichages getInstance(){
        if(Affichages.affichages==null){
            Affichages.affichages = new Affichages();
            Scanner sc = new Scanner(System.in);
            Affichages.affichages.height=CheckHight(sc);
            Affichages.affichages.width=CheckWidth(sc);          
        }
        return Affichages.affichages; 
        //recuperation de la taille de la gauffre
        
        
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    //affiche la gauffre
    //param : entier h -> hauteur, entier w -> largeur
    //retour : void
    public void DrawWaffle(boolean[][] gauffre){
        
     
        //boolean[][] gauffre = Play.InitTabGauffre(h, w);
        
        for (int j=0; j<width; j++)
                System.out.print("+---");
            System.out.println("+");
        for(int i=0; i<height; i++){
            System.out.print("");
            for(int j=0; j<width; j++){
                if(i==0 && j==0)
                    System.out.print("| O ");
                else
                    if(gauffre[i][j])
                        System.out.print("|   ");
                    else
                        System.out.print("| X ");
            }
            System.out.println("|");
            for (int j=0; j<width; j++)
                System.out.print("+---");
            System.out.println("+");
        }
    }
    
    
    //retourne la valeur lu de 'hauteur'
    public static int CheckHight(Scanner sc){
        System.out.println("hight of waffle?");
        int h=sc.nextInt();
        while(h<2){
            System.out.println("hight can't be lower than 2");
            h=sc.nextInt();
        }
        return h;
    }
    //retourne la valeur lu de 'largeur'
    public static int CheckWidth(Scanner sc){
        System.out.println("width of waffle?");
        int w=sc.nextInt();
        while(w<2){
            System.out.println("width can't be lower than 2");
            w=sc.nextInt();
        }
        return w;
    }
    
}