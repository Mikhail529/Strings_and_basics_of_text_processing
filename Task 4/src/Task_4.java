import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CLS {
    public static void main(String[] args) {

        // Task 4. В строке найти количество чисел

        String string = "September 5, 1952, at that time he was already 20 years old";

////        // Альтернативное решение
//        int k2= 0;
//        Pattern pat= Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
//        Matcher matcher=pat.matcher(string);
//        while (matcher.find()) {
//            System.out.println(matcher.group());
//            k2++;
//        };
//        System.out.println("Amount of numbers: " + k2);

        char[] numbers = string.toCharArray();
        int k1 = 0;

        for (int i=0; i<numbers.length; i++) {
            StringBuilder str = new StringBuilder();
            while ((Character.isDigit(numbers[i]))) {
                str.append(String.valueOf(numbers[i]));
                i++;
            }
            if (str.length() > 0) {
                k1++;
            }
        }
        System.out.println("Amount of numbers: " + k1);
    }
}