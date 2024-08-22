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
        EDStack stackSquareBrackets = new EDStack(); // []
        EDStack stackParentheses = new EDStack(); // ()
        EDStack stackCurlyBrackets = new EDStack(); // {}

        Scanner in = new Scanner(System.in);

        System.out.println("\nInforme a expressão: ");
        String sExp = in.next();
        boolean error = false;

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
    }
}
