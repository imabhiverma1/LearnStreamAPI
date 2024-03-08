package com.learn.java.functionalInterfaces;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    static Consumer<Student> c2 = (student) -> System.out.println(student);
    static Consumer<Student> c3 = (student) -> System.out.print(student.getName());
    static Consumer<Student> c4 = (student) -> System.out.println(student.getActivities());

    public static void printName() {

        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c2);
    }

    public static void printActivity() {

        System.out.println("printActivity");
        List<Student> studentList = StudentDataBase.getAllStudents();

        studentList.forEach(c3.andThen(c4));
    }

    public static void printActivityBasedOnConditions() {

        System.out.println("printActivityBasedOnConditions");
        List<Student> studentList = StudentDataBase.getAllStudents();

        studentList.forEach((student -> {
            if (student.getGradeLevel() > 3 && student.getName().startsWith("S"))
                c3.andThen(c4).accept(student);
        }));
    }

    public static void main(String[] args) {

        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());

        c1.accept("need to learn java 8");
        printName();
        printActivity();
        printActivityBasedOnConditions();
    }
}
