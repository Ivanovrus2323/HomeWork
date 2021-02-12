package HomeWork4;

class Person {
    private String fio;
    private String post;
    private String email;
    private String tel;
    private double salary;
    private int age;
    Person(String fio, String post, String email, String tel, double salary, int age) {
        this.fio = fio;
        this.post = post;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
        if(age>= 18) {
            this.age = age;
        } else {
            System.out.println("Сотрудник должен быть старше 18 лет");
        }
    }
    int GetAge(){
        return age;
    }
    void Show(){
        System.out.println(fio + " " + post + " " + email + " " + tel + " " + salary + " " + age);
    }



}
