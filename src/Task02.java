//Пусть дан список сотрудников:
//Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Task02 {
    public static void main(String[] args) {
        ArrayList <String> workerList = new ArrayList<>(Arrays.asList("Иван Иванов","Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова",  "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"));
        System.out.println(workerList);
        HashMap<String, Integer> myHashMap = new HashMap<>();
        int max = 1;
        for (String item:workerList)
             {
            String name = item.split(" ")[0];
            if (myHashMap.containsKey(name)) {
                myHashMap.put(name, myHashMap.get(name) + 1);
                if (myHashMap.get(name) > max) {
                    max = myHashMap.get(name);
                }
            }
            else {
                myHashMap.put(name, 1);
            }
        }
        System.out.println(myHashMap);

        for (int i = max; i > 1; i--) {
            if (myHashMap.containsValue(i)) {
                for (String item:myHashMap.keySet()
                     ) {

                    int currentValue = myHashMap.get(item);
                    if (currentValue == i) {
                        System.out.println(String.format("%s - %d", item, currentValue));
                    }
            }}
        }
    }
}
