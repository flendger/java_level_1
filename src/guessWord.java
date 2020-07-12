import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class guessWord {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                        "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                        "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                        "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String hiddenWord = words[random.nextInt(words.length)];

        System.out.println("Угадайте слово из списка:");
        printArrayOfString(words);
        System.out.println();

        boolean win = false;

        do {
            System.out.println("Введите слово: ");
            String inputTxt = scanner.nextLine();

            int minLength;
            if (inputTxt.length() < hiddenWord.length()) {
                minLength = inputTxt.length();
            } else {
                minLength = hiddenWord.length();
            }
            //сравним два слова посимвольно
            int i = 0;
            win = true;
            char[] arrChar = new char[15];
            for (i = 0; i < minLength; i++) {
                if (inputTxt.charAt(i) == hiddenWord.charAt(i)) {
                    arrChar[i] = inputTxt.charAt(i);
                } else {
                    arrChar[i] = '#';
                    win = false;
                }
            }

            if ((!win || inputTxt.length() != hiddenWord.length())) {
                //если были не совпадения выше или длина строк не совпадает,
                //то дополняем массив до 15, преобразуем его к выводу и выводим неудачу
                win = false;
                for (int k = i; k < 15; k++){
                    arrChar[k] = '#';
                }

                System.out.println("Вы не угадали...");
                System.out.printf("Подсказка: %s%n", getTextFormCharArr(arrChar));
            } else {
                System.out.println("Поздравляем, Вы угадали слово: " + hiddenWord);
            }
        } while (!win);
    }

   static String getTextFormCharArr(char[] arr) {
       String result = "";
       for (int i = 0; i < arr.length; i++) {
           result = result + String.format("%c", arr[i]);
       }
       return result;
    }

    static void printArrayOfString(String[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            System.out.printf("%d: %s\n", i+1, arr[i]);
        }
    }
}
