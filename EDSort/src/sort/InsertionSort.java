/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sort;

/**
 *
 * @author tadeu.maffeis
 */
public class InsertionSort {

    private long[] values;

    public InsertionSort(long[] values) {
        this.values = values;
    }

    public long getSize() {
        return values.length;
    }

    public void sort() {
        for (int i = 1; i < values.length; i++) {
            long current = values[i];
            int j = i - 1;

            // Move os elementos do valuesay que são maiores que o valor atual
            // para uma posição à frente de sua posição atual
            while (j >= 0 && values[j] > current) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = current;
        }   
    }

    private void swap(int indx, int i) {
        long aux = values[indx];
        values[indx] = values[i];
        values[i] = aux;
    }

    public void show() {
        long size = this.getSize();
        for (int i = 0; i < size; i++) {
            System.out.printf("\n%d  ", values[i]);
        }
        System.out.println();
    }
}
