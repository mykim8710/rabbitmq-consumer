package rabbitmq.ex.consumer;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderMqVo {
    private final String mail;
    private final String template;

    @Builder
    public OrderMqVo(String mail, String template) {
        this.mail = mail;
        this.template = template;
    }
}
