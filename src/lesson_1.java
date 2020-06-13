public class lesson_1 {
    public static void main(String[] args) {
        //Task 2
        byte myByte = 127;
        short myShort = 32000;
        int myInt = 324234234;
        long myLong = 345L;
        float myFloat = 1.3f;
        double myDouble = 1.43232;
        boolean myBoolean = true;
        char myChar = 'F';
        String myString = "123text";

        //Task 3
        System.out.println(getTask3(2, 3, 10, 3));

        //Task4
        System.out.println(getTask4(5, 7));

        //Task5
        getTask5(-1);

        //Task6
        System.out.println(getTask6(-1));

        //Task7
        getTask7("Lesson1");

        //Task8
        getTask8(2000);
        getTask8(1900);
        getTask8(1997);
        getTask8(2020);
    }

    public static double getTask3(int a, int b, int c, int d) {
        double result = 0;

        if (d != 0) result = a*(b+((double) c/d));
        else System.out.println("Ошибка деления на 0!");

        return result;
    }

    public static boolean getTask4(int a, int b) {
        int sum = a + b;

//        //длинный способ без использования логического И
        if (sum >= 10) {
            if (sum <=20) {
                return true;
            } else return false;
        } else return false;

        //сокращенная версия
//        return  (sum >= 10 && sum <= 20);
    }

    public static void getTask5(int a) {
        if (a >= 0) System.out.println("Положительное число...");
        else System.out.println("Отрицательное число...");
    }

    public static boolean getTask6(int a) {
        return a < 0;
    }

    public static void getTask7(String txtName) {
        System.out.println("Привет, " + txtName + "!");
    }

    public static void getTask8(int year) {
        //true - високосный
        boolean yearResult = false;

        if ((year % 400) == 0) yearResult = true;
        else if ((year % 100) != 0) {
            if ((year % 4) == 0) yearResult = true;
        }

        if (yearResult) System.out.println("Год: " + year + " Високосный...");
        else System.out.println("Год: " + year + " Не високосный...");
    }

}
