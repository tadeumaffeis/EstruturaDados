/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edlls;

/**
 *
 * @author tadeu.maffeis
 */
public class Node implements NodeValue {
    private int id;
    private Object value;
    private Node next;

    public Node() {
        this.id = 0;
        this.next = null;
        this.value = null;
    }
    
    public Node(int id, Object value) {
        this.id = id;
        this.value = value;
        this.next = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
