package rabbitmq.ex.consumer.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbitmq.ex.consumer.OrderMqVo;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderListener {
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "order.queue")
    public void receiveMessage(final String message) throws JsonProcessingException {
        log.info("message : {}", message);
        OrderMqVo orderMqVo = objectMapper.readValue(message, OrderMqVo.class);
        log.info("orderMqVo = {}", orderMqVo);


    }
}
