package edu.avada.course.question_04;

/*
* Разработать программу, которая будет проверять, является ли введенная пользователем строка
* корректным паролем согласно определенным правилам
* (содержать как минимум одну цифру, один спецсимвол «,», «.», «/», «?»,
*  одну заглавную букву и быть не менее 8 символов длиной).
* Приложение должно предложить пользователю ввести пароль и выдать сообщение о его корректности.
*/

import edu.avada.course.TaskUtil;
import java.util.regex.Pattern;

public class Main {
    private final static String CHECK_PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[,./?])(?=.*\\d)[\\w,./?]{8,}$";

    public static void main(String[] args) {
        String input = TaskUtil.getInput("Введіть пароль: ");
        boolean res = Pattern.matches(CHECK_PASSWORD_PATTERN, input);
        System.out.println("Пароль " + (res ? "коректний" : "не коректний"));
    }
}
