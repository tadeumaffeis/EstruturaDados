/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edsort;

import java.nio.channels.SelectableChannel;
import java.util.Random;
import sort.BubbleSort;
import sort.InsertionSort;
import sort.SelectionSort;

/**
 *
 * @author tadeu.maffeis
 */
public class EDSort {

    private static long[] EDSortRandomize(int limit, int size) {
        final double factor = Double.MAX_VALUE;
        long values[] = new long[size];
        Random random = new Random();
        random.nextLong();
        for (int i = 0; i < size; i++) {
            values[i] = random.nextLong(0, limit);
        }
        return values;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long v[] = EDSortRandomize(300000, 300000);
        InsertionSort sSort = new InsertionSort(v);
        //sSort.show();
        System.out.println();
        long st = System.nanoTime();
        sSort.sort();
        long et = System.nanoTime();
        //sSort.show();
        System.out.println("\n\nDuracao: " + ((et - st) / 1_000_000) + " milissegundos\n\n");
        for (int i = 0; i < v.length; i++) {
            System.out.printf("%d -", v[i]);
        }
    }
}
