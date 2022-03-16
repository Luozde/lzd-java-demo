# Redis

## 基于管道批量操作set

```java
// 1. 需要注入stringTemplate
@Resource
private RedisTemplate<String, String> stringTemplate;

/**
 * 2. 批量set键值对
 * @param keyValueMap 键值对
 * @param expire 过期时间
 * @return
 */
public List<Object> batchPutInPipelined(Map<String, Object> keyValueMap, long expire) {
    List<Object> results = stringTemplate.executePipelined(
            (RedisCallback<Object>) connection -> {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                for (String key : keyValueMap.keySet()) {
                    if (null != keyValueMap.get(key)) {
                        stringRedisConn.set(key, keyValueMap.get(key).toString());
                        stringRedisConn.expire(key, expire);
                    }
                }
                return null;
            });
    return results;
}
```

