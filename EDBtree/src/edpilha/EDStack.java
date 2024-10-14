/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edpilha;

/**
 *
 * @author tadeu.maffeis
 */
public class EDStack {

    private ListaLinearDupla stack;

    public EDStack() {
        this.stack = new ListaLinearDupla();
    }

    public void push(Node node) {
        stack.append(node);
    }

    public Node pop() {
        return stack.pop();
    }

    public void show() {
        stack.show();
    }
    
    public boolean empty()
    {
        return stack.empty();
    }
    
    public String toString()
    {
        return stack.toString();
    }
    
    public Node peek() 
    {
        return stack.peek();
    }
}
