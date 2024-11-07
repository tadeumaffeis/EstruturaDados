/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sort;

/**
 *
 * @author tadeu.maffeis
 */
public class BubbleSort {

    private long[] values;

    public BubbleSort(long[] values) {
        this.values = values;
    }

    public long getSize() {
        return values.length;
    }

    public void sort() {
        long size = this.getSize();
        boolean changed = true;
        while (changed) {
            show();
            changed = false;
            for (int indx = 0; indx < size - 1; indx++) {
                if (values[indx] > values[indx+1])
                {
                    swap(indx, indx+1);
                    changed = true;
                }
            }
        }
    }

    private void swap(int indx, int i) {
        long aux = values[indx];
        values[indx] = values[i];
        values[i] = aux;
    }
        
    public void show()
    {
        long size = this.getSize();
        for (int i=0; i < size; i++)
        {
            System.out.printf("%d  ", values[i]);
        }
        System.out.println();
    }

}
