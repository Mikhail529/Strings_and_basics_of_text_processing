public class CLS {
    public static void main(String[] args) {

        // Task 10. Подсчитать, сколько раз среди символов заданой строки встречается буква "а"

        String string = "assassa";
        char[] arrayString = string.toCharArray();
        int k = 0;

        for (char c : arrayString) {
            if (c == 'a') {
                k++;
            }
        }
        
        System.out.println("character 'a' occurs " + k + " times");
    }
}