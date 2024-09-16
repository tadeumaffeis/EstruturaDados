/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edrecursividade;

import java.util.Scanner;

/**
 *
 * @author tadeu.maffeis
 */
public class EDRecursividade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        long[] vector = {1,2,3,5,6,7,8,9,10,40};
        System.out.println("\nInforme o numero: ");
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        
        BinarySearch bs = new BinarySearch(vector);
        
        boolean found = bs.found(num);
        
        if (found)
        {
            System.out.println("\nValor " + num + " existe no vetor");
        }
        else
        {
            System.out.println("\nValor " + num + " nao existe no vetor");
        }
    }

}
