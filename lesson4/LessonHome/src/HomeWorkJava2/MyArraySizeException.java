package HomeWorkJava2;

    public class MyArraySizeException extends RuntimeException {

        int row, column;

        public MyArraySizeException(int row, int column) {
            super("Неправильных данных, строки и столбца может быть только 4. У вас есть: ряд" + row + ", столбец " + column);
            this.row = row;
            this.column = column;
        }
}
