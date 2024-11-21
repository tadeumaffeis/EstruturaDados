/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sort;

import edsort.EDSort;

/**
 *
 * @author tadeu.maffeis
 */
public class QuickSort {

    private long[] values;

    public QuickSort(long[] values) {
        this.values = values;
    }

    public long getSize() {
        return values.length;
    }

    private void sort(long began, long end) {
        int i, j, pivo, aux, indxPivo;
        
        i = (int) began;
        j = (int) end - 1;

        indxPivo = (int) ((began + end) / 2);
        pivo = (int) this.values[indxPivo];

        while (i <= j) {
            while (values[i] < pivo && i < end) {
                i++;
            }
            while (values[j] > pivo && j > began) {
                j--;
            }
            if (i <= j) {
                this.swap(i, j);
                i++;
                j--;
            }
        }
        
        if (j > began) {
            sort(began, j + 1);
        }
        if (i < end) {
            sort(i, end);
        }
    }

    public void sort() {
        this.sort(0, (int) this.getSize());
    }

    private void swap(int indx, int i) {
        long aux = values[indx];
        values[indx] = values[i];
        values[i] = aux;
    }

    public void show() {
        if (EDSort.DEBUG) {
            return;
        }
        long size = this.getSize();
        for (int i = 0; i < size; i++) {
            System.out.printf("%d  ", values[i]);
        }
        System.out.println();
    }

}
