package org.example.yandex.sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
-- ПРИНЦИП РАБОТЫ --
Я реализовал "Калькулятор" пользуясь стандартной имплементацией стека Java
Если входной символ - операнд, то он помещается на вершину стека.
Если входной символ - знак операции, то из стека достаю два верхних эл-та и применяю к ним текущую операцию,
после чего результат помещается обратно в стек.

После полного прохождения входного массива символов ответ будет лежать на верху стека.

-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --

Стек полностью удовлетворяет условиям для работы с постфиксной нотацией.
Так как после воплнения каждой операции мы кладем результат на вершину стека, то это гарантирует, что этот элемент будет
использован, когда во входной последовательности встретиться следующий знак операции.

В ситуации, когда знаков операций значительно меньше, чем операндов, то числа, которые остались после использования
всех знаков будут лежать в стеке ниже, чем искомый результат вычислений.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Разбить входную строку на массив строк - O(n), где n - длина строки.
Пройтись по массиву строк выполняя операции добавляения в стек и получения данных из стека O(n),
где n - размер массива строк. Операции со стеком работают за O(n).

В среднем получаем O(2n) / n ~ O(n) -- амортизированная сложность.

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Массив строк занимает - O(n) памяти,
Stack в худшем случае знаймет O(n), если во входных данных не будет знаков операций.

Поэтому алгоритм будет потреблять O(n) + O(n) = O(n) памяти.
*/


class MathNotation {

    static int mathNotation(String s) {
        Stack<Integer> stack = new Stack<>();
        String[] symbols = s.split(" ");

        int idx = 0;
        do {
            switch (symbols[idx]) {

                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int a = stack.pop();
                    stack.push(stack.pop() - a);
                    break;
                case "/":
                    a = stack.pop();
                    stack.push(Math.floorDiv(stack.pop(), a));
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                default:
                    stack.push(Integer.valueOf(symbols[idx]));
                    break;
            }
            idx++;
        } while (idx < symbols.length);
        return stack.pop();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(mathNotation(reader.readLine()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

