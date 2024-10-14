/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edbtree;

import javax.swing.JFrame;

/**
 *
 * @author Tadeu Maffeis
 */
public final class JFrameShowBTree {

    private static JFrame jFrameShow = null;
    private static BinaryTreeCanvas activeCanvas = null;

    public static void showTree(BinaryTreeCanvas canvas, int timeout) {
        try 
        {
            Thread.sleep(timeout * 1000);
        }
        catch (InterruptedException e)
        {
            
        }
        if (jFrameShow == null) {
            jFrameShow = new JFrame("Visualização da Árvore Binária");
        }
        jFrameShow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrameShow.setSize(800, 600);
        if (activeCanvas != null)
        {
            jFrameShow.remove(activeCanvas);
        }
        jFrameShow.add(canvas);
        activeCanvas = canvas;
        jFrameShow.setVisible(true);
    }
}


