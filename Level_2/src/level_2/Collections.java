package level_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Collections {

    public static void main(String[] args) {
        ArrayList ay = new ArrayList();

        ay.add("Hello");
        ay.add("Hi");
        System.out.println("Size >>" + ay.size());
        System.out.println(ay.get(0));
        String Stray0 = (String) ay.get(0);
        System.out.println(Stray0.length());
        System.out.println(ay.get(1));

        ArrayList<String> ay2 = new ArrayList<String>();
        ay2.add("Hello2");
        String ss = ay2.get(0);
        System.out.println(ss);

        Set set = new TreeSet();
        set.add("setHELLO");
        set.add("setJAVA");
        set.add("123");

        Iterator it = set.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            System.out.println(next);
        }

        printoutAll(set);
        
        
        Map map = new TreeMap();
        map.put("hello", "hello");
        map.put("hello2", "hello2");
        map.put("hello3", "hello3"); //key不變，Value內容改變
        
        System.out.println(">>Size>>" + map.size());
        System.out.println(map);
        Object obj = map.get("hello2");//取出
        String str = (String)obj;
        System.out.println(str);
        Set mapkeyset = map.keySet();
        Iterator itm = mapkeyset.iterator();
        while (itm.hasNext()) {
            Object key = itm.next();
            Object value = map.get(key);
            System.out.println("key:"+key+"  "+ "value:"+value);
        }

    }

    public static void printoutAll(Collection cc) {
        Iterator it = cc.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            System.out.println(next);
        }
    }

}
