/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fibonacci;

import java.util.Scanner;

/**
 *
 * @author tadeu.maffeis
 */
public class Main {
    public static void main(String[] args)
    {
        Fibonacci fibonacci = new Fibonacci();
        Scanner in = new Scanner(System.in);
        
        System.out.println("\nInforme o quantidade: ");
        double number = in.nextDouble();
        
        fibonacci.nf(number);
    }
}
