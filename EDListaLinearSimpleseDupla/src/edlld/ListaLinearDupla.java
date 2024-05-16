/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edlld;

/**
 *
 * @author tadeu.maffeis
 */
public class ListaLinearDupla {

    private Node top;
    private Node bottom;
    private long size;

    public ListaLinearDupla() {
        this.top = null;
        this.bottom = null;
        this.size = 0;
    }

    private void addSize() {
        this.size++;
    }

    private void decSize() {
        this.size--;
    }

    public boolean empty() {
        return (this.top == null && this.bottom == null);
    }

    public void insert(Node node) {
        if (this.empty()) {
            this.top = node;
            this.bottom = node;
        } else {
            Node aux2 = this.top;
            node.setNext(aux2);
            this.top = node;
            aux2.setPrev(this.top);
        }

        this.addSize();
    }
    
    public Node search(String id)
    {
        Node retNode = this.top;
        while (retNode != null && !retNode.getId().equals(id))
        {
            retNode = retNode.getNext();
        }
        return retNode; 
    }

    public void append(Node node) {
        if (this.empty()) {
            this.top = node;
            this.bottom = node;
        } else {
            Node aux2 = this.bottom;
            node.setPrev(aux2);
            this.bottom = node;
            aux2.setNext(this.bottom);
        }

        this.addSize();
    }

    public void show() {
        Node aux = this.top;
        while (aux != null) {
            System.out.println("\n -> " + aux.getValue().toString());
            aux = aux.getNext();
        }
    }
}
