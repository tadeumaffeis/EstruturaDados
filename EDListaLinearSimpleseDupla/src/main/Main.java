/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import edpilha.EDStack;
import edpilha.Node;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //EDStack stackSquareBrackets = new EDStack(); // []
        //EDStack stackParentheses = new EDStack(); // ()
        //EDStack stackCurlyBrackets = new EDStack(); // {}

        /*
        for (int i = 0; i < sExp.length(); i++) {
            switch (sExp.charAt(i)) {
                case '[': {
                    stackSquareBrackets.push(new Node("1", 1));
                    break;
                }
                case ']': {
                    if (stackSquareBrackets.empty()) {
                        error = true;
                    } else {
                        stackSquareBrackets.pop();
                    }
                    break;
                }
                case '(': {
                    stackParentheses.push(new Node("1", 1));
                    break;
                }
                case ')': {
                    if (stackParentheses.empty()) {
                        error = true;
                    } else {
                        stackParentheses.pop();
                    }
                    break;
                }
                case '{': {
                    stackCurlyBrackets.push(new Node("1", 1));
                    break;
                }
                case '}': {
                    if (stackCurlyBrackets.empty()) {
                        error = true;
                    } else {
                        stackCurlyBrackets.pop();
                    }
                    break;
                }
            }
            if (error) {
                break;
            }
        }

        if (error
                || !stackSquareBrackets.empty()
                || !stackParentheses.empty()
                || !stackCurlyBrackets.empty()) {
            System.out.println("\nExpressao incorreta");
        } else {
            System.out.println("\nExpressão Ok");
        }
         */
        Scanner in = new Scanner(System.in);

        System.out.println("\nInforme a expressão: ");
        String sExp = in.next();
        boolean error = false;

        boolean result = new BalancedExpression().verify(sExp);

        if (result) {
            System.out.println("\nExpressao correta");
        } else {
            System.out.println("\nExpressão incorreta");
        }
    }
}

class BalancedExpression {

    public static boolean verify(String expressao) {
        EDStack pilha = new EDStack();

        for (char c : expressao.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                pilha.push(new Node(c + "", (int) c));
            } else if (c == ')' && (pilha.empty() || (char) ((int) pilha.pop().getValue()) != '(')) {
                return false;
            } else if (c == '}' && (pilha.empty() || (char) ((int) pilha.pop().getValue()) != '{')) {
                return false;
            } else if (c == ']' && (pilha.empty() || (char) ((int) pilha.pop().getValue()) != '[')) {
                return false;
            }
        }

        return pilha.empty();
    }
}
