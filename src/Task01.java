//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Task01 {

//Реализация будет считать ФИО - ключом. Полный тёзка невозможен
    public static void main(String[] args) {
        HashMap <String, ArrayList<String>> telBook = new HashMap<>();
        addNote(telBook, "Иванов Иван", "+71111111111" );
        addNote(telBook, "Фёдоров Фёдор", "+72222222222" );
        addTel(telBook, "Иванов Иван", "+73333333333");
        System.out.println(telBook);
        
    }

    public static void addNote(HashMap telBook, String name, String tel) {
        if (!telBook.containsKey(name)) {
            ArrayList<String> tempArray = new ArrayList<>(2);
            tempArray.add(tel);
            telBook.put(name,tempArray);
            System.out.println(telBook);
        }
    }

    public static void addTel(HashMap <String, ArrayList<String>> telBook, String name, String tel) {
        if (telBook.containsKey(name)) {
            ArrayList<String> tempArray = telBook.get(name);
            tempArray.add(tel);
            telBook.put(name, tempArray);
        }
    }
}
