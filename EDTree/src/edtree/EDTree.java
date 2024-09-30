/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edtree;

/**
 *
 * @author Tadeu Maffeis
 */
public class EDTree<T> {

    private TreeNode<T> root;
    private long size;

    public EDTree() {
        this.root = null;
        this.size = 0;
    }

    public EDTree(TreeNode<T> root) {
        this.root = root;
        this.size = 0;
    }

    private void setRoot(TreeNode<T> node) {
        this.root = node;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    private void addSize() {
        this.size++;
    }

    public long getSize() {
        return this.size;
    }

    public long getHeight() {
        int retValue = 0;
        for (int i = 0; Math.pow(2.0, (double) i) < this.size; i++) {
            retValue = i;
        }
        return retValue + 1;
    }

    public void add(TreeNode<T> node) {
        System.out.println("Level = " + getHeight());
        if (this.getRoot() == null) {
            this.setRoot(node);
        } else {
            TreeNode<T> aux = insert(this.getRoot(), node, 1);
        }
        this.addSize();
    }

    public TreeNode<T> insert(TreeNode<T> lRoot, TreeNode<T> node, int index) {
        TreeNode<T> left = null;
        TreeNode<T> right = null;
        TreeNode<T> aux = null;

        if (lRoot == null) {
            if (index == this.size + 1) {
                return node;
            } else {
                return null;
            }
        }

        if (2 * index <= this.size + 1) {
            left = insert(lRoot.getLeftNode(), node, 2 * index);
            lRoot.setLeftNode(left);
        }

        if (2 * index + 1 <= this.size + 1) {
            right = insert(lRoot.getRightNode(), node, 2 * index + 1);
            lRoot.setRightNode(right);
        }

        return lRoot;
    }

    public void show() {
        TreeNode aux = this.getRoot();
        showSubTree(aux, 1);
    }

    private void showSubTree(TreeNode<T> root, int level) {
        if (root == null) {
            return;
        }

        showSubTree(root.getLeftNode(), level + 2);
        System.out.print(String.valueOf(' ').repeat(level) + root.getValue().toString() + "\n\n\n");
        showSubTree(root.getRightNode(), level + 2);
    }

    public void showToString() {
        TreeNode aux = this.getRoot();
        showSubTreeToString(root, 0);

    }

    private void showSubTreeToString(TreeNode<T> root, int level) {
        if (root == null) {
            return;
        }
        System.out.print("{");
        System.out.print(root.getValue());
        showSubTreeToString(root.getLeftNode(), level + 1);
        if (root.getLeftNode() != null) {
            System.out.print(",");
        }
        showSubTreeToString(root.getRightNode(), level + 1);
        System.out.print("}");
    }

    public void showLeftRight() {
        TreeNode<T> aux = this.getRoot();
        StringBuilder sb = new StringBuilder();
        sb.repeat(' ', this.getSpaces(1));
        System.out.print(sb.toString());
        System.out.print(this.getRoot().getValue());
        System.out.println("\n\n");
        for (int i = 1; i < this.getHeight(); i++) {
            showSubTreeLeftRight(root.getLeftNode(), i, 1);
            showSubTreeLeftRight(root.getRightNode(), i, 1);
        }
    }

    private void showSubTreeLeftRight(TreeNode<T> root, int height, int index) {
        if (root == null) {
            return;
        }
        if (height >= index) {
            StringBuilder sb = new StringBuilder();
            sb.repeat(' ', this.getSpaces(height));
            System.out.print(sb.toString());
            System.out.print(root.getValue());
        } else {
            showSubTreeLeftRight(root.getLeftNode(), height + 1, index);
            showSubTreeLeftRight(root.getRightNode(), height + 1, index);
        }
    }

    private int getSpaces(int h) {
        double total = Math.pow(2.0, h);
        double spaces = 80.0 / total;
        return (int) spaces;
    }

}
