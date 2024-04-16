package org.homies.utiles;

import java.util.ArrayList;
import java.util.List;

public class TablePrinter {
    List<String[]> list;
    int[] maxWidth;

    public TablePrinter() {
        this.list = new ArrayList<>();
        // this.maxWidth = 1;
    }

    public void addRow(String... data) {
        for (int i = 0; i < data.length; i++) {
            if (maxWidth == null) {
                maxWidth = new int[data.length];
                for (int j = 0; j < data.length; j++) {
                    maxWidth[j] = data[j].length();
                }
            } else {
                for (int j = 0; j < data.length; j++) {
                    maxWidth[j] = Math.max(maxWidth[j], data[j].length());
                }
            }
        }
        list.add(data);
    }

    public void printTable() {

        printLine();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                System.out.print("|" + putSpace(list.get(i)[j], maxWidth[j])); // |

            }

            System.out.println("|"); // |
            if (i == 0) {
                printLine();
            }
        }
        printLine();
    }

    private void printLine() {
        for (int i = 0; i < maxWidth.length; i++) {
            System.out.print("+"); // +
            for (int j = 0; j < maxWidth[i]; j++) {
                System.out.print("-"); // -
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }
        System.out.println("+"); // +
    }

    private String putSpace(String s, int i) {

        return String.format("%-" + i + "s", s);
    }
}
