package com.lindj.dubbo.consumer.manager;

import com.lindj.dubbo.consumer.config.DefaultConsumerConfigure;
import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author lindj
 * @date 2019/9/16 0016
 * @description
 */
@Log4j2
@Component
public class ConsumerManager extends DefaultConsumerConfigure implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public ConsumeConcurrentlyStatus dealBody(List<MessageExt> msgs) {
        int num = 1;
        log.info("进入");
        for(MessageExt msg : msgs) {
            log.info("第" + num + "次消息");
            try {
                String msgStr = new String(msg.getBody(), "utf-8");
                log.info("{}, {}",msgStr, msg.getMsgId());
            } catch (UnsupportedEncodingException e) {
                log.error("body转字符串解析失败");
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            super.listener("TopicTest", "Tag1");
        } catch (MQClientException e) {
            log.error("消费者监听器启动失败", e);
        }
    }
}
