package pattern.strategy.handler;

import pattern.strategy.Message;
import pattern.strategy.MsgHandlerService;

/**
 * 系统消息策略实现
 */
public class BeatNoticeMsgHandler implements MsgHandlerService {
    @Override
    public void handleMsg(Message message) {
        System.out.println("心跳消息处理开始：");
        System.out.println(message.getMsgContent());
        System.out.println("心跳消息处理结束！");
    }
}
