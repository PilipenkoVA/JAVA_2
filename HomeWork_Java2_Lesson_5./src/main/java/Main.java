/*          Урок 5. Многопоточность
    1. Необходимо написать два метода, которые делают следующее:
    1) Создают одномерный длинный массив, например:

    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];

    2) Заполняют этот массив единицами;
    3) Засекают время выполнения: long a = System.currentTimeMillis();
    4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
    arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    5) Проверяется время окончания метода System.currentTimeMillis();
    6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);

    Отличие первого метода от второго:
    Первый просто бежит по массиву и вычисляет значения.
    Второй разбивает массив на то количество потоков, которые будет передано в качестве аргумента для этого метода,
    в отдельных потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.

    Пример деления одного массива на два:

    System.arraycopy(arr, 0, a1, 0, h);
    System.arraycopy(arr, h, a2, 0, h);

    Пример обратной склейки:

    System.arraycopy(a1, 0, arr, 0, h);
    System.arraycopy(a2, 0, arr, h, h);

    Примечание:
    System.arraycopy() – копирует данные из одного массива в другой:
    System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда
    начинаем записывать данные в массив-назначение, сколько ячеек копируем)
    По замерам времени:
    Для первого метода надо считать время только на цикл расчета:

    for (int i = 0; i < size; i++) {
    arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
     */

import java.util.Arrays;

public class Main {
    private static final int size = 10000000;
    private static final int half = size / 2;

    public static void main(String[] args){
        Main mainClass = new Main();
        mainClass.methodOne();
        mainClass.methodTwo();
    }

    private void methodOne(){
        System.out.println("Старт метода №1");
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long start = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("Завершение метода №1. Время выполнения %s", String.valueOf(end - start)));
    }

    private void methodTwo(){
        System.out.println("Старт метода №2");
        float[] arr = new float[size];
        float[] arr1 = new float[half];
        float[] arr2 = new float[half];
        Arrays.fill(arr, 1.0f);
        long start = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, half);
        System.arraycopy(arr2, 0, arr, half, half);
        long split = System.currentTimeMillis();
        System.out.println(String.format("Время выполнния разделения массива %s", String.valueOf(split - start)));

        Thread thread1 = new Thread(() ->this.methodTwoInternal(arr1, 1));
        Thread thread2 = new Thread(() ->this.methodTwoInternal(arr2, 2));

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            System.out.println(String.format("Исключение в потоках. %s", e.getMessage()));
        }

        long connect = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr, 0, half);
        System.arraycopy(arr2, 0, arr, half, half);
        long end = System.currentTimeMillis();
        System.out.println(String.format("Время выполнния склейки массива %s", String.valueOf(end - connect)));
        System.out.println(String.format("Завершение метода №2. Время выполнения %s", String.valueOf(end - start)));
    }

    private void methodTwoInternal(float[] arr, int number){
        long start = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("Время выполнения потока %d равно %s", number, String.valueOf(end - start)));
    }
}

