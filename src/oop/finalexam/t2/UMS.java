package oop.finalexam.t2;

import java.util.ArrayList;
import java.util.List;

public class UMS {
    private List<Student> students;
    
    public UMS() {
        this.students = new ArrayList<>();
    }
    
    public void addStudent(Student student) {
        this.students.add(student);
    }
    
    public void printStudentData(Student student) {
        System.out.println("Student Information:");
        System.out.println("Name: " + student.getName());
        System.out.println("ID: " + student.getId());
        System.out.println("\nLearning Courses:");
        
        // Check if the student is myself
        if (student.getName().equals("Mariam Gamishidze") && student.getId().equals("61606084020")) {
            LearningCourse course1 = new LearningCourse();
            course1.setTitle("Object Oriented Programming (ENG)");
            course1.setAcceptancePrerequisites("CS50 Introduction to Programming");
            course1.setMajorTopics("Java syntax and data structures; Procedural programming; Classes; Encapsulation, polymorphism, inheritance; Packages; Working with the network; Work with files; Working with text data; Work with the terminal.");
            
            LearningCourse course2 = new LearningCourse();
            course2.setTitle("Calculus II (ENG)");
            course2.setAcceptancePrerequisites("MATH150 Calculus I");
            course2.setMajorTopics("Lecture; Seminars; Verbal method; Demonstration method; Discussion; Practical work.");
            
            LearningCourse course3 = new LearningCourse();
            course3.setTitle("Computer Organization (ENG)");
            course3.setAcceptancePrerequisites("CS50 Introduction to Programming");
            course3.setMajorTopics("Representing and manipulating information; Machine-level representations of programs; Optimizing program performance. The memory hierarchy.");
            
            LearningCourse course4 = new LearningCourse();
            course4.setTitle("Mathematical Foundation of Computing (ENG)");
            course4.setAcceptancePrerequisites("MATH150 Calculus I");
            course4.setMajorTopics("Mathematical Logic; Elements of Discrete Mathematics; Elements of Sets Theory; Elements of Graph Theory; Elements of Combinatorics; Elements of Digital Systems;");
            
            LearningCourse course5 = new LearningCourse();
            course5.setTitle("English Language Course C1-2 (ENG)");
            course5.setAcceptancePrerequisites("N/A");
            course5.setMajorTopics("N/A");
            
            student.getLearningCourses().clear();
            student.addLearningCourse(course1);
            student.addLearningCourse(course2);
            student.addLearningCourse(course3);
            student.addLearningCourse(course4);
            student.addLearningCourse(course5);
        }
        
        if (student.getLearningCourses().isEmpty()) {
            System.out.println("NO COURSES");
        } else {
            for (LearningCourse course : student.getLearningCourses()) {
                System.out.println("\nCourse Title: " + course.getTitle());
                System.out.println("Acceptance Prerequisites: " + course.getAcceptancePrerequisites());
                System.out.println("Major Topics: " + course.getMajorTopics());
            }
        }
        System.out.println("----------------------------------");
    }
    
    public static void main(String[] args) {
        UMS ums = new UMS();
        
        Student me = new Student("Mariam Gamishidze", "61606084020");
        ums.addStudent(me);
        
        // Print student data
        ums.printStudentData(me);
    }
}