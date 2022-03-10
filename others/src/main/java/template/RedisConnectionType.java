package template;

import java.util.Arrays;
import java.util.Optional;

/**
 *
 * @author lzd
 * @Date 2022/3/3
 * @Desc 枚举类通用模版
 * 关键词：枚举 模版 Enum
 */
public enum RedisConnectionType {

    STANDALONE("standalone", "单节点部署方式"),
    SENTINEL("sentinel", "哨兵部署方式"),
    CLUSTER("cluster", "集群方式"),
    MASTER_SLAVE("master_slave", "主从部署方式");

    private final String connectionType;
    private final String connectionDesc;

    RedisConnectionType(String connectionType, String connectionDesc) {
        this.connectionType = connectionType;
        this.connectionDesc = connectionDesc;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public String getConnectionDesc() {
        return connectionDesc;
    }

    /**
     * 判断是否属于该枚举类型
     * @param connectionType
     * @return
     */
    public static Boolean isConnectionType(String connectionType) {
        Optional<RedisConnectionType> first = Arrays.stream(RedisConnectionType.values())
                .filter(r -> r.getConnectionType() == connectionType).findFirst();
        return first.isPresent() ? true : false;
    }
}
