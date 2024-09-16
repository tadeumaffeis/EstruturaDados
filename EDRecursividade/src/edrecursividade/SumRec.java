/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edrecursividade;

/**
 *
 * @author tadeu.maffeis
 */
public class SumRec {
    public double somaPA(double n, double inicio, double razao)
    {
        // codição de término
        if (n <= 0)
        {
            return 0.0;
        }
        
        // recursão
        return inicio + somaPA(n - 1, inicio + razao, razao);
        
    }
    
    double sum (long size, double item)
    {
        if (size <= 0)
        {
            return 0;
        }
        
        return (item + this.sum(size - 1, item + 1.0));
    }
    
    public double fatorial(double n)
    {
        if (n <= 1)
        {
            return 1.0;
        }
        
        return n * fatorial(n - 1.0);
    }
}
