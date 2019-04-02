package me.xueyao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Simon.Xue
 * @date: 2019/4/2 9:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SimonWeiXinApiApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String, String> template;

    @Test
    public void testConnection() {
        template.opsForList().leftPush("1", "哈哈");
    }
}
