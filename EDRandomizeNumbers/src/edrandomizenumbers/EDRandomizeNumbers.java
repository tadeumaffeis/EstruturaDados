/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edrandomizenumbers;

import java.util.Random;

/**
 *
 * @author tadeu.maffeis
 */
public class EDRandomizeNumbers {

    /**
     * @param args the command line arguments
     */
    private static long[] EDSortRandomize(int size, long limit) {
        final double factor = Double.MAX_VALUE;
        long values[] = new long[size];
        Random random = new Random();
        random.nextLong();
        for (int i = 0; i < size; i++) {
            values[i] = random.nextLong(0, limit);
        }
        return values;
    }

    public static void main(String[] args) {
        
        if (args.length < 2)
        {
            System.err.println("Quantidade de paramentros incorretos");
            System.err.println("\tSintaxe:");
            System.err.println("\t\t" + args[0] + " qtde limit of range [0..limit]");
            System.exit(-1);
        }
        
        int qtde = Integer.parseInt(args[0]);
        long limit = Long.parseLong(args[1]);
        
        long values[] = EDSortRandomize(qtde, limit);
        
        for (int i=0; i < values.length; i++)
        {
            System.out.println(values[i] + " ");
        }
    }

}
