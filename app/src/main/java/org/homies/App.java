/*
 * This source file was generated by the Gradle 'init' task
 */
package org.homies;

import java.util.*;
import com.google.common.base.Optional;
import org.homies.utiles.ConsoleColors;
import org.homies.utiles.TablePrinter;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class App {

    static Scanner in = new Scanner(System.in);
    static List<Student> list = new ArrayList<>();

    public static void main(String[] args) {
        // int i = 5;1
        // while (i > 0) {
        // list.add(createStudent());
        // i--;
        // }

        // printAllStudents();

        // printStudent("justin");

        do {
            Scanner in = new Scanner(System.in);
            System.out.print(ConsoleColors.CYAN
                    + "\n1.Create Student\n2.Print All Studetns\n3.Print Student\n4.Change the Student Data"
                    + ConsoleColors.RESET
                    + ConsoleColors.CYAN_BOLD + "\n\nEnter Options : "
                    + ConsoleColors.RESET);
            int ch = 0;
            if (in.hasNextInt()) {
                ch = in.nextInt();
            } else if (in.hasNext()) {
                System.out.println(ConsoleColors.RED + "Please choose one option from above!!" + ConsoleColors.RESET);
            }

            if (ch != 0) {
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
                            printStudent(s);
                        } else {
                            printStudent("");
                        }
                    }
                        break;
                    case 4: {
                        System.out.print("Enter the Name : ");
                        if (in.hasNext()) {
                            String studentName = in.next();
                            java.util.Optional<Student> optionalStudent = list.stream()
                                    .filter(student -> student.getName().equals(studentName))
                                    .findFirst();

                            if (optionalStudent.isPresent()) {
                                Student studentToUpdate = optionalStudent.get();
                                Mark mark = studentToUpdate.getMarks(); // Get the Mark object associated with the
                                                                        // student
                                System.out.println();
                                System.out.println("Your Current Mark list");
                                System.out.println();
                                printStudent(studentName);

                                System.out.println(ConsoleColors.CYAN + "\n1.OOSE\n2.CS\n3.EWIOT\n4.NWS\n5.DM\n6.E&AI"
                                        + ConsoleColors.RESET
                                        + ConsoleColors.CYAN_BOLD + "\n\nEnter Options : "
                                        + ConsoleColors.RESET);
                                int changeData = in.nextInt();

                                switch (changeData) {
                                    case 1:
                                        System.out.print("Enter the Change data for OOSE:");
                                        int markChange = in.nextInt();
                                        mark.setMark1(markChange);
                                        System.out.println("Updated Successfully!!!");
                                        break;
                                    case 2:
                                        System.out.print("Enter the Change data for CS:");
                                        markChange = in.nextInt();
                                        mark.setMark2(markChange);
                                        System.out.println("Updated Successfully!!!");
                                        break;
                                    case 3:
                                        System.out.print("Enter the Change data for EWIOT:");
                                        markChange = in.nextInt();
                                        mark.setMark3(markChange);
                                        System.out.println("Updated Successfully!!!");
                                        break;
                                    case 4:
                                        System.out.print("Enter the Change data for NWS:");
                                        markChange = in.nextInt();
                                        mark.setMark4(markChange);
                                        System.out.println("Updated Successfully!!!");
                                        break;
                                    case 5:
                                        System.out.print("Enter the Change data for DM:");
                                        markChange = in.nextInt();
                                        mark.setMark5(markChange);
                                        System.out.println("Updated Successfully!!!");
                                        break;
                                    case 6:
                                        System.out.print("Enter the Change data for E&AI:");
                                        markChange = in.nextInt();
                                        mark.setMark6(markChange);
                                        System.out.println("Updated Successfully!!!");
                                        break;

                                    default:
                                        break;
                                }
                            } else {
                                System.out.println(ConsoleColors.RED + "Student with name '" + studentName
                                        + "' not found!" + ConsoleColors.RESET);
                            }
                        } else {
                            System.out.println(
                                    ConsoleColors.RED + "Please enter a valid student name!" + ConsoleColors.RESET);
                        }
                    }
                        break;
                    default: {
                        System.out.println(
                                ConsoleColors.RED + "Please choose one option from above!!" + ConsoleColors.RESET);

                    }
                }
            }

        } while (true);

    }

    /**
     * print all students in tabular foramt
     */
    static void printAllStudents() {
        // list.sort(new myComparator());

        Collections.sort(list, new myComparator());
        TablePrinter tablePrinter = new TablePrinter();
        tablePrinter.addRow("Name", "Total Marks", "Rank", "Advice");
        int rank = 0;
        for (Student st : list) {
            rank++;

            // tablePrinter.addRow(st.getName(), String.valueOf(st.getMarks().getTotal()),
            // st.getMarks().rank(),
            // st.getMarks().advice());

            if (st.getMarks().isFailed()) {
                tablePrinter.addRow(st.getName(), ToString(st.getMarks().getTotal()), "FAIL", st.getMarks().advice());
            } else {
                tablePrinter.addRow(st.getName(), ToString(st.getMarks().getTotal()), ToString(rank),
                        st.getMarks().advice());
            }
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
        String[] marks = { "OOSE", "Cloud Service", "Embedded With iot", "NetWork Security", "Digital Markating",
                "Ethics" };
        Mark mark = new Mark();
        // st.setMarks(new Mark(10 + new Random().nextInt(100), 10, 10, 10, 10, 10));
        for (int i = 0; i <= marks.length - 1; i++) {
            while (true) {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter Mark " + marks[i] + " : ");
                if (in.hasNextInt()) {
                    int m = in.nextInt();
                    if (m > 100) {
                        System.out
                                .println(ConsoleColors.RED + "please enter mark below/equal 100" + ConsoleColors.RESET);
                        continue;
                    } else {
                        switch (i + 1) {
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
                    break;

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
        if (o1.getMarks().isFailed() && !o2.getMarks().isFailed()) {
            return 1;
        } else if (o2.getMarks().isFailed() && !o1.getMarks().isFailed()) {
            return -1;
        }
        return o2.getMarks().getTotal() - o1.getMarks().getTotal();
    }
}