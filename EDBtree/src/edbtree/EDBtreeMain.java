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
        int[] values = {88, 10, 1, 3, 2, 44, 32, 45, 67, 32, 12, 1, 1, 56, 3234, 127}; //34,12,13,14};
        BTree<Integer> tree = new BTree<>();

        //JFrame frame = new JFrame("Visualização da Árvore Binária");
        //BinaryTreeCanvas canvas = new BinaryTreeCanvas(tree.getRootNode());
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(800, 600);
        //frame.add(canvas);
        //frame.setVisible(true);
        for (int i = 0; i < values.length; i++) {
            tree.add(new BTreeNode(String.format("%010d", values[i]), values[i]));
            //frame.remove(canvas);
            //canvas = new BinaryTreeCanvas(tree.getRootNode());
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame.setSize(800, 600);
            //frame.add(canvas);
            //frame.setVisible(true);
            //try {
            //Thread.sleep(3000);
            //} catch (InterruptedException ex) {
            //Logger.getLogger(EDBtreeMain.class.getName()).log(Level.SEVERE, null, ex);
            //}

        }

        /*
        Object[] valuesay = tree.getvaluesay();
        int i = 0;
        for (Object o : valuesay) {
            if (o != null) {
                System.out.printf("\n[%d] = %d", i++, o);
            }

            for (int v : values) {
                tree.add(new BTreeNode<Integer>(String.format("%015d", v), v));
            }

            //JFrameShowBTree.showTree(BinaryTreeCanvas.getInstance(tree.getRootNode()), 2);

        }
         */
        //JFrameShowBTree.showTree(BinaryTreeCanvas.getInstance(tree.getRootNode()), 0);
        System.out.println("Left Min: " + tree.getMin(tree.getRootNode().getLeftNode()).getInformation());
        System.out.println("Left Max: " + tree.getMax(tree.getRootNode().getLeftNode()).getInformation());
        System.out.println("Right Min: " + tree.getMin(tree.getRootNode().getRightNode()).getInformation());
        System.out.println("Right Max: " + tree.getMax(tree.getRootNode().getRightNode()).getInformation());

        JFrameShowBTree.showTree(BinaryTreeCanvas.getInstance(tree.getRootNode()), 1);

        tree.Show(tree.getRootNode(), "   ");
        //tree.remove("0000000003");
        //tree.remove("0000000088");
        
        tree.deleteNode(tree.getRootNode(), "0000000003");
        tree.deleteNode(tree.getRootNode(), "0000000032");
        tree.deleteNode(tree.getRootNode(), "0000000010");
        
        System.out.println("-----");
        tree.Show(tree.getRootNode(), "   ");
        tree.showVerticalOrder();
        JFrameShowBTree.showTree(BinaryTreeCanvas.getNewInstance(tree.getRootNode()), 1);
    }
}
