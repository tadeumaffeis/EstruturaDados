/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edpilha;

/**
 *
 * @author tadeu.maffeis
 */
public class Node implements NodeValue {
    private String id;
    private Object value;
    private Node next;
    private Node prev;

    public Node() {
        this.id = "";
        this.next = null;
        this.prev = null;
        this.value = null;
    }
    
    public Node(String id, Object value) {
        this.id = id;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
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
