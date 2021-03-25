        /*Урок 3. Коллекции

   1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных
      слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
   2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
      В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get()
      искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
      (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.*/
import java.util.*;

public class Lesson {
    public static void main(String[] args) {

        // Задание №1

        Map <Integer, String> map = new HashMap<>();
        map.put(1,"Bob1");
        map.put(2,"Bob2");
        map.put(3,"Bob3");
        map.put(1,"Bob1");                            // повтор
        map.put(4,"Bob4");
        map.put(5,"Bob5");
        map.put(1,"Bob1");                            // повтор
        map.put(6,"Bob6");
        map.put(7,"Bob7");
        map.put(8,"Bob8");
        map.put(9,"Bob9");
        map.put(10,"Bob10");
        map.put(1,"Bob1");                            // повтор
        map.put(1,"Bob1");                            // повтор
        map.put(1,"Bob1");                            // повтор

        for (Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey()+". Имя - "+entry.getValue());
        }
        System.out.println();
        
        // Задание №2

        PhoneDirectory directory = new PhoneDirectory();

        directory.add("Ivanov", "7654321098");
        directory.add("Ivanov", "5432109876");
        directory.add("Ivanov", "3210987654");
        directory.add("Ivanov-1", "1234567890");
        directory.add("Ivanov-1", "8765432109");
        directory.add("Petrov", "987654321");
        directory.add("Petrov", "6543210987");
        directory.add("Petrov", "4321098765");
        directory.add("Semenov", "2109876543");

        System.out.println(directory.get("Ivanov"));
        System.out.println(directory.get("Ivanov-1"));
        System.out.println(directory.get("Petrov"));
        System.out.println(directory.get("Semenov"));
    }
}
