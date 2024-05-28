package edu.avada.course.question_02;

/*
* Разработать программу, которая будет проверять, является ли введенная пользователем строка
* корректным адресом электронной почты с помощью регулярных выражений (regex).
* Приложение должно предложить пользователю ввести адрес и выдать сообщение о его корректности.
* Дополнительно проверить на возможность использования адресов: “example.s@email.co”, “example@email.com.ua”.
*/

import edu.avada.course.TaskUtil;
import java.util.regex.Pattern;

public class Main {
    private static final String CHECK_EMAIL_PATTERN = "^[A-Za-z_]\\w*(\\.)?\\w+@[a-z]{2,}\\.[a-z]{2,4}(\\.[a-z]{2,4})?";

    public static void main(String[] args) {
        String input = TaskUtil.getInput("Введіть ваше мило: ");
        boolean isMatch = Pattern.matches(CHECK_EMAIL_PATTERN, input);
        System.out.println(isMatch ? "Correct": "Not Correct");
    }
}
