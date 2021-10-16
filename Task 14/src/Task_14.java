import java.util.Scanner;

public class CLS {
    public static void main(String[] args) {

        // Task 14. Подсчитать количество строчных (маленьких) и прописных (больших) букв в веденой строке.
        // Учитывать только английские

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        char[] arrayString = string.toCharArray();
        int wordLillke = 0;
        int wordBig = 0;

        for (int x : arrayString) {
            if (x >= 65 && x <= 90) {
                wordBig++;
            }
            if (x >= 97 && x <= 122) {
                wordLillke++;
            }
        }

        System.out.println("Количество строчных (маленьких) букв: " + wordLillke);
        System.out.println("Количество прописных (больших) букв: " + wordBig);
    }
}