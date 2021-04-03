package hw2package;

import java.util.Arrays;

public class Palindrom {

    public static void main(String[] args) {
        String sentence = "Аргентина манит негра";//"Люди падают наступив на банановую кожуру в 10 раз чаще, чем с электротранспорта.";
        String sentenceWO_WhiteSpace;
        int lenghtOfString = sentence.length(), k, i; //определяем длину предложения
        sentenceWO_WhiteSpace = sentence.toLowerCase().replaceAll(Character.toString(' '), "");
        if (sentenceWO_WhiteSpace.equals(new StringBuilder(sentenceWO_WhiteSpace).reverse().toString())) {
            System.out.println("Предложение является палиндромом: " + sentence);
        } else System.out.println("Предложение не пaлиндром: " + sentence);


        //2-й метод решения задачи

        String sentenceLowerCase = sentence.toLowerCase();
        char[] sentenceChar = sentenceLowerCase.toCharArray();


        for (i = 0; i < lenghtOfString; i++) {
            switch (sentenceChar[i]) {  //используем case для " отлавливания" знаков: ' ', '!', '?','.','/'
                case ' ':
                    for (k = i; k < lenghtOfString - 1; k++) { //сдвиг последующих элементов
                        sentenceChar[k] = sentenceChar[k + 1];
                    }
                    lenghtOfString--; //уменьшаем длину массива, т.к. исключаем из него элемент
                    i--;  // номер элемента оставляем прежним, чтобы учесть "перескакивания" через 2 последовательных
                    //исключаемых элемента(напр. запятую ловим, а пробел за ней смещается на адрес зпт, а инкре-
                    //мент адреса уже уведет на следующую ячейку
                    break;
                case ',':
                    for (k = i; k < lenghtOfString - 1; k++) { //сдвиг последующих элементов
                        sentenceChar[k] = sentenceChar[k + 1];
                    }
                    lenghtOfString--;
                    i--;
                    break;
                case '.':
                    for (k = i; k < lenghtOfString - 1; k++) { //сдвиг последующих элементов
                        sentenceChar[k] = sentenceChar[k + 1];
                    }
                    lenghtOfString--;
                    break;
                case '!':
                    for (k = i; k < lenghtOfString - 1; k++) { //сдвиг последующих элементов
                        sentenceChar[k] = sentenceChar[k + 1];
                    }
                    lenghtOfString--;
                    i--;
                    break;
                case '?':
                    for (k = i; k < lenghtOfString - 1; k++) { //сдвиг последующих элементов
                        sentenceChar[k] = sentenceChar[k + 1];
                    }
                    lenghtOfString--;
                    i--;
                    break;
                case '/':
                    for (k = i; k < lenghtOfString - 1; k++) { //сдвиг последующих элементов
                        sentenceChar[k] = sentenceChar[k + 1];
                    }
                    lenghtOfString--;
                    i--;
                    break;

            }

        }
        char[] str = Arrays.copyOf(sentenceChar, lenghtOfString);//обрезаем массив по оставшимся элементам

        System.out.println("Строка после обработки: " + Arrays.toString(str));
        k = 1; //вводим признак палиндрома, чтобы не печаталась всегла последняя строка
        for (i = 0; i < (lenghtOfString / 2); ++i) {
            if (str[i] != str[lenghtOfString - i - 1]) {
                k = 0;
                System.out.println("Предложение не палиндром: " + sentence);
                break;
            }
        }
        if (k != 0) {
            System.out.println("Предложение является палиндромом: " + sentence);
        }
    }


}
