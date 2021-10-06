public class CLS {
    public static void main(String[] args) {

        // Task 9. С помощью функции копирования и операции конкатенации составить
        // из частей слова "информатика" слово "торт"

        String str1 = "информатика";
        char[] arrayStr1 = str1.toCharArray();
        String str2 = "";

        int index1 = str1.indexOf('т');
        int index2 = str1.indexOf('о');
        int index3 = str1.indexOf('р');

        char charIndex1 = str1.charAt(index1);
        String s1 = String.valueOf(charIndex1);

        char charIndex2 = str1.charAt(index2);
        String s2 = String.valueOf(charIndex2);

        char charIndex3 = str1.charAt(index3);
        String s3 = String.valueOf(charIndex3);

        str2 = str2.concat(s1);
        str2 = str2.concat(s2);
        str2 = str2.concat(s3);
        str2 = str2.concat(s1);

        System.out.println(str2);
    }
}