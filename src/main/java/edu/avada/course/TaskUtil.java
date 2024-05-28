package edu.avada.course;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskUtil {
    public static String getInput(String prompt) {
        System.out.print(prompt);
        String line = "";
        try (
                Scanner scanner = new Scanner(System.in)
        ) {
            line = scanner.nextLine();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return line;
    }
}
