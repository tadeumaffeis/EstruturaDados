/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edbtree;

import edfila.EDQueue;
import edfila.Node;

/**
 *
 * @author Tadeu Maffeis
 */
public class BTree<T> {

    private BTreeNode<T> rootNode;

    public BTree() {
    }

    private BTreeNode add(BTreeNode<T> root, BTreeNode<T> node) {

        JFrameShowBTree.showTree(BinaryTreeCanvas.getInstance(this.getRootNode()), 1);
        if (root == null) {
            return node;
        } else {
            if ((node.getKey()).compareTo(root.getKey()) <= 0) {
                root.setLeftNode(add(root.getLeftNode(), node));

            } else {
                root.setRightNode(add(root.getRightNode(), node));
            }
        }
        JFrameShowBTree.showTree(BinaryTreeCanvas.getInstance(this.getRootNode()), 1);
        BTreeNode retNode = balanceTree(root, node);
        return retNode;
    }

    public BTreeNode<T> getRootNode() {
        return rootNode;
    }

    public BTreeNode<T> addNode(BTreeNode node) {
        this.rootNode = add(this.rootNode, node);
        return (this.getRootNode());
    }

    private BTreeNode<T> balanceTree(BTreeNode root, BTreeNode node) {
        if (root == null) {
            return null;
        }
        // Verifica o desequilíbrio e realiza as rotações necessárias
        int balanceFactor = height(root.getLeftNode()) - height(root.getRightNode());
        //"\nBalancedFactor: " << balanceFactor << " key: " << key << " root->key: " << root -> key << "\n\n";

        if (balanceFactor > 1) {
            if (node.getKey().compareTo(root.getLeftNode().getKey()) <= 0) {
                root = rotateRight(root);
            } else {
                root = rotateLeftRight(root);
            }
        } else if (balanceFactor < -1) {
            if (node.getKey().compareTo(root.getRightNode().getKey()) > 0) {
                root = rotateLeft(root);
            } else {
                root = rotateRightLeft(root);
            }
        }

        return root;
    }

    private int height(BTreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1;
    }

    private BTreeNode<T> rotateLeft(BTreeNode<T> node) {
        BTreeNode<T> newRoot = node.getRightNode();
        node.setRightNode(newRoot.getLeftNode());
        newRoot.setLeftNode(node);
        return newRoot;
    }

// Função para realizar uma rotação simples para a direita (RR)
    private BTreeNode<T> rotateRight(BTreeNode<T> node) {
        BTreeNode newRoot = node.getLeftNode();
        node.setLeftNode(newRoot.getRightNode());
        newRoot.setRightNode(node);
        return newRoot;
    }

// Função para realizar uma rotação dupla à esquerda (LR)
    private BTreeNode<T> rotateLeftRight(BTreeNode<T> node) {
        node.setLeftNode(rotateLeft(node.getLeftNode()));
        return rotateRight(node);
    }

// Função para realizar uma rotação dupla à direita (RL)
    private BTreeNode<T> rotateRightLeft(BTreeNode<T> node) {
        node.setRightNode(rotateRight(node.getRightNode()));
        return rotateLeft(node);
    }

    public void add(BTreeNode<T> node) {
        this.rootNode = this.addNode(node);
    }

    public T[] getArray() {
        edfila.EDQueue values = new EDQueue();
        deepSearch(this.getRootNode(), values);

        int size = (int) Math.pow(2.0, this.height(this.getRootNode()));
        T[] arrayValues = (T[]) new Object[size];
        for (int i = 0; !values.empty(); i++) {
            arrayValues[i] = (T) values.dequeue().getValue();
        }
        return arrayValues;
    }

    private void deepSearch(BTreeNode<T> root, edfila.EDQueue values) {
        if (root == null) {
            return;
        }
        // esquerda
        deepSearch(root.getLeftNode(), values);
        if (values != null) {
            // valor da raiz
            values.add(new edfila.Node(root.getKey(), root.getInformation()));
        }
        // direita
        deepSearch(root.getRightNode(), values);
    }

