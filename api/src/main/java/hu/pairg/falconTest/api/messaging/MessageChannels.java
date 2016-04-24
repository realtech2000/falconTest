package hu.pairg.falconTest.api.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by pairg on 2016.04.23..
 */
interface MessageChannels {

    String OUTPUT = "apiMessages";

    @Output(MessageChannels.OUTPUT)
    MessageChannel output();

}
