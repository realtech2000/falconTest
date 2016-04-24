package hu.pairg.falconTest.ws.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by pairg on 2016.04.24..
 */
interface MessageChannels {

    String INPUT = "wsMessagesInput";

    String OUTPUT = "wsMessagesOutput";

    @Input(MessageChannels.INPUT)
    SubscribableChannel input();

    @Output(MessageChannels.OUTPUT)
    MessageChannel output();

}
