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
        for (int i = 0; Math.pow(2.0, (double) i) - 1 <= this.size; i++) {
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

    public void showVerticalOrder() {
        int h = (int) this.getHeight();
        System.out.println("\n");
        for (int destLevel = 1; destLevel <= h; destLevel++) {
            showSubTreeVerticalOrder(this.getRoot(), 1, destLevel);
            System.out.println();
        }
    }

    private void showSubTreeVerticalOrder(TreeNode<T> root, int level, int destLevel) {
        if (root == null) {
            return;
        }
        
        long maxElements = (int) Math.pow(2,level);
        long tab = Math.round(160 / maxElements);
        

        if (level == destLevel) {
            int len = root.getValue().toString().length();
            showSpaces(tab);
            System.out.print(root.getValue());
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
