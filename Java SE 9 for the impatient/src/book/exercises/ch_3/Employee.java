package src.book.exercises.ch_3;

import java.util.Arrays;

public class Employee implements Measurable, Comparable<Employee> {

    private final double salary;
    private final String firstName;
    private final String lastName;

    public Employee(double salary, String firstName, String lastName) {
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(double salary) {
        this.salary = salary;
        this.firstName = "John";
        this.lastName = "Doe";
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public static String largest(Measurable[] objects) {
        Arrays.sort(objects);
        return ((Employee)objects[0]).getFullName();
    }

    @Override
    public double getMeasure() {
        return this.salary;
    }

    public static double average(Measurable[] objects) {
         var result = Arrays.asList(objects).parallelStream().mapToDouble((o) -> o.getMeasure()).average();
         return result.getAsDouble();
    }

    @Override
    public int compareTo(Employee other) {
        if(this.getMeasure() > other.getMeasure()) {
            return -1;
        } else if (other.getMeasure() > this.getMeasure()) {
            return 1;
        }
        return 0;
    }
}
