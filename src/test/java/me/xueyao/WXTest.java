package me.xueyao;

import me.xueyao.constant.MessageType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Simon.Xue
 * @date: 2019/3/27 9:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SimonWeiXinApiApplication.class)
public class WXTest {

    @Test
    public void test01() {
        System.out.println(MessageType.TEXT_MESSAGE);
    }
}
