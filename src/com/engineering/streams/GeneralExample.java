package com.engineering.streams;

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


/**
 * @Note -:
 * Lazy Evaluation
 * One of the most important characteristics of Java streams is that they allow for significant optimizations through lazy evaluations.
 * Computation on the source data is only performed when the terminal operation is initiated, and source elements are consumed only as needed.
 * 
 * All intermediate operations are lazy, so they’re not executed until a result of processing is needed.
 *
 * <a href="https://stackify.com/streams-guide-java-8//"> Stream Tutorial</a>
 *
 */


public class GeneralExample {

    //sum(), average(), range()
    private static void mapToIntExample() {
        List<String> numbersAsString = Arrays.asList("10000000", "200000");
        IntStream intStream = numbersAsString.stream()
                .mapToInt(Integer::parseInt)
                .max().stream();

        intStream.forEach( System.out::println);
    }

    private static void flatMapToLongExample() {
        Stream<String> strings = Stream.of("10000000000,20000000000", "30000000000");
        LongStream longStream = strings.flatMapToLong(s -> Arrays.stream(s.split(","))
                .mapToLong(Long::parseLong));

        longStream.forEach(System.out::println);
    }

    private static void mapMultiExampleJava9() {
        Stream.of(1, 2, 3).<String>mapMulti((number, consumer) -> {
            consumer.accept(number + "a");
            consumer.accept(number + "b");
        }).forEach(System.out::println);
    }

    private static void mapMultiToDoubleExampleJava9() {
        Stream.of("1.1,2.2","3.3, 4.4, 5.5").mapMultiToDouble((s, consumer) -> {
            Arrays.stream(s.split(",")).mapToDouble(Double::parseDouble).forEach(consumer);
        }).forEach(System.out::println);
    }

    private static void shortCircuitingExample() {
        Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);
        List<Integer> collect = infiniteStream
                .skip(3)
                .limit(5)
                .toList();
        collect.forEach(System.out::println);
    }
    /*
    * allMatch() checks if the predicate is true for all the elements in the stream. Here, it returns false as soon as it encounters 5, which is not divisible by 2.
    * anyMatch() checks if the predicate is true for any one element in the stream. Here, again short-circuiting is applied and true is returned immediately after the first element.
    * noneMatch() checks if no elements are matching the predicate. Here, it simply returns false as soon as it encounters 6, which is divisible by 3.
    */
    private static void matchExample() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);

        boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
        boolean oneEven = intList.stream().anyMatch(i -> i % 2 == 0);
        boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);
    }

    private static void ReduceExample() {
        List<Double> doubleList = Arrays.asList(2.0, 4.0 ,5.0,6.0,7.0,8.0);
        Double sumSal = doubleList.stream()
                .reduce(0.0, Double::sum);
        System.out.println("\n Sum of Salary : " + sumSal);
    }

    private static void JoiningExample() {
        List<String> names = Arrays.asList("Steve Jobs ","Bill Gates", "Jeff Bezos", "Elon Musk");
        String collect = names.stream()
                .collect(Collectors.joining(", ", "Names: ", "."));
        System.out.println(collect);
    }
    private static void PortioningExample() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        Map<Boolean, List<Integer>> isEven = intList.stream().collect(
                Collectors.partitioningBy(i -> i % 2 == 0));

        System.out.println("\n Even Number : " + isEven.get(true));
        System.out.println("\n Odd Number : " + isEven.get(false));
    }

    private static void GroupingByExample() {
        List<String> names = Arrays.asList("Steve Jobs ","Bill Gates", "Jeff Bezos", "Elon Musk", "APJ ABDUL KALAM","Linus Torvalds","BHABHAA");
        System.out.println("\nGrouping By first character of the name : " + names.stream()
                .collect(Collectors.groupingBy(name -> name.split(" ")[0].charAt(0))));
    }

    private static void unboundedStreamsExample() {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    private static void IteratorExample() {
        Stream<Integer> evenNumStream = Stream.iterate(2, i -> i * 2);
        List<Integer> collect = evenNumStream
                .limit(5)
                .toList();

        System.out.println("\n Even Number Stream : " + collect);
    }

    // Short -circuit
    private static void java9StreamEnhancmentExample() {
        // takeWhile() - returns a stream consisting of the longest prefix of elements taken from this stream that match the given predicate.
        Stream.of(1, 2, 3, 4, 5, 6)
                .takeWhile(i -> i < 3)
                .forEach(System.out::println);

        // dropWhile() - returns a stream consisting of the remaining elements of this stream after dropping the longest prefix of elements that match the given predicate.
        Stream.of(1, 2, 3, 4, 5, 6)
                .dropWhile(i -> i < 4)
                .forEach(System.out::println);

        // ofNullable - The ofNullable method, another valuable addition in Java 9, provides a convenient way to create a stream from a single nullable element.
        // This method avoids potential NullPointerExceptions and helps keep your code cleaner:

        Integer number = null;
        Stream<Integer> result = Stream.ofNullable(number);
        result.map(x -> x * x).forEach(System.out::println);

        // concat - The concat method allows you to concatenate two streams into a single stream.
        // This can be particularly useful when you want to combine data from different sources or perform operations on multiple streams together:

        Stream<String> firstStream = Stream.of("A", "B", "C");
        Stream<String> secondStream = Stream.of("D", "E", "F");

        Stream<String> concatenatedStream = Stream.concat(firstStream, secondStream);
        concatenatedStream.forEach(System.out::println);

        // Iterator - The iterate method has been enhanced in Java 9 to support a more flexible way of generating streams.
        // Java 9 addresses this limitation by introducing an overloaded version of iterate with an additional predicate parameter to control termination:
        Stream.iterate(1, i -> i < 256, i -> i * 2)
                .forEach(System.out::println);
    }


    static void main() {
        // Example 1 -
        mapToIntExample();

        // Example 2 -
        flatMapToLongExample();

        // Example 3 -
        mapMultiExampleJava9();

        // Example 4 -
        mapMultiToDoubleExampleJava9();

        // Example 5 - Skip & limit
        //Some operations are deemed short-circuiting operations.
        // Short-circuiting operations allow computations on infinite streams to be completed in finite time:
        shortCircuitingExample();
        
        // Example 6 - allMatch , anyMatch , noneMatch
        matchExample();

        // Example -7 Reduce
        ReduceExample();

        // Example - 8 Collect - joining operation
        JoiningExample();

        // Example -9 Portioning by
        PortioningExample();

        //Example -10 Grouping By
        GroupingByExample();

        // Example - 11 Infinite Streams  (unbounded Streams)
        // - we might want to perform operations while the elements are still getting generated.
        // We might not know beforehand how many elements we’ll need. Unlike using list or map
        unboundedStreamsExample();

        // Example -12 iterate takes two parameters: an initial value, called the seed element and a function that generates the next element using the previous value.
        // By design, iterate() is stateful and hence may not be useful in parallel streams:

        IteratorExample();

        // Example - 13
        java9StreamEnhancmentExample();

    }
}
