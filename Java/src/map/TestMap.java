package map;

import org.junit.Test;

import java.util.*;

public class TestMap {
    /**
     * 添加、删除、修改操作：
     * Object put(Object key,Object value)：将指定的key-value添加到（或修改）当前map对象中
     * void putAll(map m)：将m中的所有key-value对存放到当前map中
     * Object remove(Object key)：移除指定key的key-value对，并返回value
     * void clear()：清空当前map中的所有数据
     */
    @Test
    public void test1(){
        Map map = new HashMap();
        //添加
        map.put("AA",123);
        map.put("BB",456);
        map.put(789,"CC");
        //修改
        map.put("AA",1111);
        //putAll
        Map map1 = new HashMap();
        map1.put("CC",789);
        map1.put("DD",999);
        map.putAll(map1);
        //remove
        Object value = map.remove("CC");
        //clear：与map = null操作不同，此时的map.size()=0
        map.clear();
        System.out.println(map);
        System.out.print(value);
    }


    /**
     *元素查询的操作：
     * Object get(Object key)：获取指定key对应的value
     * boolean containsKey(Object key)：是否包含指定的key
     * boolean containsValue(Object value)：是否包含指定的value
     * int size()：返回map中key-value对的个数
     * boolean isEmpty()：判断当前map是否为空
     * boolean equals(Object obj)：判断当前map和参数对象obj是否相等
     */
    @Test
    public void test2(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put("BB",456);
        map.put(789,"CC");
        //Object get(Object key)
        System.out.println(map.get("AA"));
        //boolean containsKey(Object key)
        System.out.println(map.containsKey("AA"));
        //boolean containsValue(Object value)
        System.out.println(map.containsValue("CC"));
        //boolean equals(Object obj)：要求obj也是一个map，且值要与前者相同，即为true
    }

    /**
     *元视图操作的方法：
     * Set keySet()：返回所有key构成的Set集合
     * Collection values()：返回所有value构成的Collection集合
     * Set entrySet()：返回所有key-value对构成的Set集合
     */
    @Test
    public void test3(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put("BB",456);
        map.put(789,"CC");

        //遍历所有的key集：keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator(); //迭代器
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历所有的value集：values()
        Collection values = map.values();
        for(Object obj : values){
            System.out.println(obj);
        }

        //遍历所有的key-value：entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + "----->" + entry.getValue());
        }
    }
}
