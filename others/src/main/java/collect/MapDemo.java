package collect;

import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.api.scripting.JSObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 本案例主要整理map类型的相关使用案例
 * 1. Map集合stream过滤案例：filterMap()
 */
public class MapDemo {

    public static void main(String[] args) {
        filterMap();
    }

    /**
     * Java 8 Map Filter 过滤示例
     */
    private static void filterMap(){
        Map<String, Integer> map = new HashMap<>(3);
        map.put("zzs", 26);
        map.put("zli", 27);
        map.put("lww", 28);

        // 1. 过滤返回符合条件value集合
        List<Integer> zList = map.entrySet().stream().filter(r -> r.getKey().startsWith("z"))
                .map(r1 -> r1.getValue()).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(zList));

        // 2. 过滤返回符合条件Map
        Map<String, Integer> zMapList = map.entrySet().stream().filter(r -> r.getKey().startsWith("z"))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        System.out.println(JSONObject.toJSONString(zMapList));

    }
}
