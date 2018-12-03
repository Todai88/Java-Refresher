package src.book.tests.ch_3;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import src.book.exercises.ch_3.Employee;
import src.book.exercises.ch_3.Measurable;

import java.util.Arrays;


public class Ch3_2_Test {

    @ParameterizedTest
    public void GivenMultipleEmployees_WhenTestingEmployeesLargest_ShouldReturnFullNameOfHighestPaidEmployee() {
        var doubles = "30.0 'John' 'Doe', 60.0 'Jane' 'Doe', 30.0 'Bob' 'Alice'";
        var employees = Arrays.stream(doubles.split(","))
                .map((String[] s) -> {
                        for(String emp : s) {

                        }
                        return new Employee(Double.parseDouble(s))
                    }
                )
                .toArray(Measurable[]::new);
        Assertions.assertEquals(30, Employee.average(employees));
    }
}
