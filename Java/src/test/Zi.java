package test;

import java.util.Objects;

public class Zi extends Fu {
    public int num = 2;

    public void method(){
        System.out.println("Zi");
    }

    public void sss(){
        System.out.println(this.num);
    }

    public void methodZi(){}
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Zi zi = (Zi) o;
//
//        return num == zi.num;
//    }
//
//    @Override
//    public int hashCode() {
//        return num;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Zi zi = (Zi) o;
        return num == zi.num;
    }

    @Override
    public int hashCode() {

        return Objects.hash(num);
    }
}
