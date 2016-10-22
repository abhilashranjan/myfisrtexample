import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.*;

/**
 * Created by abhilash on 7/3/16.
 */
public class MapStreaming {
    public static void main(String[] args) {
//        MapStreaming.StreamsExamples();
    }

    private static void streamMin() {
        Stream.of("a1", "a2", "a3","a4")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .min()
                .ifPresent(System.out::println);
    }

    private static void streamAvg() {
        Arrays.stream(new int[] {1, 2, 3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);
    }

    private static void inputStreamRange() {
        IntStream.range(1, 4)
                .forEach(System.out::println);
    }

    private static void findFirstExample() {
        Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);
    }

    public static void StreamsExamples(){
       // Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
       // stream.forEach(p -> System.out.println(p));
       // Stream<Date> streamDate = Stream.generate(() -> { return new Date();});
       // streamDate.forEach(p -> System.out.println(p));

        IntStream streamInt = "12345_abcdefg".chars();
        streamInt.forEach(p -> System.out.println(p));


        //OR
        Stream<String> streamReg = Stream.of("A$B$C".split("\\$"));
        streamReg.forEach(p -> System.out.println(p));
    }

    /**
     *
     */
    public static void convertToUpperCase() {
        List<String> cities = Arrays.asList("London", "HongKong", "Paris", "NewYork");
        System.out.println("Original list : " + cities);
        System.out.println("list transformed using Java 8 :" + cities.stream().map(String::toUpperCase).collect(Collectors.toList()));
    }
}
