package test;

import com.luozd.demo.GlobalExApplication;
import com.luozd.demo.controller.ResultController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GlobalExApplication.class)
public class DemoTest {

    @Resource
    ResultController resultController;

    @Test
    public void test1(){
        resultController.getResult("13","23");
    }
}
