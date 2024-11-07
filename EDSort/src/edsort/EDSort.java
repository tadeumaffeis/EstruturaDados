/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edsort;

import java.nio.channels.SelectableChannel;
import java.util.Random;
import java.util.Scanner;
import sort.BubbleSort;
import sort.InsertionSort;
import sort.SelectionSort;

/**
 *
 * @author tadeu.maffeis
 */
public class EDSort {

    public final static int BUBBLESORT      = 1;
    public final static int SELECTIONSORT   = 2;
    public final static int INSERTIONSORT   = 3;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (args.length < 2) {
            System.err.println("\nQuantidade de parametros incorreta!");
            System.exit(-1);
        }
        // TODO code application logic here
        int size = Integer.parseInt(args[0]);
        int alg = Integer.parseInt(args[1]);
        
        Scanner in = new Scanner(System.in);

        long[] values = new long[size];

        for (int i = 0; i < size; i++) {
            values[i] = in.nextInt();
        }

        long st = System.nanoTime();
        
        switch (alg) {
            case BUBBLESORT: {
                BubbleSort sort = new BubbleSort(values);
                sort.sort();
                break;
            }
            case SELECTIONSORT: {
                SelectionSort sort = new SelectionSort(values);
                sort.sort();
                break;
            }
            case INSERTIONSORT: {
                InsertionSort sort = new InsertionSort(values);
                sort.sort();
                break;
            }
        }
        long et = System.nanoTime();

        System.out.println("\n\nDuracao: " + ((et - st) / 1_000_000) + " milissegundos\n\n");
        //for (int i = 0; i < v.length; i++) {
        //    System.out.printf("%d -", v[i]);
        //}
    }
}
