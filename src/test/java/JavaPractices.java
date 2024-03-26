import java.util.LinkedHashMap;
import java.util.Map;

public class JavaPractices {

    public static void main(String[] args) {

        String [] arr = {"Apple", "Kivi", "Apple"};
        System.out.println(countEle(arr));
    }

    public static Map<String, Integer> countEle(String[] arr) {

        Map<String, Integer> elements = new LinkedHashMap<>();

        for (String e : arr) {
            if (elements.containsKey(e))
                elements.put(e, elements.get(e) + 1);
            else elements.put(e, 1);
        }
        return elements;
    }
}
