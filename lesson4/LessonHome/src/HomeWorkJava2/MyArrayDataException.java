package HomeWorkJava2;

public class MyArrayDataException extends RuntimeException {
    int i, j;

    public MyArrayDataException(int i, int j) {
        super("Неверные данные. У вас есть: строка " + i + ", столбец " + j);
        this.i = i;
        this.j = j;
    }
}
