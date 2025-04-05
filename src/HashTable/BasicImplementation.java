package HashTable;

import java.util.HashMap;
import java.util.Map;

public class BasicImplementation {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 12);
        map.put("C", 8);

        System.out.println(map);
        System.out.println(map.get("A"));
        System.out.println(map.containsKey("B"));
        System.out.println(map.containsKey("BB"));

        for(String key:map.keySet()){
            System.out.println(key+"="+map.get(key));
        }
        for(Integer val:map.values()){
            System.out.println("Value="+val);
        }

        System.out.println("Size = "+map.size());

        map.remove("B");
        System.out.println("Size = "+map.size());
    }
}
