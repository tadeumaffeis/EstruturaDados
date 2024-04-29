/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import edlls.ListaLinearSimples;
import edlls.Node;
import edlls.NodeValue;
import edlls.Nothing;
import java.util.Scanner;

/**
 *
 * @author tadeu.maffeis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ListaLinearSimples list = new ListaLinearSimples();
        Scanner in = new Scanner(System.in);
        int id = 0;
        String name;
        String email;
        
        for (; id >= 0;) {
            System.out.print("informations: ");
            id = in.nextInt();
            name = in.next();
            email = in.next();
            
            if (id < 0) {
                break;
            }
            
            list.add(new Node(id, new Nothing(id,name,email)));
        }
        list.show();
        
        System.out.println("Pesquisar n-esimo. Informe a posicao: ");
        int position = in.nextInt();
        
        Node searchedNodeClone = list.searchWithClone(position);
        NodeValue searchedNodeInterface = list.searchWithInterface(position);
        
        System.out.println("Node: " + searchedNodeClone.getValue());
        System.out.println("Node: " + searchedNodeInterface.getValue());
    }

}
