/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sort;

/**
 *
 * @author tadeu.maffeis
 */
public class HeapSort {

    private long[] values;

    public HeapSort(long[] values) {
        this.values = values;
    }

    public void sort() {
        int n = values.length;

        // Construir o Max-Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(n, i);
        }

        // Extrair elementos do Heap um a um
        for (int i = n - 1; i > 0; i--) {
            // Mover a raiz atual para o final
            long temp = values[0];
            values[0] = values[i];
            values[i] = temp;

            // Chamar heapify no Heap reduzido
            heapify(i, 0);
        }
    }

    // Função para transformar o valuesay em um Max-Heap
    void heapify(int n, int i) {
        int largest = i; // Inicializa o maior como raiz
        int left = 2 * i + 1; // Filho esquerdo
        int right = 2 * i + 2; // Filho direito

        // Se o filho esquerdo é maior que a raiz
        if (left < n && values[left] > values[largest]) {
            largest = left;
        }

        // Se o filho direito é maior que o maior até agora
        if (right < n && values[right] > values[largest]) {
            largest = right;
        }

        // Se o maior não é a raiz
        if (largest != i) {
            long swap = values[i];
            values[i] = values[largest];
            values[largest] = swap;

            // Heapify na subárvore afetada
            heapify(n, largest);
        }
    }

    public long getSize() {
        return values.length;
    }

    public void show() {
        long size = this.getSize();
        for (int i = 0; i < size; i++) {
            System.out.printf("%d  ", values[i]);
        }
        System.out.println();
    }
}
