package exercise1;

public class Student {
        private String name;
        private int age;
        private double grade;

        public Student(String name, int age, double grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }

        @Override
        public String toString() {
            return name +"-"+ age +"-"+ grade;
        }
}
