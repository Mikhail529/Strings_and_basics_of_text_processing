public class CLS {
    public static void main(String[] args) {

        // Task 3. В строке найти количество цифр

        String string = "September 5, 1952, at that time he was already 20 years old";

//        // Альтернативное решение
//        String onlyNumbers = string.replaceAll("[^0-9]", "");
//        System.out.println("Number of digits in a line: " + onlyNumbers.length());

        char[] numbers = string.toCharArray();
        int k = 0;

        for (char number : numbers) {
            if (Character.isDigit(number)) {
                k++;
            }
        }
        System.out.println("Number of digits in a line: " + k);
    }
}