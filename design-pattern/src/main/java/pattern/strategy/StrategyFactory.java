package pattern.strategy;

import org.springframework.stereotype.Service;
import pattern.strategy.handler.BeatNoticeMsgHandler;
import pattern.strategy.handler.SystemNoticeMsgHandler;
import pattern.strategy.handler.UserNoticeMsgHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author luozhengde
 * @Date 2022/3/2
 * @desc 策略工厂：通过消息类型来获取对应类型的处理器
 */
@Service("strategyFactory")
public class StrategyFactory {

    private Map<String, MsgHandlerService> msgHandlerMapByMsgType = new HashMap<>();

    public MsgHandlerService getMsgHandlerService(String msgType) {
        return msgHandlerMapByMsgType.get(msgType);
    }

    /**
     * 注册后台消息处理器
     */
    public StrategyFactory() {
        msgHandlerMapByMsgType.put("SYSTEM_NOTICE", new SystemNoticeMsgHandler());
        msgHandlerMapByMsgType.put("BEAT_NOTICE", new BeatNoticeMsgHandler());
        msgHandlerMapByMsgType.put("USER_NOTICE", new UserNoticeMsgHandler());
    }
}
