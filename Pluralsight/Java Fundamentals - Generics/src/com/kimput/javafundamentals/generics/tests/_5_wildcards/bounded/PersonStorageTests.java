package com.kimput.javafundamentals.generics.tests._5_wildcards.bounded;

import com.kimput.javafundamentals.generics._5_wildcards.bounded.Employee;
import com.kimput.javafundamentals.generics._5_wildcards.bounded.Partner;
import com.kimput.javafundamentals.generics._5_wildcards.bounded.Person;
import com.kimput.javafundamentals.generics._5_wildcards.bounded.PersonLoader;
import com.kimput.javafundamentals.generics._5_wildcards.bounded.PersonSaver;
import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonStorageTests {

    private Partner donDraper = new Partner("Don Draper", 89);
    private Partner peggyOlson = new Partner("Peggy Olson", 65);
    private Employee bertCooper = new Employee("Bert Cooper", 100);

    private File file;
    private PersonSaver saver;
    private PersonLoader loader;

    @Test
    public void savesAndLoadsPeople() throws Exception {
        Person person = new Person("Bob", 20);
        saver.save(person);

        assertEquals(person, loader.load());
    }

    @BeforeMethod
    public void setUp() {
        try {
            file = File.createTempFile("tmp", "people");
            saver = new PersonSaver(file);
            loader = new PersonLoader(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        if (file.exists())
        {
            file.delete();
        }
    }



    @Test
    public void savesAndLoadsArrayOfPeople() throws Exception {
        List<Partner> persons = new ArrayList<>();
        persons.add(donDraper);
        persons.add(peggyOlson);

        saver.saveAll(persons);

        assertEquals(donDraper, loader.load());
        assertEquals(peggyOlson, loader.load());
    }

    @Test
    public void loadsListOfPeople() throws Exception {
        saver.save(donDraper);
        saver.save(peggyOlson);

        List<Person> people = new ArrayList<>();
        loader.loadAll(people);

        assertEquals(donDraper, people.get(0));
        assertEquals(peggyOlson, people.get(1));
    }
}
