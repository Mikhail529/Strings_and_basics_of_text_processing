public class CLS {
    public static void main(String[] args) {

        // Task 12. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
        // Например, если было введено "abc cde def", то должно быть выведено "abcdef"

        // Данный способ удаляет не только пробелы но и символы вроде "tab"

        String str = "abc cde def";
        String string = str.replaceAll("\\s+", "");
        String result = new StringBuilder(string).reverse().toString();
        result = result.replaceAll("(.)(?=.*\\1)", "");
        result = new StringBuilder(result).reverse().toString();
        System.out.println(result);
    }
}