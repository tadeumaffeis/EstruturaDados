/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import edfila.EDQueue;
import edpilha.EDStack;
import edfila.Node;
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
        
        /**
         * Utilização de Pilha
         */
 /*
        
         */
        Scanner in = new Scanner(System.in);

        System.out.println("\nInforme a expressão no formato infixo: ");
        String sExp = in.next();

        if (BalancedExpression.verify(sExp)) {
            String posFixStr = (new Infix2Postfix()).convert2Posfix(sExp);
            System.out.println("Expressao pos-fixa: " + posFixStr);
            System.out.println("\nResultao: " + (new EvalPostFix()).eval(posFixStr));
        } else {
            System.out.println("Expressao incorreta");
        }

        /*
        EDQueue fila = new EDQueue();
        EDStack pilha = new EDStack();
        Scanner in = new Scanner(System.in);

        System.out.println("\nInforme a sequencia de caracteres: ");
        String buffer = in.next();

        for (char c : buffer.toCharArray()) {
            fila.enqueue(new Node(c + "", (int) c));
            pilha.push(new edpilha.Node(c + "", (int) c));
        }

        System.out.println("\nFila Str: " + fila.toString());
        System.out.println("\nPilha Str: " + pilha.toString());

        System.out.println("\n");

        for (; !fila.empty();) {
            System.out.print("+" + (char) ((int) fila.dequeue().getValue()));
        }

        System.out.println("\n");

        for (; !pilha.empty();) {
            System.out.print("-" + (char) ((int) pilha.pop().getValue()));
        }
         */
    }
}

class BalancedExpressionWithQueue {
    public static boolean verify(EDQueue expressao) {
        EDStack pilha = new EDStack();
        for (; !expressao.empty();) {
            char c = (char) expressao.remove().getValue();
            if (c == '(' || c == '{' || c == '[') {
                pilha.push(new edpilha.Node(c + "", (int) c));
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

class EvalPostFix {

    public int eval(String expressao) {
        EDStack pilha = new EDStack();

        for (char c : expressao.toCharArray()) {
            if (Character.isDigit(c)) {
                pilha.push(new Node(c + "", (int) (c - '0')));
            } else {
                if (pilha.empty()) {
                    continue;
                }
                int valor2 = (int) pilha.pop().getValue();
                int valor1 = (int) pilha.pop().getValue();
                switch (c) {
                    case '+':
                        pilha.push(new Node(c + "+", valor1 + valor2));
                        break;
                    case '-':
                        pilha.push(new Node(c + "-", valor1 - valor2));
                        break;
                    case '*':
                        pilha.push(new Node(c + "*", valor1 * valor2));
                        break;
                    case '/':
                        pilha.push(new Node(c + "/", valor1 / valor2));
                        break;
                }
            }
        }

        return (int) pilha.pop().getValue();
    }

}

class Infix2Postfix {

    public int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public String convert2Posfix(String expressao) {
        StringBuilder result = new StringBuilder();
        EDStack stack = new EDStack();

        for (char c : expressao.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(new Node(c + "", (int) c));
            } else if (c == ')') {
                while (!stack.empty() && (char) ((int) stack.peek().getValue()) != '(') {
                    result.append((char) ((int) stack.pop().getValue()));
                }
                stack.pop();
            } else {
                while (!stack.empty() && precedence(c) <= precedence((char) ((int) stack.peek().getValue()))) {
                    result.append((char) ((int) stack.pop().getValue()));
                }
                stack.push(new Node(c + "", (int) c));
            }
        }

        while (!stack.empty()) {
            result.append((char) ((int) stack.pop().getValue()));
        }

        return result.toString();
    }

    /*
    //public static void main(String[] args) {
    //    String expressao = "a+b*(c^d-e)^(f+g*h)-i";
    //    System.out.println("Expressão pós-fixa: " + converteParaPosfixa(expressao));
    //}
    public String convert2Posfix(String expressao) {
        EDStack result = new EDStack();
        EDStack stack = new EDStack();

        for (char c : expressao.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.push(new Node(c + "", (int) c));
            } else if (c == '(') {
                stack.push(new Node(c + "", (int) c));
            } else if (c == ')') {
                while (!stack.empty() && (char) ((int) stack.peek().getValue()) != '(') {
                    result.push(new Node(c + "", stack.pop().getValue()));
                }
                stack.pop();
            } else {
                while (!stack.empty() && precedence(c) <= precedence((char) ((int) stack.peek().getValue()))) {
                    result.push(new Node(c + "", stack.pop().getValue()));
                }
                stack.push(new Node(c + "", (int) c));
            }
        }

        while (!stack.empty()) {
            Node n = stack.pop();
            result.push(n);
        }

        return result.toString();
    }
}
     */
