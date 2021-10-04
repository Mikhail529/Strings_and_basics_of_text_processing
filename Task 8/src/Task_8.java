public class CLS {
    public static void main(String[] args) {

        // Task 8. Проверить, является заданое слово палиндромом

        String string = "Hello olleH";

        if (isPalindrome(string)) {
            System.out.println("String is palindrome");
        }
        else System.out.println("String is not palindrome");
    }

    public static boolean isPalindrome(String string) {
        int n = string.length();

        for (int i=0; i<n/2; ++i) {
            if (string.charAt(i) != string.charAt(n-i-1)) {
                return false;
            }
        }

        return true;
    }
}