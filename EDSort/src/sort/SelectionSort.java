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
public class SelectionSort {

    private long[] values;

    public SelectionSort(long[] values) {
        this.values = values;
    }

    public long getSize() {
        return values.length;
    }

    public void sort() {
        long size = this.getSize();
        for (int x = 0; x < size - 1; x++) {
            //show();
            for (int y = x; y < size; y++) {
                if (values[x] > values[y]) {
                    swap(x, y);
                }
            }
        }
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
