package HomeWork4;

public class HomeWork4 {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("ivanov","Engineer","ivanov@mail.ru","12345",30000,30);
        persArray[1] = new Person("Petrov","Slave","petrov@mail.ru","23231",50,45);
        persArray[2] = new Person("Backer","Junior Manager","Backer@mail.com","00321",60000,25);
        persArray[3] = new Person("Arnold","middle manager","Dog@yandex.ru","4211412", 90000,55);
        persArray[4] = new Person("Bob","middle slave","cat@mail.ru","41111323",100,33);


        for(Person item : persArray) {
            if(item.GetAge() > 40) item.Show();
        }
    }
}
