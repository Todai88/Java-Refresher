package com.kimput.calendar._1_;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Calendar;

public class Demo {
    public static void main(String[] args) {

        var testClock = Clock.fixed(Instant.EPOCH, ZoneOffset.UTC);
        var testDate = LocalDate.now(testClock);

        // TODO: Create a calendar
        Calendar calendar = new Calendar.getInstance();

        // TODO: Add tasks
        calendar.addTask(1, 0, "Answer urgent e-mail");

        // TODO: Add work periods to the calendar

        // TODO: Add event(s) to the calendar, specify time zone

        // TODO: Create a working schedule

        // TODO: Print out.
    }
}
