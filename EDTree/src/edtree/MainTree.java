/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edtree;

public class MainTree {

    public static void main(String[] args) {
        EDTree<Double> tree = new EDTree<>();
        int[] values = {1, 2, 3, 4, 5, 6, 7 }; //, 8, 9, 10, 11, 12, 13, 14, 15,16,17,18,19,20,21,22,23,24,25};
        //double[] values = {1,2,3};
        for (double v : values) {
            TreeNode<Double> node = new TreeNode<>();
            node.setValue(v);
            tree.add(node);
        }
        System.out.println("Size: " + tree.getSize());
        System.out.println("Height: " + tree.getHeight());

        tree.show();
        tree.showToString();
        tree.showLeftRight();
    }
}
