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

