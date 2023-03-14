package cn.itcast.mq.listener;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

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
//    @RabbitListener(queues = "simple.queue")
//    public void listenSimpleQueue(String massage){
//        System.out.println("listen to message" + " " + massage);
//    }

//    @RabbitListener(queues = "simple.queue")
//    public void listenWorkQueue(String massage) throws InterruptedException {
//        System.out.println("消费者1 listen to message" + " " + massage+ LocalTime.now());
//        Thread.sleep(20);
//    }
//
//    @RabbitListener(queues = "simple.queue")
//    public void listenWorkQueue2(String massage) throws InterruptedException {
//        System.err.println("消费者2 listen to message" + " " + massage+ LocalTime.now());
//        Thread.sleep(200);
//    }

//    @RabbitListener(queues = "itcast.queue1")
//    public void listenFanoutQueue1(String massage) throws InterruptedException {
//        System.err.println("消费者1 listen to fanout.queue1" + "【 "+ massage+"】"+ LocalTime.now());
//
//    }
//
//    @RabbitListener(queues = "itcast.queue2")
//    public void listenFanoutQueue2(String massage) throws InterruptedException {
//        System.err.println("消费者2 listen to fanout.queue2" + " " + massage+ LocalTime.now());
//    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "itcast.direct", type = "direct"),
            key = {"red","blue"}

    ))
    public void listenDirectQueue1(String msg){
        System.err.println("blue consumer listen to direct.queue1" + " " + msg+ LocalTime.now());
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "itcast.direct", type = "direct"),
            key = {"red","yellow"}

    ))
    public void listenDirectQueue2(String msg){
        System.err.println("yellow consumer listen to direct.queue2" + " " + msg+ LocalTime.now());
    }
}
