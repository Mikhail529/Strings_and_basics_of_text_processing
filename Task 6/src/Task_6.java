public class CLS {
    public static void main(String[] args) {

        // Task 6. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем

        String string = "September  5, 1952,   at that time  he     was already 20   years old";

        char[] probel = string.toCharArray();
        int k = 0;
        int max = 0;

        for (char c : probel) {
            if (!(c == ' ')) {
                k = 0;
            } else if (c == ' ') {
                k++;
                if (max < k) {
                    max = k;
                }
            }
        }
        System.out.println("The maximum number of spaces in a line is: " + max);
    }
}