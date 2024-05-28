package edu.avada.course.question_03;

/*
* Разработать программу, которая будет проверять, является ли введенная пользователем строка
* (например, “12/07/2023”, “12.07.2023”, “07.2023”, “2023”, “12.07.2023 17:55:23”)
* корректной датой с помощью регулярных выражений (regex). Приложение должно предложить
* пользователю ввести дату и выдать сообщение о его корректности. Если дата верна,
* то выводить информацию в таком виде, например, введено “12/07/2023 17:55” – выведет:
* 12 – день месяца, 7 – месяц года, 2023 – год, 17 часов 55 минут.
*/

import edu.avada.course.TaskUtil;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private final static String[] CHECK_DATE_PATTERNS = {
            "(?<years>(19)|(20)\\d\\d)", // YYYY
            "(?<months>0[1-9]|1[012])[./](?<years>(19)|(20)\\d\\d)", // MM/YYYY or MM.YYYY
            "(?<days>0[1-9]]|[12]\\d|3[01])[./](?<months>0[1-9]|1[012])[./](?<years>(19)|(20)\\d\\d)", // DD/MM/YYYY or DD.MM.YYYY
            "(?<days>0[1-9]]|[12]\\d|3[01])[./](?<months>0[1-9]|1[012])[./](?<years>(19)|(20)\\d\\d)(\\s+)" +
            "(?<hours>[01]\\d|2[0-4]):(?<minutes>[0-5]\\d)(:(?<seconds>[0-5]\\d))?" // (DD/MM/YYYY or DD.MM.YYYY) HH:mm[:SS]
    };

    public static void main(String[] args) {
        String input = TaskUtil.getInput("Введіть вашу дату: ");
        String res = "Помилковий ввід дати";
        for (String line: CHECK_DATE_PATTERNS) {
            Pattern pattern = Pattern.compile(line);
            Matcher matcher = pattern.matcher(input);
            if(matcher.matches()) {
                res = formResponce(matcher);
                break;
            }
        }
        System.out.print(res);
    }

    private static String formResponce(Matcher matcher) {
        StringBuilder stringBuilder = new StringBuilder();

        Map<String, Integer> namedGroups = matcher.namedGroups();

        String days = "days";
        if (namedGroups.containsKey(days)) {
            stringBuilder
                    .append(matcher.group(namedGroups.get(days)))
                    .append(" - днів місяця\n");
        }
        String months = "months";
        if (namedGroups.containsKey(months)) {
            stringBuilder
                    .append(matcher.group(namedGroups.get(months)))
                    .append(" - місяць року\n");
        }
        String years = "years";
        if (namedGroups.containsKey(years)) {
            stringBuilder
                    .append(matcher.group(namedGroups.get(years)))
                    .append(" - рік\n");
        }
        String hours = "hours";
        if (namedGroups.containsKey(hours)) {
            stringBuilder
                    .append(matcher.group(namedGroups.get(hours)))
                    .append(" годин ");
        }
        String minutes = "minutes";
        if (namedGroups.containsKey(minutes)) {
            stringBuilder
                    .append(matcher.group(namedGroups.get(minutes)))
                    .append(" хвилин ");
        }
        String seconds = "seconds";
        if (namedGroups.containsKey(seconds)) {
            stringBuilder
                    .append(matcher.group(namedGroups.get(seconds)))
                    .append(" секунд ");
        }

        return stringBuilder.toString();
    }
}
