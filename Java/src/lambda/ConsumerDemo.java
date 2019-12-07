package lambda;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void method(String s, Consumer<String> con1,Consumer<String> con2){
        con1.andThen(con2).accept(s);
        /*
        等价于：
        con1.accept(s);
        con2.accept(s);
         */
    }

    public static void main(String[] args) {
        method("Hello",(s)->{
            System.out.println(s.toUpperCase());//HELLO
        },
        (s)->{
            System.out.println(s);//Hello
        });
        //结论：andThen连接两个接口，虽然只写了一个入参，但是并不影响，只是为了简化重复代码而已
    }
}
