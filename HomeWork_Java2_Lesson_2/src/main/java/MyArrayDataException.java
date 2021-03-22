public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(int i, int j){
        super("Некоректно введены данные внутри массива: строка " + i + " столбец " + j);

    }
}
