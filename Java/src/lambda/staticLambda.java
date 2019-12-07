package lambda;

public class staticLambda {
    public static void method(String s,Test t){
        t.print(s);
    }

    public static void main(String[] args) {
        method("-10",(s)->{
            System.out.println(s);;
        });
    }
}
