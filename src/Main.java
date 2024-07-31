import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Main {
    //Метод для рандомного взятия слова из файла dictionary.txt
    private static String Line(String route) {
        List<String> l;
        try {
            l = Files.readAllLines(Paths.get(route));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        Random random = new Random();
        return l.get(random.nextInt(l.size()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nДобро пожаловать в игру \"Поле чудес\"");

        //Компьютер загадывает слово из файла dictionary.txt
        String route = new File("dictionary.txt").getAbsolutePath();
        //li - загаданное слово
        String li = Line(route);
        System.out.println("Я загадал слово");
        System.out.println("Загаданное слово состоит из " + li.length() + " букв.");
        char[] wordToDisplay = new char[li.length()];
        System.out.println("\nПопробуй угадать слово!");

        // count - кол-во попыток
        int count = 1;
        int maxCount = wordToDisplay.length + 5;
        char playerWord = ' ';
        while (count <= maxCount) {
            System.out.println("\nПопытка " + count + "/" + maxCount);
            System.out.print("Введите букву: ");
            //playerWord - Введенная пользователем буква
            playerWord = scanner.next().charAt(0);
            for (int i = 0; i < wordToDisplay.length; i++) {
                if (li.charAt(i) == playerWord) {
                    wordToDisplay[i] = playerWord;
                }
                System.out.print(wordToDisplay[i]);
            }
            //Если набор символов полностью совпадает с загаданным словом - Пользователь выиграл, игра окончена
            if (String.valueOf(wordToDisplay).equals(li)) {
                System.out.println("\n\nПоздравляем! Вы отгадали слово!");
                break;
            }
            count++;
        }
        if (count > maxCount) {
            System.out.println("\n\nУ вас больше не осталось попыток \nЗагаданное слово: " + li);
        }
    }
}