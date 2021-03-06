package me.xueyao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

/**
 * @author: Simon.Xue
 * @date: 2019/4/2 9:48
 */
@Configuration
public class RedisConfig {
    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("192.168.2.166", 6379);
        redisStandaloneConfiguration.setPassword("123456");
        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }
}
