package stream;

import io.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class buildStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        Stream<Integer> integerStream = Stream.of(0, 1, 2);
        Stream<List<String>> list1 = Stream.of(list);
        Stream<Person> personStream = Stream.of(new Person("1", 1));

    }
}
