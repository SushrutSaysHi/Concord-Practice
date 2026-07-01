import java.util.HashMap;
import java.util.Map;

public class FrequencyChecker {
    public static void main(String[] args) {
        String sentence = "the cat sat on the mat the cat";
        String[] words = sentence.split(" ");

        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        System.out.println(count);
    }
}
