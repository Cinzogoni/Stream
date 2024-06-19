import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class reduce {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,6,5,4,3);

        Optional<Integer> red = list.stream()
                .reduce(Integer::min);

        System.out.println("red = " +red.get());
    }
}
