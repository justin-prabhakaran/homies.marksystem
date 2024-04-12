package org.homies.utiles;

import java.util.ArrayList;
import java.util.List;

public class TablePrinter {
    List<String[]> list;
    int maxWidth;

    public TablePrinter() {
        this.list = new ArrayList<>();
        this.maxWidth = 1;
    }

    public void addRow(String... data) {
        for (int i = 0; i < data.length; i++) {
            if (maxWidth < data[i].length()) {
                maxWidth = data[i].length();
            }
        }
        list.add(data);
    }

    public void printTable() {
        for (int i = 0; i < list.size(); i++) {
            for (String s : list.get(i)) {
                System.out.print("| " + putSpace(s));
            }
            System.out.println("|");
        }
    }

    private String putSpace(String s) {
        return String.format("%-" + this.maxWidth + "s", s);
    }
}
