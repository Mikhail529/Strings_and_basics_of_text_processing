import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CLS {
    public static void main(String[] args) throws Exception {

        // Task 17. Дана строка, содержащая следующий текст (xml-документ)
        /*
        <notes>
            <note id = "1">
                <to>Вася</to>
                <from>Света</from>
                <heading>Напоминание</heading>
                <body>Позвони мне завтра!</body>
            </note>
            <note id = "2">
                <to>Петя</to>
                <from>Маша</from>
                <heading>Важное напоминание</heading>
                <body/>
            </note>
        </notes>
        */
        // Напишите анализатор, позволяющие последовательно возвращать содержимое узлов xml-документа
        // и его тип (открывающий тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться
        // готовыми парсерами XML для решения данной задачи нельзя

        String xml =  "<notes>\n" +
                "        <note id = \"1\">\n" +
                "           <to>Вася</to>\n" +
                "           <from>Света</from>\n" +
                "           <heading>Напоминание</heading>\n" +
                "           <body>Позвони мне завтра!</body>\n" +
                "        </note>\n" +
                "        <note id = \"2\">\n" +
                "           <to>Петя</to>\n" +
                "           <from>Маша</from>\n" +
                "           <heading>Важное напоминание</heading>\n" +
                "           <body/>\n" +
                "        </note>\n" +
                "     </notes>";

        xmlAnalizator(xml);
    }

    private static void xmlAnalizator(String xml) {
        String[] xmlAnaliz = xml.split("\n\\s+");

        Pattern patternClozeTag = Pattern.compile("[<][/]\\w+[>]");
        Pattern patternOpenTag = Pattern.compile("[<]\\w+[>]");
        Pattern patternTagWithoutBody = Pattern.compile("[<]\\w+[/][>]");
        Pattern patternBodyTag = Pattern.compile("[>].+[<]");

        for (String s : xmlAnaliz) {
            methodMatcher(patternOpenTag, patternClozeTag, patternTagWithoutBody, patternBodyTag, s);
        }
    }
    
    private static void methodMatcher(Pattern openTag, Pattern clozeTag, Pattern tagWithoutBody, Pattern bodyTag, String string) {

        Matcher matcher1 = openTag.matcher(string);
        while (matcher1.find()) {
            System.out.println("Open tag \t\t\t" + matcher1.group());
        }

        Matcher matcher2 = clozeTag.matcher(string);
        while (matcher2.find()) {
            System.out.println("Cloze tag \t\t\t" + matcher2.group());
        }

        Matcher matcher3 = tagWithoutBody.matcher(string);
        while (matcher3.find()) {
            System.out.println("Tag without body \t" + matcher3.group());
        }

        Matcher matcher4 = bodyTag.matcher(string);
        while (matcher4.find()) {
            System.out.println("Body tag \t\t\t" + matcher4.group());
        }
    }
}