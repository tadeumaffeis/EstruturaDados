/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edfila;

/**
 *
 * @author tadeu.maffeis
 */
public class EDQueue {

    private ListaLinearDupla queue;

    public EDQueue() {
        this.queue = new ListaLinearDupla();
    }

    /**
     * Adicionar elementos ao inicio da lista
     * 
     * @param node 
     */
    public void add(Node node) {
        queue.append(node);
    }

    /**
     * Remover elemeentos do final da lista
     * 
     * @return 
     */
    public Node remove() {
        return queue.remove();
    }

    /**
     * 
     * = Add
     * 
     * @param node 
     */
    public void enqueue(Node node) {
        this.add(node);
    }

    /**
     * = Remove
     * 
     * @return 
     */
    public Node dequeue() {
        return this.remove();
    }

    /**
     * Consulta o primeiro elemento da fila
     * 
     * @return 
     */
    public Node peek() {
        return queue.peekTop();
    }

    public void show() {
        queue.show();
    }

    public boolean empty() {
        return queue.empty();
    }

    public String toString() {
        return queue.toString();
    }
}
