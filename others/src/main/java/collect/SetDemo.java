package collect;

import java.util.HashSet;
import java.util.Set;

/**
 * 本案例主要整理Set类型的相关使用案例
 * Set集合交，并，差集合运算示例
 */
public class SetDemo {

    public static void main(String[] args) {
        test();
    }

    /**
     * Set集合的交集，并集，差集运算示例
     */
    private static void test() {
        Set<String> result = new HashSet<>();
        Set<String> set1 = new HashSet<String>() {
            {
                add("王者荣耀");
                add("英雄联盟");
                add("穿越火线");
                add("地下城与勇士");
            }
        };

        Set<String> set2 = new HashSet<String>() {
            {
                add("王者荣耀");
                add("地下城与勇士");
                add("魔兽世界");
            }
        };

        result.clear();
        result.addAll(set1);
        result.retainAll(set2);
        System.out.println("交集：" + result);

        result.clear();
        result.addAll(set1);
        result.removeAll(set2);
        System.out.println("差集：" + result);

        result.clear();
        result.addAll(set1);
        result.addAll(set2);
        System.out.println("并集：" + result);
    }

}
