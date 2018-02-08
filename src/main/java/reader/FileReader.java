package reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Есть входной файл с набором слов, написанных через пробел Необходимо: Прочитать слова из файла.
 * Отсортировать в алфавитном порядке. Посчитать сколько раз каждое слово встречается в файле.
 * Вывести статистику на консоль Найти слово с максимальным количеством повторений. Вывести на
 * консоль это слово и сколько раз оно встречается в файле
 */
public class FileReader {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();
        List<String> fileWords = fileReader.getOnlyWords("ddd.txt");

        Collections.sort(fileWords);

        System.out.println(
            fileWords
        );

        System.out.println(
            fileReader.getDuplicateStatistic(fileWords)
        );
    }

    private List<String> getOnlyWords(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName));
        List<String> fileWords = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            fileWords.addAll(
                Arrays.asList(
                    line.split("\\s")
                )
            );

            System.out.println(line);
        }
        reader.close();

        return fileWords;
    }

    private HashMap<String, Integer> getDuplicateStatistic(List<String> list) {
        HashMap<String, Integer> statisticMap = new HashMap<>();

        list.forEach(
            str -> statisticMap.merge(str, 1, (a, b) -> a + b)
        );

        return statisticMap;
    }
}
