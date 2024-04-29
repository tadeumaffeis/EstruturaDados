/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edlls;

/**
 *
 * @author tadeu.maffeis
 */
public class ListaLinearSimples {

    private Node top;
    private Node bottom;
    private long size;

    public ListaLinearSimples() {
        this.top = null;
        this.bottom = null;
        this.size = 0;
    }

    private boolean empty() {
        return (this.top == null && this.bottom == null);
    }

    public void add(Node node) {
        if (this.empty()) {
            this.top = this.bottom = node;
        } else {
            Node aux = this.top;
            this.top = node;
            this.top.setNext(aux);
        }
        this.addSize();
    }

    public void append(Node node) {
        if (this.empty()) {
            this.top = this.bottom = node;
        } else {
            Node aux = this.bottom;
            this.bottom = node;
            aux.setNext(node);
        }
        this.addSize();
    }
    
    private void addSize()
    {
        this.size++;
    }
    
    private long length()
    {
        return this.size;
    }
    
    public Node searchWithClone(long position)
    {
        if (this.empty() || position > this.length())
        {
            return null;
        }
        
        Node aux = this.top;
        for (int indx = 1; position != indx && aux != null; indx++)
        {
            aux = aux.getNext();
        }
        
        Node retNode = new Node(aux.getId(),aux.getValue());
        
        return retNode;
    }
    
    public NodeValue searchWithInterface(long position)
    {
        if (this.empty() || position > this.length())
        {
            return null;
        }
        
        Node aux = this.top;
        for (int indx = 1; position != indx && aux != null; indx++)
        {
            aux = aux.getNext();
        }
        return (NodeValue) aux;
    }

    public void show() {
        Node aux = this.top;
        while (aux != this.bottom) {
            System.out.print(" --> " + aux.getValue().toString());
            aux = aux.getNext();
        }
        System.out.print(" --> " + aux.getValue());
    }
}
