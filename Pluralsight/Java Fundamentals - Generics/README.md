# Generics

### Type Bounds:

`SortedPair<T extends Comparable>` may throw a runtime error if a the two types to be compared are not of the same type.
This is easily handled by binding the type that Comparator expects by changing the class' signature to `SortedPair<T extends Comparator<T>>`.
The first example would still compile, but may simply terminate at runtime, whereas the second example would break at compilation.
*Fail fast*. 

### Wrapping comparator:
`FooComparator<T> implements Comparator<T>` can be used in a way where it implements another comparator `BarComparator`
by using it as a delegate: `Collections.sort(madMen, new FooComparator<>(new BarComparator()));`.

That type of a pattern allows us to wrap `BarComparator` in `FooComparatator` to perform actions on the inner (`BarComparator`) results.

## Wild Cards:

### Upperbound wildcards (`? extends`):

An upperbound wildcard is a reference to when you allow a particular class, or that class's subtypes to be a parameter:

```public void saveAll(final List<? extends Person> persons)```.
This pattern makes it easier to write generic code that still is type-safe in terms of what parameters are expected to be passed in.
(only class or subclass of class).

Normally this pattern is used when inserting data. 

* Declare an upper bound for the type parameter
* To get data out of the parameter
* Covariance


### Lowerbound wildcards (`? super`):

When only a class or any class that the class is inhereting from is the parameter. 
In certain cases, it might be relevant to restrict a parameter to only allow a particular class or it's parent classes to be passed in as paramters such as:
```public void loadAll(final List<? super Person> people)```.
In which case only a `Person` object or any parent of Person can be passed in.

Normally this pattern is used when extracting data.

* Declare a lower bound for the type parameter
* To put data into the parameter
* Contravariance


----

## Reflection

### Reifiable Types

* Primitives
    - int, long
* Non Parameterized Class or Interface
    - String, ActionListener
* All type arguments are unbounded Wildcards
    - List<?>, Map<?, ?>
* Arrays of reifiable components
    - int[][], List<?>[]
    
### Non-Refiable Types
These types cannot be reflected, as the JVM can't determine their type at runtime.

* Type Variables
    - T
* Parameterized Type with Parameters
    - ArrayList<String>, Map<integer, String>
* Parameterized Type with Bounds
    - List<? extends Number, Consumer<? super String>

