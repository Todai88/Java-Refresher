package src.book.tests.ch_3;

import org.junit.jupiter.api.Test;
import src.book.exercises.ch_3.Employee;
import src.book.exercises.ch_3.Measurable;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch3_1_Test {
    @Test
    public void testEmployeeAverageSalary() {
        String doubles = "30.0, 30.0, 30.0";
        Measurable[] employees = Arrays.stream(doubles.split(","))
                .map(s -> new Employee(Double.parseDouble(s)))
                .toArray(Measurable[]::new);
        assertEquals(30, Employee.average(employees));
    }
}
