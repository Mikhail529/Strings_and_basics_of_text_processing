import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CLS {
    public static void main(String[] args) {

        // Task 16. Создать приложение, разбирающее текст (текст хранится в строке)
        // и позволяющее выполнять с текстом три различные операции:
        // 1. Отсортировать абзацы по количеству предложений.
        // 2. В каждом предложении отсортировать слова по длине.
        // 3. Отсортировать лексемы в предложении по убыванию количества вхождений заданного символа,
        // а в случае равенства - по алфавиту

        String string = "Christmas is one of the most popular holidays on the planet. " +
                "It seems strange but not everybody celebrate such a great holiday. " +
                "It depends on the religion and the culture of people. So, who does not celebrate this holiday?" +
                "    Firstly, it’s a religious holiday. Christians commemorate the birth of Christ. " +
                "So people who are neither Christian nor believers don’t have holiday mood on this day." +
                "    Besides, other people refuse to take part in Christmas, " +
                "because they consider that this holiday became too commercial. " +
                "It’s true that in December stores are full of Christmas goods. " +
                "And people spend a lot of money to have a good time with their friends, family and relatives. " +
                "Most of them are ready to waste money for small useless presents. " +
                "It is clear that they celebrate Christmas because " +
                "it’s a family party and a great opportunity to be together." +
                "    Nevertheless this cheerful and commercial side of this holiday attracts some countries, " +
                "for example, China. They have been celebrating Christmas for several years. " +
                "But this holiday is not in their culture." +
                "    And in many countries we can find the same traditions. " +
                "Families decorate a tree, prepare a holiday meal, and wait for Santa Claus and his gifts. " +
                "But each country also has its things. " +
                "In the USA there are garlands of popcorn, and in Sweden there are goats made of straw." +
                "    Someone doesn’t celebrate Christmas, " +
                "but two billion people, nearly every third person in the world, celebrate Christmas. " +
                "And this year it will be again, and it will be magic.";

        starProgramm(string);

    }

    public static void starProgramm (String string) {
        System.out.println("1. Отсортировать абзацы по количеству предложений");
        System.out.println("2. В каждом предложении отсортировать слова по длине");
        System.out.println("3. Отсортировать лексемы в предложении " +
                "по убыванию количества вхождений заданного символа, а в случае равенства - по алфавиту");

        System.out.println("\nEnter number from 1 to 3: ");
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();

        while (!(start <= 3 && start >= 1)) {
            System.out.println("\nEnter number from 1 to 3: ");
            start = scanner.nextInt();
        }

        switch (start) {
            case (1): sortByParagraph(string);
            break;
            case (2): sortedByLength(string);
            break;
            case (3): sortedByLexeme(string);
            break;
        }
    }

    public static void sortedByLexeme (String string) {
        String[] arrayLexeme = string.split("\\W+");
        methodTrim(arrayLexeme);

        for (int i=0; i < arrayLexeme.length; i++) {
            String tempString = arrayLexeme[i].toLowerCase();
            arrayLexeme[i] = tempString;
        }

        System.out.println("Enter character: ");
        Scanner scanner = new Scanner(System.in);
        char simvol = scanner.findInLine(".").charAt(0);

        int s = 0;
        for (String value : arrayLexeme) {
            if (methodLexeme(value, simvol) == 0) {
                s++;
            }
        }
        String[] arraySorAlphabetical  = new String[s];

        for (int left = 0; left < arrayLexeme.length; left++) {
            int minInd = left;
            for (int i = left; i < arrayLexeme.length; i++) {
                // Charge '<' if '>'
                String x1 = arrayLexeme[i]; String x2 = arrayLexeme[minInd];
                if (methodLexeme(x1, simvol) > methodLexeme(x2, simvol)) {
                    minInd = i;
                }
            }
            swap(arrayLexeme, left, minInd);
        }

        int start;
        int number = 0;
        int count = methodLexeme(arrayLexeme[0], simvol);

        for (int i=0; i<arrayLexeme.length; i++) {
            if (count == methodLexeme(arrayLexeme[i], simvol)) {
                number++;
            }
            if (!(count == methodLexeme(arrayLexeme[i], simvol))) {
                start = (i-number);
                countingTheNumber(start, number, arrayLexeme);
                number = 1;
                count = methodLexeme(arrayLexeme[i], simvol);
            }
        }
        int st = 0;
        for (String x : arrayLexeme) {
            if (0 == methodLexeme(x, simvol)) {
                st++;
            }
        }
        int numbers = arrayLexeme.length-st;

        countingTheNumber(numbers, st, arrayLexeme);
        zeroArray(arrayLexeme, simvol);
        System.out.println();

        for (String x : arrayLexeme) {
            System.out.println("Count:(" + methodLexeme(x, simvol) + ") " + x);
        }
    }

    public static void sortedByLength (String string) {
        String[] predlozheniye = string.split("([.!?])");

        print(predlozheniye);
        methodTrim(predlozheniye);

        for (String value : predlozheniye) {
            String[] tempArray = value.split("\\W+");

            System.out.print("Before:  ");
            for (String s : tempArray) {
                System.out.print(s + " ");
            }
            System.out.println();

            // Сортировка слов в предложении по длинне
            for (int left = 0; left < tempArray.length; left++) {
                int minInd = left;
                for (int i = left; i < tempArray.length; i++) {
                    // Charge '<' if '>'
                    if (tempArray[i].length() < tempArray[minInd].length()) {
                        minInd = i;
                    }
                }
                swap(tempArray, left, minInd);
            }

            System.out.print("After:   ");
            for (String s : tempArray) {
                System.out.print(s + " ");
            }
            System.out.println("\n");
        }
    }

    public static void sortByParagraph (String string) {
        String[] paragraph = string.split("( {4})");
        print(paragraph);
        methodTrim(paragraph);

        String strPattern = "([.!?])([\\s\\n])([A-Z]*)";

        sortSelection(paragraph, strPattern);
    }

    private static void sortSelection (String[] strings, String strPattern) {
        for (int left = 0; left < strings.length; left++) {
            int minInd = left;
            for (int i = left; i < strings.length; i++) {
                // Charge '<' if '>'
                String s1 = strings[i]; String s2 = strings[minInd];
                if (s1Method(s1, strPattern) > s2Method(s2,strPattern)) {
                    minInd = i;
                }
            }
            swap(strings, left, minInd);
            System.out.println("Count:("
                    + count(strings,left,strPattern) + ") "
                    + strings[left]);
        }
    }

    //                          Other methods

    public static void countingTheNumber (int start, int number, String[] arrayLexeme) {
        String[] temp = new String[number];
        int start1 = start;
        for (int i=0; i<temp.length; i++) {
            temp[i] = arrayLexeme[start];
            start++;
        }
        Arrays.sort(temp);
        for (String s : temp) {
            arrayLexeme[start1] = s;
            start1++;
        }
    }

    public static void zeroArray (String[] arrayLexeme, char simvol) {
        int st = 0;
        for (String x : arrayLexeme) {
            if (0 == methodLexeme(x, simvol)) {
                st++;
            }
        }
        int numbers = arrayLexeme.length-st;
        System.out.println("Count All: " + numbers);
        countingTheNumber(numbers, st, arrayLexeme);
    }

    private static int methodLexeme (String str, char simvol) {
        int count = 0;
        char[] tempCharArray = str.toCharArray();

        for (char c : tempCharArray) {
            if (Character.toUpperCase(c) == Character.toUpperCase(simvol)) {
                count++;
            }
        }
        return count;
    }

    private static int count (String[] string, int left, String strPattern) {
        Pattern pattern = Pattern.compile(strPattern);
        Matcher matcher = pattern.matcher(string[left]);

        int count=0;
        while (matcher.find( )) {
            count++;
        }
        count++;
        return count;
    }
    private static int s1Method (String s1, String pattern) {
        String[] temp = s1.split(pattern);
        return temp.length;
    }
    private static int s2Method (String s2, String pattern) {
        String[] temp = s2.split(pattern);
        return temp.length;
    }
    private static void swap (String[] tempArray, int ind1, int ind2) {
        String tmp = tempArray[ind1];
        tempArray[ind1] = tempArray[ind2];
        tempArray[ind2] = tmp;
    }
    private  static void methodTrim (String[] strings) {
        for (int i=0; i<strings.length; i++) {
            String temp = "";
            temp = strings[i].trim();
            strings[i] = temp;
        }
    }
    private static void print (String[] strings) {
        methodTrim(strings);
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();
    }
}