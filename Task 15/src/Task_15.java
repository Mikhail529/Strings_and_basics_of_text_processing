public class CLS {
    public static void main(String[] args) {

        // Task 15. Строка X состоит из нескольких предложений, каждое из которых кончается точкой,
        // восклицательным или вопросительным знаком. Определить количество предложений в строке X

        String str = "Hello World! Am I teaching Java? Today is Monday.";

        char[] arrayStr = str.toCharArray();
        int numberX = 0;

        for (char c : arrayStr) {
            if (c == '.' || c == '!' || c == '?') {
                numberX++;
            }
        }
        System.out.println("Количество предложений в строке X: " + numberX);
    }
}