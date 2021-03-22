
        /* Урок 2. Исключения

        1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого
           размера необходимо бросить исключение MyArraySizeException.

        2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то
           элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно
           быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.

        3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException,
           и вывести результат расчета.  */

public class LessonTwo {

    public static void main(String[] args) {
        String[][] arr = {
                {"1","2","1","2"},
                {"2","1","2","1"},
                {"1","2","1","2"},
                {"2","1","2","1"}
        };
        try {
            System.out.println("Результат сложения = "+new LessonTwo().method(arr));       // выводим результат сложения
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
    public int method(String[][] array) throws MyArraySizeException,MyArrayDataException {
        int count=0;
        for (int i = 0; i< array.length; i++) {
            if(array.length!=4){
                throw new MyArraySizeException();                     /* при подаче массива другого размера будет брошено
                                                                         исключение (MyArraySizeException)*/
            }
            for (int j = 0; j< array[i].length; j++){
                if(array[i].length!=4){
                    throw new MyArraySizeException();                 /* при подаче массива другого размера будет брошено
                                                                         исключение (MyArraySizeException)*/
                }
                try {
                    count += Integer.parseInt(array[i][j]);          // преобразовываем в int и суммируем элементы
                }catch (NumberFormatException e){
                    throw new MyArrayDataException(i,j);             /* если в ячейке лежит символ или текст вместо числа
                                                                        будет брошено исключение (MyArrayDataException)*/
                }
            }
        }
        return count;
    }

}
