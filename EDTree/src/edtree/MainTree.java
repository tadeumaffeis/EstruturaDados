/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edtree;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class MainTree {

    public static void main(String[] args) {
        EDTree<Integer> tree = new EDTree<>();
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};

        for (int v : values) {
            TreeNode<Integer> node = new TreeNode<>();
            node.setValue(v);
            tree.add(node);
        }

        System.out.println("Size: " + tree.getSize());
        System.out.println("Height: " + tree.getHeight());

        tree.show();
        tree.showToString();
        tree.showVerticalOrder();

        JFrame frame = new JFrame("Visualização da Árvore Binária");
        BinaryTreeCanvas canvas = new BinaryTreeCanvas(tree.getRoot());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(canvas);
        frame.setVisible(true);
    }
}

class BinaryTreeCanvas extends JPanel {

    private TreeNode root;

    public BinaryTreeCanvas(TreeNode root) {
        this.root = root;
    }

    // Método responsável por desenhar a árvore no Canvas
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null) {
            drawTree(g, root, getWidth() / 2, 50, getWidth() / 4, 50);
        }
    }

    // Desenho recursivo da árvore binária
    private void drawTree(Graphics g, TreeNode node, int x, int y, int xOffset, int yOffset) {
        // Cast para Graphics2D para personalização avançada
        Graphics g2d = (Graphics) g;
        
        // Definir a cor azul para o círculo
        g2d.setColor(Color.BLUE);
        
        // Desenhar o círculo do nó
        g2d.drawOval(x - 15, y - 15, 30, 30);
        g2d.setColor(new Color(173, 216, 230));  // Azul claro para o preenchimento do círculo
        g2d.fillOval(x - 15, y - 15, 30, 30);

        // Definir a cor azul e a fonte em negrito para o número do nó
        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Desenhar o valor do nó no centro do círculo
        g2d.drawString(node.toString(), x - 7, y + 5);

        // Desenha a linha e o nó da esquerda
        if (node.getLeftNode() != null) {
            g2d.setColor(Color.BLACK); // Cor preta para as linhas que conectam os nós
            g2d.drawLine(x, y, x - xOffset, y + yOffset);
            drawTree(g2d, node.getLeftNode(), x - xOffset, y + yOffset, xOffset / 2, yOffset);
        }

        // Desenha a linha e o nó da direita
        if (node.getRightNode() != null) {
            g2d.setColor(Color.BLACK); // Cor preta para as linhas que conectam os nós
            g2d.drawLine(x, y, x + xOffset, y + yOffset);
            drawTree(g2d, node.getRightNode(), x + xOffset, y + yOffset, xOffset / 2, yOffset);
        }
    }}
