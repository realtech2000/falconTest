package hu.pairg.falconTest.ws.messaging;

import hu.pairg.falconTest.ws.messaging.dto.ChannelMessage;
import hu.pairg.falconTest.ws.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * Created by pairg on 2016.04.24..
 */
@Component("WsMessagingProducer")
public class Producer {

    private final MessageChannel messageChannel;

    @Autowired
    public Producer(@Qualifier(MessageChannels.OUTPUT) MessageChannel messageChannel){
        this.messageChannel = messageChannel;
    }

    public void send(String roomName, Message msg){
        ChannelMessage channelMessage = new ChannelMessage(roomName, msg.getSenderName(), msg.getMessage());
        this.messageChannel.send(
                MessageBuilder.withPayload(channelMessage)
                        .setHeader("topic", MessageChannels.OUTPUT)
                        .build()
        );
    }

}
