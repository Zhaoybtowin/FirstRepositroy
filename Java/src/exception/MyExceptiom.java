package exception;

/**
 * 如何自定义异常类？
 * 1、继承于现有的异常结构：RuntimeException 、 exception
 * 2、提供全局常量：serialVersionUID（序列号）
 * 3、提供重载的构造器
 *
 */
public class MyExceptiom extends RuntimeException{

    static final long serialVersionUID = -7034897190745766939L;


    public MyExceptiom(){

    }

    public MyExceptiom(String m){
        super(m);
    }
}
