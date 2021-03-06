package ru.itis;

/*
Правильная ли последовательность скобок:
(()()(()))
1. Если встретили открывающую скобку - кладем в стек
2. Если встретили закрывающую скобку - достаем последнуюю скобку из стека
3. Если в конце соблюдены два условия:
	1. Стек пустой
	2. Все скобки просмотрены
	то последовательность правильная

( ( ) ( ) ( ( ) ) )
0 1 2 3 4 5 6 7 8 9
1)
ТЕК СКОБКА: (, в позиции 0
СТЕК: кладем (
2)
ТЕК СКОБКА: (, в позиции 1
СТЕК: кладем (
3)
ТЕК СКОБКА: ), в позиции 2
СТЕК: достаем (
 */
public class Main {

    // количество элементов в стеке
    public static int count = 0;
    /**
     * Кладет значение в конец стека
     * @param stack стек, куда следует положить значение
     * @param element элемент, который кладем в стек
     */

    /*
        1. [ ] [ ] [ ] [ ] [ ]
            0   1   2   3   4
        count = 0;

        2. [*] [ ] [ ] [ ] [ ]
            0   1   2   3   4
        count = 1;

        3. [*] [*] [ ] [ ] [ ]
            0   1   2   3   4
        count = 2;

        4. [*] [*] [*] [ ] [ ]
            0   1   2   3   4
        count = 3;
     */
    public static void push(char stack[], char element) {
        stack[count] = element;
        count++;
    }

    public static char pop(char stack[]) {
        char temp = stack[count - 1];
        stack[count - 1] = '\0';
        count--;
        return temp;
    }

    public static void main(String[] args) {
        // массив символов
        // стэк - список, где вы можете класть в конец и забирать
        // с конца
        char stack[] = new char[10];

        char inputBrackets[] = "((){([])}{}<>)".toCharArray();
        int isFlag = 0;
        for (int i = 0; i < inputBrackets.length; i++) {
            // смотрим текущю скобку
            // если она отркывающая
            if (inputBrackets[i] == '(' ||
                    inputBrackets[i] == '{' ||
                    inputBrackets[i] == '[' ||
                    inputBrackets[i] == '<') {
                // кладем в стек
                push(stack, inputBrackets[i]);
            }
            // если она не открывающаяся, то проверяем
            // есть ли вообще в стеке элементы
            else if (count != 0) {
                // забираем из стека последнюю скобку
                char lastBracket = pop(stack);
                // если любое из этих условий соблюдено - идем дальше
                if (inputBrackets[i] == '}' && lastBracket == '{') {
                    continue;
                }
                else if (inputBrackets[i] == '>' && lastBracket == '<') {
                    continue;
                }
                else if (inputBrackets[i] == ']' && lastBracket == '[') {
                    continue;
                }
                else if (inputBrackets[i] == ')' && lastBracket == '(') {
                    continue;
                } else {
                    break;
                }
            } else {
                // если стек пустой
                isFlag = 1;
                break;
            }
        }

        if (isFlag == 1 || count != 0) {
            System.out.println("Не правильная последовательность");
        } else {
            System.out.println("Правильная");
        }
    }
}
