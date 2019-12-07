package lambda;

import java.util.function.Supplier;

public class SupplierDemo {
    public static String method(Supplier<String> s){
        //return "0"; //0
        //return s.toString();//lambda.SupplierDemo$$Lambda$1/990368553@6d311334
        return s.get();
    }

    public static void main(String[] args) {
        System.out.println(method(() ->  "lalala"));
    }
}
