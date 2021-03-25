import java.util.Arrays;
import java.util.Locale;

public class palindrom {

    public static void main(String[] args) {
        String sentence = "Аргентина манит негра";//"Люди падают наступив на банановую кожуру в 10 раз чаще, чем с электротранспорта.";
        String sentenceWO_whiteSpace;
        int lenght_of_string = sentence.length(), k, i; //определяем длину предложения
        sentenceWO_whiteSpace = sentence.toLowerCase().replaceAll(Character.toString(' '), "");
        if(sentenceWO_whiteSpace.equals(new StringBuilder(sentenceWO_whiteSpace).reverse().toString())){
            System.out.println("Предложение является палиндромом: " + sentence);
        }else System.out.println("Предложение не пaлиндром: " + sentence);


                                  //2-й метод решения задачи

        String sentence_lower_case = sentence.toLowerCase();
        char[] sentence_char = sentence_lower_case.toCharArray();


        for ( i = 0; i < lenght_of_string; i++) {
            switch (sentence_char[i]){  //используем case для " отлавливания" знаков: ' ', '!', '?','.','/'
                case ' ': for ( k = i; k < lenght_of_string - 1; k++) { //сдвиг последующих элементов
                    sentence_char[k] = sentence_char[k + 1];
                }lenght_of_string--; //уменьшаем длину массива, т.к. исключаем из него элемент
                i--;  // номер элемента оставляем прежним, чтобы учесть "перескакивания" через 2 последовательных
                //исключаемых элемента(напр. запятую ловим, а пробел за ней смещается на адрес зпт, а инкре-
                      //мент адреса уже уведет на следующую ячейку
                    break;
                case ',': for ( k = i; k < lenght_of_string - 1; k++) { //сдвиг последующих элементов
                    sentence_char[k] = sentence_char[k + 1];
                }
                lenght_of_string--; i--; break;
                case '.': for ( k = i; k < lenght_of_string - 1; k++) { //сдвиг последующих элементов
                    sentence_char[k] = sentence_char[k + 1];
                }
                lenght_of_string--; break;
                case '!': for ( k = i; k < lenght_of_string - 1; k++) { //сдвиг последующих элементов
                    sentence_char[k] = sentence_char[k + 1];
                }lenght_of_string--; i--; break;
                case '?': for ( k = i; k < lenght_of_string - 1; k++) { //сдвиг последующих элементов
                    sentence_char[k] = sentence_char[k + 1];
                }lenght_of_string--; i--; break;
                case '/': for ( k = i; k < lenght_of_string - 1; k++) { //сдвиг последующих элементов
                    sentence_char[k] = sentence_char[k + 1];
                }lenght_of_string--; i--; break;

            }

        }
        char[] str = Arrays.copyOf(sentence_char, lenght_of_string);//обрезаем массив по оставшимся элементам

        System.out.println("Строка после обработки: " + Arrays.toString(str));
                 k = 1; //вводим признак палиндрома, чтобы не печаталась всегла последняя строка
            for ( i = 0; i < (lenght_of_string/2); ++i) {
                if (str[i] != str[lenght_of_string - i - 1]) {
                    k = 0;
                    System.out.println("Предложение не палиндром: " + sentence);break;
                }
            }
        if (k != 0) {
            System.out.println("Предложение является палиндромом: " + sentence);
        }
    }



}
