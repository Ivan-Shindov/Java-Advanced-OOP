package classroom;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    public int capacity;
    public List<Student> students;

    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.students.size() < this.capacity) {
            if (!this.students.contains(student)) {
                this.students.add(student);
                return String.format("Added student %s %s", student.getFirstName(),
                        student.getLastName());
            } else if (this.students.contains(student)) {
                return "Student is already in the classroom";
            }
        }
        return "No seats in the classroom";
    }

    public String dismissStudent(Student student) {
        if (!this.students.isEmpty()) {
            if (this.students.contains(student)) {
                this.students.remove(student);
                return String.format("Removed student %s %s", student.getFirstName(),
                        student.getLastName());
            }
        }
        return "Student not found";
    }

    public String getSubjectInfo(String subject) {
            StringBuilder result = new StringBuilder();
            int studentCnt = 0;
            result.append(String.format("Subject: %s%n", subject))
                    .append(String.format("Students:%n"));
            for (Student student : this.students) {
                if (student.getBestSubject().equals(subject)) {
                    result.append(String.format("%s %s%n",student.getFirstName(),
                            student.getLastName()));
                    studentCnt++;
                }
            }
            if (studentCnt == 0) {
                return "No students enrolled for the subject";
            }
            return result.toString().trim();
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : this.students) {
            if (student.getFirstName().equals(firstName) &&
                student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder();
        result.append("Classroom size: ").append(getStudentCount())
                .append(System.lineSeparator());
        for (Student student : this.students) {
           String current = String.format("==%s", student.toString());
            result.append(current).append(System.lineSeparator());
        }
        return result.toString().trim();
    }

}
