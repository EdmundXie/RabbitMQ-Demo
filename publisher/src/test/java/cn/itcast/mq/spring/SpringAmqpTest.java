package cn.itcast.mq.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Projectname: mq-demo
 * @Filename: SpringAmqpTest
 * @Author: EdmundXie
 * @Data:2023/3/13 19:59
 * @Email: 609031809@qq.com
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAmqpTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage2SimpleQueue() {
        String message = "hello! world!";
        String queueName = "simple.queue";
        rabbitTemplate.convertAndSend(queueName,message);
    }
}
