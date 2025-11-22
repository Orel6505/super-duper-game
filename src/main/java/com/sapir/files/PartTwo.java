package com.sapir.files;

import java.io.*;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String outputFile = "report.txt";

        String studentsFile = scanner.nextLine();
        String gradesFile = scanner.nextLine();
        
        if (studentsFile.isEmpty() || gradesFile.isEmpty()) {
            System.out.println("File names cannot be empty.");
            scanner.close();
            return;
        }
        try (BufferedReader brStudents = new BufferedReader(new FileReader(studentsFile));
                BufferedReader brGrades = new BufferedReader(new FileReader(gradesFile));
                PrintWriter pw = new PrintWriter(new FileWriter(outputFile))) {

            String lineStudent = brStudents.readLine();
            String lineGrade = brGrades.readLine();

            while (lineStudent != null && lineGrade != null) {
                String[] studentInfo = lineStudent.split(" ");
                String idStudent = studentInfo[studentInfo.length - 1];
                long id = Long.parseLong(idStudent);

                String[] grade = lineGrade.split(" ");
                long idGrade = Long.parseLong(grade[0]);

                if (id < idGrade) {
                    lineStudent = brStudents.readLine();
                } else if (idGrade < id) {
                    lineGrade = brGrades.readLine();
                }

                int grade1 = Integer.parseInt(grade[1]);
                int grade2 = Integer.parseInt(grade[2]);
                int avg = (grade1 + grade2) / 2;

                StringBuilder fullName = new StringBuilder();
                for (int i = 0; i < studentInfo.length - 1; i++) {
                    fullName.append(studentInfo[i]).append(" ");
                }
                pw.println(id + " " + fullName.toString().trim() + " " + avg);

                lineStudent = brStudents.readLine();
                lineGrade = brGrades.readLine();

            }
        }
        catch (Exception e) {
            System.out.println("Error parsing data: " + e.getMessage());
        }
    }
}
