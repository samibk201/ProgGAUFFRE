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
            Affichages.affichages.height=CheckHeight(sc);
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
    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    public void DrawWaffle(boolean[][] gauffre){
        
        int f=0;
        //boolean[][] gauffre = Play.InitTabGauffre(h, w);
        System.out.print("  ");
        for (int j=0; j<=width; j++){
            if(j<10)
                System.out.print(j+"   ");
            else
                System.out.print(+j+"  ");
        }
        System.out.print("\n  ");
        for (int j=0; j<width; j++)
            if(gauffre[0][j])
                System.out.print("+---");
            System.out.println("+");
        for(int i=0; i<height; i++){
            if(i<10)
                System.out.print(i+" ");
            else
                System.out.print(i);
            for(int j=0; j<width; j++){
                if(i==0 && j==0)
                    System.out.print("| O ");
                else
                    if(gauffre[i][j])
                        System.out.print("|   ");
                    else
                        System.out.print("");
            }
            if(gauffre[i][0])
                System.out.print("|\n  ");
            else
                System.out.println("");
            for (int j=0; j<width; j++)
                if(gauffre[i][j])
                    System.out.print("+---");
            if(gauffre[i][0])
                System.out.println("+");
            else
                System.out.println("");
            f=i;
        }
        System.out.println(f+1);
    }
    
    
    //retourne la valeur lue de 'height'
    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    public static int CheckHeight(Scanner sc){
        System.out.println("> height of waffle?");
        int intValue=0,v=0;
        String h=sc.next();
        try {
            intValue = Integer.parseInt(h);
        }catch(NumberFormatException e) {
            System.out.println("> Input is not a valid integer");
            v=1;
        }
        while(intValue<2){
            if(v==0)
                System.out.println("> height can't be lower than 2");
                h=sc.next();
            try {
                intValue = Integer.parseInt(h);
                v=0;
            }catch(NumberFormatException e) {
                System.out.println("> Input is not a valid integer");
                v=1;
            }
            
        }
        return intValue;
    }
    //retourne la valeur lue de 'width'
    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    public static int CheckWidth(Scanner sc){
        System.out.println("> width of waffle?");
        String w=sc.next();
        int intValue=0,v=0;
        
        try {
            intValue = Integer.parseInt(w);
        }catch(NumberFormatException e) {
            System.out.println("> Input is not a valid integer");
            v=1;
        }
        
        while(intValue<2){
            if(v==0)
                System.out.println("> width can't be lower than 2");
                w=sc.next();
            try {
                intValue = Integer.parseInt(w);
                v=0;
            }catch(NumberFormatException e) {
                System.out.println("> Input is not a valid integer");
                v=1;
            }
        }
        return intValue;
    }
    
}