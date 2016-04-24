package hu.pairg.falconTest.api.messaging;

import hu.pairg.falconTest.api.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * Created by pairg on 2016.04.24..
 */
@Component
public class Producer {

    private final MessageChannel messageChannel;

    @Autowired
    public Producer(@Qualifier(MessageChannels.OUTPUT) MessageChannel messageChannel){
        this.messageChannel = messageChannel;
    }

    public void send(Message message){
        this.messageChannel.send(
                MessageBuilder.withPayload(message)
                        .setHeader("topic", MessageChannels.OUTPUT)
                        .build()
        );
    }

}
