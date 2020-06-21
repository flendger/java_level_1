import java.util.Random;
import java.util.Scanner;

public class guessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int tryAgain = 1;

        do {
            boolean win = false;
            int ranNumber = random.nextInt(10);
            System.out.println("Угадай число от 0 до 9 за три попытки...");

            for (int i = 0; (i < 3) && !win; i++) {
                System.out.printf("Попытка №%d:\n", i+1);
                int enteredNumber = 0;

                do {
                    enteredNumber = scanner.nextInt();
                } while (enteredNumber < 0 || enteredNumber > 9);

                if (enteredNumber > ranNumber) {
                    System.out.println("Ваше число больше загаданного...");
                } else if (enteredNumber < ranNumber) {
                    System.out.println("Ваше число меньше загаданного...");
                } else {
                    win = true;
                }
            }

            if (win) {
                System.out.printf("Вы угадали число: %d\n", ranNumber);
            } else {
                System.out.printf("Вы проиграли. Загаданное число: %d\n", ranNumber);
            }

            System.out.println();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет:");

            do {
                tryAgain = scanner.nextInt();
            } while (tryAgain != 1 && tryAgain != 0);

        } while (tryAgain == 1);
    }
}
