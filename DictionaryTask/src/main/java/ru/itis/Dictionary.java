package ru.itis;

public class Dictionary {
    // максимальное количество букв в словаре
    private int MAX_LETTERS_COUNT = 32;

    // массив узлов, то есть фактически массив связных списков
    private Node[] nodes;

    // конструктор
    public Dictionary() {
        // создаем массив узлов
        nodes = new Node[MAX_LETTERS_COUNT];
    }

    public void addWord(String word) {
        // получили первую букву слова, отняли код буквы А
        // таким образом мы получаем порядковый номер первой буквы слова
        // в алфавите
        int position = word.charAt(0) - 'А';
        // создали узел для нового слова
        // передав ему первую букву слова и само слово
        Node newNode = new Node(word.charAt(0), word);
        // если на заданную букву слов еще нет
        if (nodes[position] == null) {
            // просто добавляем слово как первое
            nodes[position] = newNode;
        } else {
            // если слова уже на эту букву были, например:
            // nodes[position] = Аделя
            // Аделя -> Адель -> Амир
            // Добавляем: Антон (newNode)

            // Антон -> Аделя(nodes[position] -> Адель -> Амир
            newNode.setNext(nodes[position]);
            // Антон(nodes[position]) -> Аделя -> Адель -> Амир
            nodes[position] = newNode;
        }
    }

    // показываем словарь
    public void show() {
        System.out.println("Словарь");
        // идем по всем буквам
        for (int i = 0; i < MAX_LETTERS_COUNT; i++) {
            // если на i-ую букву слова есть
            if (nodes[i] != null) {
                // получаем саму букву
                char letter = (char)('А' + i);
                // выводим полученную букву
                System.out.println(letter + ":");
                // фиксируем первое слово
                // Антон(currentNode) -> Аделя -> Адель -> Амир
                Node currentNode = nodes[i];
                while (currentNode != null) {
                    // печатем само слово
                    System.out.println(currentNode.getValue());
                    // Антон -> Аделя(currentNode) -> Адель -> Амир
                    currentNode = currentNode.getNext();
                }
            }
        }
    }
}
