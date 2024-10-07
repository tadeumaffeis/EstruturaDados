/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edbtree;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

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

        JFrame frame = new JFrame("Visualização da Árvore Binária");
        BinaryTreeCanvas canvas = new BinaryTreeCanvas(tree.getRootNode());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(canvas);
        frame.setVisible(true);

        for (int v : values) {
            tree.add(new BTreeNode(v + "", v));
            frame.remove(canvas);
            canvas = new BinaryTreeCanvas(tree.getRootNode());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.add(canvas);
            frame.setVisible(true);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(EDBtreeMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
