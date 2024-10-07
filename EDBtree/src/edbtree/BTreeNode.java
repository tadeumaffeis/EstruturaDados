/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edbtree;

/**
 *
 * @author Tadeu Maffeis
 */
public class BTreeNode<T> {
    private String key;
    private T information;
    private BTreeNode leftNode;
    private BTreeNode rightNode;

    public BTreeNode() {
    }

    public BTreeNode(String key, T information) {
        this.key = key;
        this.information = information;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getInformation() {
        return information;
    }

    public void setInformation(T information) {
        this.information = information;
    }

    public BTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BTreeNode rightNode) {
        this.rightNode = rightNode;
    }
    
    public String toString()
    {
        return this.getInformation().toString();
    }

}
