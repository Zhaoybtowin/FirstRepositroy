package lambda;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("张无忌");
        list.add("谢逊");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张三丰");

        list.stream()
                .filter(s->s.startsWith("张"))
                .filter(s->s.length() == 3)
                .forEach(s-> System.out.println(s));
    }
}
