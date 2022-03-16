package pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pattern.strategy.Message;
import pattern.strategy.MsgHandlerService;
import pattern.strategy.StrategyFactory;

/**
 * 策略模式测试代码
 * 使用说明：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyTest {

    @Autowired
    private StrategyFactory strategyFactory;

    @Test
    public void test(){
        Message msg1 = createMsg("SYSTEM_NOTICE", "系统消息:警告");
        MsgHandlerService msgHandlerService1 = strategyFactory.getMsgHandlerService(msg1.getMsgType());
        msgHandlerService1.handleMsg(msg1);

        Message msg2 = createMsg("USER_NOTICE", "用户消息:你好");
        MsgHandlerService msgHandlerService2 = strategyFactory.getMsgHandlerService(msg2.getMsgType());
        msgHandlerService2.handleMsg(msg2);

        Message msg3 = createMsg("BEAT_NOTICE", "心跳:hello");
        MsgHandlerService msgHandlerService3 = strategyFactory.getMsgHandlerService(msg3.getMsgType());
        msgHandlerService3.handleMsg(msg3);
    }

    private Message createMsg(String msgType, String msg){
        Message message = new Message();
        message.setId(System.currentTimeMillis()+"");
        message.setFromUserId("userFrom");
        message.setToUserId("userTo");
        message.setMsgType(msgType);
        message.setMsgContent(msg);
        return message;
    }
}
