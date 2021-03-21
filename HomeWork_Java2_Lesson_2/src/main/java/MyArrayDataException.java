public class MyArrayDataException extends RuntimeException {
    private int i;
    private int j;


    public MyArrayDataException(int i, int j){
        super("Некоректно введены данные внутри массива: строка " + i + " столбец " + j);

    }
}
