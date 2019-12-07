package lambda;

public class TestDemo {
    public static void testPrint(Test t){
        t.print("aaaaaaaaa");
    }

    public static void main(String[] args) {
        testPrint((s)->{ //参数s经由Lambda传入对象的成员方法中
            TestYinYong t = new TestYinYong();
            t.method(s);
        });

        /**
         * 使用 方法引用 优化Lambda
         * 对象是已经存在的 t
         * 成员方法是已经存在的 method
         * 所以我们可以使用对象名引用成员方法
         */
        TestYinYong t = new TestYinYong();//对象要先创建好
        testPrint(t::method);
    }
}
