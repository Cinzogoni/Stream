package exercise1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 22, 85.5),
                new Student("Bob", 19, 90.0),
                new Student("Charlie", 23, 78.0),
                new Student("David", 20, 92.5),
                new Student("Eva", 21, 88.0));
        //Studemt Age > 20
        Map<Integer,String> map = students
                .stream()
                .filter(p->p.getAge() > 20)
                .collect(Collectors.groupingBy(
                        Student::getAge,Collectors.mapping(
                                Student::getName,Collectors.joining(" : "))
                        )
                );
        String result = map.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "-" + entry.getValue())
                .collect(Collectors.joining(", "));

        System.out.println("Students ages > 20: " +result+ ".");
        System.out.println("-----------------------------------------------------");

        //Student max grade
            Optional<Student> opt1 = students
                    .stream()
                    .max(Comparator.comparing(Student::getGrade));
            System.out.println("Students with maximum grade: " + opt1.get());
        System.out.println("-----------------------------------------------------");

        //Average grade of all students
        double totalGrades = students
                .stream()
                .map(Student::getGrade)
                .reduce(0.0, Double::sum);
        double averageGrade = totalGrades / students.size();
        System.out.println("Average grade of all students: " +averageGrade);
        System.out.println("-----------------------------------------------------");

        //Students grade increased by 5%
        //(1 + %/100)
        double increased = 1.0 + (5.0/100.0);
        List<Student> increasedGrades = students
                .stream()
                .map(student -> new Student(student.getName(), student.getAge(), student.getGrade() * increased))
                .collect(Collectors.toList());
        System.out.println("Students grade increased by 5%:");
        increasedGrades.forEach(System.out::println);
        System.out.println("-----------------------------------------------------");

        //Student list sorted by name
        List<Student> sortedbyName = students
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .map(student -> new Student(student.getName(), student.getAge(), student.getGrade()))
                .collect(Collectors.toList());
        System.out.println("Student list sorted by name:");
        sortedbyName.forEach(System.out::println);
        System.out.println("-----------------------------------------------------");
    }
}
