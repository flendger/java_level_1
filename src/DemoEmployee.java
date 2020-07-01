public class DemoEmployee {
    public static void main(String[] args) {
        Person[] persArr = createPersons();

        printPersonsArr(persArr);

        printPersonsOlder40(persArr);
    }

    public static Person[] createPersons() {
        Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "89231231287", 30000, 30); // потом для каждой ячейки массива задаем объект
        persArray[1] = new Person("Petrov Petr", "Programmer", "petrov@mailbox.com", "89235658876", 50000, 41);
        persArray[2] = new Person("Sidorov Semen", "Director", "sidorov@mailbox.com", "89237653456", 300000, 50);
        persArray[3] = new Person("Semenov Ilya", "Admin", "semenov@mailbox.com", "89230987788", 20000, 25);
        persArray[4] = new Person("Nikiforov Nikita", "Seller", "nikiforov@mailbox.com", "89238364859", 43000, 40);

        return persArray;
    }

    public static void printPersonsArr(Person[] persons) {
        System.out.println("Сотрудники:");
        for (int i = 0; i < persons.length; i++) {
            persons[i].info();
        }
    }

    public static void printPersonsOlder40(Person[] persons) {
        System.out.println("Сотрудники старше 40 лет:");
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].olderThanForty()) {
                persons[i].info();
            }
        }
    }
}
