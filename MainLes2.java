package lesson2;

import java.io.*;
import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Stream;

public class MainLes2 {
    public static void main(String[] args) throws FileNotFoundException {
    textAnalyzer1();
    }

    //Исправить ошибку вычислений и корректность отображения результата
    private static void textAnalyzer1() throws FileNotFoundException {
        Map<String, Integer> map = new TreeMap<>();
        String filePath;
        System.out.println("Введите путь к файлу: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            filePath = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //сделаем список слов
        List<String> keys = new ArrayList<>();
        Scanner sc = new Scanner(new File(filePath));
        while (sc.hasNext()) {
            //sc.useDelimiter("\s, [.,?!]");
            keys.add(sc.next());
        }
        sc.close();

        int value = 1;
        for (String s : keys) {
            if (map.containsKey(s)) {
                map.put(s, value + 1);
            } else {
                map.put(s, 1);
            }
        }



        double total = 0.00;
        int max = map.values().stream().max(Integer::compare).get();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            total += entry.getValue();
            System.out.println(entry.getKey() + " - " + entry.getValue() + " - " +
                    Math.round((entry.getValue() * 100 / total) * 10.0) / 10.0 + "%");
            if (entry.getValue() == max) {
                System.out.println("Самое часто встречающееся слово - " + entry.getKey());
            }
        }
        System.out.println("Всего слов: " + (int)total);
    }

//Первый вариант. Доделать
    public static void textAnalyzer() {
        Map<String, Integer> words = new HashMap<>();
        System.out.println("Введите путь к файлу: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path;
        try {
            path = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Введено некорректное значение. Введите путь к файлу.");
        }


        int quantity = Integer.parseInt(null);
        Scanner scanner;
        try {
            scanner = new Scanner(Paths.get(path), StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            throw new RuntimeException("Файл не обнаружен. Проверьте корректность пути и/или имени файла");
        }
        scanner.useDelimiter("\n, \s, \t, [/:;?!'.,], \u2014, \u2015, \"");
        while (scanner.hasNext()) {
            String line = scanner.next();
            if (line.equals(scanner.next())) {
                quantity ++;
            }
            words.put(line, quantity);
        }

        words.forEach((k, v) -> System.out.println(MessageFormat.format("{0} - {1}", k, v)));
    }

}
