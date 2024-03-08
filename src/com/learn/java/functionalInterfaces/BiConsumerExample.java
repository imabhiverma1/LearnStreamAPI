package com.learn.java.functionalInterfaces;

import com.learn.java.data.Student;
import com.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void nameAndActivity() {
        List<Student> studentList = StudentDataBase.getAllStudents();
        BiConsumer<String, List<String>> biConsumer = (name, activity) -> System.out.println(name + " : " + activity);
        studentList.forEach((student -> biConsumer.accept(student.getName(), student.getActivities())));
    }

    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer = (a, b) -> {
            System.out.println("a :" + a + ", b :" + b);
        };
        biConsumer.accept("learn", "java8");

        BiConsumer<Integer, Integer> multiply = (a, b) -> {
            System.out.println("Multiply :" + (a * b));
        };
        multiply.accept(23, 2);

        nameAndActivity();
    }


}
