package edu.avada.course.question_05;

/*
* Разработать программу, которая будет проверять, является ли введенная пользователем
* строка корректным номером телефона согласно определенным правилам (первые три символа всегда 380,
* далее 2 символа - код операторов, а вся строка не превышает 12 символов).
* Приложение должно предложить пользователю ввести телефон и выдать сообщение о его корректности.
*/

import edu.avada.course.TaskUtil;
import java.util.regex.Pattern;

public class Main {
    private final static String CHECK_PHONE_NUMBER_PATTERN = "^380[679][36-9]\\d{7}$";

    public static void main(String[] args) {
        String input = TaskUtil.getInput("Введіть номер телефону: ");
        boolean isMatches = Pattern.matches(CHECK_PHONE_NUMBER_PATTERN, input);
        System.out.println("Номер телефону " + (isMatches ? "коректний" : "не коректний"));

    }
}
