package exception;

public class TestThrow {
    public static void main(String[] args) {
//        try {
            Student s = new Student();
            s.register(-100);
            System.out.print(s);
//        } catch(RuntimeException e) {
//            e.printStackTrace();
//        }
    }
}

class Student{
    private int id;

    public void register(int id) {
        if(id > 0){
            this.id = id;
        }else{
            //手动抛出异常对象
            //一般都是抛Exception 和 RuntimeException，这两个异常。
            //如果抛出的是运行时异常或其子类异常，程序可以不处理，只写throw new ..即可
            //但是如果抛出的不是运行时的异常，那么程序就需要特殊处理了，例如写throws、trycatch
            throw new RuntimeException("您输入的数字非法！");//运行时异常

 //           throw new exception("您输入的数字非法！");

 //           throw new MyExceptiom("测试自定义");
        }
    }

//    public String toString(){
//        return "Student["+id+"]";
//    }
}