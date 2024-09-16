/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perfectsquare;

import java.util.Scanner;

/**
 *
 * @author tadeu.maffeis
 */
public class Main {
    public static void main(String[] args)
    {
        PerfectSquare pSquare = new PerfectSquare();
        Scanner in = new Scanner(System.in);
        
        System.out.println("\nInforme o numero: ");
        double number = in.nextDouble();
        
        if (pSquare.isPerfectSquare(number))
        {
            System.out.println("E quadrado perfeito: " + pSquare.getPerfectSquare(number));
        }
        else 
        {
            System.out.println("NAO e quadrado perfeito!");
        }
    }
}
