public class MyArraySizeException extends RuntimeException{

    public MyArraySizeException() {
        super("Массив должен иметь 4 элемента в строке и 4 элемента в столбце");
    }
}
