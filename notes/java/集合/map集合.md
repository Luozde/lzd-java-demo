
## map遍历方式

```java
class Test {
    /**
     * map遍历键值对
     */
    private static void visitMap() {
        Map<String, String> map = new HashMap<>(2);
        map.put("1", "1");
        map.put("2", "2");
        map.forEach((k, v) -> {
            System.out.println(k + "_" + v);
        });
    }
}
```
