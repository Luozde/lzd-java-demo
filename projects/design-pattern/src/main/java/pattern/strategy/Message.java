package pattern.strategy;

import jdk.jfr.DataAmount;
import lombok.Data;

import java.io.Serializable;

/**
 * @desc 消息实体定义
 */
@Data
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String fromUserId;

    private String toUserId;

    private String msgType;

    private String msgContent;
}
