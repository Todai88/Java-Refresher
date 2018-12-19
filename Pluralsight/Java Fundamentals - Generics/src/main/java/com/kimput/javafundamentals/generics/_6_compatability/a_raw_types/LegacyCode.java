package main.com.kimput.javafundamentals.generics._6_compatability.a_raw_types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LegacyCode {

    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("abc");
        list.add(1);
        list.add(new Object());

        Iterator iter = list.iterator();

        while(iter.hasNext()) {
            final Object object = iter.next();
            System.out.println(object);
        }
    }
}
