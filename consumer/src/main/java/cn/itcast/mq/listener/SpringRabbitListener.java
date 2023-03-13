package cn.itcast.mq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Projectname: mq-demo
 * @Filename: SpringRabbitListener
 * @Author: EdmundXie
 * @Data:2023/3/13 20:37
 * @Email: 609031809@qq.com
 * @Description:
 */
@Component
public class SpringRabbitListener {
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String massage){
        System.out.println("listen to message" + " " + massage);
    }
}
