/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edbtree;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Tadeu Maffeis
 */
public final class BinaryTreeCanvas extends JPanel {

    private BTreeNode root;
    private static BinaryTreeCanvas instance = null;

    private BinaryTreeCanvas(BTreeNode root) {
        this.root = root;
    }

    public static BinaryTreeCanvas getInstance(BTreeNode root) {
        instance = null;
        instance = new BinaryTreeCanvas(root);

        return instance;
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
    private void drawTree(Graphics g, BTreeNode node, int x, int y, int xOffset, int yOffset) {
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
    }
}
