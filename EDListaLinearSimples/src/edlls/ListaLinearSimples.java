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

    public void insertPosN(long pos, Node node) {
        if (this.empty() && pos != 1) {
            return; // exceção
        }
        if (pos > this.length() && pos != 1) {
            return;
        }
        if (pos == 1) {
            this.add(node);
            return;
        }

        Node nodePrev = this.searchPos(pos - 1);
        Node nodePos = nodePrev.getNext();
        node.setNext(nodePos);
        nodePrev.setNext(node);
        this.addSize();
    }

    public void insertInOrd(Node node)
    {
        
    }
    
    public Node removePosN(long pos) {
        if (this.empty()) {
            return null;
        }

        if (pos == 1) {
            return this.remove();
        }

        if (this.length() == pos) {
            return this.pop();
        }
        // remover pos N com size > que 1 e 1 < pos < size
        if (pos != 1 && this.length() <= 1) {
            return null;
        }

        if (pos > this.length()) {
            return null;
        }

        Node ant = this.searchPos(pos - 1);
        Node aux = ant.getNext();

        ant.setNext(aux.getNext());
        aux.setNext(null);

        this.decSize();
        
        return aux;
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

    public Node remove() {
        Node retNode = null;
        Node aux = null;

        if (this.empty()) {
            return null;
        }

        if (this.length() <= 1) {
            retNode = this.top;
            this.top = this.bottom = null;
        } else {
            retNode = this.top;
            aux = retNode.getNext();
            retNode.setNext(null);
            this.top = aux;
        }

        this.decSize();

        return retNode;
    }

    public Node pop() {
        Node retNode = null;
        Node aux = null;

        if (this.empty()) {
            return null;
        }

        if (this.length() <= 1) {
            retNode = this.top;
            this.top = this.bottom = null;
        } else {
            retNode = this.bottom;
            aux = this.searchPos(this.length() - 1);
            aux.setNext(null);
            this.bottom = aux;
        }

        this.decSize();

        return retNode;
    }

    public void clear() {
        while (!this.empty()) {
            this.pop();
        }
    }

    private void addSize() {
        this.size++;
    }

    private void decSize() {
        this.size--;
    }

    private long length() {
        return this.size;
    }

    public Node searchPosWithClone(long position) {
        if (this.empty() || position > this.length()) {
            return null;
        }

        Node aux = this.top;
        for (int indx = 1; position != indx && aux != null; indx++) {
            aux = aux.getNext();
        }

        Node retNode = new Node(aux.getId(), aux.getValue());

        return retNode;
    }

    public NodeValue searchPosWithInterface(long position) {
        if (this.empty() || position > this.length()) {
            return null;
        }

        Node aux = this.top;
        for (int indx = 1; position != indx && aux != null; indx++) {
            aux = aux.getNext();
        }
        return (NodeValue) aux;
    }

    private Node searchPos(long position) {
        if (this.empty() || position > this.length()) {
            return null;
        }

        Node aux = this.top;
        for (int indx = 1; position != indx && aux != null; indx++) {
            aux = aux.getNext();
        }
        return aux;
    }

    public Node searchContent(String key) {
        if (this.empty()) {
            return null;
        }
        Node aux = this.top;
        while (aux != null) {
            if (key.equals(aux.getId())) {
                break;
            }
            aux = aux.getNext();
        }

        return aux;
    }

    public void show() {
        Node aux = this.top;
        while (aux != this.bottom) {
            System.out.print(" --> " + aux.getValue().toString());
            aux = aux.getNext();
        }
        if (aux != null) {
            System.out.print(" --> " + aux.getValue());
        }
    }
}
