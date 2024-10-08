/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edbtree;

/**
 *
 * @author Tadeu Maffeis
 */
public class EDBtreeMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] values = {10, 1, 44, 32, 45, 67, 8, 32, 12, 34, 12};
        BTree<Integer> tree = new BTree<>();

        for (int v : values) {
            tree.add(new BTreeNode<Integer>(String.format("%015d", v), v));
        }

        JFrameShowBTree.showTree(BinaryTreeCanvas.getInstance(tree.getRootNode()), 2);

    }

}
