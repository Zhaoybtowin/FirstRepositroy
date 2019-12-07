package map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 *    /----map：双列数据，存储key-value对的数据   ---类似于高中的函数：y=f(x)
 *         /----HashMap：作为Map的主要实现类；线程不安全，效率高；能存储null的key和value
 *              /----LinkHashMap：保证在遍历map元素时，可以按照添加的顺序实现遍历
 *                   原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *                   对于频繁的遍历操作，此类执行效率高于HashMap。
 *         /----TreeMap：保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序。
 *                       底层使用红黑树（二叉树--排序二叉树中的一种）
 *         /----Hashtable：作为古老的实现类；线程安全，效率低；不能存储null的key、value
 *              /----TestProperties：常用来处理配置文件，它的key、value都是String类型的。
 *
 *    HashMap的底层：数组+链表  （JDK7之前）
 *                  数组+链表+红黑树  （JDK8之后）
 *
 *    面试题：
 *    1.HashMap的底层实现原理？
 *    2.HashMap和Hashtable的异同？看上
 *    3.CurrentHashMap与Hashtable的异同？
 */

public class MapTest {

    /**
     * 举例说明为什么建议用HashMap：
     *   登录网站，name:null + password:null，两个键值对，我什么都不输，点登录，是合理的操作。
     *   HashMap：不会报异常，合理。
     *   Hashtable：报异常，这显然不合理
     */
    @Test
    public void testNull(){
        //不会报错，建议用这个，保证程序健壮性。
        Map map = new HashMap();
        map.put(null,null);
        //会报错
        map = new Hashtable();
        map.put(null,null);
    }
}
