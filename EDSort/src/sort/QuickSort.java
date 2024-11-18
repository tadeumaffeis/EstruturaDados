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

    private void sort(int low, int high) {
        if (low < high) {
            // Particiona o array e obtém o índice do pivô
            int pivotIndex = (int) partition(low, high);

            // Ordena as duas subpartes recursivamente
            sort(low, pivotIndex - 1);
            sort(pivotIndex + 1, high);
        }
    }

    public void sort() {
        this.sort(0, (int) this.getSize() - 1);
    }

    private long partition(int low, int high) {
        long pivot = this.values[high];
        int i = (low - 1); // Índice do menor elemento

        for (int j = low; j < high; j++) {
            // Se o elemento atual é menor ou igual ao pivô
            if (this.values[j] <= pivot) {
                i++;
                // Troca arr[i] e arr[j]
                long temp = this.values[i];
                this.values[i] = this.values[j];
                this.values[j] = temp;
            }
        }

        // Troca arr[i + 1] e arr[high] (ou o pivô)
        long temp = this.values[i + 1];
        this.values[i + 1] = this.values[high];
        this.values[high] = temp;

        return i + 1;
    }

    private void swap(int indx, int i) {
        long aux = values[indx];
        values[indx] = values[i];
        values[i] = aux;
    }

    public void show() {
        if (EDSort.DEBUG)
            return;
        long size = this.getSize();
        for (int i = 0; i < size; i++) {
            System.out.printf("%d  ", values[i]);
        }
        System.out.println();
    }

}
