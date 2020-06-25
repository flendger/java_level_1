import javax.crypto.spec.PSource;
import java.util.Random;
import java.util.Scanner;

public class tictactoe {
    public static void main(String[] args) {
        playGame(3);
    }

    static void playGame(int fieldSize) {
        char[][] field = new char[fieldSize][fieldSize];

        do {
            initializeField(field);
            printField(field);

            do {
                humanMove(field);
                if (checkWin(field, 'X')) {
                    printField(field);
                    System.out.println("Вы победили!!!");
                    break;
                }

                if (checkDraw(field)) {
                    printField(field);
                    System.out.println("Ничья...");
                    break;
                }

                aiMove(field);
                printField(field);
                if (checkWin(field, 'O')) {
                    System.out.println("Победил комьютер!!!");
                    break;
                }

                if (checkDraw(field)) {
                    System.out.println("Ничья...");
                    break;
                }
            } while (true);

            if (!again()) break;
        } while (true);

        System.out.println("Игра завершена...");
    }

    private static int[] GetWinCoordinates(char[][] field, char rivalSign){
        int x = -1 , y = -1;

        //if win rows
        for (int i = 0; i < field.length; i++){
            y = GetWinIndex(field[i], rivalSign);
            if (y > -1) {
                x = i;
                break;
            }
        }

        //if win columns
        if (x < 0 || y < 0){
            for (int j = 0; j < field.length; j++){
                char[] cur_col = new char[field.length];
                for (int i = 0; i < field[j].length; i++){
                    cur_col[i] = field[i][j];
                }
                x = GetWinIndex(cur_col, rivalSign);
                if (x > -1) {
                    y = j;
                    break;
                }
            }
        }

        //if win cross
        if (x < 0 || y < 0){
            char[] cur_col = new char[field.length];
            for (int i = 0; i < field.length; i++){
                cur_col[i] = field[i][i];
            }
            x = GetWinIndex(cur_col, rivalSign);
            y = x;
        }

        //if win back cross
        if (x < 0 || y < 0){
            char[] cur_col = new char[field.length];
            for (int i = 0; i < field.length; i++){
                cur_col[i] = field[i][field.length-i-1];
            }
            x = GetWinIndex(cur_col, rivalSign);
            y = field.length-x-1;
        }

        return new int[] {x, y};
    }

    private static int GetWinIndex(char[] fieldline, char rivalSign){
        int last_empty_index = -1;
        int empty_counter = 0;

        for (int i = 0; i < fieldline.length; i++){
            if (fieldline[i] == '-') {
                last_empty_index = i;
                empty_counter++;
            }

            if (empty_counter > 1 || fieldline[i] == rivalSign) {
                last_empty_index = -1;
                break;
            }
        }
        return last_empty_index;
    }

    static boolean checkDraw(char[][] field) {
        //check out if the game over
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkWin(char[][] field, char sign) {
        boolean result = false;

        //cross line left_to_right
        result = true;
        for (int i = 0; i < field.length; i++) {
            if (field[i][i] != sign) {
                result = false;
                break;
            }
        }

        //cross line right_to_left
        if (!result){
            result = true;
            for (int i = 0; i < field.length; i++) {
                if (field[i][field.length-i-1] != sign) {
                    result = false;
                    break;
                }
            }
        }

        //vertical lines
        for (int i = 0; i < field.length & !result; i++) {
            result = true;
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] != sign) {
                    result = false;
                    break;
                }
            }
        }

        //horizontal lines
        for (int j = 0; j < field.length & !result; j++) {
            result = true;
            for (int i = 0; i < field[j].length; i++) {
                if (field[i][j] != sign) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    static void humanMove(char[][] field) {
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;

        do {
            System.out.println("Ваш ход [x, y]:");
            do {
                System.out.print("x: ");
                x = scanner.nextInt();

            } while (!checkOutOfRange(x, field.length));
            do {
                System.out.print("y: ");
                y = scanner.nextInt();

            } while (!checkOutOfRange(y, field.length));

            if (!putMove(field, 'X', x-1, y-1)) {
                System.out.printf("Координата [%d, %d] занята. Введите другую координату...\n", x, y);
            } else break;
        } while (true);

    }

    static boolean checkOutOfRange(int coord, int length) {
        if ( (coord-1) >= 0 && ((coord-1) < length)) {
            return true;
        } else {
            System.out.printf("Координата должна быть в пределах [%d, %d]\n", 1, length);
            return false;
        }
    }

    static void aiMove(char[][] field) {
        System.out.println("Ход компьютера:");
        int[] coords;

        do {
            //пробуем выиграть
            coords = GetWinCoordinates(field, 'X');

            if (coords[0] < 0 || coords[1] < 0){
                //пробуем не проиграть
                coords = GetWinCoordinates(field, 'O');
            }

            if (coords[0] < 0 || coords[1] < 0){
                //ходим куда попало
                Random random = new Random();
                coords[0] = random.nextInt(field.length);
                coords[1] = random.nextInt(field.length);
            }

        } while (!putMove(field, 'O', coords[0], coords[1]));

        System.out.printf("x, y: %d, %d\n", coords[0]+1, coords[1]+1);
    }

    static boolean putMove (char[][] field, char sign, int x, int y) {
        boolean res = false;

        if (field[x][y] == '-') {
            field[x][y] = sign;
            res = true;
        }

        return res;
    }

    static boolean again() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Хотите сыграть еще раз (y/n)?");

        boolean res;
        do {
            String inputTxt = scanner.nextLine();
            if (inputTxt.length() == 1) {
                if (inputTxt.charAt(0) == 'y') {
                    res = true;
                    break;
                } else if (inputTxt.charAt(0) == 'n') {
                    res = false;
                    break;
                }
            }
        } while (true);

        return res;
    }

    static void initializeField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = '-';
            }
        }
    }

    static void printField(char[][] field) {
        System.out.println("************************");
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.printf("%c ", field[i][j]);
            }
            System.out.println();
        }
        System.out.println("************************");
    }
}
