public class Person {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("********************************************");
        System.out.printf("ФИО: %s\n", this.name);
        System.out.printf("Должность: %s\n", this.position);
        System.out.printf("Почта: %s\n", this.email);
        System.out.printf("Телефон: %s\n", this.phone);
        System.out.printf("Зарплата: %d\n", this.salary);
        System.out.printf("Возраст: %d\n", this.age);
        System.out.println("********************************************");
        System.out.println();
    }

    public boolean olderThanForty() {
        return (this.age > 40);
    }
}
