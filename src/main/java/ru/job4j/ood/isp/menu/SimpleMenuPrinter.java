package ru.job4j.ood.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {
    private final StringBuilder result = new StringBuilder();

    @Override
    public void print(Menu menu) {
        menu.forEach(o -> {
                    String temp = o.getNumber() + " " + o.getName();
                    int length = o.getNumber().length();
                    if (length > 2) {
                        int repeatCount = length / 2;
                        temp = "--".repeat(repeatCount) + " " + temp;
                    }
                    System.out.println(temp);
                    result.append(temp);
                }
        );
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
