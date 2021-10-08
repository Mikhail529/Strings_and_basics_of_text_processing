public class CLS {
    public static void main(String[] args) {

        // Task 11. Из заданой строки получить новую, повторив каждый символ дважды

        String string = "Hello";
        char[] arraystring = string.toCharArray();
        String stringFinal = "";

        for (char c : arraystring) {
            String temp = "";
            for (int j = 0; j < 2; j++) {
                temp = String.valueOf(c);
                stringFinal = stringFinal.concat(temp);
            }
        }

        System.out.println(stringFinal);
    }
}