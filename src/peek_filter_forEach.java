import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class peek_filter_forEach {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("one","two","three","four","five");

        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("three");

        List<String> list = new ArrayList<>();

        stream.peek(System.out::println)
                .filter(p1.or(p2))
//                .peek(list::add) //intermediary
                .forEach(list::add); //terminal operation
        System.out.println("Done");
        System.out.println("Size of list: " +list.size());

    }
}
