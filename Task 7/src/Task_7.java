public class CLS {
    public static void main(String[] args) {

        // Task 7. В строке вставить после каждого символа 'a' символ 'b'

        String str = "September 5, 1952, at that time he was already 20 years old";
        String string = str.replaceAll("a", "b");
        System.out.println(string);
    }
}