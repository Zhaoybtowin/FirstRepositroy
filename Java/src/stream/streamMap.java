package stream;

import java.io.Serializable;
import java.util.stream.Stream;

public class streamMap {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("赵英博,24");

        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Stream<? extends Serializable> concat = Stream.concat(stringStream, integerStream);

        concat.forEach((s)-> System.out.println(s));
    }
}
