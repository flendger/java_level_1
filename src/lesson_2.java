public class lesson_2 {
    public static void main(String[] args) {
        int[] arr10 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        change10(arr10);
        printArr(arr10);

        int[] arr8 = new int[8];
        fillArr8(arr8);
        printArr(arr8);

        int[] arr6 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multArr6(arr6);
        printArr(arr6);

        int matrixLength = 5;
        int[][] matrix5x5 = new int[matrixLength][matrixLength];
        fillMatrix(matrix5x5, matrixLength);

        findMinMax(arr6);

        int[] checkArr1 = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] checkArr2 = {1, 1, 1, 2, 1};

        System.out.println(checkBalance(checkArr1));
        System.out.println(checkBalance(checkArr2));

        int[] arrMove1 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArr(arrMove1);
        moveArr(arrMove1, 3);
        printArr(arrMove1);

        int[] arrMove2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        printArr(arrMove2);
        moveArr(arrMove2, -1);
        printArr(arrMove2);

    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void change10(int[] arr){
        for (int i=0; i < arr.length; i++) {
            if (arr[i] == 0){
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
    }

    public static void fillArr8(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
    }

    public static void multArr6(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 6;
            }
        }
    }

    public static void fillMatrix(int[][] matrix, int matrixLength) {
        for (int i = 0; i < matrixLength; i++) {
            matrix[i][i] = 1;
            matrix[i][matrixLength - i - 1] = 1;
        }

        for (int i = 0; i < matrixLength; i++) {
            for (int j = 0; j < matrixLength; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void findMinMax(int[] arr) {
        int minValue = arr[0];
        int maxValue = arr[0];

        for (int i=0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            }

            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        System.out.println("Min: " + minValue + "; Max: " + maxValue);
    }

    public static boolean checkBalance(int[] arr) {
        boolean result = false;

        for (int k = 0; (k < arr.length) && (!result); k++) {
            int sumLeft = 0;
            int sumRight = 0;

            for (int i = 0; i < arr.length; i++) {
                if (i <= k) {
                    sumLeft += arr[i];
                } else {
                    sumRight += arr[i];
                }
            }

            result = sumLeft == sumRight;
        }

        return  result;
    }

    public static void moveArr(int[] arr, int n) {
        //если Н больше длины массива, то брать остаток от деления нацело
        //инкремент или дикремент

        int increment = 0;
        if (n > 0) {
            increment = 1;
        } else if (n < 0){
            increment = -1;
            n = -n;
        }

        if (n > arr.length) {
            //исключаем полные "круги"
            n = n % arr.length;
        }
        //счетчик сдвигов
        //в качестве счетчика использовал ту же входную переменную n, хотя наверно лучше было бы использовать новую переменную
        //так было бы понятнее тому, кто потом будет читать код...
        for (int k = 1; k <= n; k++) {
            int currentValue;
            if (increment >= 0) {
                currentValue = arr[0];
            } else {
                currentValue = arr[arr.length-1];
            }
            int nextValue;
            for (int i = 0; i < arr.length; i++) {
                int realIndex;
                if (increment >= 0) {
                    realIndex = i;
                } else {
                    realIndex = arr.length - i - 1;
                }

                int nextInd = realIndex + increment;
                if (nextInd == arr.length) {
                    nextInd = 0;
                } else if (nextInd == -1){
                    nextInd = arr.length - 1;
                }

                nextValue = arr[nextInd];
                arr[nextInd] = currentValue;
                currentValue = nextValue;

            }
        }
    }
}
