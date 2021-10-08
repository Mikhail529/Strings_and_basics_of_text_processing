public class CLS {
    public static void main(String[] args) {

        // Task 13. Вводиться строка слов, разделенных пробелами. Найти самое длинное слово
        // и вывести его на экран. Случай, когда самых длинных слов может быть несколько, не обрабатывать

        String string = "sea sun beach sand vacation summer";

        String chargeString = string + " ";
        char[] arrayChange = chargeString.toCharArray();

        int temp = 0;
        int k = 0;
        int kMax = 0;

        for (int i = 0; i < arrayChange.length; i++) {
            char c = arrayChange[i];
            if (!(c == ' ')) {
                k++;
            } else {
                if (!(k == 0)) {
                    if (kMax < k) {
                        kMax = k;
                        temp = i;
                    }
                }
                k = 0;
            }
        }
        System.out.println("The biggest word: " + string.substring(temp-kMax, temp));
        System.out.println("The number of letters in it: " + kMax);
    }
}