    private BTreeNode<T> searchNode(BTreeNode<T> root, String key) {
        BTreeNode nodeRet;

        if (root == null) {
            return null;
        }
        if (key.equals(root.getKey())) {
            return root;
        }
        if (key.compareTo(root.getKey()) < 0) {
            nodeRet = searchNode(root.getLeftNode(), key);
        } else {
            nodeRet = searchNode(root.getRightNode(), key);
        }

        return nodeRet;
    }

    public BTreeNode<T> search(String key) {
        return searchNode(this.rootNode, key);
    }

    /**
     * Show
     *
     * @param root
     * @param tabs
     */
    public void Show(BTreeNode<T> root, String tabs) {
        StringBuilder ntabs = new StringBuilder();
        ntabs.append(tabs);
        ntabs.append("    ");
        if (root != null) {
            Show(root.getLeftNode(), ntabs.toString());
            System.out.println(tabs + root.getKey());
            Show(root.getRightNode(), ntabs.toString());
        }
    }

    public void showVerticalOrder() {
        int h = (int) this.height(this.getRootNode());
        System.out.println("\n");
        for (int destLevel = 1; destLevel <= h; destLevel++) {
            showSubTreeVerticalOrder(this.getRootNode(), 1, destLevel);
            System.out.println();
        }
    }

    private void showSubTreeVerticalOrder(BTreeNode<T> root, int level, int destLevel) {
        if (root == null) {
            return;
        }

        long maxElements = (int) Math.pow(2, level);
        long tab = Math.round(160 / maxElements);

        if (level == destLevel) {
            int len = root.getInformation().toString().length();
            showSpaces(tab);
            System.out.print(root.getInformation());
            showSpaces(tab - len);
            return;
        }

        showSubTreeVerticalOrder(root.getLeftNode(), (level + 1), destLevel);
        showSubTreeVerticalOrder(root.getRightNode(), (level + 1), destLevel);
    }

    private void showSpaces(long times) {
        for (; times > 0; times--) {
            System.out.print(" ");
        }
    }

    public BTreeNode<T> getMax(BTreeNode<T> root) {
        if (root == null) {
            return null;
        }

        if (root.getRightNode() == null) {
            return root;
        }

        return getMax(root.getRightNode());
    }

    public BTreeNode<T> getMin(BTreeNode<T> root) {
        if (root == null) {
            return null;
        }

        if (root.getLeftNode() == null) {
            return root;
        }

        return getMin(root.getLeftNode());
    }
    
    private BTreeNode<T> getParentNode(BTreeNode<T> root, BTreeNode<T> node)
    {
        if (root == null)
        {
            return null;
        }
        
        if (root.getLeftNode() == node || root.getRightNode() == node)
        {
            return root;
        }
        
        BTreeNode<T> leftNode = this.getParentNode(root.getLeftNode(), node);
        if (leftNode != null)
        {
            return leftNode;
        }
        
        return this.getParentNode(root.getRightNode(), node);
    }
    
    public BTreeNode<T> getParent(BTreeNode<T> node)
    {
        return getParentNode(this.getRootNode(), node);
    }
    
    public BTreeNode<T> remove(String key)
    {
        BTreeNode<T> node = this.search(key); // buscar referencia
        
        if (node == null)
        {
            return null; // chave não existe
        }
        
        BTreeNode<T> parentNode = this.getParent(node);
        // parentNode == null => node é a raiz da árvore
        
        if (node.getLeftNode() == null && node.getRightNode() == null)
        {
            if (parentNode != null && parentNode.getLeftNode() == node)
            {
                parentNode.setLeftNode(null);
            }
            else 
            {
                if (parentNode != null)
                {
                    parentNode.setRightNode(null);
                }
            }
            
            return node;
        }
        
        // continua aqui
        
        return null;
        
    }
}
