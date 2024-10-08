/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edbtree;

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
}
