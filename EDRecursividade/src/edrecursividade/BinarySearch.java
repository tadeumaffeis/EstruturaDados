/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edrecursividade;

/**
 *
 * @author tadeu.maffeis
 */
public class BinarySearch {

    private long[] vector;
    
    public BinarySearch(long[] vector) {
        this.vector = vector;
    }
    
    public boolean found(long value)
    {
        boolean retValue;
        
        retValue = search(value, 0, vector.length - 1);
        
        return retValue;
    }
    
    private boolean search(long value, int left, int right)
    {
        boolean retValue;
        
        System.out.println("value: " + value + " left: " + left + " right: " + right + " media: " + (left+right)/2);
        
        if ( left > right)
        {
            return false;
        }
        
        int media = (left + right) / 2;
        
        if (value == this.vector[media])
        {
            return true;
        }
        
        if (value < this.vector[media])
        {
            retValue = search(value, left, media - 1);
        }
        else
        {
            retValue = search(value, media + 1, right);
        }
        
        return retValue;
    }
}
