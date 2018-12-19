package main.com.kimput.javafundamentals.generics._7_reflection.c_reflecting_generic_information;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RefiableExamples {

    public static class StringList extends ArrayList<String> {

    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        Class<?> arrayList = strings.getClass();
        final TypeVariable<? extends Class<?>>[] typeParameters =
                arrayList.getTypeParameters();
        System.out.println(arrayList); // <-- class java.util.ArrayList
        System.out.println(Arrays.toString(typeParameters)); // <-- [E]
        System.out.println(arrayList.toGenericString()); // <-- Added in Java SE 6,
                                                         // returns fully qualified public class java.util.ArrayList<E>
        System.out.println(arrayList.toString()); // <--- class java.util.ArrayList

        final ParameterizedType arrayListOfString =
                (ParameterizedType) StringList.class.getGenericSuperclass();

        System.out.println(arrayListOfString); // <-- java.util.ArrayList<java.lang.String>
        System.out.println(Arrays.toString(arrayListOfString.getActualTypeArguments())); // <-- [class java.lang.String]
    }
}
