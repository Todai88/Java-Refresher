package src.book.tests.ch_3;


import jdk.jfr.Description;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import src.book.exercises.ch_3.Employee;
import src.book.exercises.ch_3.Measurable;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Ch3_2_Test {

    @ParameterizedTest
    @Description("Finds the full name of the user with the highest salary")
    @CsvSource({"'joe:doe:0.0,jane:doe:20.0','jane doe'",
            "'fred:sven:10.0,frank:olson:20.0,fink:yes:30.0','fink yes'",
            "'julio:iglesias:4.0,billy:thekid:1.0,bob:dolan:1.0,jane:doe:1.0,joe:doe:3.0,fred:kruger:3.0,james:blunt:3.0','julio iglesias'"})
    public void GivenMultipleEmployees_WhenTestingEmployeesLargest_ShouldReturnFullNameOfHighestPaidEmployee(String data, String expectedLargest) {
        var employees = Arrays.stream(data.split(","))
                .map((s) -> new Employee(Double.parseDouble(s.split(":")[2]), s.split(":")[0], s.split(":")[1]))
                .toArray(Measurable[]::new);
        assertEquals(expectedLargest, Employee.largest(employees));
    }
}
