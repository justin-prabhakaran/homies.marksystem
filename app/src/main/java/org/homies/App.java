/*
 * This source file was generated by the Gradle 'init' task
 */
package org.homies;

import java.util.*;

import org.homies.utiles.ConsoleColors;
import org.homies.utiles.TablePrinter;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class App {

    static Scanner in = new Scanner(System.in);
    static List<Student> list = new ArrayList<>();

    public static void main(String[] args) {
        // int i = 5;
        // while (i > 0) {
        // list.add(createStudent());
        // i--;
        // }

        // printAllStudents();

        // printStudent("justin");

        do {
            System.out.print(ConsoleColors.CYAN + "\n1.Create Student\n2.Print All Studetns\n3.Print Student "
                    + ConsoleColors.RESET
                    + ConsoleColors.CYAN_BOLD + "\n\nEnter Options : "
                    + ConsoleColors.RESET);
            int ch = 0;
            if (in.hasNextInt()) {
                ch = in.nextInt();
            } else {
                break;
            }

            switch (ch) {

                case 1: {
                    Student st = createStudent();
                    list.add(st);
                }
                    break;
                case 2: {
                    printAllStudents();
                }
                    break;
                case 3: {
                    System.out.print("Enter the Name : ");
                    if (in.hasNext()) {
                        String s = in.next();
                        // System.out.println(s);
                        printStudent(s);
                    } else {
                        printStudent("");
                    }
                }
                    break;
            }

        } while (true);

    }

    /**
     * print all students in tabular foramt
     */
    static void printAllStudents() {
        // list.sort(new myComparator());
        int rank = 0;
        Collections.sort(list,new myComparator());
        TablePrinter tablePrinter = new TablePrinter();
        tablePrinter.addRow("Name", "Total Marks", "Rank","Advice");
        for (Student st : list) {
            rank +=  1;
            tablePrinter.addRow(st.getName(), String.valueOf(st.getMarks().getTotal()), String.valueOf(rank),st.getMarks().advice());
        }

        tablePrinter.printTable();
    }

    /**
     * print particular student
     * 
     * @param student
     */
    static void printStudent(String name) {
        TablePrinter tablePrinter = new TablePrinter();
        tablePrinter.addRow("Name", "OOSE", "CS", "EWIOT", "NWS", "DM", "E&AI");

        Optional<Student> st = Iterables.tryFind(list, new Predicate<Student>() {

            @Override
            public boolean apply(Student input) {
                // System.out.println(ss + '\t' + input.getName());
                return name.equals(input.getName());

            }
        });
        if (st.isPresent()) {

            Mark mark = st.get().getMarks();
            tablePrinter.addRow(st.get().getName(), ToString(mark.getMark1()), ToString(mark.getMark2()),
                    ToString(mark.getMark3()), ToString(mark.getMark4()),
                    ToString(mark.getMark5()), ToString(mark.getMark6()));

            tablePrinter.printTable();
        } else {
            System.out.println();
            System.out.println(ConsoleColors.RED + "No result found !!" + ConsoleColors.RESET);

        }
    }

    static Student createStudent() {
        Student st = new Student();
        System.out.print("Enter Name : ");
        if (in.hasNext()) {
            st.setName(in.next());
        } else {
            System.out.println(ConsoleColors.RED + "Something went wrong !" + ConsoleColors.RESET);
            return null;
        }
        System.out.println(ConsoleColors.CYAN_BOLD + "Enter Marks" + ConsoleColors.RESET);
        // for test sorting
        // int[] arr = new int[6];
        String[] marks ={"OOSE","Cloud Service","Embedded With iot","NetWork Security","Digital Markating", "DSA"}; 
        Mark mark = new Mark();
        // st.setMarks(new Mark(10 + new Random().nextInt(100), 10, 10, 10, 10, 10));
        for (int i = 0; i <= marks.length-1; i++) {
            System.out.print("Enter Mark " + marks[i] + " : ");
            if (in.hasNextInt()) {
                int m = in.nextInt();
                switch (i+1) {
                    case 1: {
                        mark.setMark1(m);
                    }
                        break;
                    case 2: {
                        mark.setMark2(m);
                    }
                        break;
                    case 3: {
                        mark.setMark3(m);
                    }
                        break;
                    case 4: {
                        mark.setMark4(m);
                    }
                        break;
                    case 5: {
                        mark.setMark5(m);
                    }
                    case 6: {
                        mark.setMark6(m);
                    }
                        break;

                    default: {
                        System.out.println(ConsoleColors.RED + "Something went wrong !!" + ConsoleColors.RESET);
                        return null;

                    }
                }
            }
        }

        st.setMarks(mark);
        return st;
    }

    static String ToString(int val) {
        return String.valueOf(val);
    }

    // int tes() {
    // return 1 + 1;
    // }

}

class myComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getMarks().getTotal() - o1.getMarks().getTotal();
    }
}