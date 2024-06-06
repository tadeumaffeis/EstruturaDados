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

    public Node search(String id) {
        Node retNode = this.top;
        while (retNode != null && !retNode.getId().equals(id)) {
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

    public Node remove() {
        if (this.empty()) {
            return null;
        }
        Node newTop = null;
        Node aux = this.top;
        this.top = aux.getNext();
        aux.setNext(null);
        newTop = this.top;
        if (newTop != null) {
            newTop.setPrev(null);
        } else {
            this.bottom = this.top;
        }
        this.decSize();
        return aux;
    }

    public void insertPosN(long pos, Node node) {
        if (this.empty() && pos != 1) {
            return; // exceção
        }
        if (pos > this.size && pos != 1) {
            return;
        }
        if (pos == 1) {
            this.insert(node);
            return;
        }

        Node nodePrev = this.searchPos(pos - 1);
        Node nodePos = nodePrev.getNext();
        node.setNext(nodePos);
        nodePrev.setNext(node);
        this.addSize();
    }
    
    private void insertInOrd(Node node)
    {
        if (empty())
        {
            this.insert(node);
            return;
        }
        
        Node aux = this.top;
        
        while (aux != null && aux.getId().compareTo(node.getId()) < 0)
        {
            aux = aux.getNext();
        }
        
        if (aux == null)
        {
            this.append(node);
            return;
        }
        
        aux = aux.getPrev();
        
        if (aux == null)
        {
            this.append(node);
        }
        else
        {
            node.setNext(aux.getNext());
            node.getNext().setPrev(node);
            node.setPrev(aux);
            aux.setNext(node);
            this.addSize();
        }
    }

    public Node pop() {
        if (this.empty()) {
            return null;
        }
        Node aux = this.bottom;
        Node newBottom = null;
        this.bottom = aux.getPrev();
        if (this.bottom != null) {
            newBottom = this.bottom;
            newBottom.setNext(null);
            aux.setPrev(null);
        } else {
            this.top = this.bottom;
        }
        this.decSize();
        return aux;
    }

    private Node searchPos(long position) {
        if (this.empty() || position > this.size) {
            return null;
        }

        Node aux = this.top;
        for (int indx = 1; position != indx && aux != null; indx++) {
            aux = aux.getNext();
        }
        return aux;
    }

    public Object[] invArray() {
        Object[] array = new Object[(int) this.size];
        Node aux = this.bottom;
        for (int i = 0; aux != null; i++) {
            array[i] = aux.getValue();
            aux = aux.getPrev();
        }

        return array;
    }
    
    public ListaLinearDupla sort(boolean criteria)
    {
        if (empty())
        {
            return null;
        }
        
        ListaLinearDupla lld = new ListaLinearDupla();
        Node aux = this.top;
        while (aux != null)
        {
            Node node = new Node();
            node.setValue(aux.getValue());
            lld.insertInOrd(node);
        }
        
        if (criteria)
        {
            return lld;
        }
        else
        {
            ListaLinearDupla lld2 = new ListaLinearDupla();
            lld2.insert(lld.pop());
            return lld2;
        }
    }

    public void show() {
        Node aux = this.top;
        while (aux != null) {
            System.out.println("\n -> " + aux.getValue().toString());
            aux = aux.getNext();
        }
    }
}
