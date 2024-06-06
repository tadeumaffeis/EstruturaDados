/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import edlld.ListaLinearDupla;
import edlls.ListaLinearSimples;
import edlld.Node;
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

        ListaLinearDupla list = new ListaLinearDupla();
        Scanner in = new Scanner(System.in);
        int id = 0;
        String sid = "";
        String name = "";
        String email = "";

        for (; id >= 0;) {
            System.out.print("informations: ");
            id = in.nextInt();
            name = in.next();
            email = in.next();

            if (id < 0) {
                break;
            }

            //list.add(new Node(id + "", new Nothing(id, name, email)));
            //list.insertPosN(1, new Node(id + "", new Nothing(id, name, email)));
            //list.insert(new Node(id + "", new Integer(id)));
            list.append(new Node(id + "", new Integer(id)));
        }
        
        ListaLinearDupla lld = list.sort(false);
        
        lld.show();
        
        //Object[] array = list.invArray();
        
        //for (int i=0; i < array.length; i++)
        //{
        //    System.out.println("[" + array[i] + "]" );
        //}
        
        //while (!list.empty())
        //{
        //    Node aux = list.pop();
         //   System.out.println("Node value: " + aux.getValue().toString());
        //}
        
        //System.out.print("Pesquisar Id. Informe o Id: ");
        //id = in.nextInt();
        //Node nodeRet = list.search(id + "");
        //String sret = nodeRet == null ? "*NULL*" : nodeRet.getId() + " - " + nodeRet.getValue().toString();
        //System.out.println("\nRetorno -> " + sret);
        /*
        System.out.println("\n\n");
        list.show();
        System.out.println("\n\n");
        list.insertPosN(3, new Node(id + "", new Nothing(id, name, email)));
        System.out.println("\n\n");
        list.show();
        list.insertPosN(2, new Node(id + "", new Nothing(id, name, email)));
        System.out.println("\n\n");
        list.show();
        System.out.println("\n\nRemovendo node 2\n\n");
        list.removePosN(2);
        list.show();
        System.out.println("\n\nRemovendo nodew 3\n\n");
        list.removePosN(3);
        list.show();
        /*
        System.out.println("Pesquisar n-esimo. Informe a posicao: ");
        int position = in.nextInt();
        
        Node searchedNodeClone = list.searchWithClone(position);
        NodeValue searchedNodeInterface = list.searchWithInterface(position);
        
        System.out.println("Node: " + searchedNodeClone.getValue());
        System.out.println("Node: " + searchedNodeInterface.getValue());
         */
 /*
        System.out.println("Removendo o primeiro no da lista: ");
        Node nodeRet = list.pop();
        if (nodeRet != null) {
            System.out.println("No removido: " + nodeRet.getId() + " " + nodeRet.getValue());
        }
        list.show();
        System.out.println("\n\n\n");

        nodeRet = list.pop();
        if (nodeRet != null) {
            System.out.println("No removido: " + nodeRet.getId() + " " + nodeRet.getValue());
        }
        Node aux = list.searchContent("2");
        if (aux != null) {
            System.out.println("\nSearch content: 2 -> " + aux.getValue().toString());
        } else {
            System.out.println("\nContent is NULL\n\n");
        }
         */
        System.out.println("\n\n");
        list.show();
    }

}
