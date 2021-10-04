public class CLS {
    public static void main(String[] args) {

        // Task 5. Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов
        // заменить на одиночные пробел

        String string = "September   5,   1952,   at   that   time   he   was   already   20   years   old";

        String str =  string.replaceAll("( )+", " ");
        System.out.println(str);
    }
}