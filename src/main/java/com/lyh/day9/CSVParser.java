package com.lyh.day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public static void main(String[] args) {
        List<Student> students = parseCSV("/Users/lyh/CodeLab/src/main/java/com/lyh/day9/students.csv");
        for (Student student : students) {
            System.out.println(student.getName() + ", " + student.getAge() + ", " + student.getScore());
        }
    }

    public static List<Student> parseCSV(String filename) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    String name = fields[0];
                    int age = Integer.parseInt(fields[1]);
                    double score = Double.parseDouble(fields[2]);
                    students.add(new Student(name, age, score));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}