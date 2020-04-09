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
    
    //affiche la gauffre
    //param : entier h -> hauteur, entier w -> largeur
    //retour : void
    public static void DrawWaffle(){
        
        
        int h, w;
        //recuperation de la taille de la gauffre
        
        Scanner sc = new Scanner(System.in);
        
        h=CheckHight(sc);
        w=CheckWidth(sc);
        
        for (int j=0; j<w; j++)
                System.out.print("+---");
            System.out.println("+");
        for(int i=0; i<h; i++){
            System.out.print("");
            for(int j=0; j<w; j++){
                if(i==0 && j==0)
                    System.out.print("| O ");
                else
                    System.out.print("|   ");
            }
            System.out.println("|");
            for (int j=0; j<w; j++)
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