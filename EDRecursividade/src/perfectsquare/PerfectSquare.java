package perfectsquare;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tadeu.maffeis
 */
public class PerfectSquare {
    public boolean isPerfectSquare(double n)
    {
        return ps(n,2.0);
    }
    
    private boolean ps(double n, double r)
    {
        if (n == r * r)
        {
            return true;
        }
        if (n < r * r)
        {
            return false;
        }
        
        return ps(n, r + 1);
    }
    
    public double getPerfectSquare(double n)
    {
        return psn(n, 2.0);
    }
    
    private double psn(double n, double r)
    {
        if (n == r * r)
        {
            return r;
        }
        if (n < r * r)
        {
            return Double.POSITIVE_INFINITY;
        }
        
        return psn(n, r + 1.0);
    }            
}
