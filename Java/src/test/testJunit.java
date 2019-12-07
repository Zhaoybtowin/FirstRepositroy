package test;

import org.junit.Assert;
import org.junit.Test;

public class testJunit {
    @Test
    public void test(){
        Fu f = new Fu();

        int i = f.add(1,3);

        Assert.assertEquals(5,i);
    }

    @Test
    public void test1(){
        Fu f = new Fu();

        int i = f.add(1,3);

        Assert.assertEquals(4,i);
    }
}
