/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fibonacci;

/**
 *
 * @author tadeu.maffeis
 */
public class Fibonacci {

    public Fibonacci() {
    }
    public void nf(double nesimo)
    {
        fibonacci(nesimo, 0.0, 1.0);
    }
    
    private void fibonacci(double n, double f, double s)
    {
        if (n <= 1)
        {
            System.out.println((int)f);
            return;
        }
        System.out.print((int)f);
        System.out.print(",");
        fibonacci(n-1, s, f+s);
    }
}
