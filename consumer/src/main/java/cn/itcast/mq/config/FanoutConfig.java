package cn.itcast.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Projectname: mq-demo
 * @Filename: FanoutConfig
 * @Author: EdmundXie
 * @Data:2023/3/14 01:25
 * @Email: 609031809@qq.com
 * @Description:
 */
@Configuration
public class FanoutConfig {
    //fanoutExchange交换机
    @Bean
    public FanoutExchange fanoutExchange (){
        return new FanoutExchange("itcast.fanout");
    }

    //queue1消息队列
    @Bean
    public Queue queue1(){
        return new Queue("itcast.queue1");
    }

    //将消息队列绑定至交换机
    @Bean
    public Binding binding1(FanoutExchange fanoutExchange,Queue queue1){
        return BindingBuilder.bind(queue1).to(fanoutExchange);
    }

    @Bean
    public Queue queue2(){
        return new Queue("itcast.queue2");
    }

    @Bean
    public Binding binding2(FanoutExchange fanoutExchange,Queue queue2){
        return BindingBuilder.bind(queue2).to(fanoutExchange);
    }
}
