package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class TodoApp {
    public static final String SELECT = "Выберите меню:";
    public static final String ROOT_SELECT = "Введите название элемента:";
    public static final String PARENT_SELECT = "Укажите родительский элемент:";
    public static final String NOTE_SELECT = "Введите заметку:";
    public static final String DONE = "Данные добавлены!";
    public static final String EXIT = "Конец работы";
    public static final String MENU = """
                ----- Меню -----
                Введите 1, чтобы добавить элемент в корень меню.
                Введите 2, чтобы добавить элемент к родительскому элементу.
                Введите 3, чтобы вывести заметку у элемента меню.
                Введите 4, чтобы вывести меню.
                Введите любое другое число для выхода.
            """;

    static void start(Scanner scanner, Menu menu) {
        MenuPrinter printer = new SimpleMenuPrinter();
        boolean run = true;
        String element;
        ActionDelegate action;
        while (run) {
            System.out.println(MENU);
            System.out.println(SELECT);
            int userChoice = Integer.parseInt(scanner.nextLine());
            if (userChoice == 1) {
                System.out.println(ROOT_SELECT);
                element = scanner.nextLine();
                System.out.println(NOTE_SELECT);
                String note = scanner.nextLine();
                action = () -> System.out.println(note);
                menu.add(Menu.ROOT, element, action);
                System.out.println(DONE);
            } else if (userChoice == 2) {
                System.out.println(PARENT_SELECT);
                String parent = scanner.nextLine();
                System.out.println(ROOT_SELECT);
                element = scanner.nextLine();
                System.out.println(NOTE_SELECT);
                String note = scanner.nextLine();
                action = () -> System.out.println(note);
                menu.add(parent, element, action);
                System.out.println(DONE);
            } else if (userChoice == 3) {
                System.out.println(ROOT_SELECT);
                element = scanner.nextLine();
                Menu.MenuItemInfo item = menu.select(element).get();
                item.getActionDelegate().delegate();
            } else if (userChoice == 4) {
                printer.print(menu);
            } else {
                run = false;
                System.out.println(EXIT);
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        Scanner scanner = new Scanner(System.in);
        start(scanner, menu);
    }
}
