public class CLS {
    public static void main(String[] args) {

        // Task 1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case

        mainMethod();
    }

    public static void mainMethod () {
        String[] camelCase = new String[]{"helloWord", "languageJava", "epamSistems", "it'sYou"};

        for (String s : camelCase) {
            char[] toCharArray = s.toCharArray();

            int k = 0;

            for (char c : toCharArray) {
                if (Character.isUpperCase(c)) {
                    k++;
                }
            }

            int chr = toCharArray.length + k;
            char[] chargeArray = new char[chr];

            someMethodOne(toCharArray, chargeArray);
            someMethodTwo(toCharArray, chargeArray);
            someMethodThree(chargeArray);
            printMethod(chargeArray);
        }
    }

    public static void someMethodOne (char[] toCharArray, char[] chargeArray) {
        for (int i=0; i<toCharArray.length; i++) {
            chargeArray[i] = toCharArray[i];
            if (Character.isUpperCase(chargeArray[i])) {
                chargeArray[i] = '_';
                char tempChar = chargeArray[i];
                String tempStr = String.valueOf(tempChar);
                String tempStr1 = tempStr.toLowerCase();
                char temp = tempStr1.charAt(0);
                chargeArray[i] = temp;
            }
        }
    }

    public static void someMethodTwo (char[] toCharArray, char[] chargeArray) {
        int j = 0;
        for (char c : toCharArray) {
            if (Character.isUpperCase(c)) {
                j++;
            }
            chargeArray[j] = c;
            j++;
        }
    }

    public static void someMethodThree (char[] chargeArray) {
        for (int i=0; i<chargeArray.length; i++) {
            if (Character.isUpperCase(chargeArray[i])) {
                char tempChar = chargeArray[i];
                String tempStr = String.valueOf(tempChar);
                String tempStr1 = tempStr.toLowerCase();
                char temp = tempStr1.charAt(0);
                chargeArray[i] = temp;
            }
        }
    }

    public static void printMethod (char[] chargeArray) {
        for (char x : chargeArray) {
            System.out.print(x);
        }
        System.out.println();
    }
}