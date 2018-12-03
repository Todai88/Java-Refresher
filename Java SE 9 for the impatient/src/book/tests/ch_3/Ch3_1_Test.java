package src.book.tests.ch_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.book.exercises.ch_3.Employee;
import src.book.exercises.ch_3.Measurable;

import java.util.Arrays;

public class Ch3_1_Test {
    @Test
    public void testEmployeeAverageSalary() {
        var doubles = "30.0, 30.0, 30.0";
        var employees = Arrays.stream(doubles.split(","))
                .map(s -> new Employee(Double.parseDouble(s)))
                .toArray(Measurable[]::new);
        Assertions.assertEquals(30, Employee.average(employees));
    }
}
